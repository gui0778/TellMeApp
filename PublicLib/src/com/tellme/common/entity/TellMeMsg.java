package com.tellme.common.entity;

import io.netty.util.internal.StringUtil;

import java.io.Serializable;

import org.json.JSONObject;

public class TellMeMsg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129381791725640134L;
	public int version=0x0001;//6
	public int channel=0x0001;//6
	public long msglen=0x001;//8
	public int cmd=0x0001;//6
	public int rescmd=0x0000;//6
	public long sendtime=0;//15
	public TellMeMessageData tellmedata;
	public String checksum="";//32
	public final static int CMD_LOGIN=0x100003;
	public final static int CMD_OFFLINE=0x100004;
	public final static int RESCMD_REPEAT_LOGIN=0x000004;
	public final static int RESCMD_LOGIN_NORMAL=0x000004;
	public final static long DEFAULT_TAIL_LEN=79;
	public int getRescmd() {
		return rescmd;
	}
	public void setRescmd(int rescmd) {
		this.rescmd = rescmd;
	}

	public TellMeMessageData getTellmedata() {
		return tellmedata;
	}
	public void setTellmedata(TellMeMessageData tellmedata) {
		this.tellmedata = tellmedata;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public long getMsglen() {
		return msglen;
	}
	public void setMsglen(long msglen) {
		this.msglen = msglen;
	}
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public long getSendtime() {
		return sendtime;
	}
	public void setSendtime(long sendtime) {
		this.sendtime = sendtime;
	}
	public TellMeMsg(int cmd)
	{
		this.cmd=cmd;
		
	}
	public TellMeMsg(int cmd,int rescmd)
	{
		this.cmd=cmd;
		this.rescmd=rescmd;
		
	}
	public static byte[] decodeData(TellMeMessageData data)
	{
		JSONObject json=new JSONObject(data);
		String string=json.toString();
		return com.tellme.common.util.StringUtil.StringtoByte(string);
	}
	public  long  getTellMeMsgLen()
	{
		byte[] data=decodeData(this.tellmedata);
		long l=data.length;
		return l+DEFAULT_TAIL_LEN;
		
	}
}
