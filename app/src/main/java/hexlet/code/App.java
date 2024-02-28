package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Map<Integer, String> games = new HashMap<Integer, String>();
        games.put(1, "Greet");
        games.put(2, "Even");
        games.put(3, "Calc");
        games.put(0, "Exit");
        games.put(4, "GCD");
        games.put(5, "Progression");
        games.put(6, "Prime");
        System.out.println("Please enter the game number and press Enter.");
        games.entrySet().stream().skip(1).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        Map.Entry<Integer, String> entry = games.entrySet().stream().findFirst().get();
        System.out.println(entry.getKey() + " - " + entry.getValue());
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            scanner.close();
            return;
        }
        if (!games.get(choice).isEmpty()) {
            Engine engine = new Engine(games.get(choice));
            engine.runGame();
        }
        scanner.close();
    }
}
