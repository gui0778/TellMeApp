package com.server.tellme.test;

import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

import com.server.tellme.entity.User;
import com.tcyclient.tellme.util.StringUtil;
import com.tcyclient.tellme.util.SystemUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName("tellme");
		JSONObject json=new JSONObject(user);
		String string=json.toString();
		try {
			byte[] bt=string.getBytes("UTF-8");
			String dataString=StringUtil.hexToString(bt);
			System.out.println(dataString);
			byte[] temp=StringUtil.stringToHex(dataString);
			String tempstring=new String(temp);
			System.out.println(tempstring);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
