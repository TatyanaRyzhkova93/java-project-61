package hexlet.code;

public class Utils {
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public static int getRandomInt(int max) {
        return (int) (Math.random() * (max + 1));
    }
}
