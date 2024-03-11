package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class GCD {
    private static final Integer MAX_SIZE_NUMBER = 101;
    public static void runGame() {
        List<AbstractMap.SimpleImmutableEntry<String, String>> questionAnswer = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int randomNumber2 = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int correctAnswer = calcGCD(randomNumber, randomNumber2);
            String question = randomNumber + " " + randomNumber2;
            AbstractMap.SimpleImmutableEntry<String, String> pair =
                    new AbstractMap.SimpleImmutableEntry<>(question, String.valueOf(correctAnswer));
            questionAnswer.add(pair);
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
