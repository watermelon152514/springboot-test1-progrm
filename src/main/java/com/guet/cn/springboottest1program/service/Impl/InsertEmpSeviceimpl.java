package com.guet.cn.springboottest1program.service.Impl;


import com.guet.cn.springboottest1program.bean.Employees;
import com.guet.cn.springboottest1program.mapper.InsertEmpMapper;
import com.guet.cn.springboottest1program.service.InsertEmpService;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsertEmpSeviceimpl implements InsertEmpService {
    @Autowired(required = false)
   private InsertEmpMapper insertEmpMapper;

    @Override
    public Integer insertEmpByExcel(MultipartFile multipartFile) {
        List<Employees> employeesList = new ArrayList<>();
        try {
            // 创建都Excel工作簿文件的引用
            XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
            // 获取Excel工作表总数
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {  //获取每个Sheet表
                XSSFSheet sheet = sheets.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {//获取行数
                    Employees employees= new Employees();
                    for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {  //获取单元格
                        DataFormatter dataFormatter = new DataFormatter();

                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));//第几行第几个
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
                        java.util.Date d = simpleDateFormat.parse(dataFormatter.formatCellValue(sheet.getRow(j).getCell(5)));
                        Date date =new Date(d.getTime());
                        System.out.println("第"+k+"个："+stringCellValue);
                        switch (k) {
                            case 0:
                                employees.setId(Integer.parseInt(stringCellValue));
                                break;
                            case 1:
                                employees.setName(stringCellValue);
                                break;
                            case 2:
                                employees.setSex(stringCellValue);
                                break;
                            case 3:
                                employees.setPhone(stringCellValue);
                                break;
                            case 4:
                                employees.setLv(stringCellValue);
                                break;
                            case 5:
                                employees.setEntrytime(date);
                                break;
                            case 6:
                                employees.setPerobj(Integer.parseInt(stringCellValue));
                                break;
                            case 7:
                                employees.setJobstatus(stringCellValue);
                                break;
                            case 8:
                                employees.setDepartment(stringCellValue);
                                break;
                            case 9:
                                employees.setLable(stringCellValue);
                                break;
                            case 10:
                                employees.setOrdernum(Integer.parseInt(stringCellValue));
                                break;
                            case 11:
                                employees.setWorkstatus(stringCellValue);
                                break;
                            case 12:
                                employees.setOpen_ports(stringCellValue);
                                break;
                            case 13:
                                employees.setTuijian_status(stringCellValue);
                                break;

                        }
                    }
                    employeesList.add(employees);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return insertEmpMapper.insertEmp(employeesList);

    }
}
