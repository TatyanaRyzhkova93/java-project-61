package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
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
        String name = helloUser();
        if (!nameGame.equals("Greet")) {
            Game game = chooseGame();
            game.runGame();
            correctAnswers = game.getCorrectAnswers();
            mainQuestion = game.getMainQuestion();
            questions = game.getQuestions();
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
    }
    private Game chooseGame() {
        return switch (nameGame) {
            case "Calc" -> new Calc();
            case "GCD" -> new GCD();
            case "Progression" -> new Progression();
            case "Prime" -> new Prime();
            default -> new Even();
        };
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

    private String helloUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
