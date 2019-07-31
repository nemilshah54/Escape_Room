package walls;

import images.BufferedIm;
import images.ImagePanel;

import java.util.LinkedList;

import javax.swing.JPanel;

import escape.GamePanel;
import escape.Sound;

/**
 * The WallPanel class helps navigation using the arrows in ArrowPanel and passes down common variables and methods needed in all four walls
 */
public abstract class WallPanel extends JPanel{
	
	GamePanel gp;
	
	WallBegin b;

	BufferedIm back;
	BufferedIm black;
	
	LinkedList<BufferedIm> list = new LinkedList<BufferedIm>();
	
	Sound sound = new Sound("/res/sound/blip.wav");
	
	boolean switchClicked;
	
	ImagePanel[] s;
	
	void switchLight(){
		switchClicked = !switchClicked;
	}
	
	
	
	

}