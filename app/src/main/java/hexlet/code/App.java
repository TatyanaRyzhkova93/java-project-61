package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.Even;

import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        String[] nameGame = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
        Map<Integer, String> games = new LinkedHashMap<>();
        for (int i = 1; i < nameGame.length; i++) {
            games.put(i, nameGame[i - 1]);
        }
        games.put(0, "Exit");
        System.out.println("Please enter the game number and press Enter.");
        for (Map.Entry<Integer, String>
                entry : games.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (!games.get(choice).isEmpty()) {
            switch (games.get(choice)) {
                case "Greet" : Engine.helloUser(); break;
                case "Even" :
                    Even.runGame(); break;
                case "Calc" :
                    Calc.runGame(); break;
                case "GCD" :
                    GCD.runGame(); break;
                case "Progression" :
                    Progression.runGame(); break;
                case "Prime" :
                    Prime.runGame(); break;
                default: break;
            }
        }
        scanner.close();
    }
}
