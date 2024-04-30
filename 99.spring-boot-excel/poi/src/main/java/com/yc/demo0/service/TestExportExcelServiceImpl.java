package com.yc.demo0.service;

import com.yc.demo0.pojo.AgentTpl;
import org.apache.commons.codec.Charsets;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TestExportExcelServiceImpl implements TestExportExcelService {


    /**
     *   CompletableFuture   多线程 提升导出速度
     * @param response
     */
    @Override
    public void testExportExcel(HttpServletResponse response) {
        Workbook wb = new XSSFWorkbook();
        //设置单元格式
        Font font = wb.createFont();
        font.setColor(Font.COLOR_NORMAL);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Sheet sheet = wb.createSheet("代理人数据2");
        Sheet sheet1 = wb.createSheet("代理人数据1");
        CompletableFuture<Void> dosageCountFuture1 = CompletableFuture.runAsync(() -> {
            setOne(wb, sheet, cellStyle);
        });
        CompletableFuture<Void> dosageCountFuture2 = CompletableFuture.runAsync(() -> {
            setOne(wb, sheet1, cellStyle);
        });
        CompletableFuture.allOf(dosageCountFuture1, dosageCountFuture2).join();
        writeToExcel(response, wb, "导出数据列表");

    }

  void   setOne( Workbook wb, Sheet sheet,CellStyle cellStyle) {
      List<AgentTpl> list = new ArrayList<>();

      AgentTpl agentTpl = new AgentTpl();
      agentTpl.setId(1L);
      agentTpl.setName("哈尔滨工业集团");
      agentTpl.setMobile("13800138000");
      list.add(agentTpl);

      AgentTpl agentTpl1 = new AgentTpl();
      agentTpl1.setId(2L);
      agentTpl1.setName("西北工业集团");
      agentTpl1.setMobile("13700137000");
      list.add(agentTpl1);


      List<String[]> rowValues = new ArrayList<>();
      for (AgentTpl tpl : list) {
          String[] rowValue = {
                  null == tpl.getId() ? "" : tpl.getId().toString(),
                  null == tpl.getName() ? "" : tpl.getName(),
                  null == tpl.getMobile() ? "" : tpl.getMobile(),
          };
          rowValues.add(rowValue);
      }

      for (int i = 0; i < rowValues.size(); i++) {
          Row currentRow = sheet.createRow(i);
          // 获取当前行的数据
          String[] cellValues = rowValues.get(i);
          for (int j = 0; j < cellValues.length; j++) {
              // 设置列宽
              sheet.setColumnWidth(j, 4100);
              Cell cell = currentRow.createCell(j);
              cell.setCellStyle(cellStyle);
              //每个单元格的值目前做 String 处理
              cell.setCellType(CellType.STRING);
              cell.setCellValue(cellValues[j]);
          }
      }
  }



    public void writeToExcel(HttpServletResponse response, Workbook wb, String fileName) {
        OutputStream os = null;
        try {
            response.setContentType(FileUploadBase.CONTENT_TYPE);
            response.setCharacterEncoding(Charsets.UTF_8.name());
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", new String(URLEncoder.encode(fileName + ".xlsx" , Charsets.UTF_8.name())
                    .getBytes(Charsets.UTF_8), Charsets.ISO_8859_1)));
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != wb) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
