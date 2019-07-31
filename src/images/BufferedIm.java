package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


public class BufferedIm  
{
	
	BufferedImage bf;
	
	public BufferedIm(String x){
		try {bf = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(x));} 
	    catch (IOException e) {}
	}
	public BufferedImage getBI(){return bf;}
}