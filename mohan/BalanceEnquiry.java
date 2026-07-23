import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel title, accLabel;
    JTextField accField;
    JButton checkBtn, backBtn;


    public BalanceEnquiry() {

        setTitle("Balance Enquiry");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("BALANCE ENQUIRY");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(90,20,230,30);


        accLabel = new JLabel("Account Number");
        accLabel.setBounds(30,80,120,25);


        accField = new JTextField();
        accField.setBounds(170,80,170,25);


        checkBtn = new JButton("Check");
        checkBtn.setBounds(70,150,100,30);


        backBtn = new JButton("Back");
        backBtn.setBounds(210,150,100,30);



        add(title);
        add(accLabel);
        add(accField);
        add(checkBtn);
        add(backBtn);



        checkBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==checkBtn)
        {

            String accNo = accField.getText();

            boolean found = false;


            for(Account acc : BankData.accounts)
            {

                if(acc.accountNumber.equals(accNo))
                {

                    JOptionPane.showMessageDialog(this,

                    "Account Number : " + acc.accountNumber
                    + "\nAccount Holder : " + acc.accountHolder
                    + "\nAvailable Balance : " + acc.balance);


                    found = true;
                    break;

                }

            }


            if(!found)
            {
                JOptionPane.showMessageDialog(this,
                "Account Not Found");
            }

        }



        if(e.getSource()==backBtn)
        {
            dispose();
        }

    }

}