package com.guet.cn.springboottest1program.controller;


import com.guet.cn.springboottest1program.service.Impl.InsertEmpSeviceimpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@Controller
public class InsertEmpController {
    @Autowired
    private InsertEmpSeviceimpl insertEmpSeviceimpl;
    // 将excel导入到数据库
    @RequestMapping("insertEmpByExcel")
    @ResponseBody
    public ModelAndView insertEmpByExcel(Model model, @RequestParam("file") MultipartFile multipartFile) {
        System.out.println("ggggggggggg");
//        Map message=new HashMap();
        ModelAndView modelAndView = new ModelAndView("redirect:TJYG.html");//要重定向到TJYG.html
        Integer integer = insertEmpSeviceimpl.insertEmpByExcel(multipartFile);
//        message.put("msg1","通过Excel插入成功！");
//        message.put("msg2","通过Excel插入失败！");
        if (integer > 0) {
            modelAndView.addObject("msg","通过Excel插入成功！");
            return modelAndView;
        }
        modelAndView.addObject("msg", "通过Excel插入失败!");
            return modelAndView;

    }

/* 员工资料模板下载*/
@GetMapping("/download")   //此处尽量get请求
public void downLoadTemplate(HttpServletResponse response) {
    try {
        // 获取资源中的模板文件
        ClassPathResource resource = new ClassPathResource("/templates/excel/Emp模板.xlsx");
        InputStream inputStream = resource.getInputStream();
        Workbook wb = WorkbookFactory.create(inputStream);
        response.reset();
        response.setContentType("multipart/form-data");
        // 判断excel文件类型，下载获取到的模板并重新命名
        System.out.println(wb.getClass().getSimpleName());
        if (wb.getClass().getSimpleName().equals("HSSFWorkbook")) {
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String("员工信息模板".getBytes("UTF-8"), "iso8859-1") + ".xls");
        } else {
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String("员工信息模板".getBytes("UTF-8"), "iso8859-1") + ".xlsx");
        }
        wb.write(response.getOutputStream());
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }



// 将数据库导出成excel
@GetMapping("exportExcel")
public void exportExcel(HttpServletResponse response) {
    HSSFWorkbook workbook = insertEmpSeviceimpl.exportExcel();
    // 获取输出流
    OutputStream os = null;
    try {
        // 获取输出流
        os = response.getOutputStream();
        // 重置输出流
        response.reset();
        System.out.println("准备生成文件名");
        // 设定输出文件头
        response.setHeader("Content-disposition",
                "attachment; filename=" + new String("员工信息资料".getBytes("GB2312"), "8859_1") + ".xls");
        // 定义输出类型
        response.setContentType("application/msexcel");
        workbook.write(os);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭资源
        try {
            assert os != null;
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
