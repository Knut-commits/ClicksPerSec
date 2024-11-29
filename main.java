import javax.swing.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{ // this is recommended practise for swing based GUI's
            JFrame frame = new JFrame( "  CPS Sprint Game"); // this cretaes the main games window
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // means app will close when use clsoes the game window
            frame.setResizable(false);// user can nto resize game window for consistent gameplay
          
            GamePanel gamePanel = new GamePanel();//creates an isntance of GamePanel
            frame.add(gamePanel); // displays the game panel
            frame.pack(); // adjuts size of JFrame ot fit preffered size of Game Panel
            frame.setLocationRelativeTo(null); //centers the game to centre of screen
            frame.setVisible(true); // make game window visible
    }); 
        
    }
    
}
