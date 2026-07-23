import java.util.ArrayList;
import java.util.Scanner;

class UserAction {
    String actionName;
    double carbonSaved;
    int pointsEarned;

    public UserAction(String name, double carbon, int points) {
        this.actionName = name;
        this.carbonSaved = carbon;
        this.pointsEarned = points;
    }
}

public class GreenStepSystem {
    private static ArrayList<UserAction> history = new ArrayList<>();
    private static double totalCarbonSaved = 0.0;
    private static int totalPoints = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Green Step System ===");
            System.out.println("1. Log Eco-Friendly Action");
            System.out.println("2. View Summary & Impact");
            System.out.println("3. View Action History");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    logAction(scanner);
                    break;
                case 2:
                    viewSummary();
                    break;
                case 3:
                    viewHistory();
                    break;
                case 4:
                    System.out.println("Thank you for helping the planet!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void logAction(Scanner scanner) {
        System.out.println("\nChoose an action:");
        System.out.println("1. Used Public Transport / Bicycled (2.5 kg CO2, 50 pts)");
        System.out.println("2. Planted a Tree (10.0 kg CO2, 200 pts)");
        System.out.println("3. Used Reusable Bag / Bottle (0.5 kg CO2, 10 pts)");
        System.out.print("Select action (1-3): ");
        
        int actChoice = scanner.nextInt();
        String name = "";
        double carbon = 0;
        int points = 0;

        if (actChoice == 1) {
            name = "Public Transport / Bicycle";
            carbon = 2.5;
            points = 50;
        } else if (actChoice == 2) {
            name = "Planted a Tree";
            carbon = 10.0;
            points = 200;
        } else if (actChoice == 3) {
            name = "Reusable Bag / Bottle";
            carbon = 0.5;
            points = 10;
        } else {
            System.out.println("Invalid action selected.");
            return;
        }

        history.add(new UserAction(name, carbon, points));
        totalCarbonSaved += carbon;
        totalPoints += points;
        System.out.println("Action logged successfully!");
    }

    private static void viewSummary() {
        System.out.println("\n--- Impact Summary ---");
        System.out.println("Total CO2 Saved: " + totalCarbonSaved + " kg");
        System.out.println("Total Green Points: " + totalPoints + " pts");
        if (totalPoints > 300) {
            System.out.println("Badge Unlocked: Eco Champion!");
        } else {
            System.out.println("Badge Progress: Keep going to reach Eco Champion!");
        }
    }

    private static void viewHistory() {
        System.out.println("\n--- Action History ---");
        if (history.isEmpty()) {
            System.out.println("No actions logged yet.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                UserAction a = history.get(i);
                System.out.println((i + 1) + ". " + a.actionName + " | -" + a.carbonSaved + "kg CO2 | +" + a.pointsEarned + " pts");
            }
        }
    }
}
