package com.googlecode.hotire.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.googlecode.hotire.constants.MessageType;
import com.googlecode.hotire.model.ResponseMessage;
import com.googlecode.hotire.service.FullTextService;
import com.googlecode.hotire.utils.MessageFactory;
import com.googlecode.hotire.utils.MessageParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(FullTextController.class)
public class FullTextControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  FullTextService fullTextService;

  private final String TEST_DATA = "10011000010000100001000010000";

  @Test
  public void parse() throws Exception {
    ResponseMessage responseMessage = (ResponseMessage) MessageFactory.createMessage(MessageType.RESPONSE);
    MessageParser.parseMessage(TEST_DATA, responseMessage);
    when(fullTextService.parse(TEST_DATA)).thenReturn(responseMessage);

    mockMvc
      .perform(get("/api/v1/fulltext/" + TEST_DATA))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.responseCode").value("1001"))
      .andExpect(jsonPath("$.chaserNumber").value("10000100001000010000"))
      .andExpect(jsonPath("$.message").value("100110000100001000010000"))
      .andDo(print());
  }
}