package com.sdk.realm.combat.persistance;

import java.util.ArrayList;
import java.util.List;

public class CombatEncounterPersistenceResult {

	public static enum STATUS {persisted, notPersisted};
	public static enum REASON {validationError, unexpectedError};
	public static enum VALIDATION_ERROR {fileNameAlreadyUsed, noFileNameSpecified};
	
	private STATUS myStatus;
	private REASON myReason;
	private List<VALIDATION_ERROR> myValidationErrors = new ArrayList<VALIDATION_ERROR>();
	
	public CombatEncounterPersistenceResult(STATUS myStatus, REASON myReason) {
		super();
		this.myStatus = myStatus;
		this.myReason = myReason;
	}

	public boolean wasSuccessfull() {
		return STATUS.persisted.equals(myStatus);
	}

	public boolean hasValidationErrors() {
		return myValidationErrors.size() > 0;
	}

	public List<VALIDATION_ERROR> getValidationErrors() {
		return myValidationErrors;
	}
	
	void addValidationError(VALIDATION_ERROR anError) {
		myValidationErrors.add(anError);
	}
	
}
