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
    Settings settings;

    public DVD_Icon(Settings settings) {
        this.R = 255;
        this.G = 255;
        this.B = 255;
        this.settings = settings;
    }

    public String getIcon(int indent){
        return
        //source: https://www.twitchquotes.com/copypastas/4211
        width.repeat(indent) + "⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⡀\n" +
        width.repeat(indent) + "⠀⢠⣿⣿⡿⠀⠀⠈⢹⣿⣿⡿⣿⣿⣇⠀⣠⣿⣿⠟⣽⣿⣿⠇⠀⠀⢹⣿⣿⣿ \n" +
        width.repeat(indent) + "⠀⢸⣿⣿⡇⠀⢀⣠⣾⣿⡿⠃⢹⣿⣿⣶⣿⡿⠋⢰⣿⣿⡿⠀⠀⣠⣼⣿⣿⠏ \n" +
        width.repeat(indent) + "⠀⣿⣿⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⢿⣿⣿⠏⠀⠀⢸⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀\n" +
        width.repeat(indent) + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣸⣟⣁⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
        width.repeat(indent) + "⣠⣴⣶⣾⣿⣿⣻⡟⣻⣿⢻⣿⡟⣛⢻⣿⡟⣛⣿⡿⣛⣛⢻⣿⣿⣶⣦⣄⡀⠀\n" +
        width.repeat(indent) + "⠉⠛⠻⠿⠿⠿⠷⣼⣿⣿⣼⣿⣧⣭⣼⣿⣧⣭⣿⣿⣬⡭⠾⠿⠿⠿⠛⠉⠀ ";
    }

    public void changeColor() {
        Random rand = new Random();
        R = rand.nextInt(128) + 128;
        G = rand.nextInt(128) + 128;
        B = rand.nextInt(128) + 128;
        System.out.print("\033[38;2;" + R + ";" + G + ";" + B + "m");
    }
}
