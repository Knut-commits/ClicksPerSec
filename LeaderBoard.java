import java.io.*;
import java.util.*;


public class LeaderBoard {
    public static final String LeaderBoard_file = "leaderboard.txt"; // this is where our leaderboard information will be stored and fetchd from
    
    public void saveScore( String playerName, int score){// this method saves the score to the leaderboard.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LeaderBoard_file,true))){//this will write to teh file and we use try and catch incase we cant access file
            writer.write( playerName + " " + score);
            writer.newLine();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sortLeaderboard(){
        List<String> scores = new ArrayList<>();// make a list where we store our scores;
        try(BufferedReader reader = new BufferedReader(new FileReader(LeaderBoard_file))){//this will read from teh file and we use try and catch incase we cant access file
            String line; 
            while((line = reader.readLine()) != null){
                scores.add(line); // add what we read to list
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
            return; // exist if the reading fails
        }
        // this code here is kind off iffy and im nto 100% sure what it is really doing
        scores.sort((a, b) -> { // this sorts list by descneidng order
            int scoreA = Integer.parseInt(a.split(" ")[1]); // we only wnat the score part so we extract teh score form the desired line.
            int scoreB = Integer.parseInt(b.split(" ")[1]);
            return Integer.compare(scoreB, scoreA); // we put it in descending order
        });
        
        //write list back into file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LeaderBoard_file))){//this will write to teh file and we use try and catch incase we cant access file
            for(String score : scores){// loops thorugh scores list and adds each score to file.
                writer.write(score);
                writer.newLine();
            }
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
        





    }

  




    

}
