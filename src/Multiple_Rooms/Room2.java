package Multiple_Rooms;

import images.BufferedIm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import escape.GamePanel;

public class Room2 extends RoomPanels
{
	
	JLabel caption;
	BufferedIm startTV;  BufferedIm blackLight;
	boolean unlocked;
	

	public Room2( EnterRoom b, GamePanel gp) 
	{
		super();
		this.b = b;  	this.gp = gp;
		caption = gp.caption.getText();
		
		background = new BufferedIm("res/second/roomtwoBackground.png");
		startTV = new BufferedIm("res/second/startTV.png");
		blackLight=new BufferedIm("res/second/blackLight.png");
		black = new BufferedIm("res/dimWall.png");
		list.add(background);	
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
			if(unlocked)	
				g.drawImage(blackLight.getBI(), 0, 0, null);	
		}
		
		else
			for(BufferedIm x: list)
				g.drawImage(x.getBI(), 0, 0, null);  					
	}
	
	class MyMouseListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e){
			s = gp.getImageSpacePanel().getPanelHolder();
			double x = e.getPoint().getX();  			double y = e.getPoint().getY();
			
			//if user clicked on tv region from the room.
			if(x > 177 && x < 340 && y > 150 && y < 250)
			{

				//if the keyhole is clicked
				if(x > 313 && x < 329 && y > 190 && y < 220 && !unlocked){
					if(s[1].isClicked()){
						unlocked =  true;
						list.add(startTV);
						b.fourth.drawLight = true;
						s[1].getIL().setVisible(false);
						s[1].setBackground(Color.WHITE);
						sound.start();
					}
					//else if users tries to start tv without remote.
					else
						caption.setText("Please find the remote to turn on the TV.");
				}
				
				//else if the tv is started by remote.
				else if(x > 235 && x < 275 && y > 184 && y < 252)
					if(unlocked)
					{
						//if the light is turned off
						if(clickedSwitch)
							caption.setText("I can make out the light.");
						else
							caption.setText("Can this Visual in the TV help me somewhere? TV seems super awesome with cool specs.!");
					}
						
				//else if tv is clicked
				else if(!unlocked)
					caption.setText("What a DESIGN PATTERN is this...!!!");
			}
			
			//else if the window is clicked.
			else if(x > 380 && x < 430 && y > 160 && y < 250)
				caption.setText("Who has the window with yellow color.. ?? Honestly, I didn't like it.!");
			
			//else if the ball eye is clicekded
			else if(x > 72 && x < 120 && y > 210 && y < 250)
				caption.setText("Sometimes proper insight and introspection have no meaning and purposes");
			repaint();
		}
	}
	



}
