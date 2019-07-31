package Multiple_Rooms;

import images.ImageInventoryPanel;

import java.awt.CardLayout;
import java.awt.Color;

import escape.GamePanel;

public class EnterRoom extends RoomPanels {
	
    CardLayout cardd;    Room1 first;   Room2 second;     Room3 third;      Room4 fourth;      GamePanel myghd;
   
  
	public EnterRoom(GamePanel g, ImageInventoryPanel sp){
		super();
		myghd = g;  	setBackground(Color.BLACK);
	
		
		cardd = new CardLayout();		
		setLayout(cardd);
		
		first = new Room1(this, myghd);  		add(first,"first");

		
		second = new Room2(this, myghd);   	add(second,"second");
	
		
		third = new Room3(this, myghd);  	add(third,"third");
	
		
		fourth = new Room4(this, myghd);  add(fourth, "fourth");
		
		
		cardd.show(this, "first");
	}

	public CardLayout getCl() {return cardd;}
}
