package com.pys.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pengys
 * @Description:
 */
public class TestEventListener extends AnalysisEventListener<ExcelTestVO> {
    private List<ExcelTestVO> list = new ArrayList<>();

    @Override
    public void invoke(ExcelTestVO excelTestVO, AnalysisContext analysisContext) {
        // 解析完一条后的回调
        list.add(excelTestVO);
        System.out.println(excelTestVO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 数据导入完成后的处理
        System.out.println(list);
    }
}
