package com.googlecode.hotire.utils;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.RequestMessage;
import com.googlecode.hotire.model.ResponseMessage;
import org.junit.Assert;
import org.junit.Test;

public class MessageFactoryTest {

  @Test
  public void create_response() {
    final BaseMessage baseMessage = MessageFactory.createMessage(MessageType.RESPONSE);
    Assert.assertTrue(baseMessage instanceof  ResponseMessage);
  }

  @Test
  public void create_request() {
    final BaseMessage baseMessage = MessageFactory.createMessage(MessageType.REQUEST);
    Assert.assertTrue(baseMessage instanceof RequestMessage);
  }
}