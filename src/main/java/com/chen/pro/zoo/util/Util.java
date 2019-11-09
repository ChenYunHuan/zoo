package com.chen.pro.zoo.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.UnsupportedEncodingException;

public class Util {
    public static XSSFWorkbook getXSSFWorkbook(String[] title, String[][] values) {
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet");
        Row row = sheet.createRow(0);
        CellStyle style = Util.getCellStyle(wb);
        Cell cell = null;
        sheet.setDefaultColumnWidth(10);
        int i;
        for (i = 0; i < title.length; ++i) {

            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        for (i = 0; i < values.length; ++i) {
            sheet.autoSizeColumn(i);
            row = sheet.createRow(i + 1);

            for (int j = 0; j < values[i].length; ++j) {
                row.createCell(j).setCellValue(values[i][j]);
            }
        }

        return wb;
    }

    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException var3) {
                var3.printStackTrace();
            }

            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + toUtf8String(fileName));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception var7) {
                    System.out.println(var7);
                    b = new byte[0];
                }

                for (int j = 0; j < b.length; ++j) {
                    int k = b[j];
                    if (k < 0) {
                        k += 256;
                    }

                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }

        return sb.toString();
    }

    /**
     * 初始化表格样式
     */

    public static CellStyle getCellStyle(XSSFWorkbook wb){
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);    //设置填充方案
        cellStyle.setFillForegroundColor(new XSSFColor(new Color(181,181,181)));  //设置填充颜色
        return cellStyle;
    }


}
