package com.tcyclient.tellme;

public class TellMeMsg {
	public int version=0x0001;
	public int channel=0x0001;
	public long msglen=0x001;
	public int cmd=0x0001;
	public String checksum="";
	public long sendtime=0;
	public byte[] orginmsg;
	public byte[] body;
	public byte[] getBody() {
		return body;
	}
	public void setBody(byte[] body) {
		this.body = body;
	}
	public MsgBody msgbody;
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
	public byte[] getOrginmsg() {
		return orginmsg;
	}
	public void setOrginmsg(byte[] orginmsg) {
		this.orginmsg = orginmsg;
	}
	public MsgBody getMsgbody() {
		return msgbody;
	}
	public void setMsgbody(MsgBody msgbody) {
		this.msgbody = msgbody;
	}
	class MsgBody{
		
	}
}
