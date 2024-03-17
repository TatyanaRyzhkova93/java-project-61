package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Even {
    private static final int MIN = -1000;
    private static final int MAX = 1000;
    public static void runGame() {
        String[][] questionAnswer = new String[Engine.COUNT_CORRECT_ANSWERS][Engine.COUNT_CORRECT_ANSWERS];
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            int randomNumber = Utils.getRandomInt(MIN, MAX);
            String correctAnswer = "no";
            if (isEven(randomNumber)) {
                correctAnswer = "yes";
            }
            questionAnswer[i][0] = String.valueOf(randomNumber);
            questionAnswer[i][1] = correctAnswer;
        }
        String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.runGame(questionAnswer, mainQuestion);
    }
    private static boolean isEven(int number) {
        return number % 2 != 1 && number % 2 != -1;
    }
}
