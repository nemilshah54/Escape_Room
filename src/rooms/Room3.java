package walls;

import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;
/**
 * The ThirdWall class shows the third wall of the room.
 */
public class ThirdWall extends WallPanel{
	
	BufferedIm crowbarBack;
	BufferedIm lightOn;
	BufferedIm lightOff;
	
	boolean crowbarClicked;
	
	JLabel caption;

	public ThirdWall(WallBegin b, GamePanel gp) {
		super();
		this.b = b;
		this.gp = gp;
		caption = gp.caption.getText();
		
		back = new BufferedIm("res/third/thirdWallBack.png");
		crowbarBack = new BufferedIm("res/third/crowbarBack.png");
		black = new BufferedIm("res/dimWall.png");
		lightOn = new BufferedIm("res/third/lightOn.png");
		lightOff  = new BufferedIm("res/third/lightOff.png");
		
		list.add(back);
		list.add(crowbarBack);
		list.add(lightOn);
		
		addMouseListener(new MyMouseListener());
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();
			double y = e.getPoint().getY();
			
			//if the crowbar is clicked, it is removed from the wall and appears in the inventory
			if(x > 76 && x < 184 && y > 420 && y < 440 && !crowbarClicked){
				crowbarClicked = true;
				list.remove(crowbarBack);
				s[2].getIL().setVisible(true);
				sound.start();
				caption.setText("You got special hammer to notify the dog. This hammer brings the Dog to his home even if he is miles away.");
			}
			
			//else if the puddle is clicked
			else if(x > 354 && x < 475 && y > 155 && y < 474){
				//if the empty bowl in the inventory is selected for, the empty bowl disappears and a bowl with water appears in the inventory
				if(s[0].isClicked()){
					s[4].getIL().setVisible(true);
					s[0].getIL().setVisible(false);
					s[0].setBackground(Color.WHITE);
					sound.start();
					caption.setText("Wow, you made the best Donut! Even animal can try this one out..!");
				}
				else
					caption.setText("WOW...THE CREAM ADDS BEST FLAVOR TO THE FOOD... Try it..it is game changer!!!");
			}
			
			//else if the light switch is clicked
			else if(x > 219 && x < 320 && y > 144 && y < 261){
				
				//the switchClicked variables of all the walls switch boolean values
				switchLight();
				
				b.first.switchLight();
				
				b.second.switchLight();
				
				b.fourth.switchLight();
			
				//if switch is turned on, add lightOn image
				if(switchClicked){
					caption.setText("It's dark.");
					list.remove(lightOn);
					list.add(lightOff);
					sound.start();
				}
				//else add lightOff image
				else{
					sound.start();
					list.remove(lightOff);
					list.add(lightOn);
				
					caption.setText("How do I get out?");
				}
			}	
			
		repaint();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	

		if(switchClicked){
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
			g.drawImage(black.getBI(), 0, 0, null); 
		}
		else
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null); 
	}
}