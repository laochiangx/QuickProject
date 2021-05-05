package com.project.QuickProject.common.utils;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

//import net.sf.json.JSON;

public class HttpUtils {
	
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        URLConnection connection = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
	/**
	 * 发送短信
	 * @param phones 电话号码
	 * @param msgContent 短信内容
	 * @return true：发送成功、 false ： 发送失败 
	 */
	public static boolean sendSmstxet(String postUrl, String phones,String msgContent){
		msgContent = msgContent.replaceAll("[\\t\\n\\r]", "");//替换换行符
		String jsonParam = "{\"phones\":\""+phones+"\",\"msgContent\":\""+msgContent+"\",\"systemCode\":\"chs\"}";
		String result = null;
		HttpURLConnection httpUrlConnection = null;
		OutputStream outStrm =  null;
		InputStream inStrm = null;
		try {
			URL url = new URL(postUrl);
			httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			// 设置是否从httpUrlConnection读入，默认情况下是true;
			httpUrlConnection.setDoOutput(true);
			// Post 请求不能使用缓存
			httpUrlConnection.setUseCaches(false);
			// 设定请求的方法为"POST"，默认是GET
			httpUrlConnection.setRequestMethod("POST");
			//httpUrlConnection.setRequestProperty("SOAPAction", "saveEquipmentInfo");
			 httpUrlConnection.setConnectTimeout(30000);
            httpUrlConnection.setReadTimeout(30000);
			httpUrlConnection.connect();
			outStrm = httpUrlConnection.getOutputStream();
			outStrm.write(jsonParam.getBytes("utf8"));
			outStrm.flush();
			outStrm.close();
			inStrm = httpUrlConnection.getInputStream();
			result = IOUtils.toString(inStrm);
			JSONObject json = JSONObject.fromObject(result);
			if (json.getString("resCode").equals("SUCCESS")) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(httpUrlConnection != null){
					httpUrlConnection.disconnect();
				}
				if(outStrm != null){
					outStrm.flush();
					outStrm.close();
				}
				if(inStrm != null){
					inStrm.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String send(String url, String method, Object param) {
		URL targetUrl = null;
		HttpURLConnection urlCon = null;
		DataOutputStream os = null;
		InputStream in = null;
		BufferedReader rd = null;
		if (param != null && param instanceof String) {
			url = (!url.endsWith("?")) ? (url + "?" + param) : (url + param);
		}
		try {
			targetUrl = new URL(url);
			urlCon = (HttpURLConnection) targetUrl.openConnection();
			urlCon.setRequestMethod(method);
			if(param != null &&!"".equals(param) && param instanceof String && (method.equals("POST")|| method.equals("PUT"))){//解决当请求为PUT或POST时，由于请求body为空，且为设置Content-length时sso server拒绝该请求的bug
				urlCon.addRequestProperty("Content-Length", "0"); 
				urlCon.setDoOutput(true);
				urlCon.setRequestProperty("connection", "Keep-Alive"); 
				os = new DataOutputStream( urlCon.getOutputStream() );
			    os.write( "".getBytes("UTF-8"), 0, 0);
			    os.flush();
			    os.close();
			}
			
			if (param != null && (param instanceof JSONObject || param instanceof JSON)) {
				urlCon.setDoOutput(true);
				urlCon.setRequestProperty("Content-type", "application/json");
				urlCon.getOutputStream().write(param.toString().getBytes("UTF-8"));
				urlCon.getOutputStream().flush();
				urlCon.getOutputStream().close();
			}
			in = urlCon.getInputStream();
			rd = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line = rd.readLine();
			StringBuffer jsonResult = new StringBuffer();
			while (line != null) {
				jsonResult.append(line);
				line = rd.readLine();
			}
			rd.close();
			in.close();
			return jsonResult.toString();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    try {
		    	if (urlCon != null){
					urlCon.disconnect();
				}
		    	in.close();
		    	os.flush();
			    os.close();
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public static void main(String[] args){
		//sendSmstxet("1","1","1");
		
		//援黔专家电话号码
		//String phoneString = "13693017013,13910846276,13910682830,13637818469,13637818469,18800096159,13916808925,15121007346,13810828816,13891827088,13679223501,13759968645,18918168626,18940251286,13756661657,18538088666,18980798343,13903069756,15889932190,13825017156,13501502570,13729887477,13503000739,13416119782,13802728718,13688877762,13688896122,13602751067,13613836399,15903650068,13303718122,13937390312,13592632788,13606622335,18017317460,18121186232,13651635103,18908384529,15903467396,13191088639,13803415810,13831161533,13831449988,18168779099,13962142066,13951017570,18806182060,13779202158,13802741263,18810399309,18622221119,13820694956,18622221081,18622221116,18622221371,15022590166,13516197009,18622221220,13564783816,13920500251,13361970633,13693681964,13298322770,18980601393,13511070389,13903050912,13651860058,13605695785,15611161118,18998290037,13570578779,13801683953,13701175948,13834567932,13601284793,13602852486,13805019603,18811695810,13681233816,13910862127,13910606017,13581889908,13808320718,13929530968,13974834760,18623340529,18680751726,13621766316,13701648848,13917526549,13702553272,13608327189,13302296795,13908090356,13551854270,13678099356,13808183558,18602875710,13088090513,13981783585,13808014978,13688121165,13666289881,13503070147,13685789087,18980601759,13901991406,13396726198,13665728018,18957090008,13926402695,13911516133,13883011991,13906527573,13691143164,13759505722,13888087347,13910093095,15816869102,13808800462,13609007501,13556011431,13705161766,13916328546,13482752965,13368259015,13908353989,13193182228,13708388336,13983836636,13818500747,13600481606,13801168389,13801653427,13983827031,13508308400,13501360249,13975869106,13311108089,13801068802,13602883408,13926060228,13910580602,18988803320,13911025210,13651268031,13587604949,13436199699,15657005386,13883652913,13883007291,13776048328,18611372996,13322800919,13541233090,18081892592,13881979669,13901380726,18665032086,18696620885,13770716006,13638356728,13594231239,18126255922,13901870631,18917683428,18930313198,13386259725,13651806976,13320204766,13508300283,13761635280,18902233735,18917762157,13725263051,18017591123,15553119066,13003116904,13801847125,13601063320,13801237287,13801237288,13725263051,13911461681,13370115036,15320206699,18017590817,13370110029,13512349982,13816880710,13370115058,13808041931,13601366216,18980601425,13916688508,13951680478,13386259572,18917762321,13701019752,13001078062,13910305972,13101363078,13883084710,18811125660,13808016043,13917183273,13651811278,13564694660,13301228838,13605717326,13911049472,15320253729,13910772598,13439011779,13801397035,13500052555,13602843010,13701176101,13911785957,18037121120,13633860396,13911993857,13910003909,13910521659,13917526549,13918876439,13602856626,13701277114,13910648318,13520746799,13755053455,13508488502,13380092189,13908506991,15285027410,13639079004,18612452335,18285150137,13985116151";
		
		//省内人员电话号码
		//String phoneString = "17384110052,13985060010,13765446676,13985347792,13885751528,15117520153,13985310028,13985302288,13985913497,13885539921,13908598066,13885343968,13985306199,13595898808,13378586100,15585875225,13985359203,13638199099,13985353564,18985361236,13984754130,13698552559,13708572988,13595720062,15086309766,18985088863,13885250001,15285027410,18285150137,13639079004,18612452335,18310201737,13908506991,13985116151";
		
		//测试人员电话号码
		String phoneString = "18285150137,13169642569,13842855651";
		
		//援黔专家9月1号上午内容
		//String content = "尊敬的援黔专家，欢迎您来到爽爽的贵阳，出席2017医疗卫生援黔专家团走进贵阳活动。贵阳天气9月1日多云，27℃/20℃，空气质量：优，9月2日阵雨，27℃/21℃。祝您在筑期间身体健康，万事如意！";
		
		//援黔专家9月1号下午内容
		//String content = "尊敬的援黔专家，2017医疗卫生援黔专家团走进贵阳活动开幕式，将于9月2日上午08:30准时举行，敬请出席。";
		
		//省内人员9月1号临时内容
		//String content = "尊敬的各位领导，欢迎您参加2017医疗卫生援黔专家团走进贵阳活动，给您预订的酒店是：贵州省盘江饭店。地址：观山湖区林城西路95号，联系电话：0851—88206888，联系人：林经理18685028328，早餐地点：B座三楼，早餐时间：6：30－9：00";
		
		//省内人员9月1号临时内容
		//String content  = "尊敬的各位领导：您好！贵阳市卫计委工作人员在盘江饭店一楼大厅设置了报到点。请还未报到的领导及时报到，领取参会证和会议手册，谢谢！";
		
		//省内人员和援黔专家 9月1号内容
		//String content = "尊敬的各位领导、各位专家，您好！由于明天省里有重要安排，开幕式和健步走议程稍有变动，开会时间地点不变，届时，敬请您佩戴好参会证件准时出席。";
		
		String content = "尊敬的领导、专家：请到盘江酒店一楼大厅领取雨伞。谢谢！";
		/**for(String s : phoneString.split(",")){
			sendSmstxet("http://www.h-guiyang.com/smsservice/sendSms",s,content);
			System.out.println("号码已发送："+s);
		}**/
		sendSmstxet("http://www.h-guiyang.com/smsservice/sendSms",phoneString,content);
//		System.out.println("发送内容："+content);
		
	}
}
