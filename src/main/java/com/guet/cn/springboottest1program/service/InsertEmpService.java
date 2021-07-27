package com.guet.cn.springboottest1program.service;

import org.springframework.web.multipart.MultipartFile;

public interface InsertEmpService {
    Integer insertEmpByExcel(MultipartFile multipartFile);

}
