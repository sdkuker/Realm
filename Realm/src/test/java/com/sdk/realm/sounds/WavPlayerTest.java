package com.sdk.realm.sounds;

import java.io.File;

import org.junit.Test;


public class WavPlayerTest {

	private static String TEST_FILE_LOCATION = "data//sounds//curses//Inconcievable.wav";
	@Test
	public void testPlayExistingSoundFile() throws Exception {
		
		WavPlayer myPlayer = new WavPlayer();
		myPlayer.playSoundFile(new File(TEST_FILE_LOCATION));
		
	}
}
