package serviceImpl;

import com.zfy.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ExportServiceImpl implements ExportService {

    @Override
    public void exportExcel(Map<String, String> map) {
//        HSSFWorkbook wb = new HSSFWorkbook();//声明工
//        Sheet sheet = wb.createSheet("数据权限申请审批表");//新建表
//        sheet.setDefaultColumnWidth(15);//设置表宽
//        HSSFCellStyle style = wb.createCellStyle();
//        HSSFFont font = wb.createFont();
//        font.setFontHeightInPoints((short) 12);
//
//        HSSFCellStyle headerStyle = wb.createCellStyle();
//        HSSFFont headerFont = wb.createFont();
//        headerFont.setFontHeightInPoints((short) 14);
//
//        headerStyle.setFont(headerFont);
//
//        CellRangeAddress cra0 = new CellRangeAddress(0, 1, 0, 9);
//        sheet.addMergedRegion(cra0);
//        sheet.setDefaultColumnWidth((short) 15);
//        Row row = sheet.createRow(0);
//        Cell cell1 = row.createCell(0);
//
//        cell1.setCellValue("数据权限申请审批表");
//        cell1.setCellStyle(headerStyle);
//        //设置字体样式
//        HSSFFont titleFont = wb.createFont();
//
//        Row row1 = sheet.createRow(2);
//
//        Cell cell = row1.createCell(0);
//        cell.setCellValue("ID");
//        cell.setCellStyle(style);
//
//        cell = row1.createCell(1);
//        cell.setCellValue("username");
//        cell.setCellStyle(style);
//
//        cell = row1.createCell(2);
//        cell.setCellValue("password");
//        cell.setCellStyle(style);
//
//
//        System.out.println("mapList:"+mapList);
//        int createRow = 0;
//        for(Map<String,String> m:mapList){
//            row1 = sheet.createRow(3+createRow);
//            for (String key:m.keySet()){
//                if(key.equals("id")){
//                    //createCell 0 表示第一列
//                    row1.createCell(0).setCellValue(MapUtil.getStringValeByKey(m,key));
//                }
//                if(key.equals("username")){
//                    //createCell 1 表示第二列
//                    row1.createCell(1).setCellValue(MapUtil.getStringValeByKey(m,key));
//                }
//                if(key.equals("password")){
//                    //createCell 2 表示第三列
//                    row1.createCell(2).setCellValue(MapUtil.getStringValeByKey(m,key));
//                }
//
//
//            }
//            createRow++;
//        }
//
//
//        response.reset();
//        response.setContentType("application/msexcel;charset=UTF-8");
//        try {
//            SimpleDateFormat newsdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            String date = newsdf.format(new Date());
//            response.addHeader("Content-Disposition", "attachment;filename=\""
//                    + new String(("数据权限申请审批表" + date + ".xls").getBytes("GBK"),
//                    "ISO8859_1") + "\"");
//            OutputStream out = response.getOutputStream();
//            wb.write(out);
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "导出失败!");
//            e.printStackTrace();
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "导出失败!");
//            e.printStackTrace();
//        }
    }
}
