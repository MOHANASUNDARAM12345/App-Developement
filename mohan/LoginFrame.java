import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel, userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton, exitButton;

    public LoginFrame() {

        FileManager.loadAccounts();

        setTitle("Banking System Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("BANKING SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(80, 20, 250, 30);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 80, 100, 25);

        userField = new JTextField();
        userField.setBounds(150, 80, 180, 25);

        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 120, 100, 25);

        passField = new JPasswordField();
        passField.setBounds(150, 120, 180, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 190, 100, 30);

        exitButton = new JButton("Exit");
        exitButton.setBounds(220, 190, 100, 30);

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(titleLabel);
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
        add(exitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(this, "Login Successful");

                dispose();

                new Dashboard();

            } else {

                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}