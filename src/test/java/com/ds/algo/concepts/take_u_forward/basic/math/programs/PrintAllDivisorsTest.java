package com.ds.algo.concepts.take_u_forward.basic.math.programs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintAllDivisorsTest {

	@Test
	void returnsAllDivisorsForCompositeNumber() {
		assertEquals(List.of(1, 12, 2, 6, 3, 4), new PrintAllDivisors().getDivisors(12));
	}

	@Test
	void returnsAllDivisorsForPerfectSquareWithoutDuplication() {
		assertEquals(List.of(1, 28, 2, 14, 4, 7), new PrintAllDivisors().getDivisors(28));
		assertEquals(List.of(1, 36, 2, 18, 3, 12, 4, 9, 6), new PrintAllDivisors().getDivisors(36));
	}

	@Test
	void returnsOnlyOneAndItselfForPrimeNumber() {
		assertEquals(List.of(1, 13), new PrintAllDivisors().getDivisors(13));
	}

	@Test
	void returnsOneForInputOne() {
		assertEquals(List.of(1), new PrintAllDivisors().getDivisors(1));
	}
}

