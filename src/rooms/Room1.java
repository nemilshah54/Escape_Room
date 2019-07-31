package walls;

import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;
import escape.Sound;
/**
 * The FirstWall class shows the first wall of the room.
 */
public class FirstWall extends WallPanel {
	
	BufferedIm couch;
	BufferedIm door;
	BufferedIm bowl;
	BufferedIm openCouch;
	BufferedIm key;
	BufferedIm openDoor;
	
	boolean revBowl;
	boolean bowlClicked;
	boolean couchClicked;
	boolean keyClicked;
	boolean doorUnlocked;
	
	JLabel caption;
	
	Sound unlocking;
	Sound rattle;
	Sound win;

	
	public FirstWall(WallBegin b, GamePanel gp) {
		super();
		this.b = b;
		this.gp = gp;
		caption = gp.caption.getText();
		
		//creating new BufferedIm objects
		back = new BufferedIm("res/first/firstBack.png");
		black = new BufferedIm("res/dimWall.png");
		
		couch = new BufferedIm("res/first/couch.png");
		door = new BufferedIm("res/first/door.png");
		bowl = new BufferedIm("res/first/bowlOnGround.png");
		openCouch = new BufferedIm("res/first/openCouch.png");
		key = new BufferedIm("res/first/keyOnCouch.png");
		
		openDoor =  new BufferedIm("res/first/openDoor.png");
		
		unlocking = new Sound("/res/sound/thump.wav");
		win = new Sound("/res/sound/win.wav");
		rattle = new Sound("/res/sound/rattle.wav");
		
		//add the images to a linked list of BufferedIm objects
		list.add(back);
		list.add(bowl);
		list.add(door);
		list.add(openCouch);
		list.add(key);
		list.add(couch);
		
		addMouseListener(new MyMouseListener());	
	}
	
	class MyMouseListener extends MouseAdapter{
		/*
		 * This method performs actions(add and remove from linked list, start sound effect, show a comment, etc.)
		 * based on the region the user clicks on and which item is currently selected for in the inventory.
		 */
		public void mouseClicked(MouseEvent e){

			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();
			double y = e.getPoint().getY();
	
			//if the bowl is clicked, the bowl is removed from the wall and appears in the inventory
			if(x > 460 && x < 492 && y > 420 && y < 440 && !bowlClicked){
				bowlClicked = true;
				list.remove(bowl);
				s[0].getIL().setVisible(true);
				caption.setText("You got the Donut that gets more yummy with added cream..!!");
				sound.start();
				
			}
			//if the couch is clicked and it is closed, the closed couch is removed, revealing an open couch
			//this can only happen once.
			else if(x > 260 && x < 369 && y > 375 && y < 416 && !couchClicked){
				couchClicked = true;		
				list.remove(couch);
			}
			
			//if couch is open and the key is clicked, the key appears in the inventory and the couch is closed
			//this can only happen once
			else if(x > 323 && x < 348 && y > 390 && y < 410 && couchClicked && !keyClicked){
				keyClicked = true;
				list.remove(key);
				list.remove(openCouch);
				list.add(couch);
				s[1].getIL().setVisible(true);
				caption.setText("You got TV remote to turn on the TV in next room...Some visuals are beautiful in TV!!");
				sound.start();

			}
			
			//if the final key in the inventory is clicked and the door knob is clicked, the door opens and the user wins
			//the key disappears
			else if(x > 175 && x < 205 && y > 259 && y < 295){
				if(s[6].isClicked()){
					doorUnlocked = true;
					list.remove(door);
					list.add(openDoor);
					s[6].getIL().setVisible(false);
					s[6].setBackground(Color.WHITE);
					unlocking.start();
					win.start();
					caption.setText("Enjoy the POP CORN. Congrationations, you have escape the room..WINNER WINNER POPCORN DINNER");
				}
				//else the door remains locked
				else{
					rattle.start();
					caption.setText("Needs a key.");
				}
			}		
			repaint();	
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(switchClicked){	//if the light is turned off from the third wall, the black image is drawn over the rest of the wall images
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			g.drawImage(black.getBI(), 0, 0, null); 
		}
		else	//else only the black image is not drawn
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 		
		
	}
}