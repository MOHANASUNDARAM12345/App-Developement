import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel title, accLabel, amountLabel;
    JTextField accField, amountField;
    JButton depositBtn, backBtn;


    public Deposit() {

        setTitle("Deposit Money");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("DEPOSIT MONEY");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(110,20,200,30);


        accLabel = new JLabel("Account Number");
        accLabel.setBounds(30,80,120,25);

        accField = new JTextField();
        accField.setBounds(170,80,170,25);



        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30,120,120,25);

        amountField = new JTextField();
        amountField.setBounds(170,120,170,25);



        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(70,190,100,30);


        backBtn = new JButton("Back");
        backBtn.setBounds(210,190,100,30);



        add(title);

        add(accLabel);
        add(accField);

        add(amountLabel);
        add(amountField);

        add(depositBtn);
        add(backBtn);


        depositBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==depositBtn)
        {

            String accNo = accField.getText();


            try
            {
                double amount =
                Double.parseDouble(amountField.getText());


                boolean found = false;


                for(Account acc : BankData.accounts)
                {

                    if(acc.accountNumber.equals(accNo))
                    {

                        acc.balance += amount;

                        String history =
                        "DEPOSIT\nAccount : "
                        + acc.accountNumber
                        + "\nAmount : "
                        + amount;

                        BankData.transactions.add(history);
                        FileManager.saveTransaction(history);
                        FileManager.saveAccounts();

                        found = true;

                        JOptionPane.showMessageDialog(this,
                        "Deposit Successful");

                        break;
                    }

                }


                if(!found)
                {
                    JOptionPane.showMessageDialog(this,
                    "Account Not Found");
                }


            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,
                "Enter valid amount");
            }

        }



        if(e.getSource()==backBtn)
        {
            dispose();
        }

    }

}