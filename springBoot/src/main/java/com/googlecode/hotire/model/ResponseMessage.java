package com.googlecode.hotire.model;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.annoation.Order;
import com.googlecode.hotire.constants.MessageFieldType;

/**
 * 
 * @author : hoTire
 * @comment : Response (correct way)
 */
public class ResponseMessage extends BaseMessage {
	@FixedString(value=4, type=MessageFieldType.ALPHABET) @Order(1)
	private String responseCode;
	@FixedString(value=20, type=MessageFieldType.NUMERIC) @Order(2)
	private String chaserNumber;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getChaserNumber() {
		return chaserNumber;
	}
	public void setChaserNumber(String chaserNumber) {
		this.chaserNumber = chaserNumber;
	}
	
}
