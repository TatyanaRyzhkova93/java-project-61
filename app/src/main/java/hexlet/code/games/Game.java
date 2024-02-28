package hexlet.code.games;

import java.util.List;

public interface Game {
    String getMainQuestion();
    List<String> getCorrectAnswers();
    List<String> getQuestions();

    void runGame();
}
