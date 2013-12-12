package com.server.tellme.server;

import java.util.List;

import org.apache.log4j.Logger;

import com.tellme.common.entity.TellMeMessageData;
import com.tellme.common.entity.TellMeMsg;
import com.tellme.common.util.CoderTools;
import com.tellme.common.util.StringUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class TellMeEncodderHander extends MessageToMessageEncoder<TellMeMsg> {
	private static final Logger logger = Logger.getLogger(TellMeEncodderHander.class);
	@Override
	protected void encode(ChannelHandlerContext ctx, TellMeMsg msg,
			List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		TellMeMsg bufmsg = (TellMeMsg)msg;
		int len = bufmsg.getTellMeData().length + TellMeMsg.DEFAULT_HEAD_LEN + TellMeMsg.DEFAULT_TAIL_LEN;
		ByteBuf buf=Unpooled.buffer();
		buf.writeInt(len);
		buf.writeInt(bufmsg.getChannel());
		buf.writeInt(bufmsg.getCmd());
		buf.writeInt(bufmsg.getRescmd());
		buf.writeInt(bufmsg.getVersion());
		buf.writeLong(bufmsg.getSendtime());
		buf.writeInt(bufmsg.getPackettotal());
		buf.writeInt(bufmsg.getPacketindex());
		buf.writeLong(bufmsg.getSerial());
		buf.writeLong(bufmsg.getNextserial());
		buf.writeBytes(bufmsg.getTellMeData());
		byte[] checksum=CoderTools.getencoderChecksum(buf);
		buf.writeBytes(checksum);
		out.add(buf);
		if(logger.isDebugEnabled())
		{
			logger.info("send to client msg--"+bufmsg.getTellmedata().getOrganziner().getName()+":"+buf.toString());
		}
		
		
	}

}
