package com.server.tellme.test;

import java.io.UnsupportedEncodingException;

import org.json.JSONObject;


import com.tellme.common.entity.TellMeMessageData;
import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.entity.User;
import com.tellme.common.util.StringUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User user=new User();
//		user.setName("tellme");
//		JSONObject json=new JSONObject(user);
//		String string=json.toString();
//		try {
//			byte[] bt=string.getBytes("UTF-8");
//			String dataString=StringUtil.hexToString(bt);
//			System.out.println(dataString);
//			byte[] temp=StringUtil.stringToHex(dataString);
//			String tempstring=new String(temp);
//			System.out.println(tempstring);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		TellMeMessageData n=new TellMeMessageData();
		n.setId("得到");
		byte[] b=TellMeMsg.decodeData(n);
		String dString=StringUtil.bytesToHexString(b);
		System.out.println(dString);
		byte[] encd=StringUtil.hexStringToBytes(dString);
		char[] chs=StringUtil.bytetoChar(encd);
		for(char c:chs)
		{
			System.out.print(c);
		}
		System.out.println();
		System.out.println(StringUtil.bytetoString(encd));
		


	}

}
