package com.ds.algo.concepts.take_u_forward.basic.math.programs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmstrongCheckerTest {

    @Test
    void returnsTrueForKnownArmstrongNumbers() {
        assertTrue(ArmstrongChecker.isArmstrong(0));
        assertTrue(ArmstrongChecker.isArmstrong(1));
        assertTrue(ArmstrongChecker.isArmstrong(9));
        assertTrue(ArmstrongChecker.isArmstrong(153));
        assertTrue(ArmstrongChecker.isArmstrong(370));
        assertTrue(ArmstrongChecker.isArmstrong(371));
        assertTrue(ArmstrongChecker.isArmstrong(407));
        assertTrue(ArmstrongChecker.isArmstrong(1634));
        assertTrue(ArmstrongChecker.isArmstrong(9474));
    }

    @Test
    void returnsFalseForNonArmstrongNumbers() {
        assertFalse(ArmstrongChecker.isArmstrong(18));
        assertFalse(ArmstrongChecker.isArmstrong(100));
        assertFalse(ArmstrongChecker.isArmstrong(9475));
    }

    @Test
    void returnsFalseForNegativeNumbers() {
        assertFalse(ArmstrongChecker.isArmstrong(-153));
    }
}

