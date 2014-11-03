package com.sdk.realm.persistance.domain;


/*
 * I describe common behavior of all domain objects that are persisted - players, characters,
 * combat results, etc.
 */
public abstract class PersistantDomainObject {

	protected int _id;
	
	public int getId() {
		return _id;
	}
	
	public void setId(int anId) {
		_id = anId;
	}
	
	public boolean equals(Object o) {
		boolean isEquals = false;
		if (o instanceof PersistantDomainObject) {
			PersistantDomainObject otherDomainObject = (PersistantDomainObject) o;
			if (_id  == otherDomainObject._id) {
				isEquals = true;
			}
		}
		return isEquals;
	}
	
	public int hashCode() {
		return _id;
	}

}
