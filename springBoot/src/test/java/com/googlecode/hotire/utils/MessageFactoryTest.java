package com.googlecode.hotire.utils;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.ResponseMessage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageFactoryTest {

  @Test
  public void create_response() {
    final BaseMessage result = MessageFactory.createMessage(MessageType.RESPONSE);
    assertThat(result).isInstanceOf(ResponseMessage.class);
  }

  @Test
  public void create_request() {
    final BaseMessage result = MessageFactory.createMessage(MessageType.REQUEST);
    assertThat(result).isInstanceOf(ResponseMessage.class);
  }
}