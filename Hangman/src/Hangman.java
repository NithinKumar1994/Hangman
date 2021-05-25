import java.io.*;
import java.util.*;

/**
 * @author Nithin Kumar Pechetti np2598@rit.edu
 *Represents the Hangman class to create the game
 */
public class Hangman
{
    private GameBoard gameBoard;
    private String currLine;

    /**
     * Represents the Hangman Constructor to create the game according to the entered level
     * @param mode
     * @throws FileNotFoundException
     */
    public Hangman(LevelMode mode) throws FileNotFoundException
    {
         gameBoard= new GameBoard(mode);

    }

    /**
     * The play method used to play the game until user guesses word or exceeds maximum tries
     */
    public void play()  {

        System.out.print(gameBoard.toString());
        Scanner sc = new Scanner(System.in);
       while(!gameBoard.gameOver()) {
           if (enterLetter(sc)) {
                gameBoard.enterLetter(currLine.charAt(0));
               System.out.print(gameBoard.toString());
           }
           else{
			   if(currLine.charAt(0)=='0'){
					System.out.println("Quitting Program");
					break;
			   }
               System.out.println("Invalid user input!");
               System.out.print("Enter valid input:");
           }

       }
    }

    /**
     * To check if the input is character or not.
     * @param in
     * @return Validity of the input
     */
    private boolean enterLetter(Scanner in)
    {
        currLine = in.nextLine();
		if(currLine.length()==1){
        boolean result = (currLine.charAt(0)>='a'&&currLine.charAt(0)<='z')||(currLine.charAt(0)>='A'&&currLine.charAt(0)<='Z');
        if(result)
        {
            return true;
        }
		}
        return false;
    }

    /**
     * THe main method used for playing the game
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Hangman hangmanObject=null;
        switch(args[0]){
            case "e":
				System.out.println("Welcome to Hangman Game");
                hangmanObject= new Hangman(LevelMode.EASY);

                break;
            case "m":
				System.out.println("Welcome to Hangman Game");
				hangmanObject = new Hangman(LevelMode.MEDIUM);
                break;
            case "h":
				System.out.println("Welcome to Hangman Game");
                hangmanObject = new Hangman(LevelMode.HARD);
                break;
            default:
                System.out.println("Usage: java Hangman mode (e -- easy, m –- medium, h -- hard)");
                break;
        }

        hangmanObject.play();
    }



}


