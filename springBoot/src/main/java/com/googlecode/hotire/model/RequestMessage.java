package com.googlecode.hotire.model;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.annoation.Order;
import com.googlecode.hotire.constants.MessageFieldType;
import lombok.Data;

@Data
public class RequestMessage extends BaseMessage {
	@FixedString(value = 8, type = MessageFieldType.ALPHABET)
	@Order(1)
	private String organizationCode;
	@FixedString(value = 20, type = MessageFieldType.NUMERIC)
	@Order(2)
	private String chaserNumber;
}
