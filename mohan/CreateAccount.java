import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateAccount extends JFrame implements ActionListener {

    JLabel lblTitle, lblAccNo, lblName, lblBalance;
    JTextField txtAccNo, txtName, txtBalance;
    JButton btnSave, btnBack;

    public CreateAccount() {

        setTitle("Create Account");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        lblTitle = new JLabel("CREATE ACCOUNT");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(100, 20, 250, 30);

        lblAccNo = new JLabel("Account Number");
        lblAccNo.setBounds(30, 80, 120, 25);

        txtAccNo = new JTextField();
        txtAccNo.setBounds(170, 80, 170, 25);

        lblName = new JLabel("Account Holder");
        lblName.setBounds(30, 120, 120, 25);

        txtName = new JTextField();
        txtName.setBounds(170, 120, 170, 25);

        lblBalance = new JLabel("Initial Deposit");
        lblBalance.setBounds(30, 160, 120, 25);

        txtBalance = new JTextField();
        txtBalance.setBounds(170, 160, 170, 25);

        btnSave = new JButton("Save");
        btnSave.setBounds(70, 230, 100, 30);

        btnBack = new JButton("Back");
        btnBack.setBounds(210, 230, 100, 30);

        btnSave.addActionListener(this);
        btnBack.addActionListener(this);

        add(lblTitle);
        add(lblAccNo);
        add(txtAccNo);
        add(lblName);
        add(txtName);
        add(lblBalance);
        add(txtBalance);
        add(btnSave);
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSave) {

            String accNo = txtAccNo.getText();
            String name = txtName.getText();

            double balance;

            try {
                balance = Double.parseDouble(txtBalance.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid amount!");
                return;
            }

            Account account = new Account(accNo, name, balance);

            BankData.accounts.add(account);

            String history =
                "ACCOUNT CREATED\n"
                + "Account : "
                + accNo
                + "\nHolder : "
                + name
                + "\nInitial Deposit : "
                + balance;

            BankData.transactions.add(history);
            FileManager.saveTransaction(history);

            FileManager.saveAccounts();

            JOptionPane.showMessageDialog(this, "Account Created Successfully!");

            txtAccNo.setText("");
            txtName.setText("");
            txtBalance.setText("");
        }

        if (e.getSource() == btnBack) {

            dispose();

        }
    }
}