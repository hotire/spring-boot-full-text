package com.googlecode.hotire.service;

import org.springframework.stereotype.Service;

import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.ResponseMessage;
import com.googlecode.hotire.model.factory.MessageFactory;
import com.googlecode.hotire.util.MessageParser;

/**
 * 
 * @author : hoTire
 * @comment : Test Service
 */
@Service
public class TestFullTextService extends BaseService{

	public ResponseMessage test(String test) {
		BaseMessage message = MessageFactory.getMessageInstance("ResponseMessage");
		MessageParser.parseMessage(test,message);
		ResponseMessage response = (ResponseMessage)message;
		return response;
	}
}
