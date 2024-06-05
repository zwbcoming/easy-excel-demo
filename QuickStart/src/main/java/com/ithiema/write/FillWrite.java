package com.ithiema.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ithiema.pojo.Employee;
import com.ithiema.utils.TestFileUtil;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author zwb
 * @create 2024-06-05 下午 10:12
 */
public class FillWrite {

    public static void main(String[] args) {

        String templateFileName = TestFileUtil.getPath() + "模板.xlsx";
        String fileName = TestFileUtil.getPath() + "listFill" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            for (int i = 0; i < 100; i++) {
                excelWriter.fill(data(10), writeSheet);
            }

        }

    }

    public static List<Employee> data(int count) {
        List<Employee> list = ListUtils.newArrayList();
        for (int i = 1; i <= count; i++) {
            Employee data = new Employee();
            data.setName("test_" + i);
            data.setDate(new Date());
            data.setSalary(23.33);
            data.setId(i);
            list.add(data);
        }
        return list;
    }
}
