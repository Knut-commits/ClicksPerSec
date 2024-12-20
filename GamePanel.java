import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {
     
	private static final int panel_width= 630; 
	private static final int panel_height = 400;// this is going to be the the size of the game 600 x 400 pixels
	private static final int timer_delay= 200; // milliseconds the game timer checks every 1000 miliseconds
	private static final int Game_time = 150; // quarter seconds  // variables are static and final as I want them to be constant for each game and unchangeable.
	
	private Player player; // using how player class
	private int timeLeft; 
	private ArrayList<NPC> npcs;  // list that will hold the npcs.
	private  Timer gameTimer;
	private JLabel timerLabel; // from java swing
	private JLabel distanceLabel; // from java swing
	private JButton clickButton; // java swing
	private BufferedImage background;
	private int backgroundX;
	private double distance;
	private BufferedImage playerSprite;
    private BufferedImage npcSprite;
	private int Score;
	
	
	public GamePanel() {
	    this.setPreferredSize(new Dimension(panel_width, panel_height)); // this method is inheirted from Jpanel
	    this.setLayout(null);// empty layout
	    this.setBackground(Color.LIGHT_GRAY); // sets background colour to gray.
	    
	    player = new Player(10,150,5);// sets its starting position and how many pixels it moves per click
	    timeLeft = Game_time;
	    
		Score = 0;
	    try {
			playerSprite = ImageIO.read(new File("bike.PNG"));// our player sprite
			npcSprite = ImageIO.read(new File("NPC.PNG"));
			background = ImageIO.read(new File("Background.jpg"));//our npc sprite
		} catch (IOException e) {
			System.out.println("heres error");
			e.printStackTrace();
		} // will load a chosen image as the background
	    backgroundX = 0;
	    
	    timerLabel =  new JLabel("Time left:" + timeLeft); // this adds a label (pop up) that shows how much time is left(updates every second)
	    timerLabel.setBounds(10,10,200,30); // positions the label in the screen
	    this.add(timerLabel);
         
		distance = 0;
		distanceLabel = new JLabel ("Distance covered: " + distance + "m");// new label that shows the distance player moves
	    distanceLabel.setBounds(200,10,300,30);
		this.add(distanceLabel);


        clickButton = new JButton("click me"); // adds the button to be clicked to move player
        clickButton.setBounds(500,10,100,30);// sets position of clickbutton.
        clickButton.addActionListener(e -> handleClick()); // the action listener will handle each click.
        this.add(clickButton);

		Random rand = new Random(); // this the isntance of teh random class
		npcs = new ArrayList<NPC>();
	    // intiliaize the NPCs
		for( int i = 0 ; i < 4; i ++){ // we are going to be adding 4 NPC to the game
			int startY = 200 + i* 50; // this will posiiton the npcs along differnet points of the vertical axis
			int speed = 3 + rand.nextInt(5); // randomizes speed of NPCs so eahc will have a differnet speed
			npcs.add(new NPC(10,startY,speed));//each npcs as same starting X positon but different everything else
		}

        gameTimer = new Timer(timer_delay,this);// creates the timer and we use this to refer the current instance of the class
	    
	}	
	private void handleClick() {// this method is private as it is not relevent for external use.
		if( gameTimer.isRunning() ==false){
			gameTimer.start(); // i start the timer once teh button is clicked // action listener will handle the timers events.
		}
		player.move( );
		distance = player.getX() * 0.1; // each pixel represnts 0.1 metres
		//System.out.println("Player X position: " + player.getX());
		distanceLabel.setText("distance covered: " + distance + "m");
		//System.out.println("Distance covered: " + distance);
		repaint(); // this will re do the "screen" of the game so that the sprites can move
	}	
	@Override // method is intended to override a method in its super class however if it doesnt the compiler will generate a mistake
	protected void paintComponent(Graphics g) { // this method will paint the games "screen" its protected so subclasses can inherit and pottentially override methods.
		super.paintComponent(g);
		g.drawImage(background, backgroundX, 0 , this); //draws first part of background
		g.drawImage(background,backgroundX + background.getWidth(), 0 , this);// loops background to give scorlling affect
		g.drawImage( playerSprite, player.getX(), player.getY(),40,40,this); // heres teh sprite with its size.
		for(NPC npc : npcs) {
			g.drawImage( npcSprite , npc.getX(), npc.getY(),40,40,this); // loops though npc list and prints each one
		}
	}

	public int FindFastestNPC(){
		int max = 0;
		for(NPC npc : npcs)// searches through npc list
		{
			if(npc.getX() > max){
				max = npc.getX(); // max is going to be largest npc x coordinate
			}

		}
		return max;
	} 
	@Override
	public void actionPerformed(ActionEvent e) { // use this whenever an action event occurs suhc as clicking a button
		if(player.getX() ==  600 || player.getX() > 600){
			gameTimer.stop(); 
			Score = Game_time - timeLeft;
			
			
			clickButton.setEnabled(false);// this means button can no longer be clicked because game is over
			LeaderBoard board =  new LeaderBoard(); // create an instance of leaderboard.

			board.saveScore("knut" , Score);// saves the score to leadeboard file
			board.sortLeaderboard();
			if(player.getX() > FindFastestNPC()){
				timerLabel.setText("You won");
			}
			else{
				timerLabel.setText("You Lost");
			}
				
		}
		else if(timeLeft > 0) {
			timeLeft --; // decrease time by 1
			timerLabel.setText("Time Left: " + timeLeft);

		
			// we need to move NPCs now
		

				
			for( NPC npc : npcs) {
				npc.move();
			}
			
			repaint();
		}
		else{
			gameTimer.stop(); 
			clickButton.setEnabled(false);// this means button can no longer be clicked because game is over
			timerLabel.setText("Time's up!, You Lost");
			Score = Game_time - timeLeft;
			    
			LeaderBoard board =  new LeaderBoard(); // create an instance of leaderboard.

			board.saveScore("knut" , Score);// saves the score to leadeboard file
			board.sortLeaderboard();
		}	
		



	}

		

	
}
