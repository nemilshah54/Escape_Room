package images;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import escape.GamePanel;


public class ImageInventoryPanel extends JPanel{
	public ImagePanel[] panelHolder;
	GamePanel gp;


	public ImageInventoryPanel(GamePanel gp) {
		super();
		this.gp = gp;
	  
		setLayout(new GridLayout(2,4));

		panelHolder = new ImagePanel[8];    

		//sets the 8 individual ImagePanel objects up and organizes them into the ImageInventoryPanel panel
		for(int m = 0; m < 8; m++) {
		      panelHolder[m] = new ImagePanel(m, this);
		      panelHolder[m].setPreferredSize(new Dimension(50,60));
		      panelHolder[m].setBackground(Color.WHITE);
		      panelHolder[m].setBorder(BorderFactory.createLineBorder(new Color(0,0,0,125)));
		      add(panelHolder[m]);  
		}
	}
	
	public ImagePanel[] getPanelHolder(){return panelHolder;}
}