package com.googlecode.hotire.model.factory;

import com.googlecode.hotire.exception.ServiceException;
import com.googlecode.hotire.model.BaseMessage;

/**
 * 
 * @author : hoTire
 * @comment : Factory (request, response)
 */
public class MessageFactory {
	private final static String packageName = "com.googlecode.hotire.model.";
	private MessageFactory (){ throw new ServiceException("객체를 생성할 수 없습니다."); }
	public static BaseMessage getMessageInstance(String messageType) {
		try {
			@SuppressWarnings("unchecked")
			Class<? extends BaseMessage> cls = (Class<? extends BaseMessage>) Class.forName(packageName + messageType);
			return cls.newInstance();
		} catch (Exception e) {
			throw new ServiceException("해당 Message가 존재하지 않습니다. : " + messageType);
		}
	}
}
