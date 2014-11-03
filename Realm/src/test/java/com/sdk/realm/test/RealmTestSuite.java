package com.sdk.realm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sdk.realm.criticalhit.domain.CriticalHitLibraryTest;
import com.sdk.realm.criticalhit.persistance.CriticalHitDAOTest;

@RunWith(Suite.class)
@SuiteClasses({	CriticalHitLibraryTest.class,
				CriticalHitDAOTest.class})

public class RealmTestSuite {

	public RealmTestSuite() {
	}

}
