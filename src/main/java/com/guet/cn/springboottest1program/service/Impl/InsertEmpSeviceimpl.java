package com.guet.cn.springboottest1program.service.Impl;


import com.guet.cn.springboottest1program.bean.Employees;
import com.guet.cn.springboottest1program.mapper.InsertEmpMapper;
import com.guet.cn.springboottest1program.service.InsertEmpService;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import java.util.Iterator;
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

    @Override
    public HSSFWorkbook exportExcel() {
        // 创建Execl工作薄
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 在Excel工作簿中建一工作表
        HSSFSheet sheet = hssfWorkbook.createSheet("Employee");
        HSSFRow row = sheet.createRow(0);   //第零行
        row.createCell(0).setCellValue(new HSSFRichTextString("编号(id)"));   //第一个单元格（代表第一个字段）
        row.createCell(1).setCellValue(new HSSFRichTextString("姓名(name)"));
        row.createCell(2).setCellValue(new HSSFRichTextString("性别(sex)"));
        row.createCell(3).setCellValue(new HSSFRichTextString("手机号码(phone)"));
        row.createCell(4).setCellValue(new HSSFRichTextString("级别(lv)"));
        row.createCell(5).setCellValue(new HSSFRichTextString("入职时间(entrytime)"));
        row.createCell(6).setCellValue(new HSSFRichTextString("业绩目标(perobj)"));
        row.createCell(7).setCellValue(new HSSFRichTextString("状态(jobstatus)"));
        row.createCell(8).setCellValue(new HSSFRichTextString("部门(department)"));
        row.createCell(9).setCellValue(new HSSFRichTextString("标签(lable)"));
        row.createCell(10).setCellValue(new HSSFRichTextString("排序号(ordernum)"));
        row.createCell(11).setCellValue(new HSSFRichTextString("状态(workstatus)"));
        row.createCell(12).setCellValue(new HSSFRichTextString("开放端口(open_ports)"));
        row.createCell(13).setCellValue(new HSSFRichTextString("推荐装态(tuijian_status)"));
        List<Employees> employees = insertEmpMapper.EmpList();
        Iterator<Employees> iterator = employees.iterator();
        int num = 1;
        System.out.println("准备遍历数据");
        while (iterator.hasNext()) {
            Employees employee = iterator.next();//迭代
            HSSFRow rowNum = sheet.createRow(num); //创建第一行
            rowNum.createCell(0).setCellValue(new HSSFRichTextString(employee.getId().toString()));
            rowNum.createCell(1).setCellValue(new HSSFRichTextString(employee.getName()));
            rowNum.createCell(2).setCellValue(new HSSFRichTextString(employee.getSex()));
            rowNum.createCell(3).setCellValue(new HSSFRichTextString(employee.getPhone()));
            rowNum.createCell(4).setCellValue(new HSSFRichTextString(employee.getLv()));
            rowNum.createCell(5).setCellValue(new HSSFRichTextString(employee.getEntrytime().toString()));
            rowNum.createCell(6).setCellValue(new HSSFRichTextString(employee.getPerobj().toString()));
            rowNum.createCell(7).setCellValue(new HSSFRichTextString(employee.getJobstatus()));
            rowNum.createCell(8).setCellValue(new HSSFRichTextString(employee.getDepartment()));
            rowNum.createCell(9).setCellValue(new HSSFRichTextString(employee.getLable()));
            rowNum.createCell(10).setCellValue(new HSSFRichTextString(employee.getOrdernum().toString()));
            rowNum.createCell(11).setCellValue(new HSSFRichTextString(employee.getWorkstatus()));
            rowNum.createCell(12).setCellValue(new HSSFRichTextString(employee.getOpen_ports()));
            rowNum.createCell(13).setCellValue(new HSSFRichTextString(employee.getTuijian_status()));
            num++;
        }
        return hssfWorkbook;
    }


}
