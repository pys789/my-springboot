package com.pys.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: pengys
 * @Description:
 */
@Data
public class ExcelTestVO {
    // 指标名称
    @ExcelProperty(index = 0)
    private String indexName;

    // 指标定义
    @ExcelProperty(index = 1)
    private String indexDefine;

    // 数据开发
    @ExcelProperty(index = 2)
    private String dataDevelop;
}
