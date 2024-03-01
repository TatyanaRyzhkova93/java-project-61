package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Progression {

    private static final int SIZE_SUBSEQUENCE = 10;
    private static final Integer MAX_SIZE_NUMBER = 11;

    public static void runGame() {
        Random random = new Random();
        List<String> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        for (int i = 0; i < Engine.COUNT_CORRECT_ANSWERS; i++) {
            List<String> subsequence = new ArrayList<>(SIZE_SUBSEQUENCE);
            int randomNumber = random.nextInt(MAX_SIZE_NUMBER);
            int difference = random.nextInt(MAX_SIZE_NUMBER);
            int indexDelete = random.nextInt(SIZE_SUBSEQUENCE);
            subsequence.add(String.valueOf(randomNumber));
            for (int j = 1; j < SIZE_SUBSEQUENCE; j++) {
                subsequence.add(String.valueOf(Integer.parseInt(subsequence.get(j - 1)) + difference));
            }
            correctAnswers.add(subsequence.get(indexDelete));
            subsequence.set(indexDelete, "..");
            questions.add(String.join(" ", subsequence));
        }
        String mainQuestion = "What number is missing in the progression?";
        Engine.runGame(correctAnswers, questions, mainQuestion);
    }
}
