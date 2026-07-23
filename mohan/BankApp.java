import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== BANKING SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Transfer Money");
            System.out.println("6. Search Account");
            System.out.println("7. Update Account");
            System.out.println("8. Delete Account");
            System.out.println("9. View All Accounts");
            System.out.println("10. Transaction History");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 11) {
                System.out.println("Thank You!");
                break;
            }

            if (choice == 1) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                boolean exists = false;

                for (Account account : accounts) {
                    if (account.accountNumber.equals(accountNumber)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Account Number Already Exists!");
                } else {

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scan.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double balance = scan.nextDouble();
                    scan.nextLine();

                    Account newAccount = new Account(accountNumber, accountHolder, balance);
                    accounts.add(newAccount);

                    System.out.println("Account Created Successfully.");
                }

            } else if (choice == 2) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    System.out.print("Enter Deposit Amount: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();

                    if (amount > 0) {
                        account.balance += amount;
                        System.out.println("Deposit Successful.");
                        System.out.println("Current Balance: " + account.balance);
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    System.out.print("Enter Withdraw Amount: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();

                    if (amount <= 0) {
                        System.out.println("Invalid Amount!");
                    } 
                    else if (amount > account.balance) {
                        System.out.println("Insufficient Balance!");
                    } 
                    else {
                        account.balance -= amount;
                        System.out.println("Withdrawal Successful.");
                        System.out.println("Current Balance: " + account.balance);
                    }
                }

            } else if (choice == 4) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    System.out.println("\n========== ACCOUNT DETAILS ==========");
                    System.out.println("Account Number : " + account.accountNumber);
                    System.out.println("Account Holder : " + account.accountHolder);
                    System.out.println("Current Balance: " + account.balance);
                }

            } else if (choice == 5) {

                System.out.print("Enter Sender Account Number: ");
                String senderNumber = scan.nextLine();

                System.out.print("Enter Receiver Account Number: ");
                String receiverNumber = scan.nextLine();

                Account sender = null;
                Account receiver = null;

                for (Account a : accounts) {

                    if (a.accountNumber.equals(senderNumber)) {
                        sender = a;
                    }

                    if (a.accountNumber.equals(receiverNumber)) {
                        receiver = a;
                    }
                }

                if (sender == null) {
                    System.out.println("Sender Account Not Found!");
                }
                else if (receiver == null) {
                    System.out.println("Receiver Account Not Found!");
                }
                else {

                    System.out.print("Enter Transfer Amount: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();

                    if (amount <= 0) {
                        System.out.println("Invalid Amount!");
                    }
                    else if (amount > sender.balance) {
                        System.out.println("Insufficient Balance!");
                    }
                    else {

                        sender.balance -= amount;
                        receiver.balance += amount;

                        System.out.println("Transfer Successful.");
                        System.out.println("Sender Balance   : " + sender.balance);
                        System.out.println("Receiver Balance : " + receiver.balance);
                    }
                }

            } else if (choice == 6) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    System.out.println("\n========== ACCOUNT FOUND ==========");
                    System.out.println("Account Number : " + account.accountNumber);
                    System.out.println("Account Holder : " + account.accountHolder);
                    System.out.println("Balance        : " + account.balance);
                }

            } else if (choice == 7) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    System.out.println("Current Account Holder : " + account.accountHolder);

                    System.out.print("Enter New Account Holder Name : ");
                    String newName = scan.nextLine();

                    account.accountHolder = newName;

                    System.out.println("Account Updated Successfully.");
                }

            } else if (choice == 8) {

                System.out.print("Enter Account Number: ");
                String accountNumber = scan.nextLine();

                Account account = null;

                for (Account a : accounts) {
                    if (a.accountNumber.equals(accountNumber)) {
                        account = a;
                        break;
                    }
                }

                if (account == null) {
                    System.out.println("Account Not Found!");
                } else {

                    accounts.remove(account);

                    System.out.println("Account Deleted Successfully.");
                }

            } else if (choice == 9) {

                if (accounts.isEmpty()) {
                    System.out.println("No Accounts Available.");
                } 
                else {

                    System.out.println("\n================ ALL ACCOUNTS ================");
                    System.out.printf("%-15s %-20s %-15s\n", 
                            "Account No", "Account Holder", "Balance");
                    System.out.println("-------------------------------------------------------");

                    for (Account account : accounts) {

                        System.out.printf("%-15s %-20s %-15.2f\n",
                                account.accountNumber,
                                account.accountHolder,
                                account.balance);
                    }

                    System.out.println("-------------------------------------------------------");
                }

            } else if (choice == 10) {
                System.out.println("Transaction History not implemented yet.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }

        scan.close();
    }
}
