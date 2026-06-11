package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void addition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void stringNotEmpty() {
        String message = "Hello, World!";
        assertFalse(message.isEmpty());
        assertTrue(message.contains("Hello"));
    }

    @Test
    void nullCheck() {
        Object obj = new Object();
        assertNotNull(obj);
    }
}
