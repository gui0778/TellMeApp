package com.tellme.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.tellme.app.util.StringUtil;

public class TellMeMsg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129381791725640134L;
	public int version=0x0001;//4
	public int channel=0x0001;//4
	public long msglen=0x001;//4
	public int cmd=0x0001;//4
	public int rescmd=0x0000;//4
	public long sendtime=0;//8
	public int packettotal=1;//4
	public int packetindex=1;//4
	public long serial=0;//8
	public int getPackettotal() {
		return packettotal;
	}
	public void setPackettotal(int packettotal) {
		this.packettotal = packettotal;
	}
	public int getPacketindex() {
		return packetindex;
	}
	public void setPacketindex(int packetindex) {
		this.packetindex = packetindex;
	}
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public long getNextserial() {
		return nextserial;
	}
	public void setNextserial(long nextserial) {
		this.nextserial = nextserial;
	}
	public long nextserial=0;//8
	public TellMeMessageData tellmedata;
	public String checksum="";//32
	public final static int CMD_LOGIN=0x100003;
	public final static int CMD_OFFLINE=0x100004;
	public final static int RESCMD_REPEAT_LOGIN=0x000004;
	public final static int RESCMD_LOGIN_NORMAL=0x000004;
	public final static int DEFAULT_HEAD_LEN=28;
	public final static int DEFAULT_TAIL_LEN=32;
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
		com.tellme.json.JSONObject json=new com.tellme.json.JSONObject(data);
		String string=json.toString();
		return StringUtil.StringtoByte(string);
	}
	public  long  getTellMeMsgLen()
	{
		byte[] data=decodeData(this.tellmedata);
		long l=data.length;
		return l+DEFAULT_TAIL_LEN;
		
	}
	public  byte[] getTellMeData()
	{
		com.tellme.json.JSONObject json=new com.tellme.json.JSONObject(tellmedata);
		String string=json.toString();
		return StringUtil.StringtoByte(string);
	}
}
