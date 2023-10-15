package Settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
import Utililties.CustomUtils;

public class Settings {
    static String configDirectory = System.getProperty("user.home") + "/.config/bash-dvd-screensaver/";
    static String configFilePath = configDirectory + "config.properties";
    static File configFile = new File(configFilePath);
    int movementSpeed;
    int[] movementDirection;
    Colorscheme colorscheme;
    boolean colorBackground;

    static {
        if (configFileIsMissing()) {
            int[] direction = {2,1};
            String[] standardSaver = {"DVD-Screensaver"};
            Settings preSettings = new Settings(48, direction, false, Colorscheme.BRIGHT);
            createConfigFile();
            preSettings.addToConfigFile();
        }
    }

    public Settings() {
    }

    public Settings(int movementSpeed, int[] movementDirection,
                    boolean colorBackground, Colorscheme colorscheme) {
        this.movementSpeed = movementSpeed;
        this.movementDirection = movementDirection;
        this.colorBackground = colorBackground;
        this.colorscheme = colorscheme;
    }

    static boolean configFileIsMissing() {
        return !configFile.exists();
    }

    static void createConfigFile() {
        try {
            File config = new File(configDirectory);
            config.mkdir();
            configFile.createNewFile();
        } catch (IOException e) {
            CustomUtils.logErrorAndQuit("Error with creating in your Settings File. Please check permissions.");
        }
    }

    void addToConfigFile() {
        try (FileWriter initialContent = new FileWriter(configFilePath)){
            initialContent.write("# Change according to your preferences. Changes are loaded when launching the Screensaver.\n");
            initialContent.append("# Please refer to the documentation for explanations on these settings: https://github.com/Jacinto-S/Bash-DVD_Screensaver\n");
            initialContent.append("movementSpeed:"+movementSpeed+"\n");
            initialContent.append("movementDirection:"+ translateForConversion(movementDirection)+"\n");
            initialContent.append("colorBackground:"+ colorBackground+"\n");
            initialContent.append("colorscheme:" + translateForConversion(colorscheme)+"\n");
        } catch (IOException e) {
            Logger warning = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            warning.severe("Error with writing in your Settings File. Please check writing permissions.");
            System.out.println("Closing Program...");
            System.exit(1);
        }
    }

    String translateForConversion(int[] settings) {
        int x = settings[0];
        int y = settings[1];
        return "("+x+"/"+y+")"; //Makes it easier to parse and write
    }
    int translateForConversion(Colorscheme cholorscheme) {
        int encodedColorscheme;
        switch (cholorscheme) {
            case DARK  -> encodedColorscheme = 1;
            case RANDOM -> encodedColorscheme = 2;
            default -> encodedColorscheme = 0;  //case BRIGHT omitted
        }
        return encodedColorscheme;
    }

    public void getFromPropertiesFile() {
        try {
        Properties config = new Properties();
        config.load(new FileInputStream(configFile));

        movementSpeed = Integer.parseInt(config.getProperty("movementSpeed"));
        movementDirection = retranslateDirection(config.getProperty("movementDirection"));
        colorBackground = Boolean.parseBoolean(config.getProperty("colorBackground"));
        colorscheme = retranslateColorscheme(config.getProperty("colorscheme"));

        } catch (IOException e) {
            CustomUtils.logErrorAndQuit("There was an error with reading your config file." +
                    " Please check your ~/.config/bash-dvd-screensaver/config.properties file.");
        }
    }

    int[] retranslateDirection(String encoding) {
        int[] directions = new int[2];
        int middle = encoding.indexOf('/');
        int end = encoding.indexOf(')');
        directions[0] = Integer.parseInt(encoding.substring(1,middle));
        directions[1] = Integer.parseInt(encoding.substring(middle+1,end));
        return directions;
    }

    Colorscheme retranslateColorscheme(String encoding) {
        int identifier = Integer.parseInt(encoding);
        Colorscheme colorscheme;
        switch (identifier) {
            case 1 -> colorscheme = Colorscheme.DARK;
            case 2 -> colorscheme = Colorscheme.RANDOM;
            default -> colorscheme = Colorscheme.BRIGHT; //Case 0 omitted
        }
        return colorscheme;
    }


    @Override
    public String toString() {
        return "Movement Speed: " + movementSpeed + "\n" +
               "Movement Direction " + translateForConversion(movementDirection) + "\n" +
               "Background is set to: " + (colorBackground ? "colored" : "not colored") + "\n" +
               "Colorscheme: " + colorscheme.toString() + "\n";
    }

}
