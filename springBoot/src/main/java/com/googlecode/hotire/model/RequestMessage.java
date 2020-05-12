package com.googlecode.hotire.model;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.constants.MessageFieldType;
import lombok.Data;

@Data
public class RequestMessage implements BaseMessage {
	@FixedString(value = 8, type = MessageFieldType.ALPHABET, order = 1)
	private String organizationCode;
	@FixedString(value = 20, type = MessageFieldType.NUMERIC, order = 2)
	private String debugId;
}
chaserNumber