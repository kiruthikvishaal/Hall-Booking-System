import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class registration {
    JFrame f = new JFrame("WELCOME");
    JButton b;
    JLabel l1,l2,l3,l4,l5,l6,img;
        
    public registration()
    {
        
        l1 = new JLabel("HALL BOOKING SYSTEM");
        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.CYAN);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 31));
        l1.setBounds(150,100,500,100);
        f.add(l1);
        
        l2 = new JLabel("PROJECT BY:");
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.CYAN);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 27));
        l2.setBounds(250,140,500,100);
        f.add(l2);
        
        l3 = new JLabel("ABINESH R");
        l3.setForeground(Color.BLACK);
        l3.setBackground(Color.CYAN);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        l3.setBounds(250,180,500,100);
        f.add(l3);
        
        l4 = new JLabel("KIRUBANAND R");
        l4.setForeground(Color.BLACK);
        l4.setBackground(Color.CYAN);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        l4.setBounds(250,220,500,100);
        f.add(l4);
        l5 = new JLabel("KIRUTHIK VISHAAL S");
        l5.setForeground(Color.BLACK);
        l5.setBackground(Color.CYAN);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        l5.setBounds(250,260,500,100);
        f.add(l5);
        l6 = new JLabel("SRI RAM RAJU M");
        l6.setForeground(Color.BLACK);
        l6.setBackground(Color.CYAN);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 22));
        l6.setBounds(250,300,500,100);
        f.add(l6);
        b = new JButton("PROCEED");
        b.setBounds(230,400,193,52);
        f.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
                new newclas();
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
public class NewClass{
    public static void main(String[] args)
    {
        new registration();
    }
}
