package escape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainMenu extends JPanel implements ActionListener{
	private JButton buttonStart, buttonExit, buttonCredit, buttonRules;
	JFrame myframe;  	URL image;

	
	public MainMenu(JFrame j) 
	{  super();
		Dimension d1 = new Dimension (1000,1000);

		myframe = j;
		setPreferredSize(d1);
		setMaximumSize(d1);
	    setMinimumSize(d1);
	    
	    GridBagLayout gl = new GridBagLayout();
		setLayout(gl);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;  	c.gridx = 0;   		c.gridy = 0;	  	c.insets= new Insets(0,0,20,0);  	c.ipady=180;  		c.ipadx=60;
	    Title p1 =new Title();  	add(p1, c); 
		c.gridx = 0;   		c.gridy = 1;  		c.ipady=20;  		c.ipadx=300;   	c.insets= new Insets(20,0,0,0);
	    panelButton b1= new panelButton();  	 	add(b1,c);

		c.gridx = 0;   		c.gridy = 2;  		c.ipady=10;  		c.ipadx=600;   	c.insets= new Insets(0,0,0,20);
		buttonStart.addActionListener(this);
		buttonExit.addActionListener(this);
		//buttonCredit.addActionListener(this);
		//buttonRules.addActionListener(this);
		
		buttonCredit.addActionListener
		(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						System.out.println( "credit enter");
						
						JTextArea area;  // Output Textbox area.
						
						 area= new JTextArea(50, 50);
						 
						 area.append ("Made by Wishy Parikh, Nemil Shah, David, Ruchit");
						 
						 area.setBackground( Color.GREEN);
						 
						 add ( area,c);
						
						
					}
				}
		);
		
		
		buttonRules.addActionListener
		(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						System.out.println( "credit enter");
						
						JTextArea area;  // Output Textbox area.
						
						 area= new JTextArea(200, 50);
						 
						 area.append ("Get the objects from room, then get the key wisely to escape the room");
						 
						 area.setBackground( Color.magenta);
						 
						 add ( area,c);
						
						
					}
				}
		);
		
		
		
		
		image = getClass().getResource("/res/mainMenuBack.png");
	}

    
    
    private class panelButton extends JPanel{ //panel that holds the buttons
    	
    	public panelButton(){
    		super();
    		setLayout(new FlowLayout());
    		setBackground(new Color(100, 70, 50));
    		
    		GridBagConstraints c = new GridBagConstraints();
    		
    		buttonStart = new JButton("Start");  	buttonStart.setFocusable(false);     		add(buttonStart,c);
    	
    		c.insets=new Insets(0,40,0,0);
    	
    		buttonExit = new JButton("Exit");    		buttonExit.setFocusable(false);  		add(buttonExit,c);	
    		buttonCredit= new JButton("Credit");    	buttonCredit.setFocusable(false);       		add(buttonCredit,c);	
    		buttonRules= new JButton("Rules");
    		buttonRules.setFocusable(false);
    		add( buttonRules,c);    
    	}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonExit)) {
			System.exit(0);
		}
		
	/*	if (e.getSource().equals(buttonCredit)) 
		{
			
			Title p1 =new Title();  	add(p1); 
			System.out.println( "credit enter");
			JTextArea area;  // Output Textbox area.
			
			 area= new JTextArea(22, 50);
			 
			 area.append ("Made by Nemil");
			 
			 add ( area);
		}   */
		
		if (e.getSource().equals(buttonStart)) 
		{
			setVisible(false);
		}
	
		myframe.setContentPane(new GamePanel()); 
		myframe.getContentPane().remove(this);	
		
	}   
	
	
	@Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(new ImageIcon(image).getImage(),0,0,null);
    }
	
	
	
	public class Title extends JPanel{
		
		JLabel in;
		
		public Title() 
		{
			
			
			
			super();
			
		//	System.out.println("Name ewrgwrgof button: ");
			setLayout(new BorderLayout());
			setBackground(new Color(120, 0, 0, 100));
		
			in = new JLabel("<html><center>WELCOME TO THE GAME -- ESCAPE ROOM<html>");
			in.setFont(new Font ("Garamond",Font.BOLD, 12)); //setting JLabel characteristics
		    in.setForeground(Color.blue);
			in.setHorizontalAlignment(JLabel.RIGHT);
			
			add(in,BorderLayout.CENTER);
		}
	}      
	
	
	
}