
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;

public class customer_new {
    public boolean phoneNumberValidation(String s)
    {
        int i,a,c=0;
        a = s.length();
        if(a==10&&(s.charAt(0)=='6'||s.charAt(0)=='7'||s.charAt(0)=='8'||s.charAt(0)=='9'))
        {
            for(i=0;i<a;i++)
            {
                if(Character.isDigit(s.charAt(i)))
                {
                    c++;
                }
            }
        }
        if(c==10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean emailVerification(String s)
    {
        String id = "",mid = "",last = "";
        int d=0;
        int m;
        int length;
        length = s.length();
        for(int i =0;i<length;i++)
        {

            if(s.charAt(i)=='@')
            {
                break;
            }
            else
            {
                d++;
                id = id+s.charAt(i);
            }
        }
        m=d;
        for(int i=d+1;i<length;i++)
        {
            if(s.charAt(i)=='.')
            {
                break;
            }
            else
            {
                m++;
                mid=mid+s.charAt(i);
            }
        }
        m++;
        for(int i = m+1;i<length;i++)
        {
            last = last+s.charAt(i);
        }
        int idl=0;

        if(((id.charAt(id.length()-1))!='-'||(id.charAt(id.length()-1))!='_'||(id.charAt(id.length()-1))!='.')&&
                ((id.charAt(0))!='-'||(id.charAt(0))!='_'||(id.charAt(0))!='.'));
        {
            for(int i=0;i<id.length();i++)
            {
                if(Character.isDigit(id.charAt(i))||id.charAt(i)=='.'||id.charAt(i)=='-'||id.charAt(i)=='_'||(id.toLowerCase().charAt(i)>='a'&&id.toLowerCase().charAt(i)<='z'))
                {
                    idl++;
                }
            }
        }
        if(idl==id.length()&&(mid.equals("gmail")||mid.equals("yahoo"))&&(last.equals("com")||last.equals("in")))
        {
            return true;
        }
        else
            return false;
    }
    JFrame f = new JFrame("NEW USER LOGIN");
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    JPasswordField value1,value2;
    public customer_new()
    {
        l1 = new JLabel("First Name");
        l1.setBounds(100,90,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,100,180,20);
        f.add(tf1);
        l2 = new JLabel("Last Name");
        l2.setBounds(100,180,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,190,180,20);
        f.add(tf2);
        l3 = new JLabel("Email Id");
        l3.setBounds(100,270,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,280,180,20);
        f.add(tf3);
        l6 = new JLabel("Phone");
        l6.setBounds(100,360,150,40);
        f.add(l6);
        tf4 = new JTextField("+91");
        tf4.setBounds(200,370,30,20);
        f.add(tf4);
        tf5 = new JTextField();
        tf5.setBounds(240,370,180,20);
        f.add(tf5);
        l4 = new JLabel("New Password");
        l4.setBounds(100,450,150,40);
        f.add(l4);
        value1= new JPasswordField();
        value1.setBounds(200,460,180,20);
        f.add(value1);
        l5 = new JLabel("Re-Enter Password");
        l5.setBounds(80,540,150,40);
        f.add(l5);
        value2 = new JPasswordField();
        value2.setBounds(200,550,180,20);
        f.add(value2);
        b = new JButton("Create");
        b.setBounds(100,640,80,30);
        f.add(b);
        b2 = new JButton("Back");
        b2.setBounds(300,640,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 String strr = tf1.getText();
                if(tf1.getText().equals("")||tf2.getText().equals("")||tf5.getText().equals("")||tf3.getText().equals("")||String.valueOf(value1.getPassword()).equals(""))
                {
                    JOptionPane.showMessageDialog(null, "EMPTY FORM CANNOT BE SUBMITTED");
                    //f.dispose();
                }
                else
                {
                    if(phoneNumberValidation(tf5.getText()))
                    {
                        if(emailVerification(tf3.getText()))
                        {
                            try
                            {
			Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","abcde","vishaal");

			String sql = "INSERT INTO reg_users (f_name, l_name, email, phone,password) " +
					"values ('"+tf1.getText()+"'," +"'"+tf2.getText()+"'," +"'"+tf3.getText()+"'," +"'"+tf5.getText()+"',"+"'"+value1.getText()+"')";

			Statement st = con.createStatement();
			st.execute(sql);

			JOptionPane.showMessageDialog(null, "Record Added Succesfully.","Record Added",
                        JOptionPane.INFORMATION_MESSAGE);
			tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        tf5.setText("");
                        value1.setText("");
                        }catch(Exception ae)
                        {
			JOptionPane.showMessageDialog(null, ae.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
                        }
                            //owner ah = new owner("");
                            //ah.setVisible(true);
                        customer_old ah = new customer_old(strr);
                        //ah.setVisible(true);
                        f.dispose();
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "INVALID EMAIL ID");
                            //f.dispose();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "INVALID PHONE NUMBER");
                       //f.dispose();
                    }
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new customer();
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.cyan);
    	}
	public static void main(String[] args)
	{
		new customer_new();
	}
}



