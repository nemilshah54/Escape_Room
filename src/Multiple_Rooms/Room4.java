package Multiple_Rooms;

import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;
import escape.Sound;
/**
 * The FourthWall class shows the fourth wall of the room.
 */
public class Room4 extends RoomPanels
{
	JLabel caption;
	BufferedIm dog;  	BufferedIm blackLight;
	boolean clickNotifier;  	boolean drawLight;  	boolean boneClicked;  	boolean dogboneUnhidden;
	boolean seedInHole;  	boolean waterInHole;  	boolean mainkeyClicked;
	boolean[] correctpattern = new boolean[3];
	BufferedIm [] pattern = new BufferedIm[3];
	
	BufferedIm colorOne;  	BufferedIm colorTwo;  	BufferedIm colorThree;
	BufferedIm colorOneu;   	BufferedIm colorTwou;   BufferedIm colorThreeu;
	BufferedIm opening;  	BufferedIm dogBone;  	BufferedIm tree;   	BufferedIm key;

	boolean patterns;
	Sound sound3;
	
	public Room4( EnterRoom b, GamePanel gp) 
	{
		super();
		this.b = b;
		this.gp = gp;
		caption = gp.caption.getText();
		
		background = new BufferedIm("res/fourth/roomFourBackground.png");
		blackLight= new BufferedIm("res/fourth/roomFourlight.png");
		black = new BufferedIm("res/dimWall.png");
		colorOne = new BufferedIm("res/fourth/colorOne.png");
		colorTwo  = new BufferedIm("res/fourth/colorTwo.png");
		colorThree = new BufferedIm("res/fourth/colorThree.png");	
		colorOneu  = new BufferedIm("res/fourth/colorOneu.png");
		colorTwou = new BufferedIm("res/fourth/colorTwou.png");
		colorThreeu = new BufferedIm("res/fourth/colorThreeu.png");	
		dog = new BufferedIm("res/fourth/dog.png");
		opening = new BufferedIm("res/fourth/boneOpen.png"); 
		dogBone = new BufferedIm("res/fourth/dogBone.png"); 
		tree = new BufferedIm("res/fourth/tree.png");  
		key = new BufferedIm("res/fourth/keyOnFloor.png");   	
		sound3 = new Sound("/res/sound/sound3.wav");	
		patterns = true;
	
		
		pattern[0] = colorOne;  pattern[1] = colorTwo;  pattern[2] = colorThree;
		correctpattern[0] = true;
		list.add(background);
		
		addMouseListener(new MyMouseListener());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		
		if(clickedSwitch)
		{
			
				for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 

				for(BufferedIm x: pattern)
					g.drawImage(x.getBI(), 0, 0, null); 
			
				g.drawImage(black.getBI(), 0, 0, null); 
				if(drawLight)
					g.drawImage(blackLight.getBI(), 0, 0, null); 
		}
		
		else
		{
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			for(BufferedIm x: pattern)
				g.drawImage(x.getBI(), 0, 0, null); 
		}	
	}
	
	public boolean allTrue(boolean[] a)
	{
		
		for(int i = 0; i < a.length; i++){
			if(a[i]==false)
				return false;
		}
		return true;
	}
	
	
	class MyMouseListener extends MouseAdapter
	{
		
		public void mouseClicked(MouseEvent e)
		{
			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();  			double y = e.getPoint().getY();

			//if the notifier circular image is clicked.
			if(x > 297 && x < 330 && y > 415 && y < 4550 && !clickNotifier)
			{
		
				if(s[2].isClicked())
				{
					clickNotifier =  true;  			list.add(dog);
					s[2].getIL().setVisible(false);  			s[2].setBackground(Color.WHITE);
					sound3.start();
					caption.setText("A DOG IS VERY HUNGRY. Feed him!");
				}
				
			}
			else if(x > 167 && x < 315 && y > 415 && y < 450 ){
				if(s[4].isClicked())
				{
					//if the dog is feed
					if(clickNotifier)
					{
						waterInHole =  true;
						s[4].getIL().setVisible(false);  			s[4].setBackground(Color.WHITE);  		s[0].getIL().setVisible(true);
						sound.start();
						if(seedInHole)
						{
							list.add(tree);  				list.add(key);
			
							caption.setText("GET THE KEY MY FRIEND...Almost there!");
						}
					}
				}
				else if(s[5].isClicked())
				{
					if(clickNotifier)
					{
						seedInHole =  true;
						s[5].getIL().setVisible(false);  				s[5].setBackground(Color.WHITE);  		sound.start();
						// If the dog is feed.
						if(waterInHole)
						{
							list.add(tree);  			list.add(key);
							caption.setText("GET THE KEY MY FRIEND...Almost there!");
						}
					}
				}
				else if(clickNotifier)
					caption.setText("Dog is selfish...Feed him and get the key..!");
			}
			
			//else if the first pattern is clicked
			else if(x > 322 && x < 358 && y > 310 && y < 418)
			{
				correctpattern[0] = !correctpattern[0];
				if(pattern[0].equals(colorOne))
					pattern[0] = colorOneu;
				else 
					pattern[0] = colorOne;
			}
			
			//if the secon pattern is clicked
			else if(x > 372 && x < 410 && y > 310 && y < 418)
			{
				correctpattern[1] = !correctpattern[1];
				if(pattern[1].equals(colorTwo))
					pattern[1] = colorTwou;
				else 
					pattern[1] = colorTwo;
			}
			//else if the third pattern is clicked
			else if(x > 425 && x < 460 && y > 310 && y < 418)
			{
				correctpattern[2] = !correctpattern[2];
				if(pattern[2].equals(colorThree))
					pattern[2] = colorThreeu;
				else 
					pattern[2] = colorThree;
			}
			
			//else if the user gets the key by cliciking and then puts it into inventory.
			else if(x > 380 && x < 435 && y > 420 && y < 454 && waterInHole && seedInHole && !mainkeyClicked){
				mainkeyClicked = true;
				list.remove(key);  			s[6].getIL().setVisible(true);	  		sound.start();
				caption.setText("\"You got the key to unlock the microwave. I got something special for you.");
			}
			
			//else if the dog bone is clicked.
			else if(x > 350 && x < 436 && y > 259 && y < 279 && !boneClicked)
			{

				if(dogboneUnhidden){
					boneClicked = true;  	s[5].getIL().setVisible(true);
					caption.setText("A delicious bone is mouth watering for the Dog. HEY YOU EARNED It..I told you some visuals are beatiful!");
					list.remove(dogBone);  		list.add(opening);  	sound.start();		
				}
			}
			
			//if the color combination of patterns is correct, you get the dog the bone to put into inventory.
			if(allTrue(correctpattern) && patterns)
			{
				patterns = false;  	dogboneUnhidden = true;  	list.add(dogBone);

			}
			repaint();
		}		
	}
	


	
	
}