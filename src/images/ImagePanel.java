package images;

import java.awt.GridBagLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class ImagePanel extends JPanel{

	ImageIcon image;
	ImageLabel x;
	ImageInventoryPanel space;
	
	public ImagePanel(int m,ImageInventoryPanel space) {
		super();
		setLayout(new GridBagLayout());
		this.space = space;
		switch (m){
			case 0:	
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/donut.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
				catch (IOException e){} 
			
			case 1:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/remote.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
				catch (IOException e){} 
				
			case 2:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/hammer.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
			    catch (IOException e){} 
				
			case 4:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/chocolate.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
				catch (IOException e){} 
				
			case 5:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/meat.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
				catch (IOException e){} 
		
			case 6:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/finalKey.png")))),space, this);
					
					x.setVisible(false);
					add(x);
					break;
				}
				catch (IOException e){} 
				
			default:
				try{
					x = new ImageLabel((new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/finalKey.png")))),space, this);
				}
				catch (IOException e){} 		
		}
	}
	
	public boolean isClicked(){return x.clicked;}
	public ImageLabel getIL(){return x;}	
}
