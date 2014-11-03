package com.sdk.realm.player.domain;

import com.sdk.realm.persistance.domain.PersistantDomainObject;

public class Player extends PersistantDomainObject {

	private String _name;
	
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

}
