package com.googlecode.hotire.utils;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.RequestMessage;
import com.googlecode.hotire.model.ResponseMessage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageFactory {

  private static final Map<MessageType, Supplier<BaseMessage>> FACTORY;

  static {
    FACTORY = new HashMap<>();
    FACTORY.put(MessageType.REQUEST, RequestMessage::new);
    FACTORY.put(MessageType.RESPONSE, ResponseMessage::new);
  }

  public static BaseMessage createMessage(final MessageType messageType) {
    return Optional.ofNullable(FACTORY.get(messageType))
                   .map(Supplier::get)
                   .orElseThrow(() -> new IllegalArgumentException("해당 Message Type 이 존재하지 않습니다. : " + messageType));
  }
}
