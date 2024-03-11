package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Calc {
    private static final Integer MAX_SIZE_NUMBER = 1001;
    public static void runGame() {
        ArrayList<String> operands = new ArrayList<>(Arrays.asList("+", "-", "*"));
        List<AbstractMap.SimpleImmutableEntry<String, String>> questionAnswer = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int indexOperand = Utils.getRandomInt(operands.size());
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int randomNumber2 = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int correctAnswer = calcValues(randomNumber, randomNumber2, operands.get(indexOperand));
            String question = randomNumber + " " + operands.get(indexOperand) + " " + randomNumber2;
            AbstractMap.SimpleImmutableEntry<String, String> pair =
                    new AbstractMap.SimpleImmutableEntry<>(question, String.valueOf(correctAnswer));
            questionAnswer.add(pair);
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
