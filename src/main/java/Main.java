import Settings.Settings;
import Utililties.TextAnimation;

public class Main {
    public static void main(String[] args) {
        Settings settings = new Settings();
        settings.getFromPropertiesFile();
        TextAnimation dvd = new TextAnimation(settings);
        dvd.startMovement();
    }
}
