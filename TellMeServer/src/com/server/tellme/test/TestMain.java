package com.server.tellme.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;


import com.tellme.common.entity.MsgContent;
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
		User user=new User("tt");
		MsgContent m=new MsgContent();
		m.setFilename("ggg");
		List<MsgContent> list=new LinkedList<MsgContent>();
		list.add(m);
		n.setMsgcontent(list);
		n.setOrganziner(user);
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
		String str=StringUtil.bytetoString(encd);
		System.out.println(str);
		net.sf.json.JSONObject jsonObject=net.sf.json.JSONObject.fromObject(str);
		TellMeMessageData beandata=(TellMeMessageData)net.sf.json.JSONObject.toBean(jsonObject, TellMeMessageData.class);
		System.out.println(beandata.getOrganziner().getName());
		System.out.println(beandata.getMsgcontent().get(0));
		long l=1;
		ByteBuf buf=Unpooled.buffer();
		buf.writeLong(l);
		System.out.println(buf.readableBytes());
		System.out.println(buf.readLong());
		


	}

}
