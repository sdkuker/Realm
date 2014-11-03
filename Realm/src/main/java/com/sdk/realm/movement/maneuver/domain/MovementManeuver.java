package com.sdk.realm.movement.maneuver.domain;

import java.util.HashMap;
import java.util.Map;

import com.sdk.realm.domain.common.Range;

public class MovementManeuver {

	public enum MovementManeuverDifficulty {
		   TRIVIAL, ROUTINE, EASY, LIGHT, MEDIUM, HARD, 
		   VERY_HARD, EXTREMELY_HARD, SHEER_FOLLY, 
		   ABSURD, INSANE, PHENOMENAL, VIRTUALLY_IMPOSSIBLE;
		}
	
	private Map<MovementManeuverDifficulty, String> movementManeuverResults = new HashMap<MovementManeuverDifficulty, String>();
	private Range  range = null;

	public MovementManeuver(int minimumValue, int maximumValue) {
		super();
		this.range = new Range(minimumValue, maximumValue);

	}
	

	public Range getRange() {
		return range;
	}
	public String getMovementManeuverResult(MovementManeuverDifficulty aType) {
		return movementManeuverResults.get(aType);
	}
	
	public void addMovementManeuverResult(MovementManeuverDifficulty aType, String aResult) {
		movementManeuverResults.put(aType, aResult);
	}
	
}
