import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class booked_halls extends JFrame implements ActionListener {  
//Initializing Components  
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8,lb9;  
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;  
    JButton btn,b;  
    String qwe;
    //Creating Constructor for initializing JFrame components  
    booked_halls(String username) {  
        
        //Providing Title  
        super("Fetching Information");  
        qwe=username;
        lb5 = new JLabel("NAME:");  
        lb5.setBounds(20, 20, 100, 20);  
        //tf5 = new JTextField(20);  
        lb9 = new JLabel(username);
        lb9.setBounds(130, 20, 200, 20);
        //tf5.setBounds(130, 20, 200, 20);  
        btn = new JButton("Submit");  
        btn.setBounds(50, 50, 100, 20); 
        b = new JButton("LOGOUT AND EXIT");  
        b.setBounds(50, 350, 300, 20);  
        btn.addActionListener(this);  
        b.addActionListener(this);  
        lb = new JLabel("Fetching Information From Database");  
        lb.setBounds(30, 80, 450, 30);  
        lb.setForeground(Color.red);  
        lb.setFont(new Font("Serif", Font.BOLD, 20));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(700, 800);  
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.cyan);
        lb1 = new JLabel("ID:");  
        lb1.setBounds(20, 120, 100, 20);  
        tf1 = new JTextField(50);  
        tf1.setBounds(130, 120, 200, 20);  
        lb2 = new JLabel("HALL NAME:");  
        lb2.setBounds(20, 150, 100, 20);  
        tf2 = new JTextField(100);  
        tf2.setBounds(130, 150, 200, 20);  
        lb3 = new JLabel("HALL LOCATION:");  
        lb3.setBounds(20, 180, 100, 20);  
        tf3 = new JTextField(50);  
        tf3.setBounds(130, 180, 200, 20);  
        lb4 = new JLabel("HALL OWNER:");  
        lb4.setBounds(20, 210, 100, 20);  
        tf4 = new JTextField(50);  
        tf4.setBounds(130, 210, 100, 20);  
        lb6 = new JLabel("HALL CAPACITY:");  
        lb6.setBounds(20, 240, 100, 20); 
        tf7 = new JTextField(50);  
        tf7.setBounds(130, 240, 100, 20); 
        lb7 = new JLabel("HALL TYPE:");  
        lb7.setBounds(20, 270, 100, 20); 
        tf8 = new JTextField(50);  
        tf8.setBounds(130, 270, 100, 20); 
        lb8 = new JLabel("HALL STATUS:");  
        lb8.setBounds(20, 300, 100, 20); 
        tf9 = new JTextField(50);  
        tf9.setBounds(130, 300, 100, 20); 
        setLayout(null);  
        //Add components to the JFrame  
        add(lb5);  
        //add(tf5);  
        add(btn);  
        add(lb);  
        add(lb1);  
        add(tf1);  
        add(lb2);  
        add(tf2);  
        add(lb3);  
        add(tf3);  
        add(lb4);  
        add(tf4);
        add(lb6);
        add(tf7);
        add(lb7);
        add(tf8);
        add(lb8);
        add(tf9);
        add(lb9);
        add(b);
        //Set TextField Editable False  
        tf1.setEditable(false);  
        tf2.setEditable(false);  
        tf3.setEditable(false);  
        tf4.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
    }  
    public void actionPerformed(ActionEvent e) {  
        //Create DataBase Coonection and Fetching Records  
        if (e.getSource() == btn)
        {
            try {  
            //String str = tf5.getText();  
            String str = lb9.getText();
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");
            Statement stmt = con.createStatement();
            String query ="select * from owner inner join booked on owner.h_name=booked.h_name";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {  
                String s = rs.getString("id");  
                String s1 = rs.getString("h_name");  
                String s2 = rs.getString("h_loc");  
                String s3 = rs.getString("h_owner");  
                String s4 = rs.getString("h_capacity");  
                String s5 = rs.getString("h_type");
                String s6 = rs.getString("h_status");
                String s7 = rs.getString("name_");
                if(!s7.equals(qwe))
                {
                    JOptionPane.showMessageDialog(null, "YOU HAVEN'T BOOKED ANY HALL");
                }
                //Sets Records in TextFields.  
                else{
                tf1.setText(s);  
                tf2.setText(s1);  
                tf3.setText(s2);  
                tf4.setText(s3);
                tf7.setText(s4);
                tf8.setText(s5);
                tf9.setText(s6);
                }
            } else {  
                JOptionPane.showMessageDialog(null, "Name not Found");  
            }  
            //Create Exception Handler  
        } catch (Exception ex) {  
            System.out.println(ex);  
        }  
        }
        else if (e.getSource() == b)
        {
            new customer();
            dispose();
        }
        
    }  
    //Running Constructor  
    public static void main(String args[]) {  
        new booked_halls("");  
    }  
}  


