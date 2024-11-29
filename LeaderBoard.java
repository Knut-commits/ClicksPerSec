import java.io.*;
//import java.util.*;


public class LeaderBoard {
    public static final String LeaderBoard_file = "leaderboard.txt"; // this is where our leaderboard information will be stored and fetchd from
    
    public void saveScore( String playerName, int score){// this method saves the score to the leaderboard.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LeaderBoard_file,true))){//this will write to teh file and we use try and catch incase we cant access file
            writer.write(playerName + " " + score);
            writer.newLine();
            
        }catch(IOException e){
            e.printStackTrace();
        }

    




    }

}
