package com.tcyclient.tellme;

import java.util.List;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class TellMeDecoderHandler extends MessageToMessageDecoder<ByteBuf> {
	private static final Logger logger = Logger.getLogger(TellMeDecoderHandler.class);
	//将原始数据转化成内部使用的object
	@Override
	protected void decode(ChannelHandlerContext arg0,ByteBuf recevice, List<Object> arg2)
			throws Exception {
		
		// TODO Auto-generated method stub

		byte[] buf=new byte[recevice.readableBytes()];
		recevice.readBytes(buf);
		int len=buf.length;
		//logger.info("decoder start"+recevice.nioBuffers()[0]);
		logger.info("msg len--"+len);
		logger.info("msg data--");
		String str="";
		for(byte b:buf)
		{
			logger.info(b);
			str+=b;
		}
		logger.info(str.toString());
		TellMeMsg msg=new TellMeMsg();
		msg.setMsglen(len);
		arg2.add(msg);
		
	}

}
