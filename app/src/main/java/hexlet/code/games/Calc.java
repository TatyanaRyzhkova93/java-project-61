package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Calc implements Game {
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
    public Calc() {
        int maxSizeNumber = 1000;
        Random random = new Random();
        mainQuestion = "What is the result of the expression?";
        ArrayList<String> operands = new ArrayList<>(Arrays.asList("+", "-", "*"));
        questions = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int indexOperand = random.nextInt(operands.size());
            int randomNumber = random.nextInt(maxSizeNumber + 1);
            int randomNumber2 = random.nextInt(maxSizeNumber + 1);
            int correctAnswer = switch (operands.get(indexOperand)) {
                case "+" -> randomNumber + randomNumber2;
                case "-" -> randomNumber - randomNumber2;
                case "*" -> randomNumber * randomNumber2;
                default -> 0;
            };
            correctAnswers.add(String.valueOf(correctAnswer));
            questions.add(randomNumber + " " + operands.get(indexOperand) + " " + randomNumber2);
        }
    }
}
