package com.njust.milestone.excel;

import com.njust.milestone.entity.ProjectMilestone;
import com.njust.milestone.util.BaseUtil;
import com.njust.milestone.util.Result;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectMilestoneInsert extends BaseUtil {

    //3.对表格进行操作
    public static Result sheetIterator(List<Sheet> sheets) {

        Result result = new Result();
        //循环每一张工作表
        Sheet sheet = sheets.get(0);
        //判断是否为空表，获取有数据的最后一行的行数。如果为零则为空表
        sheet.getLastRowNum();
        if (sheet.getLastRowNum() > 1) {
            //打印不为空的工作表名字
            System.out.println(sheet.getSheetName() + "=============");
        }
        //迭代器
        Iterator<Row> iterator = sheet.iterator();
        //定义ProjectMilestone数组
        List<ProjectMilestone> projectMilestoneList = new ArrayList<>();

        //用两个while循环遍历所有单元格
        while (iterator.hasNext()) {
            //遍历每一行
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() < 1) {
                //nextRow.getRowNum()就是获取行数，一般第一行(getRowNum()=0)为表头，直接跳过
                //这里，第一行是说明内容，第二行是表头
                continue;
            }

            Iterator<Cell> cellIterator = nextRow.cellIterator();

            //查询第二行表头字段，判断导入内容与该表是否对应
            if (nextRow.getRowNum() == 1) {
                Cell cell = cellIterator.next();
                Row row = cell.getRow();
                for (int i = 0; i < 20; i++) {
                    if (row.getCell(i) != null) {
                        row.getCell(i).setCellType(1);
                    }
                }
                String projectCode = row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue();
                String projectName = row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue();
                String engineerVoltageLevel = row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue();
                String engineerProperty = row.getCell(4) == null ? "" : row.getCell(4).getStringCellValue();
                String constructionProperty = row.getCell(5) == null ? "" : row.getCell(5).getStringCellValue();
                String engineerCode = row.getCell(6) == null ? "" : row.getCell(6).getStringCellValue();
                String engineerName = row.getCell(7) == null ? "" : row.getCell(7).getStringCellValue();
                String productTime = row.getCell(10) == null ? "" : row.getCell(10).getStringCellValue();
                if (!(projectCode.contains("项目编") && projectName.contains("项目名称") && engineerVoltageLevel.contains("电压等级")
                        && engineerProperty.contains("工程") && constructionProperty.contains("建设") && engineerCode.contains("工程编")
                        && engineerName.contains("工程名称") && productTime.contains("投产"))) {
                    result.setMsg("导入文件不符合，请检查文件是否有误！");
                    result.setSuccess(false);
                    return result;
                }
                continue;
            }

            ProjectMilestone projectMilestone = new ProjectMilestone();

            //从第三行开始是有用的数据，要保存到数据库，第三行：nextRow.getRowNum()=2
            //遍历每一行的每一列
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getColumnIndex()) {
                    default:
                        break;
                    case 0:
                        // 1表示字符串型，0表示数值型，4表示布尔型
                        cell.setCellType(0);
                        projectMilestone.setCode(cell.getRowIndex());
                        break;
                    case 1:
                        cell.setCellType(1);
                        projectMilestone.setProjectCode(cell.getStringCellValue());
                        break;
                    case 2:
                        cell.setCellType(1);
                        projectMilestone.setProjectName(cell.getStringCellValue());
                        break;
                    case 3:
                        cell.setCellType(1);
                        projectMilestone.setEngineerVoltageLevel(cell.getStringCellValue());
                        break;
                    case 4:
                        cell.setCellType(1);
                        projectMilestone.setEngineerProperty(cell.getStringCellValue());
                        break;
                    case 5:
                        cell.setCellType(1);
                        projectMilestone.setConstructionProperty(cell.getStringCellValue());
                        break;
                    case 6:
                        cell.setCellType(1);
                        projectMilestone.setEngineerCode(cell.getStringCellValue());
                        break;
                    case 7:
                        cell.setCellType(1);
                        projectMilestone.setEngineerName(cell.getStringCellValue());
                        break;
                    case 8:
                        cell.setCellType(0);
                        SimpleDateFormat ftm1 = new SimpleDateFormat("yyyy-MM-dd");
                        double value1 = cell.getNumericCellValue();
                        Date date1 = DateUtil.getJavaDate(value1);
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            projectMilestone.setStartTime(ftm1.format(date1));
                            //如果这里打印的话，还是会打印出数字，但是保存到数据库会变成日期格式
                        }
                        break;
                    case 9:
                        cell.setCellType(0);
                        SimpleDateFormat ftm2 = new SimpleDateFormat("yyyy-MM-dd");
                        double value5 = cell.getNumericCellValue();
                        Date date5 = DateUtil.getJavaDate(value5);
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            projectMilestone.setProjectFirstreviewTime(ftm2.format(date5));
                        }
                        break;
                    case 10:
                        cell.setCellType(0);
                        SimpleDateFormat ftm3 = new SimpleDateFormat("yyyy-MM-dd");
                        double value7 = cell.getNumericCellValue();
                        Date date7 = DateUtil.getJavaDate(value7);
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            projectMilestone.setProductTime(ftm3.format(date7));
                        }
                        break;
                    case 11:
                        cell.setCellType(1);
                        projectMilestone.setProjectManager(cell.getStringCellValue());
                        break;
                    case 12:
                        cell.setCellType(1);
                        projectMilestone.setProjectPhone(cell.getStringCellValue());
                        break;
                }
                System.out.print(cell + " --> ");
            }
            System.out.println(cellIterator);
            projectMilestoneList.add(projectMilestone);
        }

        try {
            ProjectMilestoneImp imp = new ProjectMilestoneImp();
            //遍历所有行，一旦出现重复项，则整个文件均不允许导入
            for (ProjectMilestone projectMilestone : projectMilestoneList) {
                //根据不可重复字段，判断是否已存在数据库
                if (imp.exist(projectMilestone)) {
                    System.out.println("导入失败！    工程编码：" + projectMilestone.getEngineerCode() + "已存在，不允许出现具有相同工程编码的工程");
                    result.setMsg("导入失败！    工程编码：" + projectMilestone.getEngineerCode() + "已存在，不允许出现具有相同工程编码的工程");
                    result.setSuccess(false);
                    return result;
                }
            }

            for (ProjectMilestone projectMilestone : projectMilestoneList) {
                //保存导入文件
                imp.save(projectMilestone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setMsg("导入已完成!");
        result.setSuccess(true);
        return result;
    }
}
