package com.project.QuickProject.common.utils;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * springboot
 * @author Jimmey-Jiang
 * 2021/01/26
 */
public class Fastcsv {
	public static String csvReadOperation(String path,String msg) throws Exception {
        File file = new File(path);
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        StringBuffer buffer = new StringBuffer();
        QybSms sms = QybSms.singleton();
        for (CsvRow row : csv.getRows()) {
            buffer.append(row.getField("phone")).append(",");//获取手机号
        	//System.out.println(row.getField("phone"));
        	//sms.send(row.getField("phone"), "读取csv文件短信发送测试:"+"【企业宝】");
        }
        if(buffer.length()>0) {
        	buffer = buffer.deleteCharAt(buffer.length()-1);
        }
        System.out.println(buffer.toString());
        
    	String data = sms.send(buffer.toString(), msg+"【企业宝】");
    	//System.out.println(data);
    	return data;
    }
	public static void main(String[] args) throws Exception {
		//csvReadOperation("F:\\TSSWCFServices\\AppData\\man.csv");
	}
}
