package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Even {
    private static final int MIN = -1000;
    private static final int MAX = 1000;
    public static void runGame() {
        List<AbstractMap.SimpleImmutableEntry<String, String>> questionAnswer = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MIN, MAX);
            String correctAnswer = "no";
            if (isEven(randomNumber)) {
                correctAnswer = "yes";
            }
            AbstractMap.SimpleImmutableEntry<String, String> pair =
                    new AbstractMap.SimpleImmutableEntry<>(String.valueOf(randomNumber), correctAnswer);
            questionAnswer.add(pair);
        }
        String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.runGame(questionAnswer, mainQuestion);
    }
    private static boolean isEven(int number) {
        return number % 2 != 1 && number % 2 != -1;
    }
}
