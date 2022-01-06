package com.pys.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.pys.demo.excel.ExcelTestVO;
import com.pys.demo.excel.TestEventListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: pengys
 * @Description:
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelController {

    @GetMapping(value = "/download/template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        Resource resource = new ClassPathResource("/excel/test.xlsx");
        XSSFWorkbook wb;
        try (InputStream is = resource.getInputStream()) {
            wb = new XSSFWorkbook(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=test.xlsx");

        try (OutputStream os = response.getOutputStream()) {
            wb.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("模板文件下载失败");
        }
    }

    @PostMapping(value = "/importTest")
    public void importTestData(MultipartFile file) {
        try {
            ExcelReader excelReader = EasyExcel.read(file.getInputStream()).build();

            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(ExcelTestVO.class)
                            .registerReadListener((new TestEventListener()))
                            .build();

            // 可以配置多个sheet
            excelReader.read(readSheet1);

            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            excelReader.finish();
        } catch (IOException ex) {
            log.info("导入失败", ex);
        }

    }

}
