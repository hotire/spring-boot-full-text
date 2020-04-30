package com.googlecode.hotire.utils;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.ResponseMessage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageFactoryTest {

  @Test
  public void create_response() {
    // given
    final BaseMessage result = MessageFactory.createMessage(MessageType.RESPONSE);

    // then
    assertThat(result).isInstanceOf(ResponseMessage.class);
  }

  @Test
  public void create_request() {
    // given
    final BaseMessage result = MessageFactory.createMessage(MessageType.REQUEST);

    // then
    assertThat(result).isInstanceOf(ResponseMessage.class);
  }
}