package com.sdk.realm.criticalhit.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CriticalHitLibraryTest {

	private static final String CRITICAL_HIT_TYPE = "electric";
	private static final String CRITICAL_HIT_SEVERITY = "reallySevere";
	private static final int CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE = 5;
	private static final int CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE = 10;
	private static final int CRITICAL_HIT_THREE_MAXIMUM_ROLL_VALUE = 15;
	private static CriticalHit CRITICAL_HIT_ONE = null;
	private static CriticalHit CRITICAL_HIT_THREE = null;
	private static int NUMBER_OF_HITS_INSERTED_INTO_LIBRARY = 0;
	private static int NUMBER_OF_UNIQUE_SEVERITIES = 0;
	private static int NUMBER_OF_UNIQUE_TYPES = 0;

	@AfterClass
	public static void reset() {
		CriticalHitLibrary.setCurrent(null);
	}
	@BeforeClass
	public static void populateCriticalHitLibrary() {

		CriticalHitLibrary myLibrary = new CriticalHitLibrary();
		List<CriticalHit> criticalHits = new ArrayList<CriticalHit>();

		CRITICAL_HIT_ONE = new CriticalHit(CRITICAL_HIT_TYPE,
				CRITICAL_HIT_SEVERITY, CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
				CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE, "Hit One");
		criticalHits.add(CRITICAL_HIT_ONE);
		NUMBER_OF_UNIQUE_SEVERITIES++;
		NUMBER_OF_UNIQUE_TYPES++;

		// same type and severity as hit one, just a lower roll range
		CriticalHit hitTwo = new CriticalHit(CRITICAL_HIT_TYPE,
				CRITICAL_HIT_SEVERITY, 0,
				CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE - 1, "Hit Two");
		criticalHits.add(hitTwo);

		// same type and severity as hit one, just a higher roll range
		CRITICAL_HIT_THREE = new CriticalHit(CRITICAL_HIT_TYPE,
				CRITICAL_HIT_SEVERITY, CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE + 1,
				CRITICAL_HIT_THREE_MAXIMUM_ROLL_VALUE, "Hit Three");
		criticalHits.add(CRITICAL_HIT_THREE);

		// same type and roll range as hit one, different severity
		CriticalHit hitFour = new CriticalHit(CRITICAL_HIT_TYPE,
				CRITICAL_HIT_SEVERITY + "test",
				CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
				CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE, "Hit Four");
		criticalHits.add(hitFour);
		NUMBER_OF_UNIQUE_SEVERITIES++;

		// same severity and roll range as hit one, different type
		CriticalHit hitFive = new CriticalHit(CRITICAL_HIT_TYPE + "test",
				CRITICAL_HIT_SEVERITY, CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
				CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE, "Hit Five");
		criticalHits.add(hitFive);
		NUMBER_OF_UNIQUE_TYPES++;

		NUMBER_OF_HITS_INSERTED_INTO_LIBRARY = criticalHits.size();
		myLibrary.setCriticalHits(criticalHits);
		CriticalHitLibrary.setCurrent(myLibrary);
	}

	@Test
	public void getAllCriticalHits() {

		assertTrue(CriticalHitLibrary.getCurrent().getAllCriticalHits().size() == NUMBER_OF_HITS_INSERTED_INTO_LIBRARY);
	}

	@Test
	public void testMinimumRollBoundaryCondition() {
		CriticalHit hitOne = CriticalHitLibrary.getCurrent().getCriticalHit(
				CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
				CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE);
		CriticalHit notHitOne = CriticalHitLibrary.getCurrent().getCriticalHit(
				CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
				CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE - 1);
		assertSame(CRITICAL_HIT_ONE, hitOne);
		assertNotSame(CRITICAL_HIT_ONE, notHitOne);
	}

	@Test
	public void testMaximumRollBoundaryCondition() {
		CriticalHit hitThree = CriticalHitLibrary.getCurrent().getCriticalHit(
				CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
				CRITICAL_HIT_THREE_MAXIMUM_ROLL_VALUE);
		CriticalHit stillHitThree = CriticalHitLibrary.getCurrent()
				.getCriticalHit(CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
						CRITICAL_HIT_THREE_MAXIMUM_ROLL_VALUE + 11);
		assertSame(CRITICAL_HIT_THREE, hitThree);
		assertSame(CRITICAL_HIT_THREE, stillHitThree);
	}

	@Test
	public void testGetGetAllCriticalHitSeverities() {
		int librarySeverities = CriticalHitLibrary.getCurrent()
				.getAllCriticalHitSeverities().size();
		assertEquals(NUMBER_OF_UNIQUE_SEVERITIES, librarySeverities);
	}

	@Test
	public void testGetGetAllCriticalHitTypes() {
		int libraryTypes = CriticalHitLibrary.getCurrent()
				.getAllCriticalHitTypes().size();
		assertEquals(NUMBER_OF_UNIQUE_TYPES, libraryTypes);
	}

	@Test
	public void testGetGetAllCriticalHits() {
		int libraryHits = CriticalHitLibrary.getCurrent().getAllCriticalHits()
				.size();
		assertEquals(NUMBER_OF_HITS_INSERTED_INTO_LIBRARY, libraryHits);
	}

	@Test
	public void getSuccessfulGetCriticalHitByTypeSeverityMinAndMax() {
		CriticalHit selectedCriticalHit = CriticalHitLibrary.getCurrent()
				.getCriticalHit(CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
						CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
						CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE);
		assertNotNull("No hit returned but should have been", selectedCriticalHit);
		assertSame("wrong one returned", CRITICAL_HIT_ONE, selectedCriticalHit);
	}
	
	@Test
	public void getUnsuccessfulGetCriticalHitByTypeSeverityMinAndMaxBadType() {
		CriticalHit selectedCriticalHit = CriticalHitLibrary.getCurrent()
				.getCriticalHit("George", CRITICAL_HIT_SEVERITY,
						CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
						CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE);
		assertNull("critical hit returned but one should not have been", selectedCriticalHit);
	}
	
	@Test
	public void getUnsuccessfulGetCriticalHitByTypeSeverityMinAndMaxBadSeverity() {
		CriticalHit selectedCriticalHit = CriticalHitLibrary.getCurrent()
				.getCriticalHit(CRITICAL_HIT_TYPE, "George",
						CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
						CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE);
		assertNull("critical hit returned but one should not have been", selectedCriticalHit);
	}
	
	@Test
	public void getUnsuccessfulGetCriticalHitByTypeSeverityMinAndMaxBadMin() {
		CriticalHit selectedCriticalHit = CriticalHitLibrary.getCurrent()
				.getCriticalHit(CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
						123654,
						CRITICAL_HIT_ONE_MAXIMUM_ROLL_VALUE);
		assertNull("critical hit returned but one should not have been", selectedCriticalHit);
	}

	@Test
	public void getUnsuccessfulGetCriticalHitByTypeSeverityMinAndMaxBadMax() {
		CriticalHit selectedCriticalHit = CriticalHitLibrary.getCurrent()
				.getCriticalHit(CRITICAL_HIT_TYPE, CRITICAL_HIT_SEVERITY,
						CRITICAL_HIT_ONE_MINIMUM_ROLL_VALUE,
						123987);
		assertNull("critical hit returned but one should not have been", selectedCriticalHit);
	}

}
