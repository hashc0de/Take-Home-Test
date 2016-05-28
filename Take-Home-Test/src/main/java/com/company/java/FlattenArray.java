package com.company.java;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.List;

public class FlattenArray {

	/**
	 * 
	 * @param nestedNumbers:
	 *            array objects (either plain integers or nested arrays of
	 *            integers)
	 * @return - flat array of Integers
	 */
	public Object[] convertToSimpleArray(Object[] nestedNumbers) {
		checkArgument(nestedNumbers != null, "Input cant be null");
		return flatten(nestedNumbers).toArray();
	}

	/**
	 * 
	 * @param nestedNumbers:
	 *            array objects (either plain integers or nested arrays of
	 *            integers)
	 * @return array list of Integers
	 */
	private List<Integer> flatten(Object[] nestedNumbers) {

		List<Integer> flattenedNumbers = new ArrayList<Integer>();
		for (Object element : nestedNumbers) {
			if (element instanceof Integer) {
				flattenedNumbers.add((Integer) element);
			} else {
				flattenedNumbers.addAll(flatten((Object[]) element));
			}
		}
		return flattenedNumbers;
	}

}
