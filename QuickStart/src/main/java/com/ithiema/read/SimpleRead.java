package com.ithiema.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.ithiema.pojo.Employee;
import com.ithiema.utils.TestFileUtil;


/** 读数据
 * @author zwb
 * @create 2024-06-05 下午 7:20
 */
public class SimpleRead {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "simpleWrite1717583103715.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, Employee.class, new PageReadListener<Employee>(dataList -> {
            for (Employee employee : dataList) {
                System.out.println(employee);
            }
        })).sheet().doRead();
    }
}
