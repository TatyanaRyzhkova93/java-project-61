package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Even implements Game {
    private List<String> correctAnswers = new ArrayList<>();
    private List<String> questions = new ArrayList<>();

    public String getMainQuestion() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
    public List<String> getQuestions() {
        return questions;
    }
    public void runGame() {
        int randomNumber;
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            randomNumber = ThreadLocalRandom.current().nextInt();
            String correctAnswer;
            if (randomNumber % 2 == 1 || randomNumber % 2 == -1) {
                correctAnswer = "no";
            } else {
                correctAnswer = "yes";
            }
            questions.add(String.valueOf(randomNumber));
            correctAnswers.add(correctAnswer);
        }
    }
}
