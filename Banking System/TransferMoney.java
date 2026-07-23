import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransferMoney extends JFrame implements ActionListener {

    JLabel title, fromLabel, toLabel, amountLabel;
    JTextField fromField, toField, amountField;
    JButton transferBtn, backBtn;


    public TransferMoney() {

        setTitle("Transfer Money");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("TRANSFER MONEY");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(90,20,230,30);



        fromLabel = new JLabel("From Account");
        fromLabel.setBounds(30,80,120,25);

        fromField = new JTextField();
        fromField.setBounds(170,80,170,25);



        toLabel = new JLabel("To Account");
        toLabel.setBounds(30,120,120,25);

        toField = new JTextField();
        toField.setBounds(170,120,170,25);



        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30,160,120,25);

        amountField = new JTextField();
        amountField.setBounds(170,160,170,25);



        transferBtn = new JButton("Transfer");
        transferBtn.setBounds(70,230,100,30);



        backBtn = new JButton("Back");
        backBtn.setBounds(210,230,100,30);



        add(title);

        add(fromLabel);
        add(fromField);

        add(toLabel);
        add(toField);

        add(amountLabel);
        add(amountField);

        add(transferBtn);
        add(backBtn);



        transferBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==transferBtn)
        {

            String fromAcc = fromField.getText();
            String toAcc = toField.getText();


            try
            {

                double amount =
                Double.parseDouble(amountField.getText());


                Account sender = null;
                Account receiver = null;



                for(Account acc : BankData.accounts)
                {

                    if(acc.accountNumber.equals(fromAcc))
                    {
                        sender = acc;
                    }


                    if(acc.accountNumber.equals(toAcc))
                    {
                        receiver = acc;
                    }

                }



                if(sender == null || receiver == null)
                {

                    JOptionPane.showMessageDialog(this,
                    "Account Not Found");

                }


                else if(sender.balance < amount)
                {

                    JOptionPane.showMessageDialog(this,
                    "Insufficient Balance");

                }


                else
                {


                        sender.balance -= amount;

                        receiver.balance += amount;

                        String history =
                        "TRANSFER\nFrom Account : "
                        + fromAcc
                        + "\nTo Account : "
                        + toAcc
                        + "\nAmount : "
                        + amount;

                        BankData.transactions.add(history);
                        FileManager.saveTransaction(history);
                        FileManager.saveAccounts();

                        JOptionPane.showMessageDialog(this,
                        "Money Transferred Successfully");

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