package com.googlecode.hotire.model;

import com.googlecode.hotire.utils.MessageParser;

/**
 * 
 * @author : hoTire
 * @comment : Base Message 
 */
public class BaseMessage {
	public String getMessage() {
		return MessageParser.getMessage(this);
	}
}
