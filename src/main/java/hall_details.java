import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class hall_details {

    JFrame f = new JFrame("ADD NEW HALL");
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton b,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    public hall_details()
    {
        l1 = new JLabel("Hall ID");
        l1.setBounds(100,50,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,60,180,20);
        f.add(tf1);
        l2 = new JLabel("Hall Name");
        l2.setBounds(100,140,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,150,180,20);
        f.add(tf2);
        l3 = new JLabel("Hall Location");
        l3.setBounds(100,230,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,240,180,20);
        f.add(tf3);
        l4 = new JLabel("Owner Name");
        l4.setBounds(100,320,150,40);
        f.add(l4);
        tf4 = new JTextField();
        tf4.setBounds(200,330,180,20);
        f.add(tf4);

        l5 = new JLabel("Hall Capacity");
        l5.setBounds(100,410,150,40);
        f.add(l5);
        tf5 = new JTextField();
        tf5.setBounds(200,420,180,20);
        f.add(tf5);

        l6 = new JLabel("Hall type");
        l6.setBounds(100,500,150,40);
        f.add(l6);
        tf6 = new JTextField();
        tf6.setBounds(200,510,180,20);
        f.add(tf6);
        l7 = new JLabel("Hall Status");
        l7.setBounds(100,590,150,40);
        f.add(l7);
        tf7 = new JTextField();
        tf7.setBounds(200,600,180,20);
        f.add(tf7);
        b = new JButton("Create Hall");
        b.setBounds(90,700,160,30);
        f.add(b);
        b2 = new JButton("Back");
        b2.setBounds(300,700,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String strr = tf4.getText();
                if(tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "EMPTY FORM CANNOT BE SUBMITTED");
                    //f.dispose();
                } else {
                    // create a record
                        try
                        {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");


			String sql = "INSERT INTO owner (id,h_name,h_loc,h_owner,h_capacity,h_type,h_status) " +
					"values ('"+tf1.getText()+"'," +"'"+tf2.getText()+"'," +"'"+tf3.getText()+"'," +"'"+tf4.getText()+"',"+"'"+tf5.getText()+"',"+"'"+tf6.getText()+"',"+"'"+tf7.getText()+"')";
                            Statement st = con.createStatement();
                            st.execute(sql);

			JOptionPane.showMessageDialog(null, "Record Added Succesfully.","Record Added",
                        JOptionPane.INFORMATION_MESSAGE);
			tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        tf4.setText("");
                        tf5.setText("");
                        tf6.setText("");
                        tf7.setText("");
                        }catch(Exception ae)
                        {
			JOptionPane.showMessageDialog(null, ae.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
                        }
                    owner ah = new owner(strr);
                    ah.setVisible(true);
                    f.dispose();
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // go to previous page
                new abc();
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
        new hall_details();
    }
}
