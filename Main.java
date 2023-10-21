import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import ConnectJDBC.ConnectJDBC;

class Choose implements ActionListener {
    JFrame f;
    JButton b1, b2, b3;
    JCheckBox c;
    JLabel label;
    ConnectJDBC con = new ConnectJDBC();
    String userFName;
    String userLName;
    ImageIcon downIcon = new ImageIcon("down.png");
    JLabel downButton = new JLabel(downIcon);

    ImageIcon logoutIcon = new ImageIcon("logout.png");
    JLabel logoutButton = new JLabel(logoutIcon);
    JPopupMenu popupMenu;
    JPanel panel;

    Choose() {
        f = new JFrame("Book Ticket");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);

        b1 = new JButton("Movie Ticket");
        b2 = new JButton("Flight Ticket");
        b3 = new JButton("Bus Ticket");

        String nameSQL = "SELECT * FROM registration_detail WHERE email = '" + GetEmail.g_email + "'";

        try {

            Statement statement = con.connection.createStatement();

            ResultSet rs = statement.executeQuery(nameSQL);

            while (rs.next()) {
                userFName = rs.getString("first_name");
                userLName = rs.getString("last_name");
            }
            statement.close();

        } catch (Exception ee) {
            System.out.println(ee);

        }

        label = new JLabel("");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Sans-Sarif", 0, 15));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setText("" + userFName + " " + userLName + "");
        label.setBorder(new EmptyBorder(0, 0, 0, 10));

        b1.setBounds(200, 100, 150, 30);
        b2.setBounds(200, 140, 150, 30);
        b3.setBounds(200, 180, 150, 30);

        // label.setBounds(150, 10, 250, 20);

        // downButton.setBounds(410, 10, 30, 25);
        // logoutButton.setBounds(750, 10, 50, 25);

        String item[] = { "Change Password", "Delete my Account" };

        popupMenu = new JPopupMenu();
        for (int i = 0; i < item.length; i++) {
            JMenuItem menuItem = new JMenuItem(item[i]);
            menuItem.addActionListener((ActionListener) new MenuItemListener());
            popupMenu.add(menuItem);

        }
        downButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(downButton, 0, downButton.getHeight());
            }
        });
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBounds(0, 0,790, 30);
        panel.setBackground(Color.BLACK);
        panel.setBorder(new EmptyBorder(0, 0, 0, 10));
        downButton.setBorder(new EmptyBorder(0, 0, 0, 10));

        
        panel.add(label);
        panel.add(downButton);
        panel.add(logoutButton);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(panel);
        // f.add(label);
        // f.add(downButton);

        f.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Book();
        }
        if (e.getSource() == b2) {
            f.dispose();
            new Flight();
        }
        if (e.getSource() == b3) {
        }
    }

}

class Main {
    public static void main(String[] s) {
        Choose cc = new Choose();
    }
}

class MenuItemListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Selected: " + e.getActionCommand());

    }

}