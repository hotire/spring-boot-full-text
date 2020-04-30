package com.googlecode.hotire.model;

import com.googlecode.hotire.utils.MessageParser;


public class BaseMessage {
	public String getMessage() {
		return MessageParser.getMessage(this);
	}
}
