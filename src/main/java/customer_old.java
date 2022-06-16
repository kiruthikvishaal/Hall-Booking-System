import java.awt.event.*;  
import javax.swing.*;  
import java.awt.*;
public class customer_old { 
    JFrame f=new JFrame("Button Example");  
    JButton b1,b2;
    JLabel l;
    String strr;
    public customer_old(String name){ 
        strr=name;
    l = new JLabel("CHOOSE YOUR OPTION:");
    l.setForeground(Color.BLACK);
    l.setBackground(Color.CYAN);
    l.setFont(new Font("Tahoma", Font.PLAIN, 32));
    l.setBounds(150,100,500,30);
    f.add(l);
    b1 =new JButton("AVAILABLE HALLS");  
    b1.setFont(new Font("Tahoma", Font.PLAIN, 26));
    b1.setBounds(400, 392, 250, 73);
    f.add(b1);
    b2 =new JButton("BOOKED HALLS");
    b2.setFont(new Font("Tahoma", Font.PLAIN, 26));
    b2.setBounds(100, 392, 250, 73);
    //b2.setBounds(150,300,120,30);
    f.add(b2);
    b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
             new neww(strr);
             f.dispose();
        }  
    }); 
    b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){
            
            booked_halls ah = new booked_halls(strr);
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
  
