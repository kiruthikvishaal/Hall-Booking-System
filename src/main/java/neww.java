import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class neww extends JFrame implements ActionListener {

 

    JFrame frame1;

    JLabel l0, l1, l2;
    JTextField l3;

    JComboBox c1;

    JButton b1,b2,b3,b4,b;

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst;

    String ids,z;

    static JTable table;

    String[] columnNames = {"id","h_name","h_ocation","h_owner","h_capacity","h_type","h_status"};

    String from,strr;

 

    neww(String name) {

 
        strr = name;
        l0 = new JLabel("Fatching Information");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select name");

        b1 = new JButton("VIEW");
        b2 = new JButton("BOOK");
        b3 = new JButton("BACK");
        b4 = new JButton("PAY AND BOOK");
        b = new JButton("LOGOUT AND EXIT");
        l3 = new JTextField();

 

        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(75, 110, 75, 20);

        b1.setBounds(150, 150, 150, 20);
         b2.setBounds(100, 250, 150, 20);
          b3.setBounds(270, 250, 150, 20);
        b4.setBounds(420, 300, 150, 20);
        b.setBounds(200, 400, 150, 20);
        l3.setBounds(150, 300, 250, 20);
         l3.setVisible(false);
         b4.setVisible(false);

        b1.addActionListener(this);
         b2.addActionListener(this);
          b3.addActionListener(this);
        b4.addActionListener(this);
        b.addActionListener(this);

 

        setTitle("Fetching Info From DataBase");

        setLayout(null);

        setVisible(true);

        setSize(700, 800);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        
        setResizable(false);
        getContentPane().setBackground(Color.cyan);

 

        add(l0);

        add(l1);;

        add(b1);
        add(b2);
        add(b3);
        add(l3);
        add(b4);
        add(b);

        try {

             Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");

            st = con.createStatement();

            rs = st.executeQuery("select h_name from owner where h_status='NOT BOOKED'");

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getString(1);

                v.add(ids);

            }

            c1 = new JComboBox(v);

            c1.setBounds(150, 110, 150, 20);

 

            add(c1);

            st.close();

            rs.close();

        } catch (Exception e) {

        }

    }

 

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            showTableData();

        }
        else if (ae.getSource() == b2) {

            //String z = c1.getSelectedItem();
            l3.setVisible(true);
            b4.setVisible(true);
            String z =(String) c1.getSelectedItem();
            l3.setText(c1.getSelectedItem()+" ");
                
        }
        else if (ae.getSource() == b3) {

            customer_old ah = new customer_old(strr);

        }
        else if (ae.getSource() == b4) {

            try {
                    //Class.forName("oracle.jdbc.driver.OracleDriver"); 
                    String z =(String) c1.getSelectedItem();
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("update owner set h_status='BOOKED' where h_name=?");

                    st.setString(1, z);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        String stq ="INSERT INTO booked (name_,h_name) " +"values ('"+strr+"'," +"'"+z+"')";
                        Statement sta = con.createStatement();
			st.execute(stq);
                        JOptionPane.showMessageDialog(b4, "BOOKED");
                        payment ah = new payment(strr);
                        dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(b4, "NOT BOOKED");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

        }
        else if (ae.getSource() == b) {

            new customer();
            dispose();

        }
    }
    public void showTableData() {

 

        frame1 = new JFrame("Database Search Result");

        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

//String textvalue = textbox.getText();

        String id = "";

        String h_name = "";

        String h_loc = "";

        String h_owner = "";
        String h_capacity = "";
        String h_type = "";
        String h_status = "";

 

        try {

            pst = con.prepareStatement("select * from owner where h_name='" + from + "'");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {

                id = rs.getString("id");

                h_name = rs.getString("h_name");

                h_loc = rs.getString("h_loc");

                h_owner = rs.getString("h_owner");
                h_capacity = rs.getString("h_capacity");
                h_type = rs.getString("h_type");
                h_status = rs.getString("h_status");
                

                model.addRow(new Object[]{id,h_name,h_loc,h_owner,h_capacity,h_type,h_status});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);

    }

 

    public static void main(String args[]) {

        new neww("");

    }

}
