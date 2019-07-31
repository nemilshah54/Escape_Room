package Multiple_Rooms;

import images.BufferedIm;
import images.ImagePanel;

import java.util.LinkedList;

import javax.swing.JPanel;

import escape.GamePanel;
import escape.Sound;

/**
 * The WallPanel class helps navigation using the arrows in ArrowPanel and passes down common variables and methods needed in all four walls
 */
public abstract class RoomPanels extends JPanel{
	
	GamePanel gp;
	
	EnterRoom b;

	BufferedIm background;
	BufferedIm black;
	
	LinkedList<BufferedIm> list = new LinkedList<BufferedIm>();
	
	Sound sound = new Sound("/res/sound/blip.wav");
	
	boolean clickedSwitch;
	
	ImagePanel[] s;
	
	void switchLight(){
		clickedSwitch = !clickedSwitch;
	}
	
	
	
	

}