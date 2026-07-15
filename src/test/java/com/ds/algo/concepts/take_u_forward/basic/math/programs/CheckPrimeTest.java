package com.ds.algo.concepts.take_u_forward.basic.math.programs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPrimeTest {

    @Test
    void returnsFalseForNonPositiveNumbers() {
        assertFalse(CheckPrime.isPrime(-11));
        assertFalse(CheckPrime.isPrime(0));
        assertFalse(CheckPrime.isPrime(1));
    }

    @Test
    void returnsTrueForSmallPrimeNumbers() {
        assertTrue(CheckPrime.isPrime(2));
        assertTrue(CheckPrime.isPrime(3));
        assertTrue(CheckPrime.isPrime(5));
        assertTrue(CheckPrime.isPrime(7));
    }

    @Test
    void returnsFalseForSmallNonPrimeNumbers() {
        assertFalse(CheckPrime.isPrime(4));
        assertFalse(CheckPrime.isPrime(6));
        assertFalse(CheckPrime.isPrime(9));
        assertFalse(CheckPrime.isPrime(25));
    }

    @Test
    void handlesLargerNumbers() {
        assertTrue(CheckPrime.isPrime(97));
        assertFalse(CheckPrime.isPrime(221)); // 13 * 17
        assertFalse(CheckPrime.isPrime(9973 * 2));
    }
}

