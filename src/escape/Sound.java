
package escape;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Sound {
	String soundName;   
	InputStream is;
	public AudioInputStream audioInputStream;
	Clip clip;
	
	public Sound(String s){
		soundName = s;
		try{
			clip = AudioSystem.getClip();
			audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(soundName));
			clip.open(audioInputStream);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}

	}
	
	/*
	 * The start() plays the sound file
	 */
	public void start(){
		clip.setFramePosition(0);
		clip.start();
	}

}