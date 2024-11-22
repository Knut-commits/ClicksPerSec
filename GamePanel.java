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
     
	private static final int panel_width= 600; 
	private static final int panel_height = 400;// this is going to be the the size of the game 600 x 400 pixels
	private static final int timer_delay= 1000; // milliseconds the game timer checks every 1000 miliseconds
	private static final int Game_time = 10; // seconds  // variables are static and final as I want them to be constant for each game and unchangeable.
	
	private Player player; // using how player class
	private int timeLeft;
	private ArrayList<NPC> npcs;  // list that will hold the npcs.
	private Timer gameTimer;
	private JLabel timerLabel; // from java swing
	private JLabel distanceLabel; // from java swing
	private JButton clickButton; // java swing
	private BufferedImage background;
	private int backgroundX;
	
	
	public GamePanel() {
	    this.setPreferredSize(new Dimension(panel_width, panel_height)); // this method is inheirted from Jpanel
	    this.setLayout(null);// empty layout
	    this.setBackground(Color.LIGHT_GRAY); // sets background colour to gray.
	    
	    player = new Player(10,150,10);// sets its starting position and how many pixels it moves per click
	    timeLeft = Game_time;
	    
	    background = Image.IO.read(new File("background.jpg")); // will load a chosen image as the background
	    
	    
	    timerLabel =  new JLabel("Time left:" + timeLeft); // this adds a label (pop up) that shows how much time is left(updates every second)
	    timerLabel.setBounds(10,10,100,30); // positions the label in the screen
	    this.add(timerLabel);
	    
        clickButton = new JButton("click me"); // adds the button to be clicked to move player
        clickButton.setBounds(250,10,100,30);// sets position of clickbutton.
        clickButton.addActionListener(e - > handleClick()); // the action listener will handle each click.

	    
	
	
	
}
