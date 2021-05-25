import java.io.*;
import java.util.*;

/**
 * The WordReader Class is for reading the File and selecting random word
 */
public class WordReader {
    private List<String> dict=new ArrayList<>();

    /**
     * The WordReader constructor is used to create the WordReader
     * @param fileName
     * @throws FileNotFoundException
     */
    public WordReader(String fileName) throws FileNotFoundException
    {
        readFile(fileName);
    }

    /**
     * Used to pick the hidden word randomly from the File.
     * @return
     */
    public String pickHiddenWord()
    {   Random rand= new Random();
        int randIndex= rand.nextInt(dict.size());
        return dict.get(randIndex).toUpperCase();
    }

    /**
     * Used to read the File.
     * @param fileName
     * @throws FileNotFoundException
     */
    private void readFile(String fileName) throws FileNotFoundException
    {
        FileReader file = new FileReader(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
        {
            dict.add(sc.nextLine());
        }

    }


    public List<String> getDict() {
        return dict;
    }

    public void setDict(List<String> dict) {
        this.dict = dict;
    }

}