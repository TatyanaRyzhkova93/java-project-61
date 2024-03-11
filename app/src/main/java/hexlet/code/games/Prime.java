package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static final Integer MAX_SIZE_NUMBER = 1001;

    public static void runGame() {
        List<AbstractMap.SimpleImmutableEntry<String, String>> questionAnswer = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            boolean isPrime = isPrime(randomNumber);
            String correctAnswer = "no";
            if (isPrime) {
                correctAnswer = "yes";
            }
            AbstractMap.SimpleImmutableEntry<String, String> pair =
                    new AbstractMap.SimpleImmutableEntry<>(String.valueOf(randomNumber), correctAnswer);
            questionAnswer.add(pair);
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
