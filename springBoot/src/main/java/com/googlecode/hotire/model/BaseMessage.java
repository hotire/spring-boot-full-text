package com.googlecode.hotire.model;

import com.googlecode.hotire.utils.MessageParser;


public interface BaseMessage {
	default String getMessage() {
		return MessageParser.getMessage(this);
	}
}
