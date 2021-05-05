package com.project.QuickProject.common.utils;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class QybSms {
	private String username ="sjsms605";//设置帐号
	private String passwd = "sjsms605";;//
	private static QybSms qybSms = new QybSms();
	public static QybSms singleton(){
		return  qybSms;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QybSms qs = new QybSms();
		try {
			String ss = qs.send("18285150137", "早上好【医会宝】");
			JSONObject jsonObject=JSONObject.fromObject(ss);
			System.out.println(jsonObject.get("respdesc"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("aaa");
	}

	public String sendMsg(String phone,String msg,String needstatus,String port,String sendtime) throws Exception{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://www.qybor.com:8500/shortMessage");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
		NameValuePair[] data ={
				new NameValuePair("username",this.username),
				new NameValuePair("passwd",this.passwd),
				new NameValuePair("phone",phone),
				new NameValuePair("msg",msg),
				new NameValuePair("needstatus",needstatus),
				new NameValuePair("port",port),
				new NameValuePair("sendtime",sendtime)};
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		String result = new String(post.getResponseBodyAsString().getBytes());
		System.out.println(result); //打印返回消息状态
		post.releaseConnection();
		//ResultObj group2 = JSON.parseObject(result, ResultObj.class);
		return result;
	}
	/**
	 * 简单短信发送
	 * @param phone 手机号码，多个
	 * @param msg
	 * @throws Exception
	 */
	public String send(String phone,String msg) throws Exception{
		return this.sendMsg(phone, msg, "true", "", "");
	}

}


