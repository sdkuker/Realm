package com.sdk.realm.criticalhit.domain;

import com.sdk.realm.domain.common.Range;

public class CriticalHit {

	private String _type = null;
	private String _severity = null;
	private Range  _range = null;
	private String _description = null;
	
	public CriticalHit(String type, String severity, int minimumValue, int maximumValue, String description) {
		super();
		_type = type;
		_severity = severity;
		_range = new Range(minimumValue, maximumValue);
		_description = description;
	}

	public String getType() {
		return _type;
	}

	public String getSeverity() {
		return _severity;
	}

	public Range getRange() {
		return _range;
	}

	public String getDescription() {
		return _description;
	}

}
