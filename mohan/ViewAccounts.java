import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewAccounts extends JFrame implements ActionListener {

    JTextArea area;
    JButton backBtn;


    public ViewAccounts() {

        setTitle("View All Accounts");
        setSize(450,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        JLabel title = new JLabel("ALL ACCOUNTS");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(140,20,200,30);


        area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(40,70,360,220);


        backBtn = new JButton("Back");
        backBtn.setBounds(170,320,100,30);


        add(title);
        add(scroll);
        add(backBtn);


        backBtn.addActionListener(this);


        displayAccounts();


        setVisible(true);

    }



    public void displayAccounts() {

        if(BankData.accounts.size()==0)
        {
            area.setText("No Accounts Available");
        }

        else
        {

            String data = "";

            for(Account acc : BankData.accounts)
            {

                data += "Account Number : "
                        + acc.accountNumber
                        + "\nName : "
                        + acc.accountHolder
                        + "\nBalance : "
                        + acc.balance
                        + "\n-----------------------\n";

            }

            area.setText(data);

        }

    }



    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==backBtn)
        {
            dispose();
        }

    }

}