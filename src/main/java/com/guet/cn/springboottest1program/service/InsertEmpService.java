package com.guet.cn.springboottest1program.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


public interface InsertEmpService {
    Integer insertEmpByExcel(MultipartFile multipartFile);
    HSSFWorkbook exportExcel();
}
