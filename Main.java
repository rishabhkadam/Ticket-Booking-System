import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class Choose implements ActionListener
{
JFrame f;
JButton b1,b2,b3;
JCheckBox c;
Choice ch;

Choose()
{
f=new JFrame("Book Ticket");
f.setSize(500,300);
f.setLocationRelativeTo(null);
f.setLayout(null);

b1=new JButton("Movie Ticket");
b2=new JButton("Flight Ticket");
b3=new JButton("Bus Ticket");

c=new JCheckBox("Setting");

ch=new Choice();

b1.setBounds(200,100,100,30);
b2.setBounds(200,140,100,30);
b3.setBounds(200,180,100,30);

c.setBounds(400,10,100,30);

ch.setBounds(380,50,100,30);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(c);
f.add(ch);

ch.add("Change Password");
ch.add("Delete Account");
ch.add("Logout");

f.setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}


public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){}
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
