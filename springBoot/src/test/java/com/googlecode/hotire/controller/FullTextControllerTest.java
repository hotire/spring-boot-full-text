package com.googlecode.hotire.controller;

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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(FullTextController.class)
public class FullTextControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FullTextService fullTextService;


  @Test
  public void parse() throws Exception {
    // given
    final String data = "10011000010000100001000010000";
    final ResponseMessage responseMessage = (ResponseMessage) MessageFactory.createMessage(MessageType.RESPONSE);
    MessageParser.parseMessage(data, responseMessage);

    // when then
    when(fullTextService.parse(data)).thenReturn(responseMessage);

    mockMvc
      .perform(get("/api/v1/fulltext/" + data))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.responseCode").value("1001"))
      .andExpect(jsonPath("$.chaserNumber").value("10000100001000010000"))
      .andExpect(jsonPath("$.message").value("100110000100001000010000"))
      .andDo(print());
  }
}