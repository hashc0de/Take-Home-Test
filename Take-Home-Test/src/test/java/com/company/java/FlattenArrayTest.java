package com.company.java;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FlattenArrayTest {

	@InjectMocks
	private FlattenArray flattenArray;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testFlattenArrayWithNull() {
		Object[] inputArray = null;
		exception.equals(NullPointerException.class);
		exception.expectMessage("Input cant be null");
		flattenArray.convertToSimpleArray(inputArray);
	}

	@Test
	public void testFlattenArrayWithSimpleArray() {
		Object[] inputArray = { 1, 2, 3, 5, 6, 7, 8, 9, 4, 10, 11 };
		Object[] outputArray = { 1, 2, 3, 5, 6, 7, 8, 9, 4, 10, 11 };
		Object[] convertedArray = flattenArray.convertToSimpleArray(inputArray);
		assertArrayEquals(outputArray, convertedArray);
	}

	@Test
	public void testFlattenArrayTwoLevelNestedArray() {
		Object[] inputArray = new Object[] { 1, 2, new Object[] { 3, 4, 5 }, 6, 7 };
		Object[] outputArray = { 1, 2, 3, 4, 5, 6, 7 };
		Object[] convertedArray = flattenArray.convertToSimpleArray(inputArray);
		assertArrayEquals(outputArray, convertedArray);
	}

	@Test
	public void testFlattenArrayThreeLevelNestedArray() {
		Object[] inputArray = new Object[] { 1, 2, new Object[] { 3, new Object[] { 4, 5 } }, 6, 7 };
		Object[] outputArray = { 1, 2, 3, 4, 5, 6, 7 };
		Object[] convertedArray = flattenArray.convertToSimpleArray(inputArray);
		assertArrayEquals(outputArray, convertedArray);
	}

	@Test
	public void testFlattenArrayMultiLevelNestedArray() {
		Object[] inputArray = new Object[] {
				new Object[] { 1, 2, new Object[] { 3, new Object[] { 5, 6, new Object[] { 7, 8, 9 } } } },
				new Object[] { 4, 10, new Object[] { 11 } } };
		Object[] outputArray = { 1, 2, 3, 5, 6, 7, 8, 9, 4, 10, 11 };
		Object[] convertedArray = flattenArray.convertToSimpleArray(inputArray);
		assertArrayEquals(outputArray, convertedArray);
	}

}
