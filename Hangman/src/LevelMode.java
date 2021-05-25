import java.io.*;
import java.util.*;
enum LevelMode {
    EASY,
    MEDIUM,
    HARD

    ;

    private static String DEFAULT_DICTIONARY_FILE="D:\\Downloads\\hw02\\resources\\dict.txt";
    private static int DEFAULT_MAXIMUM_NUM_TRIES=8;
    private static String dictFile;
    private int maxNumTries;
    private static Properties properties;

    /**
     * Used to select the dictionary file based on user's selected difficulty
     * @return Path
     */
	String config = "resources/config.properties";
    public String getDictFile(){
        properties= new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(config));
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }

        if (this == EASY || this == MEDIUM)
            return properties.getProperty("easy.dict");
        else
            return properties.getProperty("hard.dict");
    }

    /**
     * Used to get Maximum tries based on user's selected difficulty
     * @return Maximum tries
     */
    public int getMaxNumTries()
    {
        if(this==EASY)
            return Integer.parseInt(properties.getProperty("easy.tries"));
        else
            return Integer.parseInt(properties.getProperty("hard.tries"));
    }


}
