import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class payment {

    JFrame f = new JFrame("PAYMENT");
    JTextField tf1,tf2,tf3,tf4;
    JButton b,b2;
    JLabel l1,l2,l3,l4;
    public payment(String name)
    {
        l1 = new JLabel("ACCOUNT ID");
        l1.setBounds(100,50,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,60,180,20);
        f.add(tf1);
        l2 = new JLabel("ACCOUNT NAME");
        l2.setBounds(100,140,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,150,180,20);
        f.add(tf2);
        l3 = new JLabel("IFSC CODE");
        l3.setBounds(100,230,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,240,180,20);
        f.add(tf3);
        l4 = new JLabel("PHONE NUMBER");
        l4.setBounds(100,320,150,40);
        f.add(l4);
        tf4 = new JTextField();
        tf4.setBounds(200,330,180,20);
        f.add(tf4);

        
        b = new JButton("PAY");
        b.setBounds(90,700,160,30);
        f.add(b);
        b2 = new JButton("EXIT");
        b2.setBounds(300,700,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String strr = tf4.getText();
                if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "EMPTY FORM CANNOT BE SUBMITTED");
                    //f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "BOOKED");
                    customer_old ah = new customer_old(name);
                    
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // go to previous page
                customer_old ah = new customer_old(name);
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.cyan);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new payment("");
    }
}
