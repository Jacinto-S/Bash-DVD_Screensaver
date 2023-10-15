package Utililties;

import java.util.Random;
import static java.lang.Math.abs;
import Settings.Settings;

/**
 * Creates and moves the DVD Icon
 */

public class TextAnimation {
  int yposup;
  int yposdown;
  int xposright;
  int xposleft;
  static int xmax = 80;
  static int ymax = 24;
  static String newLine = "\n";
  static int systemCount = 0;
  int delay;
  Settings settings;

  public TextAnimation(Settings settings) {
    this.yposup = 7;
    this.yposdown = 0;
    this.xposright = 30;
    this.xposleft = 0;
    this.settings = settings;
    this.delay = settings.getMovementSpeed();
  }

  static {
    TerminalDimensions.initializeTerminal();
    TerminalDimensions.setDimensions();
    System.out.println("\n".repeat(ymax-7));
  }

  public void startMovement(){
    DVD_Icon icon = new DVD_Icon(settings);
    moveIcon(icon, settings.getXDirection(), settings.getYDirection());
  }

  public void moveIcon(DVD_Icon icon, int xvelocity, int yvelocity) {
    try {
    while (System.in.available()==systemCount) {
      System.out.print(icon.getIcon(xposleft));
      System.out.print(newLine.repeat(yposdown));
      doDelay(delay);

      yposup += yvelocity;
      yposdown += yvelocity;
      xposright += xvelocity;
      xposleft += xvelocity;

      System.out.print("\033[2J");

      if (xposleft + xvelocity <= 0) {
        xvelocity = abs(xvelocity);
        icon.changeColor();
      }
      if (yposdown + yvelocity <= 0) {
        yvelocity = abs(yvelocity);
        icon.changeColor();
      }
      if (xvelocity + xposright + 1> xmax) {
        xvelocity = -1 * abs(xvelocity);
        icon.changeColor();
      }
      if (yvelocity + yposup > ymax) {
        yvelocity = -1 * abs(yvelocity);
        icon.changeColor();
      }
      if (!TerminalDimensions.checkTerminalDimensions(xmax, ymax)) {
        TerminalDimensions.setDimensions();
      }
    }
    } catch (Exception e) {
      System.out.println("Error with end program loop.");
    }
      systemCount++;
      System.out.println("\033[0m");
  }



  public static void doDelay(int delay) {
      try {
	Thread.sleep(delay);
      } catch (Exception e) {
	System.out.println("Fehler");
      }
  }


}
