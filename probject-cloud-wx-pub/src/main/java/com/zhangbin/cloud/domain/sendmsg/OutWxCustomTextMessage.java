package com.zhangbin.cloud.domain.sendmsg;

import com.alibaba.fastjson.JSONObject;

public class OutWxCustomTextMessage extends OutWxCustomMessage {
	
	private OutWxCustomTextMessageContent text;

	public OutWxCustomTextMessageContent getText() {
		return text;
	}

	public void setText(OutWxCustomTextMessageContent text) {
		this.text = text;
	}
	
	
	@Override
	public String toString() {
		return "OutWxCustomTextMessage [text=" + text + "]";
	}

	public static void main(String[] args) {
		OutWxCustomTextMessage outWxCustomTextMessage = new OutWxCustomTextMessage();
		OutWxCustomTextMessageContent outWxCustomTextMessageContent = new OutWxCustomTextMessageContent("hello");
		outWxCustomTextMessage.setText(outWxCustomTextMessageContent);
		System.out.println(outWxCustomTextMessage);
		System.out.println(JSONObject.toJSON(outWxCustomTextMessage));
	}
}
