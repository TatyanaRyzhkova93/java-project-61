package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCD {
    private static final Integer MAX_SIZE_NUMBER = 101;
    public static void runGame() {
        Random random = new Random();
        List<String> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = random.nextInt(MAX_SIZE_NUMBER);
            int randomNumber2 = random.nextInt(MAX_SIZE_NUMBER);
            int correctAnswer = calcGCD(randomNumber, randomNumber2);
            correctAnswers.add(String.valueOf(correctAnswer));
            questions.add(randomNumber + " " + randomNumber2);
        }
        String mainQuestion = "Find the greatest common divisor of given numbers.";
        Engine.runGame(correctAnswers, questions, mainQuestion);
    }
    private static int calcGCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return calcGCD(m, n % m);
        }
    }
}
