package com.googlecode.hotire.exception;


import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceExceptionTest {

    @Test
    void responseStatus() {
        // given
        final ServiceException exception = new ServiceException("");

        // when
        final ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);

        // then
        assertThat(responseStatus.code()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(responseStatus.reason()).isEqualTo("ServiceException");
    }
}