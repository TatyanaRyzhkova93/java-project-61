package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.Arrays;


public class Calc {
    private static final Integer MAX_SIZE_NUMBER = 1001;
    public static void runGame() {
        ArrayList<String> operands = new ArrayList<>(Arrays.asList("+", "-", "*"));
        String[][] questionAnswer = new String[Engine.COUNT_CORRECT_ANSWERS][Engine.COUNT_CORRECT_ANSWERS];
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int indexOperand = Utils.getRandomInt(operands.size() - 1);
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int randomNumber2 = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int correctAnswer = calcValues(randomNumber, randomNumber2, operands.get(indexOperand));
            String question = randomNumber + " " + operands.get(indexOperand) + " " + randomNumber2;
            questionAnswer[i][0] = question;
            questionAnswer[i][1] = String.valueOf(correctAnswer);
        }
        String mainQuestion = "What is the result of the expression?";
        Engine.runGame(questionAnswer, mainQuestion);
    }

    private static int calcValues(int x, int y, String operand) {
        return switch (operand) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> throw new Error("Unknown operand!");
        };
    }
}
