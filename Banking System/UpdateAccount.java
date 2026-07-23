import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateAccount extends JFrame implements ActionListener {

    JLabel title, accLabel, nameLabel;
    JTextField accField, nameField;
    JButton updateBtn, backBtn;


    public UpdateAccount() {

        setTitle("Update Account");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        title = new JLabel("UPDATE ACCOUNT");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(100,20,220,30);


        accLabel = new JLabel("Account Number");
        accLabel.setBounds(30,80,120,25);

        accField = new JTextField();
        accField.setBounds(170,80,170,25);



        nameLabel = new JLabel("New Name");
        nameLabel.setBounds(30,120,120,25);

        nameField = new JTextField();
        nameField.setBounds(170,120,170,25);



        updateBtn = new JButton("Update");
        updateBtn.setBounds(70,190,100,30);


        backBtn = new JButton("Back");
        backBtn.setBounds(210,190,100,30);



        add(title);

        add(accLabel);
        add(accField);

        add(nameLabel);
        add(nameField);

        add(updateBtn);
        add(backBtn);



        updateBtn.addActionListener(this);
        backBtn.addActionListener(this);


        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==updateBtn)
        {

            String accNo = accField.getText();
            String newName = nameField.getText();

            boolean found = false;


            for(Account acc : BankData.accounts)
            {

                if(acc.accountNumber.equals(accNo))
                {

                    acc.accountHolder = newName;

                    found = true;


                    JOptionPane.showMessageDialog(this,
                    "Account Updated Successfully");

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