import java.awt.event.*;  
import javax.swing.*;  
import java.awt.*;
public class newclas { 
    JFrame f=new JFrame("Button Example");  
    JButton b1,b2,b3;
    JLabel l;
    public newclas(){ 
    l = new JLabel("CHOOSE YOUR MODE:");
    l.setForeground(Color.BLACK);
    l.setBackground(Color.CYAN);
    l.setFont(new Font("Tahoma", Font.PLAIN, 32));
    l.setBounds(150,100,500,30);
    f.add(l);
    b1 =new JButton("OWNER");  
    b1.setFont(new Font("Tahoma", Font.PLAIN, 26));
    b1.setBounds(400, 392, 162, 73);
    f.add(b1);
    b2 =new JButton("CUSTOMER");
    b2.setFont(new Font("Tahoma", Font.PLAIN, 26));
    b2.setBounds(100, 392, 200, 73);
    //b2.setBounds(150,300,120,30);
    f.add(b2);
    b3 =new JButton("EXIT");
    b3.setFont(new Font("Tahoma", Font.PLAIN, 26));
    b3.setBounds(250, 500, 200, 73);
    //b2.setBounds(150,300,120,30);
    f.add(b3);
    b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
             new login();
             f.dispose();
        }  
    }); 
    b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
             f.dispose();
             new customer();
        }  
    }); 
    b3.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
             f.dispose();
        }  
    }); 
    f.setLayout(null);
    f.setVisible(true);
    f.setSize(700,800);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(false);
    f.getContentPane().setBackground(Color.cyan);
}  
} 
