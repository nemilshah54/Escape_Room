
package escape;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import Multiple_Rooms.EnterRoom;



public class ArrowPanel extends JPanel implements ActionListener{
	
	EnterRoom par; 	BasicArrowButton arr;  	CardLayout card;


	public ArrowPanel(String s, EnterRoom wall) {
		super();
		par = wall;  	card = wall.getCl();
	
		setLayout(new GridBagLayout());  	GridBagConstraints c = new GridBagConstraints();  	setBackground(new Color(0, 0, 0, 125));
		
		c.insets = new Insets(0,10,0,10);
		
		if(s.equals("right"))
		{		
			arr = new BasicArrowButton(BasicArrowButton.EAST);	  			arr.addActionListener(this);  		add(arr, c);
	
		}
		else if(s.equals("left"))
		{
			arr = new BasicArrowButton(BasicArrowButton.WEST);	  		arr.addActionListener(this);    	add(arr,c);
		
		}

	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource().equals(arr))
		{
			if(arr.getDirection()== BasicArrowButton.EAST)
			{
				card.next(par);
			}
				
			else
			{
				card.previous(par);	
			}
							
		}	
	}
}