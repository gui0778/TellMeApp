package com.tcy.test;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	WeiXinUtil wxutil=new WeiXinUtil();
	    	String sortstring=wxutil.BuildSignString("1381111111411", "tancyu");
	    	System.out.println(sortstring);
	    	System.out.println(wxutil.encrypt(sortstring));
	    	String textweixn="<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType></xml>";
	    	String xml="<root><users><user><name>tancyu</name></user><user><name>slimo</name></user></users></root>";
	    	JSONArray obejct=wxutil.getJSONObject(textweixn);
	    	JSONObject json=JSONObject.fromObject(obejct.optJSONObject(0));
	    	System.out.println(json.toString());
	    	User user=new User();
	    	user.setName("tancyu");
	    	CommonUtil com=new CommonUtil();
	    	com.setFieldValue(user,"setRegistertime", 124,long.class);
	    	System.out.println("getname--"+com.getFieldValue(user, "getRegistertime"));
	    	BaseWeixinMsg eventmsg=(BaseWeixinMsg)net.sf.json.JSONObject.toBean(json,BaseWeixinMsg.class);
	    	System.out.println(eventmsg.getCreateTime());
	    

	}
}
