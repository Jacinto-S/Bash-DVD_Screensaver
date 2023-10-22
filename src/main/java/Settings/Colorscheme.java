package Settings;

import java.util.Random;

/**
 * Includes available colorschemes for DVD Logo.
 */

public enum Colorscheme{
    RANDOM, BRIGHT, DARK;

    //static ArrayList<Integer> repetitions = new ArrayList<Integer>();

    /*public static void main(String[] args) {
        int testCount = 1000000;
        int errorCount = 0;
        for (int i=0; i<testCount; i++) {
            RGB randomColor = DARK.getRange();
            int currentDifference = 35-luminance(randomColor);
            if (!(currentDifference<=35 && currentDifference>=-35)) {
                System.out.println("Error at: " + i + "." +
                        " Actual: " + luminance(randomColor));
                errorCount++;
            }
        }
        System.out.println("Count was wrong " + ((double)errorCount/(double)testCount)*100 + "% of the time");
        //System.out.println(Collections.max(repetitions));
        //System.out.println(repetitions.stream().mapToDouble(Integer::doubleValue).average());
        //Maximum = 10, Average = 7,67
    }*/

    public RGB getRange() {
        RGB randomValue;
        switch (this) {
            case BRIGHT -> randomValue = getBright();
            case DARK -> randomValue = getDark();
            default -> randomValue = getRandom();
        }
        return randomValue;
    }

    private RGB getBright() {
        return randomColor(220, 35);
    }

    private RGB getDark() {
        return randomColor(35, 35);
    }

    private RGB getRandom() {
        return randomColor();
    }

    /**
     * Simple implementation of Random RGB value without brightness settings. <br>
     * Use overloaded version for brightness.
     * @return Random RGB Value
     */
    public static RGB randomColor() {
        RGB random = new RGB();
        Random rand = new Random();
        random.R = rand.nextInt(255);
        random.G = rand.nextInt(255);
        random.B = rand.nextInt(255);
        return random;
    }

    /**
     * Creates random RGB Value of a certain brightness. <br>
     * Uses: luminance = ( 299*R + 587*G + 114*B )/1000 (w3c).
     * Luminance is given +/-1
     * @param luminance Level of perceived brightness between 0 (dark) and 255 (bright)
     * @return Random RGB Value that matches luminance
     */
    public static RGB randomColor(int luminance) {
        return randomColor(luminance, 1);
    }


    /**
     * Creates random RGB Value of a certain brightness. <br>
     * Uses: luminance = ( 299*R + 587*G + 114*B )/1000 (w3c).
     * @param luminance Level of perceived brightness between 0 (dark) and 255 (bright)
     * @param range Allowed offset for the resulting luminance (luminance = +/- range)
     * @return Random RGB Value that matches luminance
     */
    public static RGB randomColor(int luminance, int range) {
        RGB rnd = randomColor();
        int searched = luminance;

        while (true) {    //each iteration makes result more accurate
            luminance = (rnd.B * 299 + rnd.G * 587 + rnd.R * 114) / 1000;
            int difference = searched - luminance;
            allotDifferenceToRGB(rnd, difference);
            int currentDifference = searched-luminance(rnd);
            if (currentDifference<=range && currentDifference>=-range) {
                //repetitions.add(i);
                break;
            }
        }
        return rnd;
    }

    /**
     * Allots the difference between actual and wanted luminance to the random RGB. <br>
     * Makes sure that RGB get the value in accordance to their percentage of luminance. <br>
     */
    private static void allotDifferenceToRGB(RGB rnd, int difference) {
        int newR = rnd.R + (int) (difference * (299.0 / 1000.0));
        if (keepNumberInRange(newR)>0) {
            newR = (newR < 0 ? 0 : 255);
            difference += keepNumberInRange(newR);
        }
        int newG = rnd.G + (int) (difference * (587.0 / 1000.0));
        if (keepNumberInRange(newG)>0) {
            newG = (newG < 0 ? 0 : 255);
            difference += keepNumberInRange(newG);
        }
        int newB = rnd.B + (int) (difference * (114.0 / 1000.0));
        if (keepNumberInRange(newB)>0) {
            newB = (newB < 0 ? 0 : 255);
            difference += keepNumberInRange(newB);
        }

        rnd.R = newR;
        rnd.G = newG;
        rnd.B = newB;
    }

    /**
     * Makes sure that R, G and B are not negative.
     * If a number is negative or above 255, it becomes 0.
     * @return The number out of bounds
     */
    private static int keepNumberInRange(int newVal) {
        int remainder = 0;
        if (newVal < 0) {
           remainder = newVal *-1;
        } else if (newVal > 255) {
            remainder = newVal-255;
        }
        return remainder;
    }

    /**
     * For debugging purpose: Check luminance.
     */
    public static int luminance(RGB rgb) {
        return ( rgb.B*299 + rgb.G*587 + rgb.R*114 ) / 1000;
    }

}
