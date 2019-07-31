package escape;

import javax.swing.JFrame;



public class EscapeGame extends JFrame{	

	private EscapeGame() throws InterruptedException 
	{
		
		super("GAME----ESCAPE ROOM");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MainMenu menu =new MainMenu(this);   pack();
		setContentPane( menu);  setVisible(true);
		
		Sound mainMenu;
		Sound laugh;
		Sound welcome;
		
		welcome = new Sound("/res/sound/welcome.wav");
		laugh = new Sound("/res/sound/laugh.wav");
		mainMenu = new Sound("/res/sound/mainMenu.wav");
		laugh.start();
		
		Thread.sleep(5000);
		welcome.start();
		Thread.sleep(2000);
		mainMenu.start();
	}
	
	public static void main (String[] args) throws InterruptedException
	{	
		EscapeGame game= new EscapeGame();	
	}


}