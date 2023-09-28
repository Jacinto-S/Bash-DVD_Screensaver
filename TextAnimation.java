import java.io.*;
public class TextAnimation {
  public static int xmax = 237;
  public static int ymax = 55;
  public static int yposup = 7;
  public static int yposdown = 0;
  public static int xposright = 30;
  public static int xposleft = 0;

  public static String width = " ";
  public static String slash = "-";
  public static String newLine = "\n";
    public static void main(String[] args){
      /*for (int i=0; i<ymax-7; i++){
	System.out.print("\033[2J");
	System.out.print(DVD(i*4));
	System.out.print(newLine.repeat(i));
	doDelay(48);
      }*/
      moveIcon(4, 1);
      while(true){}
      /*
      for (int i=0;i<height;i++){
      System.out.println(slash.repeat(length));
      }
      while(true) {
	printWithDelay(liste, 19);
      }
      */
  }

  public static void printWithDelay(String[] input, int delay) {
    for(int i=0; i<input.length; i++) {
      System.out.print("\033[2J");
      System.out.print("\n" + input[i]);
      doDelay(delay);
    }
  }

  public static void moveIcon(int xvelocity, int yvelocity) {
    while (yposup<ymax && xposleft<xmax) {
      System.out.print("\033[2J");
      System.out.print(DVD(yposdown));
      System.out.print(newLine.repeat(xposleft));
      doDelay(48);

      yposup+=yvelocity;
      yposdown+=yvelocity;
      xposright+=xvelocity;
      xposleft+=xvelocity;
    }
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
  
  private static String executeCommand(String command) {
    try {
	InputStream input = Runtime.getRuntime().exec(command).getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	return reader.readLine();
    } catch (Exception e) {
	e.printStackTrace();
	return null;
    }
  }
}
