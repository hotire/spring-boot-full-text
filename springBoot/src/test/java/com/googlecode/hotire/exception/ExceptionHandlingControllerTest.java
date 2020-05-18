package com.googlecode.hotire.exception;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class ExceptionHandlingControllerTest {

    @Test
    void handleBaseError() {
        // given
        final ExceptionHandlingController controller = new ExceptionHandlingController();

        // when
        controller.handleBaseError(mock(BaseException.class));

        // no assert
    }
}