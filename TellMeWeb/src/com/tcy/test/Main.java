package com.tcy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import com.tellme.common.entity.User;
import com.tellme.common.util.CommonUtil;
import com.tellme.common.util.WeiXinUtil;
import com.tellme.weixin.entity.BaseWeixinMsg;
import com.tellme.weixin.entity.WeixinEventMsg;

public class Main {

	/**
	 * @param args
	 */
	static String textweixn="<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event></xml>";
	static String testdocString="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><note><to>Lin</to><from>Ordm</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
	    	WeiXinUtil wxutil=new WeiXinUtil();
	    	String sortstring=wxutil.BuildSignString("1381111111411", "tancyu");
	    	System.out.println(sortstring);
	    	System.out.println(wxutil.encrypt(sortstring));
	    	String xml="<root><users><user><name>tancyu</name></user><user><name>slimo</name></user></users></root>";
	    	JSONArray obejct=wxutil.getJSONObject(textweixn);
	    	JSONObject json=JSONObject.fromObject(obejct.optJSONObject(0));
	    	System.out.println(json.toString());
	    	User user=new User();
	    	user.setName("tancyu");

	    	CommonUtil com=new CommonUtil();
	    	WeixinEventMsg eventmsg=(WeixinEventMsg)com.JSONObjectToBean(json,WeixinEventMsg.class);
	    	System.out.println(eventmsg.getCreateTime());
	    	**/
		//buildtestfilexml();
		//buildxmlfromjson();
    	CommonUtil com=new CommonUtil();
    	System.out.println(testdocString);
    	Document doc=com.fromString(testdocString);
    	System.out.println(doc.getRootElement().getName());
	    

	}
	public static void buildtestfilexml()
	{
    	CommonUtil com=new CommonUtil();
    	File file=new File("weixintext.xml");
    	try {
			InputStream in=new FileInputStream(file);
			JSONArray jsonArray=com.getJSONArray(in);
			System.out.println(jsonArray.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void buildxmlfromjson()
	{
		WeixinEventMsg user=new WeixinEventMsg();
		String xml=CommonUtil.fromJavaToXML(user,"root");
		//xml.replace("", replacement)
		System.out.println(xml);
	}
}
