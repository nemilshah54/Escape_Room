package Multiple_Rooms;

import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;

public class Room3 extends RoomPanels
{
	
	JLabel caption;
	BufferedIm hammer;  	BufferedIm On;  	BufferedIm Off;
	boolean hammerClicked;

	public Room3( EnterRoom b, GamePanel gp) 
	{
		super();  		this.b = b;  		this.gp = gp;
		caption = gp.caption.getText();
		
		background = new BufferedIm("res/third/roomThreeBackground.png");
		hammer = new BufferedIm("res/third/hammer.png");
		black = new BufferedIm("res/dimWall.png");
		On = new BufferedIm("res/third/On.png");
		Off  = new BufferedIm("res/third/Off.png");
		
		list.add(background);  	list.add(hammer);  	list.add(On);
		addMouseListener(new MyMouseListener());
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
	
	class MyMouseListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();
			double y = e.getPoint().getY();
			
			//if the hammer is clicked, and get sin inventory.
			if(x > 76 && x < 184 && y > 420 && y < 440 && !hammerClicked)
			{
				hammerClicked = true;  	list.remove(hammer);  	s[2].getIL().setVisible(true);  		sound.start();
				caption.setText("You got special hammer to notify the dog. This hammer brings the Dog to his home even if he is miles away.");
			}
			
			//else if the donut is clicked and adding the cream on donut.
			else if(x > 354 && x < 475 && y > 155 && y < 474)
			{
				if(s[0].isClicked())
				{
					s[4].getIL().setVisible(true);  s[0].getIL().setVisible(false);  	s[0].setBackground(Color.WHITE);
					sound.start();
					caption.setText("Wow, you made the best Donut! Even animal can try this one out..!");
				}
				else
					caption.setText("WOW...THE CREAM ADDS BEST FLAVOR TO THE FOOD... Try it..it is game changer!!!");
			}
			
			else if(x > 219 && x < 320 && y > 144 && y < 261)
			{
	
				switchLight();
				b.first.switchLight();  		b.second.switchLight();  			
				b.fourth.switchLight();

				if(clickedSwitch)
				{
					caption.setText("It's dark.");
					list.remove(On);
					list.add(Off);
					sound.start();
				}
				else
				{
					sound.start();
					list.remove(Off);
					list.add(On);
					caption.setText("How do I get out?");
				}
			}	
			
		repaint();
		}
	}
	

}