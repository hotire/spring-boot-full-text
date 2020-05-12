package com.googlecode.hotire.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseMessageTest {

    @Test
    void getResponseCode() {
        // given
        final String responseCode = "";
        final ResponseMessage message = new ResponseMessage().setResponseCode(responseCode);

        // when
        final String result = message.getResponseCode();

        // then
        assertThat(result).isEqualTo(responseCode);
    }

    @Test
    void getDebugId() {
        // given
        final String debugId = "";
        final ResponseMessage message = new ResponseMessage().setDebugId(debugId);

        // when
        final String result = message.getDebugId();

        // then
        assertThat(result).isEqualTo(debugId);
    }
}