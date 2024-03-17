package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final Integer MAX_SIZE_NUMBER = 1001;

    public static void runGame() {
        String[][] questionAnswer = new String[Engine.COUNT_CORRECT_ANSWERS][Engine.COUNT_CORRECT_ANSWERS];
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            boolean isPrime = isPrime(randomNumber);
            String correctAnswer = "no";
            if (isPrime) {
                correctAnswer = "yes";
            }
            questionAnswer[i][0] = String.valueOf(randomNumber);
            questionAnswer[i][1] = correctAnswer;
        }
        String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.runGame(questionAnswer, mainQuestion);

    }
    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
