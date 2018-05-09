package com.googlecode.hotire.model;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.annoation.Order;
import com.googlecode.hotire.constants.MessageFieldType;

/**
 * 
 * @author : hoTire
 * @comment : Request (correct way) 
 */
public class RequestMessage extends BaseMessage {
	@FixedString(value=8, type=MessageFieldType.ALPHABET) @Order(1)
	private String organizationCode;
	@FixedString(value=20, type=MessageFieldType.NUMERIC) @Order(2)
	private String chaserNumber;
	
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getChaserNumber() {
		return chaserNumber;
	}
	public void setChaserNumber(String chaserNumber) {
		this.chaserNumber = chaserNumber;
	}
}
