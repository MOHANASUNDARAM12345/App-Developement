import java.util.ArrayList;

public class BankData {

    // அனைத்து Account-களையும் store செய்யும் ArrayList
    public static ArrayList<Account> accounts = new ArrayList<>();

    // Transaction history as simple strings
    public static ArrayList<String> transactions =
        FileManager.loadTransactions();

}