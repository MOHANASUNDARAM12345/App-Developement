import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {


    JTextArea area;
    JButton closeBtn;


    public AdminPanel()
    {

        setTitle("Admin Panel");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel title =
        new JLabel("ADMIN PANEL");


        title.setFont(
        new Font("Arial",Font.BOLD,20));


        title.setBounds(170,20,200,30);



        area = new JTextArea();

        JScrollPane sp =
        new JScrollPane(area);


        sp.setBounds(50,70,400,220);



        closeBtn =
        new JButton("Close");


        closeBtn.setBounds(190,320,100,30);



        add(title);
        add(sp);
        add(closeBtn);



        closeBtn.addActionListener(this);



        showAccounts();



        setVisible(true);

    }



    public void showAccounts()
    {

        String data="";


        for(Account acc : BankData.accounts)
        {

            data +=
            "Account No : "
            +acc.accountNumber+
            "\nName : "
            +acc.accountHolder+
            "\nBalance : "
            +acc.balance+
            "\n----------------\n";

        }


        area.setText(data);

    }



    public void actionPerformed(ActionEvent e)
    {

        dispose();

    }

}