package Settings;

import java.awt.*;

public class RGB {
    public int R;
    public int G;
    public int B;
    public RGB(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public RGB() {
        this.R = 255;
        this.G = 255;
        this.B = 255;
    }


    /**
     * Allows for efficient iteration over RGB.
     * @param option Choose R, G or B
     */
    public int getValue(char option) {
        int returnValue=0;
        switch (option) {
            case ('R') -> returnValue = this.R;
            case ('G') -> returnValue = this.G;
            case ('B') -> returnValue = this.B;
        }
        return returnValue;
    }

    /**
     * Allows for efficient iteration over RGB.
     * @param option Choose R, G or B
     * @param value New Value
     */
    public void setValue(char option, int value) {
        switch (option) {
            case ('R') -> this.R = value;
            case ('G') -> this.G = value;
            case ('B') -> this.B = value;
        }
    }

    /**
     * For debugging purposes.
     * @return RGB values, color sample and luminance.
     */
    @Override
    public String toString() {
        return "[ " + this.R + "; " + this.G + "; " + this.B + " ] " +
                "= [" +
                "\033[38;2;"+R+";"+G+";"+B+"m" + "\033[48;2;"+R+";"+G+";"+B+"m" +
                "   " + "\033[0m" + "] - Luminance: " + Colorscheme.luminance(this);
    }
}
