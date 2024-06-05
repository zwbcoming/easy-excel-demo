package com.ithiema.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.ithiema.pojo.Employee;
import com.ithiema.utils.TestFileUtil;

import java.util.Date;
import java.util.List;

/**
 * @author zwb
 * @create 2024-06-05 下午 6:06
 */
public class SimpleWrite {
    public static void main(String[] args) {

        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Employee.class).sheet("模板").doWrite(data(10));

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
