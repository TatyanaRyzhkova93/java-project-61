package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prime {
    private static final Integer MAX_SIZE_NUMBER = 1001;
    public static void runGame() {
        Random random = new Random();
        List<String> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = random.nextInt(MAX_SIZE_NUMBER);
            boolean isPrime = isPrime(randomNumber);
            if (isPrime) {
                correctAnswers.add("yes");
            } else {
                correctAnswers.add("no");
            }
            questions.add(String.valueOf(randomNumber));
        }
        String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.runGame(correctAnswers, questions, mainQuestion);

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
