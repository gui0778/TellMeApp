package com.tellme.common.util;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.springframework.beans.factory.annotation.Value;

public class WeiXinUtil {
	public final static String TOKEN="";
	public MessageDigest digest;
	@Value(value = "wxalgorithm") 
	public String wxalgorithm="SHA-1";
	@Value(value = "wxtoken") 
	public String wxtoken="test";
	public String getWxalgorithm() {
		return wxalgorithm;
	}
	public void setWxalgorithm(String wxalgorithm) {
		this.wxalgorithm = wxalgorithm;
	}
	public String getWxtoken() {
		return wxtoken;
	}
	public void setWxtoken(String wxtoken) {
		this.wxtoken = wxtoken;
	}
	public String BuildSignString(String timestamp,String nonce) {
		String[] sign=new String[]{timestamp,nonce,wxtoken};
		Arrays.sort(sign);
		StringBuilder sb=new StringBuilder();
		for(String s:sign)
		{
			sb.append(s);
		}
		return sb.toString();
	}
	public  Boolean validtoken(String signature,String timestamp,String nonce)
	{

		String buildsign=BuildSignString(timestamp,nonce);
		String expectedSignature = encrypt(buildsign);
		if(signature.equals(expectedSignature))
		{
			return true;
		}
		else{
			return false;
		}
	}
	public WeiXinUtil()
	{
		try {
			digest=MessageDigest.getInstance(wxalgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public String encrypt(String strSrc) {  
	        String strDes = null;  
	        byte[] bt = strSrc.getBytes();  
	        digest.update(bt);  
	        strDes = byte2hex(digest.digest());  
	        return strDes;  
	    } 
	 /** 
	     * 将字节数组转换成16进制字符串 
	     * @param b 
	     * @return 
	     */  
	 public static String byte2hex(byte[] b) {  
	        StringBuilder sbDes = new StringBuilder();  
	        String tmp = null;  
	        for (int i = 0; i < b.length; i++) {  
	            tmp = (Integer.toHexString(b[i] & 0xFF));  
	            if (tmp.length() == 1) {  
	                sbDes.append("0");  
	            }  
	            sbDes.append(tmp);  
	        }  
	        return sbDes.toString();  
	    }


}
