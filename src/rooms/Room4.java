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
 * The FourthWall class shows the fourth wall of the room.
 */
public class FourthWall extends WallPanel{
	
	BufferedIm dirt;
	BufferedIm blackLight;
	
	boolean spotClicked;
	boolean unhidden;
	boolean seedClicked;
	boolean openingUnhidden;
	
	boolean seedInHole;
	boolean waterInHole;
	boolean keyClicked;
	
	boolean[] correctflower = new boolean[3];
	BufferedIm [] flower = new BufferedIm[3];
	
	BufferedIm firstP;
	BufferedIm secondP;
	BufferedIm thirdP;
	
	BufferedIm firstPu;
	BufferedIm secondPu;
	BufferedIm thirdPu;
	
	BufferedIm opening;
	BufferedIm seedsAndOpening;
	
	BufferedIm tree;
	BufferedIm key;
	
	JLabel caption;
	
	boolean flowers;
	
	Sound floorboard;
	
	public FourthWall(WallBegin b, GamePanel gp) {
		super();
		this.b = b;
		this.gp = gp;
		caption = gp.caption.getText();
		
		back = new BufferedIm("res/fourth/fourthWallBack.png");
		blackLight= new BufferedIm("res/fourth/fourthWallBlack.png");
		black = new BufferedIm("res/dimWall.png");

		firstP = new BufferedIm("res/fourth/firstP.png");
		secondP  = new BufferedIm("res/fourth/secondP.png");
		thirdP = new BufferedIm("res/fourth/thirdP.png");
		
		firstPu  = new BufferedIm("res/fourth/firstPu.png");
		secondPu = new BufferedIm("res/fourth/secondPu.png");
		thirdPu = new BufferedIm("res/fourth/thirdPu.png");
		
		dirt = new BufferedIm("res/fourth/dirt.png");
		opening = new BufferedIm("res/fourth/seedOpening.png"); 
		seedsAndOpening = new BufferedIm("res/fourth/seedsInOpening.png"); 
		tree = new BufferedIm("res/fourth/tree.png");  
		key = new BufferedIm("res/fourth/keyOnFloor.png");   
		
		floorboard = new Sound("/res/sound/thump.wav");
		
		flowers = true;
	
		
		flower[0] = firstP;
		flower[1] = secondP;
		flower[2] = thirdP;
		correctflower[0] = true;
		
		list.add(back);
		
		addMouseListener(new MyMouseListener());
	}
	class MyMouseListener extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e){
			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();
			double y = e.getPoint().getY();
			
			//if the edge of the floorboard is clicked
			if(x > 297 && x < 330 && y > 415 && y < 4550 && !spotClicked){
				
				//if the crowbar is selected for, the floorboard is removed and the crowbar disappears from the inventory
				//This can only happen once.
				if(s[2].isClicked()){
					spotClicked =  true;
					list.add(dirt);
					s[2].getIL().setVisible(false);
					s[2].setBackground(Color.WHITE);
					floorboard.start();
					caption.setText("A DOG IS VERY HUNGRY. Feed him!");
				}
				
			}
			//if the floorboard area is clicked
			else if(x > 167 && x < 315 && y > 415 && y < 450 ){
				//if the bowl with water is selected for
				if(s[4].isClicked()){
					//if the dirt is shown, the bowl with water disappears from the inventory and the empty bowl reappears
					if(spotClicked){
						waterInHole =  true;
						s[4].getIL().setVisible(false);
						s[4].setBackground(Color.WHITE);
						s[0].getIL().setVisible(true);
						sound.start();
						//if the seeds have already been placed in the dirt, the tree and key appear on screen
						if(seedInHole){
							list.add(tree);
							list.add(key);
							caption.setText("GET THE KEY MY FRIEND...Almost there!");
						}
					}
				}
				//else if the seeds are selected for, they disappear from the inventory
				else if(s[5].isClicked()){
					if(spotClicked){
						seedInHole =  true;
						s[5].getIL().setVisible(false);
						s[5].setBackground(Color.WHITE);
						sound.start();
						//if the water has already been poured in, the tree and key appear on screen
						if(waterInHole){
							list.add(tree);
							list.add(key);
							caption.setText("GET THE KEY MY FRIEND...Almost there!");
						}
					}
				}
				else if(spotClicked)
					caption.setText("Dog is selfish...Feed him and get the key..!");
			}
			
			//else if the first flower is clicked, the boolean value at pos 0 in  correctflower is switched.
			else if(x > 322 && x < 358 && y > 310 && y < 418){
				correctflower[0] = !correctflower[0];
				//the flower colors are swapped
				if(flower[0].equals(firstP))
					flower[0] = firstPu;
				else 
					flower[0] = firstP;
			}
			
			//if the secon flower is clicked, the boolean value at pos 1 in  correctflower is switched.
			else if(x > 372 && x < 410 && y > 310 && y < 418){
				correctflower[1] = !correctflower[1];
				if(flower[1].equals(secondP))
					flower[1] = secondPu;
				else 
					flower[1] = secondP;
			}
			//else if the third flower is clicked, the boolean value at pos 2 in  correctflower is switched.
			else if(x > 425 && x < 460 && y > 310 && y < 418){
				correctflower[2] = !correctflower[2];
				if(flower[2].equals(thirdP))
					flower[2] = thirdPu;
				else 
					flower[2] = thirdP;
			}
			
			//else if the key on screen is clicked, the key appears in the inventory
			//this can only happen once
			else if(x > 380 && x < 435 && y > 420 && y < 454 && waterInHole && seedInHole && !keyClicked){
				keyClicked = true;
				list.remove(key);
				s[6].getIL().setVisible(true);	
				sound.start();
				caption.setText("\"You got the key to unlock the microwave. I got something special for you.");
			}
			
			//else if the hidden opening area is clicked and the seeds haven't been taken
			else if(x > 350 && x < 436 && y > 259 && y < 279 && !seedClicked){
				//if the opening is shown, the seeds appear in the inventory and the seeds are removed from the screen
				//this can only happen once
				if(openingUnhidden){
					seedClicked = true;
					s[5].getIL().setVisible(true);
					caption.setText("A delicious bone is mouth watering for the Dog. HEY YOU EARNED It..I told you some visuals are beatiful!");
					list.remove(seedsAndOpening);
					list.add(opening);
					sound.start();
				}
			}
			
			//if the color combination of flowers is correct, the opening with seeds with unhidden
			//this can only happen once
			if(allTrue(correctflower) && flowers){
				flowers = false;
				openingUnhidden = true;
				list.add(seedsAndOpening);
			}
			repaint();
		}		
	}
	
	/*
	 * This method checks if the flower colors are in the right order
	 */
	public boolean allTrue(boolean[] a){
		
		for(int i = 0; i < a.length; i++){
			if(a[i]==false)
				return false;
		}
		return true;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		
		//if light is turned off
		if(switchClicked){
			
				for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			
				//flowers are drawn at the end, separately	
				for(BufferedIm x: flower)
					g.drawImage(x.getBI(), 0, 0, null); 
			
				g.drawImage(black.getBI(), 0, 0, null); 
				
				//if the safe on the second wall is unlocked, draw the red light
				if(unhidden)
					g.drawImage(blackLight.getBI(), 0, 0, null); 
		}
		
		else{
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			for(BufferedIm x: flower)
				g.drawImage(x.getBI(), 0, 0, null); 
		}	
	}
}