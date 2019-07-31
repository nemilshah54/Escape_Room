package Multiple_Rooms;
import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;
import escape.Sound;

public class Room1 extends RoomPanels 
{
	
	BufferedIm microwave;  	BufferedIm dog;  BufferedIm donut;  	BufferedIm openMicrowave;  	BufferedIm remote;  	BufferedIm open;
	boolean revBowl;  	boolean donutClicked;  boolean dogClicked;  	boolean remoteClicked;   	boolean microwaveUnlocked;
	JLabel caption;
	Sound unlocking;  	Sound sound2;  	Sound winGame;

	public Room1( EnterRoom b, GamePanel gp) 
	{
		super();
		this.b = b;
		this.gp = gp;
		caption = gp.caption.getText();
		
		// Creating Objects from images.
		background = new BufferedIm("res/first/background.png");
		black = new BufferedIm("res/dimWall.png");
		dog = new BufferedIm("res/first/dog.png");
		donut = new BufferedIm("res/first/donut.png");
		microwave = new BufferedIm("res/first/microwave.png");
		openMicrowave = new BufferedIm("res/first/openMicrowave.png");
		remote = new BufferedIm("res/first/remote.png");	
		open =  new BufferedIm("res/first/open.png");	
		unlocking = new Sound("/res/sound/thump.wav");
		winGame = new Sound("/res/sound/winGame.wav");
		sound2 = new Sound("/res/sound/sound2.wav");
		
		list.add(background);   list.add(remote); 	list.add( dog);  	list.add(donut);  		list.add(microwave);  	  		
		addMouseListener(new MyMouseListener());	
	}
	
	class MyMouseListener extends MouseAdapter
	{
		// Does actions acc to user clicks on the specific location of room.
		public void mouseClicked(MouseEvent e)
		{

			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();  		double y = e.getPoint().getY();
	
			//if the donut is clicked, the donut is removed from the wall and appears in the inventory
			if(x > 460 && x < 492 && y > 420 && y < 440 && !donutClicked)
			{
				donutClicked = true;
				list.remove(donut);
				s[0].getIL().setVisible(true);
				caption.setText("You got the Donut that gets more yummy with added cream..!!");
				sound.start();
				
			}
			//if the dog is clicked showinGameg the hidden remote in it
			else if(x > 260 && x < 369 && y > 375 && y < 416 && !dogClicked)
			{
				dogClicked = true;		
				list.remove(dog);
				list.add(open);
			}
			
			// If the dog is pressed, and then remote is clicked, remote will appear in the inventort.
			else if(x > 323 && x < 348 && y > 390 && y < 410 && dogClicked && !remoteClicked)
			{
				remoteClicked = true;
				list.remove(remote);
				
				
				s[1].getIL().setVisible(true);
				caption.setText("You got TV remote to turn on the TV in next room...Some visuals are beautiful in TV!!");
				sound.start();

			}
			
			// If the key is presssed on the microwave, user Wins the game and escapes from the rrom.
			else if(x > 175 && x < 205 && y > 259 && y < 295){
				if(s[6].isClicked()){
					microwaveUnlocked = true;
					list.remove(microwave);
					list.add(openMicrowave);
					s[6].getIL().setVisible(false);
					s[6].setBackground(Color.WHITE);
					unlocking.start();
					winGame.start();
					caption.setText("Enjoy the POP CORN. Congrationations, you have escape the room..WINNER WINNER POPCORN DINNER");
				}
				// Will need a key open microwave.
				else{
					sound2.start();
					caption.setText("Needs a key.");
				}
			}		
			repaint();	
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		if(clickedSwitch)
		{	
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			g.drawImage(black.getBI(), 0, 0, null); 
		}
		else	
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 		
		
	}
}