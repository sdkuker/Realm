package com.sdk.realm.domain.common;

/*
 * I represent a range of int values.  If an external value is within my
 * min and max values (inclusive), that external value is considered within
 * my range.
 */
public class Range {

	private int _minimum = 0;
	private int _maximum= 0;
	
	public Range(int minValue, int maxValue) {
		super();
		_minimum = minValue;
		_maximum= maxValue;
	}

	public int getMinimum() {
		return _minimum;
	}

	public int getMaximum() {
		return _maximum;
	}

	public boolean isContainedInRange(int aValue) {
		return  ! (aValue < _minimum) && ! (aValue > _maximum);
	}
}
