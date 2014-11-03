package com.sdk.realm.movement.maneuver.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.sdk.realm.movement.maneuver.domain.MovementManeuver;
import com.sdk.realm.movement.maneuver.domain.MovementManeuver.MovementManeuverDifficulty;

/*
 * I provide access to the critical hit data stored on files.
 */
public class MovementManeuverDAO {

	private static final Logger _log = Logger
			.getLogger(MovementManeuverDAO.class);
	private static final String FILE_LOCATION = "data";

	private List<MovementManeuver> allMovementManeuvers = new ArrayList<MovementManeuver>();

	public MovementManeuverDAO() {
	}

	/*
	 * read all the maneuvers from the data files, then return that list. the
	 * data files must be in the 'data' directory and must have 'movement
	 * maneuver' in their file name.
	 */
	public List<MovementManeuver> getAllMovementManeuvers() {

		loadDataFromFiles();
		return allMovementManeuvers;
	}

	private void loadDataFromFiles() {

		File directory = new File(FILE_LOCATION);
		File[] files = directory
				.listFiles(new MovementManeuverDataFileFilter());
		_log.debug("Loading movement maneuver data from: " + files.length
				+ " files.");
		for (int index = 0; index < files.length; index++) {
			loadFile(files[index]);
		}
		_log.debug("Total of: " + allMovementManeuvers.size()
				+ " movement maneuvers loaded.");
	}

	/*
	 * unmarshall the file, covert to domain objects and load into the internal
	 * collection
	 */
	private void loadFile(File aFile) {

		try {
			JAXBContext jc = JAXBContext
					.newInstance("com.sdk.realm.movement.maneuver.persistance");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object theUnmarshalledObject = unmarshaller.unmarshal(aFile);
			convertToDomainObjectsAndStore((MovementManeuverLibrary) theUnmarshalledObject);
		} catch (JAXBException e) {
			_log
					.error("unable to unmarshall file named: "
							+ aFile.getName(), e);
		}
	}

	private void convertToDomainObjectsAndStore(
			MovementManeuverLibrary aLibrary) {

		for (MovementManeuverType aMovementManeuverType : aLibrary
				.getMovementManeuverCollection().getMovementManeuvers()) {
			MovementManeuver aMovementManeuver = new MovementManeuver(
					aMovementManeuverType.getRollValues().getMinimum(),
					aMovementManeuverType.getRollValues().getMaximum());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.TRIVIAL, aMovementManeuverType.getTrivialManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.ROUTINE, aMovementManeuverType.getRoutineManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.EASY, aMovementManeuverType.getEasyManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.LIGHT, aMovementManeuverType.getLightManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.MEDIUM, aMovementManeuverType.getMediumManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.HARD, aMovementManeuverType.getHardManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.VERY_HARD, aMovementManeuverType.getVeryHardManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.EXTREMELY_HARD, aMovementManeuverType.getExtremelyHardManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.SHEER_FOLLY, aMovementManeuverType.getSheerFollyManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.ABSURD, aMovementManeuverType.getAbsurdManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.INSANE, aMovementManeuverType.getInsaneManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.PHENOMENAL, aMovementManeuverType.getPhenomenalManeuverResult());
			aMovementManeuver.addMovementManeuverResult(MovementManeuverDifficulty.VIRTUALLY_IMPOSSIBLE, aMovementManeuverType.getVirtuallyImpossibleManeuverResult());
					
			allMovementManeuvers.add(aMovementManeuver);
		}

	}
}
