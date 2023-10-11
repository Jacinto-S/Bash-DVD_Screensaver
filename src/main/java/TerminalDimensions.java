import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class TerminalDimensions {
    int xmax;
    int ymax;
    private static Terminal terminal;

    static {
        TerminalDimensions.initializeTerminal();
        TerminalDimensions.setDimensions();
    }

    public TerminalDimensions (int xmax, int ymax) {
        this.xmax = xmax;
        this.ymax = ymax;
    }

    public static void initializeTerminal() {
        try {
            terminal = TerminalBuilder.builder().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TerminalDimensions getDimension() {
        int xvalue = 0;
        int yvalue = 0;
        try {
            if (terminal == null) {
                throw new IllegalStateException("Terminal has not been initialized.");
            }
            xvalue = terminal.getWidth(); // xmax
            yvalue = terminal.getHeight();  //ymax
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TerminalDimensions(xvalue, yvalue);
    }

    public static boolean checkTerminalDimensions(int xis, int yis) {
        int xshould = terminal.getWidth();
        int yshould = terminal.getHeight();
        return xshould == xis && yshould == yis;
    }

    public static void setDimensions() {
        TerminalDimensions dimensions = getDimension();
        TextAnimation.xmax = dimensions.xmax;
        TextAnimation.ymax = dimensions.ymax;
    }

    public static void setVolcity(int xmax, int ymax) {
        long aspectRatio = (long)xmax/(long)ymax;
    }

    /**
     * For Debugging purposes
     */
    public static void printDimensions() {
        System.out.println("x : " + terminal.getWidth());
        System.out.println("y : " + terminal.getHeight());
    }
}