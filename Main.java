// import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuListener;
class Choose implements ActionListener
{
JFrame f;
JButton b1,b2,b3;
JCheckBox c;

Choose()
{
f=new JFrame("Book Ticket");
f.setSize(500,300);
f.setLocationRelativeTo(null);
f.setLayout(null);

b1=new JButton("Movie Ticket");
b2=new JButton("Flight Ticket");
b3=new JButton("Bus Ticket");

b1.setBounds(200,100,100,30);
b2.setBounds(200,140,100,30);
b3.setBounds(200,180,100,30);

JMenu setMenu = new JMenu("Setting");
JMenuItem menuItem = new JMenuItem("Change Password");
setMenu.add(menuItem);
// menuItem.setActionCommand("Change Password");

// menuItem.addActionListener(this);
f.add(menuItem);

f.add(b1);
f.add(b2);
f.add(b3);


f.setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}


public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            new Book();
        }
        if(e.getSource() == b2){
            f.dispose();
            new Flight();
        }
        if(e.getSource() == b3){}
}
}
class Main
{
public static void main(String[] s)
{
Choose cc=new Choose();
}
}
