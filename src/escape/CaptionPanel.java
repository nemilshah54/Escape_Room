
package escape;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


// feature1.
public class CaptionPanel extends JPanel{	
	public JLabel lab;  int size;
	
	
	public CaptionPanel()
	{
		lab= new JLabel("Grab the Donut...Find the TV remote... Dog is hiding something...");
		add(lab);

		// dcd////
		///
	}
	
	public JLabel getText()
	{
		return lab;
	}
	
}
