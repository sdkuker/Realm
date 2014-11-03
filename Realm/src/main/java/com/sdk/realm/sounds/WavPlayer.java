package com.sdk.realm.sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class WavPlayer implements LineListener {
	
	protected Clip myClip;

	protected void playSoundFile(File soundFile)  throws Exception {
		Line.Info linfo = new Line.Info(Clip.class);
		Line line = AudioSystem.getLine(linfo);
		myClip = (Clip) line;
		myClip.addLineListener(this);
		AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
		myClip.open(ais);
		myClip.start();
	}
	
	  public void update(LineEvent le) {
		    LineEvent.Type type = le.getType();
		    if (type == LineEvent.Type.OPEN) {
		      System.out.println("OPEN");
		    } else if (type == LineEvent.Type.CLOSE) {
		      System.out.println("CLOSE");
		      System.exit(0);
		    } else if (type == LineEvent.Type.START) {
		      System.out.println("START");
		    } else if (type == LineEvent.Type.STOP) {
		      System.out.println("STOP");
		      myClip.close();
		    }
		  }
}
