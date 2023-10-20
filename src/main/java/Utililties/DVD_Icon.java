package Utililties;

import java.util.Random;
import Settings.Settings;

/**
 * Constructs and returns the DVD Icon Ascii Art.
 * Credit for the icon: <a href="https://www.twitchquotes.com/copypastas/4211">twitchqoutes.com</a>
 */
public class DVD_Icon {
    static String width = " ";
    public int R;
    public int G;
    public int B;
    boolean backgroundIsColored;
    String resetColor = "\033[0m";
    String colorCode;
    int indent;

    public DVD_Icon(Settings settings) {
        this.R = 255;
        this.G = 255;
        this.B = 255;
        backgroundIsColored = settings.backgroundIsColored();
    }

    public String getIcon(int indent){
        return createIcon(indent);
    }

    private String createIcon(int indent) {
        colorCode = "\033[" + (backgroundIsColored ? "48" : "38") + ";2;" + R + ";" + G + ";" + B + "m";
        this.indent = indent;
        return //source: https://www.twitchquotes.com/copypastas/4211
        createIconLine("⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⡀") +
        createIconLine("⠀⢠⣿⣿⡿⠀⠀⠈⢹⣿⣿⡿⣿⣿⣇⠀⣠⣿⣿⠟⣽⣿⣿⠇⠀⠀⢹⣿⣿⣿") +
        createIconLine("⠀⢸⣿⣿⡇⠀⢀⣠⣾⣿⡿⠃⢹⣿⣿⣶⣿⡿⠋⢰⣿⣿⡿⠀⠀⣠⣼⣿⣿⠏") +
        createIconLine("⠀⣿⣿⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⢿⣿⣿⠏⠀⠀⢸⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀") +
        createIconLine("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣸⣟⣁⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀") +
        createIconLine("⣠⣴⣶⣾⣿⣿⣻⡟⣻⣿⢻⣿⡟⣛⢻⣿⡟⣛⣿⡿⣛⣛⢻⣿⣿⣶⣦⣄⡀⠀") +
        createIconLine("⠉⠛⠻⠿⠿⠿⠷⣼⣿⣿⣼⣿⣧⣭⣼⣿⣧⣭⣿⣿⣬⡭⠾⠿⠿⠿⠛⠉⠀ ");
    }

    /**
     * Transforms a line Text so that it's displayed at the proper location in the terminal.
     */
    private String createIconLine(String line) {
      return width.repeat(indent) + colorCode + line + resetColor + "\n";
    }

    public void changeColor() {
        Random rand = new Random();
        R = rand.nextInt(128) + 128;
        G = rand.nextInt(128) + 128;
        B = rand.nextInt(128) + 128;
    }
}
