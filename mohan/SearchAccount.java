import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchAccount extends JFrame implements ActionListener {

    JLabel title, accLabel;
    JTextField accField;
    JButton searchBtn, backBtn;


    public SearchAccount() {

        setTitle("Search Account");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("SEARCH ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100,20,220,30);


        accLabel = new JLabel("Account Number");
        accLabel.setBounds(30,80,120,25);


        accField = new JTextField();
        accField.setBounds(170,80,170,25);


        searchBtn = new JButton("Search");
        searchBtn.setBounds(70,150,100,30);


        backBtn = new JButton("Back");
        backBtn.setBounds(210,150,100,30);



        add(title);
        add(accLabel);
        add(accField);
        add(searchBtn);
        add(backBtn);



        searchBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==searchBtn)
        {

            String accNo = accField.getText();

            boolean found = false;


            for(Account acc : BankData.accounts)
            {

                if(acc.accountNumber.equals(accNo))
                {

                    JOptionPane.showMessageDialog(this,

                    "Account Found\n\n"+
                    "Account No : "+acc.accountNumber+
                    "\nName : "+acc.accountHolder+
                    "\nBalance : "+acc.balance);


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