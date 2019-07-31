
package escape;

import images.ImageInventoryPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import Multiple_Rooms.EnterRoom;


public class GamePanel extends JPanel{
	
	public CaptionPanel caption;
	ArrowPanel right;  	ArrowPanel left;
	public ImageInventoryPanel ab;   	EnterRoom room;



	
	public GamePanel()
	{
		
		super();
		setBackground(new Color(77,77,77));
		setLayout(new BorderLayout());
		
		caption = new CaptionPanel();  	add(caption, BorderLayout.NORTH);
	 
		
		ab = new ImageInventoryPanel(this);  		add(ab, BorderLayout.SOUTH);

	
		room = new EnterRoom(this, ab);   	add(room, BorderLayout.CENTER);
	
		
		right = new ArrowPanel("right", room);	  		add(right, BorderLayout.EAST);

		
		left = new ArrowPanel("left", room);	  		add(left, BorderLayout.WEST);

	}
	
	public ImageInventoryPanel getImageSpacePanel(){return ab;}	//method that returns ab
}