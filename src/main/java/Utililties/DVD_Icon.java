package Utililties;

import java.util.Random;
import Settings.*;

/**
 * Constructs and returns the DVD Icon Ascii Art.
 * Credit for the icon: <a href="https://www.twitchquotes.com/copypastas/4211">twitchqoutes.com</a>
 */
public class DVD_Icon {
    static String width = " ";
    public RGB rgb;
    Colorscheme colorscheme;
    boolean backgroundIsColored;
    String resetColor = "\033[0m";
    String colorCode;
    int indent;

    public DVD_Icon(Settings settings) {
        this.rgb = settings.getColorscheme().getRange();
        backgroundIsColored = settings.backgroundIsColored();
        if (backgroundIsColored) resetColor = "\033[49m";
        colorscheme = settings.getColorscheme();
    }

    public String getIcon(int indent){
        return createIcon(indent);
    }

    private String createIcon(int indent) {
        colorCode = "\033[" + (backgroundIsColored ? "48" : "38") + ";2;" + rgb.R + ";" + rgb.G + ";" + rgb.B + "m";
        this.indent = indent;
        return //source: https://www.twitchquotes.com/copypastas/4211
        resetColor +
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
        rgb = colorscheme.getRange();
    }
}
