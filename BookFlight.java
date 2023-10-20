import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ConnectJDBC.ConnectJDBC;

import javax.swing.*;

class Flight implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    ConnectJDBC con = new ConnectJDBC();

    Flight() {
        f = new JFrame("Book Your Flight");
        f.setSize(500, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        l1 = new JLabel("From");
        l2 = new JLabel("To");
        l3 = new JLabel("Departure Date");
        l4 = new JLabel("Adult");
        l5 = new JLabel("Children");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();

        b1 = new JButton("Search");
        b2 = new JButton("Cancel");

        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 100, 100, 20);
        l3.setBounds(50, 150, 180, 20);
        l4.setBounds(50, 200, 100, 20);
        l5.setBounds(50, 250, 100, 20);

        t1.setBounds(300, 50, 150, 30);
        t2.setBounds(300, 100, 150, 30);
        t3.setBounds(300, 150, 150, 30);
        t4.setBounds(300, 200, 150, 30);
        t5.setBounds(300, 250, 150, 30);

        b1.setBounds(100, 400, 150, 40);
        b2.setBounds(300, 400, 150, 40);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);

        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);

        f.add(b1);
        f.add(b2);

        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l2.setFont(new Font("Arial", Font.BOLD, 24));
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        l5.setFont(new Font("Arial", Font.BOLD, 24));

        b1.setFont(new Font("Dialog", Font.BOLD, 30));
        b2.setFont(new Font("Dialog", Font.BOLD, 30));

        t1.setFont(new Font("Arial", Font.BOLD, 30));
        f.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1){}
        if(e.getSource() == b2){
            f.dispose();
            new Choose();
        }

    }
}

class BookFlight {
    public static void main(String[] s) {
        new Flight();
    }
}