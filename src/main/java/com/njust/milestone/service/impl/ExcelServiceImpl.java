package com.njust.milestone.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.njust.milestone.excel.ProjectMilestoneInsert;
import com.njust.milestone.service.ExcelService;
import com.njust.milestone.util.BaseUtil;
import com.njust.milestone.util.Result;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel 服务实现类
 *
 * @author 修身
 * @since 2019/4/25
 **/

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public Result importExcel(MultipartFile multipartFile, String type) {
        try {
            //1、先上传到服务器
            JSONObject object = upload(multipartFile);
            String uplLoadState = "upLoadLocation";
            if (object.containsKey(uplLoadState)) {
                String upLoadLocation = object.getString(uplLoadState);
                String suffix = upLoadLocation.substring(upLoadLocation.lastIndexOf(".") + 1);
                if ("xlsx".equals(suffix)) {
                    if (!"".equals(upLoadLocation)) {
                        File file = new File(upLoadLocation);
                        //2、从服务器上导入Excel并存入数据库
                        String path = file.toString();
                        InputStream in = new FileInputStream(new File(path));
                        Result result = excel2Database(in, path, type);
                        //3、传到数据库后删除上传的Excel以免影响内存
                        deleteFolder(upLoadLocation);
                        //判断上传成功与否
                        if (result != null) {
                            if (result.isSuccess()) {
                                return BaseUtil.renderSuccess(result.getMsg());
                            } else {
                                return BaseUtil.renderError(result.getMsg());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //1、先上传到服务器
    public JSONObject upload(MultipartFile file) {
        JSONObject row = new JSONObject();
        String actualLocation = "C://upload/" + "/";
        File file1 = new File(actualLocation);
        //如果项目文件夹不存在则创建
        if (!file1.exists() && !file1.isDirectory()) {
            System.out.println("不存在");
            boolean mkdir = file1.mkdir();
            System.out.println(mkdir);
        }

        if (!file.isEmpty()) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDhhmmss");
            //获取当前时间
            String fileName = sdf.format(date) + "." + file.getOriginalFilename().split("\\.")[1];
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(actualLocation + fileName)));
                out.write(file.getBytes());
                out.flush();//冲刷输出流的缓冲区
                out.close();//关闭流，释放掉十分有限的操作系统资源
            } catch (FileNotFoundException e) {
                row.put("upLoadState", "上传失败" + e.getMessage());
                e.printStackTrace();
                return row;
            } catch (IOException e) {
                e.printStackTrace();
                row.put("upLoadState", "上传失败" + e.getMessage());
                return row;
            }
            row.put("upLoadState", "上传成功");
            row.put("upLoadLocation", actualLocation + fileName);
            return row;
        } else {
            row.put("upLoadState", "上传失败，因为文件是空的");
            return row;
        }
    }

    //2、从服务器上导入Excel并存入数据库
    private Result excel2Database(InputStream in, String path, String type) {
        try {
            //1.获取工作簿
            Workbook book = path.endsWith(".xls") ? new HSSFWorkbook(in) : (path.endsWith(".xlsx") ? new XSSFWorkbook(in) : null);
            if (book != null) {
                //2.获取所有工作表
                List<Sheet> sheets = new ArrayList<>();
                sheets.add(book.getSheetAt(0));

                //3.对表格进行操作，通过“type”可进行扩展
                //导入项目里程碑
                if ("projectMilestone".equals(type)) {
                    return ProjectMilestoneInsert.sheetIterator(sheets);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //3、传到数据库后删除上传的Excel以免影响内存
    private void deleteFolder(String sPath) {
        File file = new File(sPath);
        if (file.exists() && file.isFile()) {
            boolean delete = file.delete();
            System.out.println(delete);
        }
    }
}
