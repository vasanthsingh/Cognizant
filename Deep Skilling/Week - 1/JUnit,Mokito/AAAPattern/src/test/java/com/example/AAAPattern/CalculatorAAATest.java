package com.example.AAAPattern;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Setup: executed before each test
        calculator = new Calculator();
        System.out.println("Setup completed.");
    }

    @AfterEach
    public void tearDown() {
        // Teardown: executed after each test
        calculator = null;
        System.out.println("Teardown completed.");
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }
}