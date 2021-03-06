package com.tcyclient.tellme;

import java.util.List;

import org.apache.log4j.Logger;

import com.tellme.common.entity.TellMeMessageData;
import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.util.CoderTools;
import com.tellme.common.util.StringUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class TellMeDecoderHandler extends MessageToMessageDecoder<ByteBuf> {
	private static final Logger logger = Logger.getLogger(TellMeDecoderHandler.class);
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		logger.error("client error,had close");
	}

	//将原始数据转化成内部使用的object
	@Override
	protected void decode(ChannelHandlerContext arg0,ByteBuf buf, List<Object> out)
			throws Exception {
		
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled())
		{
			logger.info("recevice from client msg==");
		}
		int len=buf.readableBytes();
		int msglen=buf.readInt();
		int channel=buf.readInt();
		int cmd=buf.readInt();
		int rescmd=buf.readInt();
		int version=buf.readInt();
		long sendtime=buf.readLong();
		int packettotal=buf.readInt();
		int packetindex=buf.readInt();
		long serial=buf.readLong();
		long nextserial=buf.readLong();


		byte[] msgdata=new byte[len-TellMeMsg.DEFAULT_TAIL_LEN-TellMeMsg.DEFAULT_HEAD_LEN];
		buf.readBytes(msgdata);
		TellMeMessageData msgbean=null;
		if(msgdata!=null&&msgdata.length>5)
			{
			msgbean=TellMeMsg.getTellMeData(msgdata);
			}
		byte[] checksum=new byte[32];
		buf.readBytes(checksum);
		TellMeMsg outmsg=new TellMeMsg();
		outmsg.setMsglen(msglen);
		outmsg.setCmd(cmd);
		outmsg.setChannel(channel);
		outmsg.setRescmd(rescmd);
		outmsg.setVersion(version);
		outmsg.setSendtime(sendtime);
		outmsg.setPackettotal(packettotal);
		outmsg.setPacketindex(packetindex);
		outmsg.setSerial(serial);
		outmsg.setNextserial(nextserial);
		outmsg.setTellmedata(msgbean);
		outmsg.setChecksum(StringUtil.bytetoString(checksum));
		out.add(outmsg);
	}

}
