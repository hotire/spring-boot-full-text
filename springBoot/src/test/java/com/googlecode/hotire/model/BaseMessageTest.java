package com.googlecode.hotire.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseMessageTest {

    @Test
    void getMessage() {
        // given
        final BaseMessage message = new BaseMessage() {};

        // when
        final String result = message.getMessage();

        // then
        assertThat(result).isEmpty();
    }
}