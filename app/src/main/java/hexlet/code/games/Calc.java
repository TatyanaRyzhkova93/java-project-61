package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Calc {
    private static final Integer MAX_SIZE_NUMBER = 1001;
    public static void runGame() {
        Random random = new Random();
        ArrayList<String> operands = new ArrayList<>(Arrays.asList("+", "-", "*"));
        List<String> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int indexOperand = random.nextInt(operands.size());
            int randomNumber = random.nextInt(MAX_SIZE_NUMBER);
            int randomNumber2 = random.nextInt(MAX_SIZE_NUMBER);
            int correctAnswer = switch (operands.get(indexOperand)) {
                case "+" -> randomNumber + randomNumber2;
                case "-" -> randomNumber - randomNumber2;
                case "*" -> randomNumber * randomNumber2;
                default -> 0;
            };
            correctAnswers.add(String.valueOf(correctAnswer));
            questions.add(randomNumber + " " + operands.get(indexOperand) + " " + randomNumber2);
        }
        String mainQuestion = "What is the result of the expression?";
        Engine.runGame(correctAnswers, questions, mainQuestion);
    }
}
