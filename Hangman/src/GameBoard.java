import java.io.*;
import java.util.*;

/**
 * This class handles all the in game functions
 */
public class GameBoard {
    private String hiddenWord;
    private char[] maskWord = new char[200];
    private int maxNumTries;
    private Set<Character> missedLetters = new HashSet<Character>();
    private WordReader wordReader;

    /**
     * This constructor reads the file and selects the hiddenWord
     * @param mode
     * @throws FileNotFoundException
     */
    public GameBoard(LevelMode mode) throws FileNotFoundException {
        String path;
        path = mode.getDictFile();
        wordReader = new WordReader(path);
        hiddenWord = wordReader.pickHiddenWord();
        maxNumTries = mode.getMaxNumTries();
        for(int i=0;i<hiddenWord.length();i++){
            maskWord[i]='*';
        }

    }

    /**
     * It validates the entered Letter with hidden Word
     * @param guessesLetter
     */
    public void enterLetter(char guessesLetter)
    {
        char guessesLetterLC = Character.toUpperCase(guessesLetter);
        for(int i=0; i<hiddenWord.length();i++) {
            if (hiddenWord.charAt(i) == guessesLetterLC) {
                maskWord[i] = guessesLetterLC;
            }

        }
        if (hiddenWord.indexOf(guessesLetterLC)<0) {
                if (missedLetters.contains(guessesLetterLC)) {
                    System.out.println("Enter another letter");
                } else {
                    maxNumTries--;
                    missedLetters.add(guessesLetterLC);
                }
            }

    }

    /**
     * The game exits if Tries are over or the user wins
     * @return
     */

    public boolean gameOver()
    {
        StringBuffer maskWordString = new StringBuffer();
        for(int i=0;i<hiddenWord.length();i++)
        {
            maskWordString.append(maskWord[i]);
        }
        if(maxNumTries==0) {
            System.out.println("\n"+"Game Over! The secret word was:" + hiddenWord);
            return true;
        }
        else
            if(maskWordString.toString().compareToIgnoreCase(hiddenWord)==0) {
                System.out.println("You guessed the secret word!");
                return true;
            }
                return false;
    }

    /**
     * It is used for returning the current status of the game
     * @return
     */
    public String toString()
    {
        StringBuffer maskWordString = new StringBuffer();
        for(int i=0;i<hiddenWord.length();i++)
        {
            maskWordString.append(maskWord[i]);
        }
        StringBuilder charSetString = new StringBuilder();
        List<Character>setReplica= new ArrayList<Character>(missedLetters);
        for(int i=0; i<missedLetters.size();i++) {
            charSetString.append(setReplica.get(i));
            charSetString.append(',');
        }
        return "WORD:"+maskWordString.toString() +"\n"+"Misses:"+ charSetString.toString()+ "\n"+"Num of Remaining Tries:"+maxNumTries+"\n"+"Enter a letter:";
    }


}


