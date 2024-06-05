package com.ithiema.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ithiema.pojo.Employee;
import com.ithiema.utils.TestFileUtil;

import java.util.Date;
import java.util.List;

/**
 * @author zwb
 * @create 2024-06-05 下午 7:48
 */
public class ManyWrite {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String fileName = TestFileUtil.getPath() + "重复写" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, Employee.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("多次写入").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<Employee> data = data(100);
                excelWriter.write(data, writeSheet);
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("用时时间：" + (endTime - start) / 1000 + " 秒");
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
