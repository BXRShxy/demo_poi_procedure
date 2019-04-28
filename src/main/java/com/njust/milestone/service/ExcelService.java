package com.njust.milestone.service;

import com.njust.milestone.util.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Excel 服务类
 *
 * @author 修身
 * @since 2019/4/25
 **/

public interface ExcelService {

    Result importExcel(MultipartFile multipartFile, String type);
}
