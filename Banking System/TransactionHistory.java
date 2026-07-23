import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionHistory extends JFrame implements ActionListener {

    JTextArea area;
    JButton backBtn;


    public TransactionHistory() {

        setTitle("Transaction History");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        JLabel title = new JLabel("TRANSACTION HISTORY");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(120,20,300,30);



        area = new JTextArea();
        area.setEditable(false);


        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(50,70,400,220);



        backBtn = new JButton("Back");
        backBtn.setBounds(200,320,100,30);



        add(title);
        add(scroll);
        add(backBtn);


        displayHistory();

        backBtn.addActionListener(this);

        setVisible(true);

    }



    public void displayHistory() {

        if(BankData.transactions.size()==0)
        {
            area.setText("No Transactions Available");
        }
        else
        {
            for(String t : BankData.transactions)
            {
                area.append(t + "\n\n");
            }
        }

    }



    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==backBtn)
        {
            dispose();
        }

    }

}