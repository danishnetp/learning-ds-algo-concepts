package com.ds.algo.concepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void greetingShouldReturnExpectedMessage() {
        assertEquals("Hello from Gradle!", App.greeting());
    }
}

