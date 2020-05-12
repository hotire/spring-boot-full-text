package com.googlecode.hotire.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseExceptionTest {

    @Test
    void getMessage() {
        // given
        final String message = "";
        final BaseException baseException = new BaseException(message);

        // when
        final String result = baseException.getMessage();

        // then
        assertThat(result).isEqualTo(message);
    }
}