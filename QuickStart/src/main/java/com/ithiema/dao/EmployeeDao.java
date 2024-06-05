package com.ithiema.dao;

import com.ithiema.pojo.Employee;

import java.util.List;

/**
 * @author zwb
 * @create 2024-06-05 下午 10:37
 */
public class EmployeeDao {

    public void save(List<Employee> list) {
        System.out.println("保存数据库成功：  " + "数据条数是：" + list.size());
    }
}
