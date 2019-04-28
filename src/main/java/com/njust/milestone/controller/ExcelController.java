package com.njust.milestone.controller;

import com.njust.milestone.service.ExcelService;
import com.njust.milestone.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Excel控制器
 *
 * @author 修身
 * @since 2019/4/25
 **/

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Resource
    private ExcelService excelService;

    /**
     * 打开导入窗口
     **/
    @RequestMapping("/toImport")
    public String toImport(@RequestParam(value = "type", defaultValue = "") String type, Model model) {
        model.addAttribute("type", type);
        return "/importExcel";
    }

    /**
     * 导入Excel
     **/
    @PostMapping("/importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam(value = "fileContent") MultipartFile multipartFile,
                              @RequestParam(value = "type") String type) {
        return excelService.importExcel(multipartFile, type);
    }

}
