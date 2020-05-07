package com.googlecode.hotire.model;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.constants.MessageFieldType;
import lombok.Data;

@Data
public class ResponseMessage implements BaseMessage {
	@FixedString(value = 4, type = MessageFieldType.ALPHABET, order = 1)
	private String responseCode;
	@FixedString(value = 20, type = MessageFieldType.NUMERIC, order = 2)
	private String chaserNumber;
}
