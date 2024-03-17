package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final Integer MAX_SIZE_NUMBER = 101;
    public static void runGame() {
        String[][] questionAnswer = new String[Engine.COUNT_CORRECT_ANSWERS][Engine.COUNT_CORRECT_ANSWERS];
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int randomNumber2 = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int correctAnswer = calcGCD(randomNumber, randomNumber2);
            String question = randomNumber + " " + randomNumber2;
            questionAnswer[i][0] = question;
            questionAnswer[i][1] = String.valueOf(correctAnswer);
        }
        String mainQuestion = "Find the greatest common divisor of given numbers.";
        Engine.runGame(questionAnswer, mainQuestion);
    }
    private static int calcGCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return calcGCD(m, n % m);
        }
    }
}
