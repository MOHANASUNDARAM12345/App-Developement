import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton createBtn, depositBtn, withdrawBtn, balanceBtn;
    JButton transferBtn, searchBtn, updateBtn, deleteBtn;
    JButton viewBtn, historyBtn, logoutBtn;
    JButton adminBtn;


    public Dashboard() {

        setTitle("Banking System Dashboard");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2, 10, 10));


        createBtn = new JButton("Create Account");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        balanceBtn = new JButton("Balance Enquiry");

        transferBtn = new JButton("Transfer Money");
        searchBtn = new JButton("Search Account");
        updateBtn = new JButton("Update Account");
        deleteBtn = new JButton("Delete Account");

        viewBtn = new JButton("View All Accounts");
        historyBtn = new JButton("Transaction History");
        logoutBtn = new JButton("Logout");
        adminBtn = new JButton("Admin Panel");


        add(createBtn);
        add(depositBtn);
        add(withdrawBtn);
        add(balanceBtn);

        add(transferBtn);
        add(searchBtn);
        add(updateBtn);
        add(deleteBtn);

        add(viewBtn);
        add(historyBtn);
        add(logoutBtn);
        add(adminBtn);



        createBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);

        transferBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        viewBtn.addActionListener(this);
        historyBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        adminBtn.addActionListener(this);


        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == createBtn)
        {
            new CreateAccount();
        }


        else if(e.getSource() == depositBtn)
        {
            new Deposit();
        }


        else if(e.getSource() == searchBtn)
        {
            new SearchAccount();
        }


        else if(e.getSource() == updateBtn)
        {
            new UpdateAccount();
        }


        else if(e.getSource() == deleteBtn)
        {
            new DeleteAccount();
        }


        else if(e.getSource() == viewBtn)
        {
            new ViewAccounts();
        }


        else if(e.getSource() == withdrawBtn)
        {
            new Withdraw();
        }


        else if(e.getSource() == balanceBtn)
        {
            new BalanceEnquiry();
        }


        else if(e.getSource() == logoutBtn)
        {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );


            if(choice == JOptionPane.YES_OPTION)
            {
                dispose();
                new LoginFrame();
            }

        }


        else if(e.getSource() == transferBtn)
        {
            new TransferMoney();
        }

        else if(e.getSource() == historyBtn)
        {
            new TransactionHistory();
        }

        else if(e.getSource() == adminBtn)
        {
            new AdminPanel();
        }

    }

}