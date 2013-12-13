package com.tellme.common.util;

import java.io.UnsupportedEncodingException;

import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.entity.User;

import io.netty.buffer.ByteBuf;

public class CoderTools {
	public static  byte[] getencoderChecksum(ByteBuf buf) {
		return new byte[]{1};
		
	}
	public static  byte[] getDecoderChecksum(ByteBuf buf) {
		return new byte[]{1};
		
	}
	public static  byte[] CalculaterChecksum(ByteBuf buf) {
		return new byte[]{1};
		
	}
	public static int getCrc16(Byte[] buffer) {
	    return getCrc16(buffer, 0, buffer.length, 0xA001, 0);
	    }

	public synchronized static int getCrc16(Byte[] buffer, int offset, int bufLen, int polynom, int preset) {
	    preset &= 0xFFFF;
	    polynom &= 0xFFFF;
	    int crc = preset;
	    for (int i = 0; i < bufLen; i++) {
	        int data = buffer[i + offset] & 0xFF;
	        crc ^= data;
	        for (int j = 0; j < 8; j++) {
	            if ((crc & 0x0001) != 0) {
	                crc = (crc >> 1) ^ polynom;
	            } else {
	                crc = crc >> 1;
	            }
	        }
	    }
	    return crc & 0xFFFF;
	}
	public static String  encryPasswd(User user)
	{
		String name=user.getName();
		String passwdString=user.getPasswd();
		byte[] namebyte=StringUtil.StringtoByte(name);
		byte[] passbyte=StringUtil.StringtoByte(passwdString);
		byte[] appsecrete=StringUtil.StringtoByte(AppConfig.APPSCRETE);
		byte[] namepass=new byte[namebyte.length+passbyte.length];
		return null;
	}

}
