import java.util.*;
import javax.swing.*;
import java.util.Date;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

class Book {
    JFrame f;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b;
    JLabel l1, l2, l3, l4, l5, l6;
    int totalPrice = 0;

    Book() {
        f = new JFrame("Book Show");
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        Random random = new Random();

        LocalDate date = LocalDate.now();

        l1 = new JLabel("Theater Name");
        l2 = new JLabel("Screen");
        l3 = new JLabel("Select Date");
        l4 = new JLabel("Show Timing");
        l5 = new JLabel("Seat Type");
        l6 = new JLabel("Number Of Ticket");

        int screenNumber = random.nextInt(3) + 1;

        t1 = new JTextField("LAXMI CINEMA HOUSE");
        t1.setEditable(false);
        t2 = new JTextField("A" + String.valueOf(screenNumber));
        t2.setEditable(false);

        t3 = new JTextField(String.valueOf(date));

        String[] timeItem = { "Select timing", "09:00 AM - ₹190", "10:00 AM - ₹190", "11:00 AM - ₹200",
                "12:00 PM - ₹210", "01:00 PM - ₹220", "02:00 PM - ₹220", "04:00 PM - ₹230",
                "06:00 PM- ₹250", "07:00 PM- ₹290", "08:00 PM - ₹290", "09:00 PM - ₹290" };
        JComboBox timeBox = new JComboBox<>(timeItem);

        if (timeBox.getSelectedIndex() == 1) {
            totalPrice = totalPrice + 190;

        }
        if (timeBox.getSelectedIndex() == 2) {
            totalPrice = totalPrice + 190;
        }
        if (timeBox.getSelectedIndex() == 3) {
            totalPrice = totalPrice + 200;
        }
        if (timeBox.getSelectedIndex() == 4) {
            totalPrice = totalPrice + 210;
        }
        if (timeBox.getSelectedIndex() == 5) {
            totalPrice = totalPrice + 220;
        }
        if (timeBox.getSelectedIndex() == 6) {
            totalPrice = totalPrice + 220;
        }
        if (timeBox.getSelectedIndex() == 7) {
            totalPrice = totalPrice + 230;
        }
        if (timeBox.getSelectedIndex() == 8) {
            totalPrice = totalPrice + 250;
        }
        if (timeBox.getSelectedIndex() == 9) {
            totalPrice = totalPrice + 290;
        }
        if (timeBox.getSelectedIndex() == 10) {
            totalPrice = totalPrice + 290;
        }
        if (timeBox.getSelectedIndex() == 11) {
            totalPrice = totalPrice + 290;
        }

        String[] seatItem = { "Seat Type", "Silver", "Gold - +₹10", "Diamond - +₹50" };
        JComboBox seatBox = new JComboBox<>(seatItem);

        if (seatBox.getSelectedIndex() == 2) {
            totalPrice = totalPrice + 10;
        }
        if (seatBox.getSelectedIndex() == 3) {
            totalPrice = totalPrice + 50;
        }
        System.out.println(totalPrice);
        t6 = new JTextField();

        b = new JButton("Book");

        l1.setBounds(400, 60, 100, 30);
        l2.setBounds(400, 100, 100, 30);
        l3.setBounds(400, 140, 100, 30);
        l4.setBounds(400, 180, 100, 30);
        l5.setBounds(400, 220, 100, 30);
        l6.setBounds(400, 260, 100, 30);

        t1.setBounds(600, 60, 140, 30);
        t2.setBounds(600, 100, 140, 30);
        t3.setBounds(600, 140, 140, 30);
        timeBox.setBounds(600, 180, 140, 30);
        seatBox.setBounds(600, 220, 140, 30);
        t6.setBounds(600, 260, 140, 30);

        b.setBounds(350, 400, 100, 30);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);

        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(timeBox);
        f.add(seatBox);
        f.add(t6);

        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(totalPrice);

            }
        });

        f.setVisible(true);
    }
}

public class BookMovie {
    public static void main(String[] args) {

        new Book();
    }

}
