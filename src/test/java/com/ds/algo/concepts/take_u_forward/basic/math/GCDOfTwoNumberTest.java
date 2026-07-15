package com.ds.algo.concepts.take_u_forward.basic.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GCDOfTwoNumberTest {

    @Test
    void computesGcdForPositiveNumbers() {
        assertEquals(12, GCDOfTwoNumber.gcd(36, 60));
    }

    @Test
    void handlesWhenOneValueIsZero() {
        assertEquals(5, GCDOfTwoNumber.gcd(0, 5));
        assertEquals(7, GCDOfTwoNumber.gcd(7, 0));
    }

    @Test
    void handlesNegativeValues() {
        assertEquals(6, GCDOfTwoNumber.gcd(-24, 18));
        assertEquals(9, GCDOfTwoNumber.gcd(-27, -9));
    }

    @Test
    void throwsForBothZeros() {
        assertThrows(IllegalArgumentException.class, () -> GCDOfTwoNumber.gcd(0, 0));
    }
}

