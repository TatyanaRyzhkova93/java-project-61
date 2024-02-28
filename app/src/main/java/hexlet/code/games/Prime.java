package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prime implements Game {
    private List<String> correctAnswers = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    public String getMainQuestion() {
        return "What number is missing in the progression?";
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void runGame() {
        int maxSizeNumber = 1000;
        Random random = new Random();
        questions = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = random.nextInt(maxSizeNumber + 1);
            boolean isPrime = isPrime(randomNumber);
            if (isPrime) {
                correctAnswers.add("yes");
            } else {
                correctAnswers.add("no");
            }
            questions.add(String.valueOf(randomNumber));
        }
    }
    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(number) + 1; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
