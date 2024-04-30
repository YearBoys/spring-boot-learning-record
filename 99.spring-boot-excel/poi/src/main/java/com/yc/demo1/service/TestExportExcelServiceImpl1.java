//package com.yc.demo1.service;
//
//import com.yc.demo0.pojo.AgentTpl;
//import com.yc.demo0.service.TestExportExcelService;
//import com.yc.demo1.utils.ExcelSheet;
//import org.apache.commons.codec.Charsets;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.tomcat.util.http.fileupload.FileUploadBase;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TestExportExcelServiceImpl1 implements TestExportExcelService {
//
//
//    @Override
//    public void testExportExcel(HttpServletResponse response) {
//
//        List<AgentTpl> list = new ArrayList<>();
//
//        AgentTpl agentTpl = new AgentTpl();
//        agentTpl.setId(1L);
//        agentTpl.setName("哈尔滨工业集团");
//        agentTpl.setMobile("13800138000");
//        list.add(agentTpl);
//
//        AgentTpl agentTpl1 = new AgentTpl();
//        agentTpl1.setId(2L);
//        agentTpl1.setName("西北工业集团");
//        agentTpl1.setMobile("13700137000");
//        list.add(agentTpl1);
//
//        Workbook wb = new XSSFWorkbook();
//        //设置单元格式
//        Font font = wb.createFont();
//        font.setColor(Font.COLOR_NORMAL);
//        CellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        Sheet sheet = wb.createSheet("代理人数据");
//
//        List<String[]> rowValues = new ArrayList<>();
//        for (AgentTpl tpl : list) {
//            String[] rowValue = {
//                    null == tpl.getId() ? "" :tpl.getId().toString(),
//                    null == tpl.getName() ? "" : tpl.getName(),
//                    null == tpl.getMobile() ? "" :  tpl.getMobile(),
//            };
//            rowValues.add(rowValue);
//        }
//
//        for (int i = 0; i < rowValues.size(); i++) {
//            Row currentRow = sheet.createRow(i);
//            // 获取当前行的数据
//            String[] cellValues = rowValues.get(i);
//            for (int j = 0; j < cellValues.length; j++) {
//                // 设置列宽
//                sheet.setColumnWidth(j, 4100);
//                Cell cell = currentRow.createCell(j);
//                cell.setCellStyle(cellStyle);
//                //每个单元格的值目前做 String 处理
//                cell.setCellType(CellType.STRING);
//                cell.setCellValue(cellValues[j]);
//            }
//        }
//
//        List<ExcelSheet> mysheet = new ArrayList<>();
//
//
//
//    }
//
//}
