package com.googlecode.hotire.service;

import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.model.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class TestFullTextServiceTest {

  private final String TEST_DATA = "10011000010000100001000010000";
  private final FullTextService fullTextService = new FullTextService();

  @Test
  public void parse() {
    final ResponseMessage responseMessage = fullTextService.parse(TEST_DATA);
    Assert.assertEquals("1001", responseMessage.getResponseCode());
    Assert.assertEquals("10000100001000010000", responseMessage.getChaserNumber());
  }
}