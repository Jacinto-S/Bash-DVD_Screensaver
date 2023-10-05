import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;


public class TextAnimation {
  public static int R = 255;
  public static int G = 255;
  public static int B = 255;
  public static int xmax = 80;
  public static int ymax = 24;
  public static int yposup = 7;
  public static int yposdown = 0;
  public static int xposright = 30;
  public static int xposleft = 0;

  public static String width = " ";
  public static String newLine = "\n";
  public static int systemCount = 0;
  public static int delay = 48;
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      TerminalDimensions.initializeTerminal();
      TerminalDimensions.setDimensions();
      moveIcon(2, 1);
  }

  public static void moveIcon(int xvelocity, int yvelocity) {
    try {
    while (System.in.available()==systemCount) {
      System.out.print("\033[2J");
      System.out.print(DVD(xposleft));
      System.out.print(newLine.repeat(yposdown));
      doDelay(delay);

      yposup += yvelocity;
      yposdown += yvelocity;
      xposright += xvelocity;
      xposleft += xvelocity;

      if (xposleft + xvelocity <= 0) {
        xvelocity = abs(xvelocity);
        changeColor();
      }
      if (yposdown + yvelocity <= 0) {
        yvelocity = abs(yvelocity);
        changeColor();
      }
      if (xvelocity + xposright + 1> xmax) {
        xvelocity = -1 * abs(xvelocity);
        changeColor();
      }
      if (yvelocity + yposup > ymax) {
        yvelocity = -1 * abs(yvelocity);
        changeColor();
      }
      if (!TerminalDimensions.checkTerminalDimensions(xmax, ymax)) {
        TerminalDimensions.setDimensions();
      }
    }
    } catch (Exception e) {
      System.out.println("Error with end Program loop.");
    }
      systemCount++;
      System.out.println("\033[0m");
  }

  public static void changeColor() {
    Random rand = new Random();
    R = rand.nextInt(128) + 128;
    G = rand.nextInt(128) + 128;
    B = rand.nextInt(128) + 128;
    System.out.print("\033[38;2;" + R + ";" + G + ";" + B + "m");
  }

  public static void doDelay(int delay) {
      try {
	Thread.sleep(delay);
      } catch (Exception e) {
	System.out.println("Fehler");
      }
  }

  public static String DVD (int indent){
    String dvd = 
      //source: https://www.twitchquotes.com/copypastas/4211
      width.repeat(indent) + "⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⡀\n" +
      width.repeat(indent) + "⠀⢠⣿⣿⡿⠀⠀⠈⢹⣿⣿⡿⣿⣿⣇⠀⣠⣿⣿⠟⣽⣿⣿⠇⠀⠀⢹⣿⣿⣿ \n" +
      width.repeat(indent) + "⠀⢸⣿⣿⡇⠀⢀⣠⣾⣿⡿⠃⢹⣿⣿⣶⣿⡿⠋⢰⣿⣿⡿⠀⠀⣠⣼⣿⣿⠏ \n" +
      width.repeat(indent) + "⠀⣿⣿⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⢿⣿⣿⠏⠀⠀⢸⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀\n" +
      width.repeat(indent) + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣸⣟⣁⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
      width.repeat(indent) + "⣠⣴⣶⣾⣿⣿⣻⡟⣻⣿⢻⣿⡟⣛⢻⣿⡟⣛⣿⡿⣛⣛⢻⣿⣿⣶⣦⣄⡀⠀\n" +
      width.repeat(indent) + "⠉⠛⠻⠿⠿⠿⠷⣼⣿⣿⣼⣿⣧⣭⣼⣿⣧⣭⣿⣿⣬⡭⠾⠿⠿⠿⠛⠉⠀";
    return dvd;
  }
}
