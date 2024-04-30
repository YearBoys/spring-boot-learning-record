package com.yc.demo0.congtoller;

import com.yc.demo0.service.TestExportExcelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/statistics")
public class TestExportExcel {

    @Resource
    private TestExportExcelService testExportExcelService;

    @GetMapping(value = "/export/excel")
    public void exportExcel(HttpServletResponse response) {
        testExportExcelService.testExportExcel(response);
    }
}
