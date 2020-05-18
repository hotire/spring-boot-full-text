package com.googlecode.hotire.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestMessageTest {

    @Test
    void getOrganizationCode() {
        // given
        final String responseCode = "";
        final RequestMessage message = new RequestMessage().setOrganizationCode(responseCode);

        // when
        final String result = message.getOrganizationCode();

        // then
        assertThat(result).isEqualTo(responseCode);
    }

    @Test
    void getDebugId() {
        // given
        final String debugId = "";
        final RequestMessage message = new RequestMessage().setDebugId(debugId);

        // when
        final String result = message.getDebugId();

        // then
        assertThat(result).isEqualTo(debugId);
    }
}