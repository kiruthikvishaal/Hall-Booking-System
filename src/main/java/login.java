import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton, btnNewButton1, l,lb;
    private JLabel label;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public login() {
        setLayout(null);
        setSize(700,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.cyan);
        //setBounds(450, 190, 1014, 597);
        setResizable(false);

    
        
        int k=0;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ADMIN Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(245, 13, 330, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(281, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(281, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(100, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(100, 286, 193, 52);
        contentPane.add(lblPassword);
        
        l = new JButton("BACK");
        l.setFont(new Font("Tahoma", Font.PLAIN, 26));
        l.setBounds(100, 500, 162, 73);
        contentPane.add(l);
        
        lb = new JButton("EXIT");
        lb.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lb.setBounds(400, 500, 162, 73);
        contentPane.add(lb);
        
        btnNewButton1 = new JButton("SIGNUP");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(100, 392, 162, 73);
        contentPane.add(btnNewButton1);
        
        btnNewButton = new JButton("SIGNIN");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(400, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    //Class.forName("oracle.jdbc.driver.OracleDriver");  
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select f_name, password from reg_owners where f_name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        
                        
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        owner ah = new owner(userName);
                        ah.setVisible(true);
                        dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                
                //new customer("");
                //dispose();
            }
        });
        lb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        l.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //abc ah = new abc();
                //ah.setVisible(true);
                new newclas();
                dispose();
            }
        });

        btnNewButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //abc ah = new abc();
                //ah.setVisible(true);
                new abc();
                dispose();
            }
        });
        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        
    }
}
