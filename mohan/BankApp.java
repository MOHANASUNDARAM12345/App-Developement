import java.util.ArrayList;
import java.util.Scanner;

// Simple Account Data Holder
class Account {
    String id;
    String name;
    double balance;

    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}

// Main Application
public class BankApp {
    public static void main(String[] args) {
        ArrayList<Account> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("=======================BANKING APP MANAGEMENT=====================");
            System.out.println("                       1. Crete");
            System.out.println("                       2. Deposit");
            System.out.println("                       3. Withdraw");
            System.out.println("                       4. Balance");
            System.out.println("                       5. Exit");
            System.out.print("Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 5)
                break;

            System.out.print("Enter Account ID: ");
            String id = scan.nextLine();

            if (choice == 1) {

                boolean exists = false;
                for (Account a : list) {
                    if (a.id.equals(id))
                        exists = true;
                }

                if (exists) {
                    System.out.println("Error: Duplicate ID!");
                } else {
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Initial Deposit: ");
                    double amt = scan.nextDouble();
                    list.add(new Account(id, name, amt));
                    System.out.println("Account Created!");
                }

            } else {

                Account target = null;
                for (Account a : list) {
                    if (a.id.equals(id))
                        target = a;
                }

                if (target == null) {
                    System.out.println("Account not found!");
                    continue;
                }

                if (choice == 2) {
                    System.out.print("Amount to deposit: ");
                    double amt = scan.nextDouble();
                    target.balance += amt;
                    System.out.println("Done! New Balance: $" + target.balance);

                } else if (choice == 3) {
                    System.out.print("Amount to withdraw: ");
                    double amt = scan.nextDouble();

                    if (amt <= target.balance) {
                        target.balance -= amt;
                        System.out.println("Done! New Balance: $" + target.balance);
                    } else {
                        System.out.println("Insufficient funds!");
                    }

                } else if (choice == 4) {
                    System.out.println("Holder: " + target.name);
                    System.out.println("Balance: $" + target.balance);
                }
            }
        }

        scan.close();
    }
}