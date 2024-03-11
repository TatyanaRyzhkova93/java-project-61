package hexlet.code;

import java.util.AbstractMap;
import java.util.List;
import java.util.Scanner;

public class Engine {
    public static final int COUNT_CORRECT_ANSWERS = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void runGame(List<AbstractMap.SimpleImmutableEntry<String, String>> questionAnswer,
                               String mainQuestion) {
        String name = helloUser();
        int countCorrectAnswer = 0;
        System.out.println(mainQuestion);
        while (countCorrectAnswer < COUNT_CORRECT_ANSWERS) {
            for (int i = 0; i < questionAnswer.size(); i++) {
                if (equalsAnswers(name, questionAnswer.get(i).getValue(), questionAnswer.get(i).getKey())) {
                    countCorrectAnswer++;
                } else {
                    return;
                }
            }
        }
        if (countCorrectAnswer == COUNT_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
        scanner.close();
    }
    private static boolean equalsAnswers(String name, String correctAnswer, String question) {
        System.out.print("Question: " + question + "\nYour answer: ");
        String answer = scanner.nextLine();
        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        }
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
        return false;
    }

    public static String helloUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
