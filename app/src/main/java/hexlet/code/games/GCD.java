package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCD implements Game {
    private List<String> correctAnswers;
    private List<String> questions;
    private final String mainQuestion;

    public String getMainQuestion() {
        return mainQuestion;
    }
    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
    public List<String> getQuestions() {
        return questions;
    }
    public GCD() {
        int maxSizeNumber = 100;
        Random random = new Random();
        mainQuestion = "Find the greatest common divisor of given numbers.";
        questions = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = random.nextInt(maxSizeNumber + 1);
            int randomNumber2 = random.nextInt(maxSizeNumber + 1);
            int correctAnswer = calcGCD(randomNumber, randomNumber2);
            correctAnswers.add(String.valueOf(correctAnswer));
            questions.add(randomNumber + " " + randomNumber2);
        }
    }
    private int calcGCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return calcGCD(m, n % m);
        }
    }
}
