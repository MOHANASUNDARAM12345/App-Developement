import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteAccount extends JFrame implements ActionListener {

    JLabel title, accLabel;
    JTextField accField;
    JButton deleteBtn, backBtn;


    public DeleteAccount() {

        setTitle("Delete Account");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("DELETE ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100,20,220,30);


        accLabel = new JLabel("Account Number");
        accLabel.setBounds(30,80,120,25);


        accField = new JTextField();
        accField.setBounds(170,80,170,25);



        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(70,150,100,30);


        backBtn = new JButton("Back");
        backBtn.setBounds(210,150,100,30);



        add(title);
        add(accLabel);
        add(accField);
        add(deleteBtn);
        add(backBtn);


        deleteBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==deleteBtn)
        {

            String accNo = accField.getText();

            boolean found = false;


            for(int i = 0; i < BankData.accounts.size(); i++)
            {

                Account acc = BankData.accounts.get(i);

                if(acc.accountNumber.equals(accNo))
                {

                    BankData.accounts.remove(i);

                    found = true;


                    JOptionPane.showMessageDialog(this,
                            "Account Deleted Successfully");

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