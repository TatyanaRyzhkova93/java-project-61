package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Progression {

    private static final int SIZE_SUBSEQUENCE = 10;
    private static final Integer MAX_SIZE_NUMBER = 11;

    public static void runGame() {
        String[][] questionAnswer = new String[Engine.COUNT_CORRECT_ANSWERS][Engine.COUNT_CORRECT_ANSWERS];
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int difference = Utils.getRandomInt(MAX_SIZE_NUMBER);
            int indexDelete = Utils.getRandomInt(SIZE_SUBSEQUENCE);
            List<String> subsequence = generateSubsequence(randomNumber, difference, SIZE_SUBSEQUENCE);
            subsequence.set(indexDelete, "..");
            questionAnswer[i][0] = String.join(" ", subsequence);
            questionAnswer[i][1] = subsequence.get(indexDelete);
        }
        String mainQuestion = "What number is missing in the progression?";
        Engine.runGame(questionAnswer, mainQuestion);
    }
    private static List<String> generateSubsequence(int min, int difference, int length) {
        List<String> subsequence = new ArrayList<>(length);
        subsequence.add(String.valueOf(min));
        for (int j = 1; j < length; j++) {
            subsequence.add(String.valueOf(Integer.parseInt(subsequence.get(j - 1)) + difference));
        }
        return subsequence;
    }
}
