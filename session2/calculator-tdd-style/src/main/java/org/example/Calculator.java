package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    // Addition methods for all numeric types
    public int add(int a, int b) {
        return a + b;
    }

    public long add(long a, long b) {
        return a + b;
    }

    public short add(short a, short b) {
        return (short) (a + b);
    }

    public float add(float a, float b) {
        return roundToFourDecimalPlaces(a + b);
    }

    public double add(double a, double b) {
        return roundToFourDecimalPlaces(a + b);
    }

    // Subtraction methods for all numeric types
    public int subtract(int a, int b) {
        return a - b;
    }

    public long subtract(long a, long b) {
        return a - b;
    }

    public short subtract(short a, short b) {
        return (short) (a - b);
    }

    public float subtract(float a, float b) {
        return roundToFourDecimalPlaces(a - b);
    }

    public double subtract(double a, double b) {
        return roundToFourDecimalPlaces(a - b);
    }

    // Multiplication methods for all numeric types
    public int multiply(int a, int b) {
        return a * b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    public short multiply(short a, short b) {
        return (short) (a * b);
    }

    public float multiply(float a, float b) {
        return roundToFourDecimalPlaces(a * b);
    }

    public double multiply(double a, double b) {
        return roundToFourDecimalPlaces(a * b);
    }

    // Division methods for all numeric types
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public long divide(long a, long b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public short divide(short a, short b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (short) (a / b);
    }

    public float divide(float a, float b) {
        // For float and double, division by zero returns infinity (IEEE 754 standard)
        // but we check for zero to handle the precision requirement
        if (b == 0.0f) {
            return Float.POSITIVE_INFINITY;
        }
        return roundToFourDecimalPlaces(a / b);
    }

    public double divide(double a, double b) {
        // For double, division by zero returns infinity (IEEE 754 standard)
        if (b == 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        return roundToFourDecimalPlaces(a / b);
    }

    // Helper method to round float to 4 decimal places
    private float roundToFourDecimalPlaces(float value) {
        if (Float.isInfinite(value) || Float.isNaN(value)) {
            return value;
        }
        BigDecimal bd = new BigDecimal(Float.toString(value));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    // Helper method to round double to 4 decimal places
    private double roundToFourDecimalPlaces(double value) {
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            return value;
        }
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}