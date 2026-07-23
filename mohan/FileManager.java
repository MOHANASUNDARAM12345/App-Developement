import java.io.*;
import java.util.*;

public class FileManager {

    static String fileName = "transactions.txt";

    public static void saveAccounts()
    {

        try
        {

            FileWriter fw =
            new FileWriter("accounts.txt");


            for(Account acc : BankData.accounts)
            {

                fw.write(
                acc.accountNumber + "," +
                acc.accountHolder + "," +
                acc.balance +
                "\n");

            }


            fw.close();

        }

        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    public static void loadAccounts()
    {

        try
        {

            File file = new File("accounts.txt");


            if(!file.exists())
                return;



            Scanner sc = new Scanner(file);


            while(sc.hasNextLine())
            {

                String data = sc.nextLine();


                String arr[] =
                data.split(",");



                Account acc =
                new Account(
                arr[0],
                arr[1],
                Double.parseDouble(arr[2])
                );


                BankData.accounts.add(acc);

            }


            sc.close();

        }

        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    // Save Transaction
    public static void saveTransaction(String data)
    {

        try
        {

            FileWriter fw = new FileWriter(fileName,true);

            fw.write(data);
            fw.write("\n-----------------\n");

            fw.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    // Load Transaction History
    public static ArrayList<String> loadTransactions()
    {

        ArrayList<String> list = new ArrayList<>();

        try
        {

            File file = new File(fileName);

            if(!file.exists())
                return list;


            Scanner sc = new Scanner(file);


            String temp="";


            while(sc.hasNextLine())
            {

                temp += sc.nextLine()+"\n";


                if(temp.contains("-----------------"))
                {
                    list.add(temp);
                    temp="";
                }

            }


            sc.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


        return list;

    }

}