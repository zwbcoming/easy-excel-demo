package com.itheima.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.itheima.domain.Employee;
import com.itheima.listener.EmployeeListener;
import com.itheima.service.EmployeeService;
import com.itheima.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile file, HttpServletResponse response) throws IOException {

        EasyExcel.read(file.getInputStream(), Employee.class, new EmployeeListener(service)).sheet().doRead();
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Employee.class).sheet("模板").doWrite(service.getData());
    }
}
