package walls;

import images.ImageInventoryPanel;

import java.awt.CardLayout;
import java.awt.Color;

import escape.GamePanel;
/**
 * Flipping through the four walls occurs here
 */
public class WallBegin extends WallPanel {
	
    CardLayout cardd;    FirstWall first;   SecondWall second;     ThirdWall third;       FourthWall fourth;      GamePanel myghd;
   
  
	public WallBegin(GamePanel g, ImageInventoryPanel sp){
		super();
		myghd = g;  	setBackground(Color.BLACK);
	
		
		cardd = new CardLayout();		
		setLayout(cardd);
		
		first = new FirstWall(this, myghd);  		add(first,"first");

		
		second = new SecondWall(this, myghd);   	add(second,"second");
	
		
		third = new ThirdWall(this, myghd);  	add(third,"third");
	
		
		fourth = new FourthWall(this, myghd);  add(fourth, "fourth");
		
		
		cardd.show(this, "first");
	}

	public CardLayout getCl() {return cardd;}
}
