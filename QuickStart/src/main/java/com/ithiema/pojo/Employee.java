package com.ithiema.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** 员工类
 * @author zwb
 * @create 2024-06-05 下午 6:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @ExcelProperty("员工编号")
    private Integer id;
    @ExcelProperty("员工姓名")
    private String name;
    @ExcelProperty("员工薪资")
    private Double salary;
    @ExcelProperty("入职日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date date;

}
