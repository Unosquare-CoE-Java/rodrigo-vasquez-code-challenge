package com.unosquare.challenge.datastructure01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Challenge01Test {

    @Test
    void shouldPassExampleTest() {
        // Arrange
        final Challenge01 challenge01 = new Challenge01();

        // Act
        challenge01.push(1);
        challenge01.push(2);
        challenge01.push(3);
        challenge01.push(4);
        challenge01.push(5);
        challenge01.push(2);
        challenge01.get(1);
        challenge01.get(2);
        challenge01.get(2);
        challenge01.get(1);
        challenge01.get(0);
        challenge01.push(7);
        challenge01.pop();

        // Assert
        assertNotNull(challenge01.getItems());
        assertEquals(Boolean.FALSE, challenge01.getItems().isEmpty());
        assertEquals(1, challenge01.getItems().get(0).getNumber());
        assertEquals(2, challenge01.getItems().get(1).getNumber());
        assertEquals(3, challenge01.getItems().get(2).getNumber());
        assertEquals(7, challenge01.getItems().get(3).getNumber());
    }
}
