package com.tellme.common.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class StringUtil {
	public static String hexToString(byte[] ids) {
		StringBuffer id = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			char c = (char) (((ids[i] >> 4) & 0x0f) + 0x30);
			id.append(c);
			c = (char) (((ids[i]) & 0x0f) + 0x30);
			id.append(c);
		}

		return id.toString();
	}

	public static byte[] stringToHex(String ids) {
		byte[] buf = new byte[ids.length() / 2];

		for (int i = 0, j = 0; i < buf.length; i++, j += 2) {
			byte h = (byte) ((byte) ids.charAt(j) - 0x30);
			byte l = (byte) ((byte) ids.charAt(j + 1) - 0x30);
			buf[i] = (byte) (h << 4 | l);
		}

		return buf;
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static byte[] StringtoByte(String data) {
		try {
			return data.getBytes(AppConfig.DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String ConvertHexString(byte[] b) {
		String a = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}

			a = a + hex;
		}

		return a;
	}
	 public static String bytesToHexString(byte[] src){
	        StringBuilder stringBuilder = new StringBuilder("");
	        if (src == null || src.length <= 0) {
	            return null;
	        }
	        for (int i = 0; i < src.length; i++) {
	            int v = src[i] & 0xFF;
	            String hv = Integer.toHexString(v);
	            if (hv.length() < 2) {
	                stringBuilder.append(0);
	            }
	            stringBuilder.append(hv);
	        }
	        return stringBuilder.toString();
	    }
	 public static String bytetoString(byte[] b)
	 {
		 try {
			return new String(b,AppConfig.DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
	 public static char[] bytetoChar(byte[] bytes)
	 {
		   Charset cs = Charset.forName (AppConfig.DEFAULT_CHARSET);
		      ByteBuffer bb = ByteBuffer.allocate (bytes.length);
		      bb.put (bytes);
		                 bb.flip ();
		       CharBuffer cb = cs.decode (bb);
		  
		   return cb.array();
		 
	 }

}
