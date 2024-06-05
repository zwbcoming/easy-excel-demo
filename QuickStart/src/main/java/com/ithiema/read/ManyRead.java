package com.ithiema.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.ithiema.EmployeeListener.EmployeeListener;
import com.ithiema.dao.EmployeeDao;
import com.ithiema.pojo.Employee;
import com.ithiema.utils.TestFileUtil;

import java.io.File;

/**  自定义监听器读取数据
 * @author zwb
 * @create 2024-06-05 下午 10:56
 */
public class ManyRead {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDao();

        String fileName = TestFileUtil.getPath() + "simpleWrite1717583103715.xlsx";

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, Employee.class, new EmployeeListener(employeeDao)).sheet().doRead();
    }
}
