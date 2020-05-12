package com.googlecode.hotire.service;

import com.googlecode.hotire.model.ResponseMessage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFullTextServiceTest {
    @Test
    public void parse() {
      // given
      final String data = "10011000010000100001000010000";
      final FullTextService fullTextService = new FullTextService();

      // when
      final ResponseMessage result = (ResponseMessage) fullTextService.parse(data);

      // then
      assertThat(result.getResponseCode()).isEqualTo("1001");
      assertThat(result.getDebugId()).isEqualTo("10000100001000010000");
   }
}