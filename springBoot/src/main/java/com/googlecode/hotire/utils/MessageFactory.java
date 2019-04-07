package com.googlecode.hotire.utils;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.RequestMessage;
import com.googlecode.hotire.model.ResponseMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MessageFactory {

  private static Map<MessageType, Supplier<BaseMessage>> factory;

  static {
    factory = new HashMap<>();
    factory.put(MessageType.REQUEST, RequestMessage::new);
    factory.put(MessageType.RESPONSE, ResponseMessage::new);
  }

  public static BaseMessage createMessage(MessageType messageType) {
    if (!factory.containsKey(messageType)) {
      throw new IllegalArgumentException("해당 Message Type 이 존재하지 않습니다. : " + messageType);
    }
    return factory.get(messageType).get();
  }
}
