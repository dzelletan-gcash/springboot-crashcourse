package org.example;

import org.example.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should add two positive integers")
        void shouldAddTwoPositiveIntegers() {
            assertEquals(5, calculator.add(2, 3));
        }

        @Test
        @DisplayName("Should add two negative integers")
        void shouldAddTwoNegativeIntegers() {
            assertEquals(-8, calculator.add(-3, -5));
        }

        @Test
        @DisplayName("Should add positive and negative integers")
        void shouldAddPositiveAndNegativeIntegers() {
            assertEquals(2, calculator.add(5, -3));
        }

        @Test
        @DisplayName("Should add two long values")
        void shouldAddTwoLongValues() {
            assertEquals(3000000000L, calculator.add(1000000000L, 2000000000L));
        }

        @Test
        @DisplayName("Should add two short values")
        void shouldAddTwoShortValues() {
            short a = 100;
            short b = 200;
            assertEquals((short) 300, calculator.add(a, b));
        }

        @Test
        @DisplayName("Should add two float values with precision")
        void shouldAddTwoFloatValues() {
            assertEquals(5.7f, calculator.add(2.3f, 3.4f), 0.0001f);
        }

        @Test
        @DisplayName("Should add two double values with precision")
        void shouldAddTwoDoubleValues() {
            assertEquals(5.7, calculator.add(2.3, 3.4), 0.0001);
        }

        @Test
        @DisplayName("Should handle integer overflow")
        void shouldHandleIntegerOverflow() {
            // This will overflow and wrap around
            assertEquals(Integer.MIN_VALUE, calculator.add(Integer.MAX_VALUE, 1));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Should subtract two positive integers")
        void shouldSubtractTwoPositiveIntegers() {
            assertEquals(2, calculator.subtract(5, 3));
        }

        @Test
        @DisplayName("Should subtract negative from positive")
        void shouldSubtractNegativeFromPositive() {
            assertEquals(8, calculator.subtract(5, -3));
        }

        @Test
        @DisplayName("Should subtract positive from negative")
        void shouldSubtractPositiveFromNegative() {
            assertEquals(-8, calculator.subtract(-5, 3));
        }

        @Test
        @DisplayName("Should subtract two long values")
        void shouldSubtractTwoLongValues() {
            assertEquals(1000000000L, calculator.subtract(3000000000L, 2000000000L));
        }

        @Test
        @DisplayName("Should subtract two short values")
        void shouldSubtractTwoShortValues() {
            short a = 200;
            short b = 100;
            assertEquals((short) 100, calculator.subtract(a, b));
        }

        @Test
        @DisplayName("Should subtract two float values")
        void shouldSubtractTwoFloatValues() {
            assertEquals(1.1f, calculator.subtract(3.4f, 2.3f), 0.0001f);
        }

        @Test
        @DisplayName("Should subtract two double values")
        void shouldSubtractTwoDoubleValues() {
            assertEquals(1.1, calculator.subtract(3.4, 2.3), 0.0001);
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Should multiply two positive integers")
        void shouldMultiplyTwoPositiveIntegers() {
            assertEquals(15, calculator.multiply(3, 5));
        }

        @Test
        @DisplayName("Should multiply positive and negative integers")
        void shouldMultiplyPositiveAndNegativeIntegers() {
            assertEquals(-15, calculator.multiply(3, -5));
        }

        @Test
        @DisplayName("Should multiply two negative integers")
        void shouldMultiplyTwoNegativeIntegers() {
            assertEquals(15, calculator.multiply(-3, -5));
        }

        @Test
        @DisplayName("Should multiply by zero")
        void shouldMultiplyByZero() {
            assertEquals(0, calculator.multiply(5, 0));
        }

        @Test
        @DisplayName("Should multiply two long values")
        void shouldMultiplyTwoLongValues() {
            assertEquals(6000000000L, calculator.multiply(2000000000L, 3L));
        }

        @Test
        @DisplayName("Should multiply two short values")
        void shouldMultiplyTwoShortValues() {
            short a = 10;
            short b = 20;
            assertEquals((short) 200, calculator.multiply(a, b));
        }

        @Test
        @DisplayName("Should multiply two float values")
        void shouldMultiplyTwoFloatValues() {
            assertEquals(7.82f, calculator.multiply(2.3f, 3.4f), 0.0001f);
        }

        @Test
        @DisplayName("Should multiply two double values")
        void shouldMultiplyTwoDoubleValues() {
            assertEquals(7.82, calculator.multiply(2.3, 3.4), 0.0001);
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide two positive integers")
        void shouldDivideTwoPositiveIntegers() {
            assertEquals(2, calculator.divide(6, 3));
        }

        @Test
        @DisplayName("Should divide positive and negative integers")
        void shouldDividePositiveAndNegativeIntegers() {
            assertEquals(-2, calculator.divide(6, -3));
        }

        @Test
        @DisplayName("Should divide two negative integers")
        void shouldDivideTwoNegativeIntegers() {
            assertEquals(2, calculator.divide(-6, -3));
        }

        @Test
        @DisplayName("Should throw exception when dividing integer by zero")
        void shouldThrowExceptionWhenDividingIntegerByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        }

        @Test
        @DisplayName("Should divide two long values")
        void shouldDivideTwoLongValues() {
            assertEquals(1000000000L, calculator.divide(3000000000L, 3L));
        }

        @Test
        @DisplayName("Should throw exception when dividing long by zero")
        void shouldThrowExceptionWhenDividingLongByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(5L, 0L));
        }

        @Test
        @DisplayName("Should divide two short values")
        void shouldDivideTwoShortValues() {
            short a = 100;
            short b = 20;
            assertEquals((short) 5, calculator.divide(a, b));
        }

        @Test
        @DisplayName("Should throw exception when dividing short by zero")
        void shouldThrowExceptionWhenDividingShortByZero() {
            short a = 5;
            short b = 0;
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }

        @Test
        @DisplayName("Should divide two float values")
        void shouldDivideTwoFloatValues() {
            assertEquals(2.5f, calculator.divide(5.0f, 2.0f), 0.0001f);
        }

        @Test
        @DisplayName("Should handle float division by zero")
        void shouldHandleFloatDivisionByZero() {
            // For float, division by zero returns infinity, not exception
            assertEquals(Float.POSITIVE_INFINITY, calculator.divide(5.0f, 0.0f));
        }

        @Test
        @DisplayName("Should divide two double values")
        void shouldDivideTwoDoubleValues() {
            assertEquals(2.5, calculator.divide(5.0, 2.0), 0.0001);
        }

        @Test
        @DisplayName("Should handle double division by zero")
        void shouldHandleDoubleDivisionByZero() {
            // For double, division by zero returns infinity, not exception
            assertEquals(Double.POSITIVE_INFINITY, calculator.divide(5.0, 0.0));
        }

        @Test
        @DisplayName("Should handle float precision correctly")
        void shouldHandleFloatPrecision() {
            float result = calculator.divide(10.0f, 3.0f);
            assertEquals(3.3333f, result, 0.0001f);
        }

        @Test
        @DisplayName("Should handle double precision correctly")
        void shouldHandleDoublePrecision() {
            double result = calculator.divide(10.0, 3.0);
            assertEquals(3.3333, result, 0.0001);
        }
    }
}