package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Game;

import java.util.List;
import java.util.Scanner;

public class Engine {
    private List<String> questions;
    private List<String> correctAnswers;
    private String mainQuestion;
    private final String nameGame;
    public static final int COUNT_CORRECT_ANSWERS = 3;
    Scanner scanner = new Scanner(System.in);

    public Engine(String nameGame) {
        this.nameGame = nameGame;
    }
    public void runGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        getParams();
        int countCorrectAnswer = 0;
        System.out.println(mainQuestion);
        while (countCorrectAnswer < COUNT_CORRECT_ANSWERS && questions.size() == correctAnswers.size()) {
            for (int i = 0; i < questions.size(); i++) {
                if (equalsAnswers(name, correctAnswers.get(i), questions.get(i))) {
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
    private void getParams() {
        Game game;
        switch (nameGame) {
            case "Calc" : game = new Calc(); break;
            case "GCD" : game = new GCD(); break;
            default: game = new Even();
        }
        correctAnswers = game.getCorrectAnswers();
        mainQuestion = game.getMainQuestion();
        questions = game.getQuestions();
    }
    private boolean equalsAnswers(String name, String correctAnswer, String question) {
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
}
