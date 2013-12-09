package com.tcyclient.tellme.util;



public class StringUtil {
	public static String hexToString(byte[] ids){
		StringBuffer id = new StringBuffer();
		for(int i = 0; i < ids.length; i ++) {
			char c = (char)(((ids[i] >> 4) & 0x0f) + 0x30);
			id.append(c);
			c = (char)(((ids[i]) & 0x0f) + 0x30);
			id.append(c);
		}
		
		return id.toString();
	}
	
	public static byte[] stringToHex(String ids){
		byte[] buf = new byte[ids.length()/2];
		
		for(int i = 0, j=0; i < buf.length; i ++,j+=2) {
			byte h = (byte) ((byte) ids.charAt(j) - 0x30);
			byte l = (byte) ((byte) ids.charAt(j+1) - 0x30);
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

}
