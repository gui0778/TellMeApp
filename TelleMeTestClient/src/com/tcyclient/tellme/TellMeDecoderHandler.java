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
			logger.info("recevice from client msg=="+buf.toString());
		}
		ByteBuf checksumbuf=Unpooled.buffer();
		buf.readBytes(checksumbuf, buf.readableBytes()-TellMeMsg.DEFAULT_TAIL_LEN, TellMeMsg.DEFAULT_TAIL_LEN);
		byte[] recivecechecksum=CoderTools.getDecoderChecksum(checksumbuf);
		byte[] testchecksum=CoderTools.CalculaterChecksum(buf);
		if(!recivecechecksum.equals(testchecksum))
		{
			logger.error("checksum errot--");
			return;
			
		}
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
		byte[] msgdata = new byte[msglen-TellMeMsg.DEFAULT_TAIL_LEN-TellMeMsg.DEFAULT_HEAD_LEN];
		TellMeMessageData msgbean=null;
		buf.readBytes(msgdata);
		if(msgdata!=null&&msgdata.length>1)
			{
			msgbean=TellMeMsg.getTellMeData(msgdata);
			}
		TellMeMsg outmsg=new TellMeMsg();
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
		outmsg.setChecksum(StringUtil.bytetoString(recivecechecksum));
		out.add(outmsg);
	}

}
