package com.project.QuickProject.common.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 导出excel文件
 * @author 杨飘
 * 2020/12/26
 */
public class ExportExcelUtil {
	public static void expoerDataExcel(HttpServletResponse response, ArrayList<String> titleKeyList, Map<String, String> titleMap, List<Map<String,Object>> src_list) throws IOException {

        String xlsFile_name = DateUtils.dateTime()+ ".xlsx";     //输出xls文件名称
        //内存中只创建100个对象
        Workbook wb = new SXSSFWorkbook(100);           //关键语句
        Sheet sheet = null;     //工作表对象
        Row nRow = null;        //行对象
        Cell nCell = null;      //列对象

        int rowNo = 0;      //总行号
        int pageRowNo = 0;  //页行号

        for (int k=0;k<src_list.size();k++) {
            Map<String,Object> srcMap = src_list.get(k);
            //写入300000条后切换到下个工作表
            if(rowNo%300000==0){
                wb.createSheet("工作簿"+(rowNo/300000));//创建新的sheet对象
                sheet = wb.getSheetAt(rowNo/300000);        //动态指定当前的工作表
                pageRowNo = 0;      //新建了工作表,重置工作表的行号为0
                // -----------定义表头-----------
                nRow = sheet.createRow(pageRowNo++);
                // 列数 titleKeyList.size()
                for(int i=0;i<titleKeyList.size();i++){
                    Cell cell_tem = nRow.createCell(i);
                    cell_tem.setCellValue(titleMap.get(titleKeyList.get(i)));
                }
                rowNo++;
                // ---------------------------
            }
            rowNo++;
            nRow = sheet.createRow(pageRowNo++);    //新建行对象

            // 行，获取cell值
            for(int j=0;j<titleKeyList.size();j++){
                nCell = nRow.createCell(j);
                if (srcMap.get(titleKeyList.get(j)) != null) {
                    nCell.setCellValue(srcMap.get(titleKeyList.get(j)).toString());
                } else {
                    nCell.setCellValue("");
                }
            }
        }
        System.out.println("-------------------------123123--");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + xlsFile_name);
        response.flushBuffer();
        OutputStream outputStream = response.getOutputStream();
        wb.write(response.getOutputStream());
        wb.close();
        outputStream.flush();
        outputStream.close();
    }
}
