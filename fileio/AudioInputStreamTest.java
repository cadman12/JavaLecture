package edu.pnu.fileio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioInputStreamTest {

	public static void main(String[] args) {

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("gameover.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}		

		System.out.println("Done");
	}
}
