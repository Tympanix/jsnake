package Model;

import java.io.*;
import java.util.Arrays;
import java.util.*;

/**
 * Class that includes methods for a high score system.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class HighScore {


    private final File highScoresFile;
    private String highScoreList;
    private int[] highScores;
    private int currentScore;
    private Scanner input;
    private FileWriter writeFile;

    public HighScore() {
        this.highScoreList = "";
        this.highScores = new int[10];
        this.currentScore = 0;
        this.writeFile = null;
        this.input = null;
        highScoresFile = new File ("highscores.dat");
    }

    //Checks if a score is a high score.
    public boolean isHighScore(int score) {
        this.currentScore = score;
        if (this.currentScore > this.highScores[0]) {
            return true;
        } else {
            return false;
        }
    }

    //Add a score to highScores and sort the Array.
    //The lowest high score is on the lowest index in the array and the highest high score is on the highest index.
    public void placeHighScore(int score) {
        this.currentScore = score;
        this.highScores[0] = this.currentScore;
        Arrays.sort(this.highScores);
        //Override highscores.dat
        writeHighScores();
    }

    //Write high scores from the Array highScores and save them to highscores.dat.
    public void writeHighScores() {

        if (!this.highScoresFile.exists()) {
            try {
                this.highScoresFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            this.writeFile = new FileWriter(this.highScoresFile);
            //Add the elements in the array to one string.
            String setHighScoresList = "";
            for (int i = 0; i < this.highScores.length; i++) {
                setHighScoresList += this.highScores[i]+":";
            }
            this.writeFile.write(setHighScoresList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.writeFile != null)
                    this.writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] getHighScores() {
        return this.highScores;
    }

    //Read high scores from highscores.dat and save them to the Array highScores.
    public int[] readHighScoresList() {

        if (!this.highScoresFile.exists()) {
            try {
                this.highScoresFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {

            this.input = new Scanner(this.highScoresFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Add the string from highscores.dat to string variable.
        while (input.hasNextLine()) {
            this.highScoreList = this.input.nextLine();
            //Splits the string and add the scores to an array.
            for (int i = 0; i < this.highScores.length; i++) {
                this.highScores[i] = Integer.parseInt((this.highScoreList.split(":")[i]));
            }
            //Prints array for debugging.
            /*
            for (int i = 0; i < this.highScores.length; i++) {
                System.out.println(this.highScores[i]);
            }
            */
            return this.highScores;
        }
        return this.highScores;
    }
}
