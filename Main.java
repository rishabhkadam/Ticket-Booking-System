import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.ImageView;

import java.sql.*;
import ConnectJDBC.ConnectJDBC;

class Choose {
    ConnectJDBC con = new ConnectJDBC();
    JFrame f;
    JButton b1, b2, b3;
    JCheckBox c;
    JLabel label;
    String userFName;
    String userLName;
    ImageIcon downIcon;
    ImageIcon upIcon;
    JLabel downButton;
    ImageIcon logoutIcon = new ImageIcon("logout.png");
    JLabel logoutButton = new JLabel(logoutIcon);
    JPopupMenu popupMenu;
    JPanel panel;

    ImageIcon img_travel;
    JLabel label_travel;

    Choose() {
        f = new JFrame("Book Ticket");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);

        img_travel = new ImageIcon("travel.jpg");
        label_travel = new JLabel(img_travel);
        label_travel.setBounds(300, 100, 450, 300);

        Border border = new LineBorder(Color.YELLOW, 2);
        Border borderBtn = new LineBorder(Color.BLACK, 2);

        upIcon = new ImageIcon("up.png");
        downIcon = new ImageIcon("down.png");
        downButton = new JLabel(downIcon);

        b1 = new JButton("Train Ticket");
        b2 = new JButton("Flight Ticket");
        b3 = new JButton("Bus Ticket");
        
        b1.setBorder(borderBtn);
        b2.setBorder(borderBtn);
        b3.setBorder(borderBtn);

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
        JLabel name = new JLabel("JourneyJunction");
        name.setFont(new Font("Calibri Bold",Font.ITALIC, 25));
        name.setForeground(Color.YELLOW);
        name.setBorder(border);
        
        
        label = new JLabel("");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Sans-Sarif", 0, 15));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setText("" + userFName + " " + userLName + "");
        label.setBorder(new EmptyBorder(0, 350, 0, 10));

        b1.setBounds(70, 150, 200, 40);
        b2.setBounds(70, 210, 200, 40);
        b3.setBounds(70, 270, 200, 40);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b3.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);

        popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Chnage Password");
        JMenuItem menuItem2 = new JMenuItem("Delete my Account");

        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangePassword();
                f.dispose();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] objects = { "Delete", "Cancel" };

                int choice = JOptionPane.showOptionDialog(f, "confirm", "Are you really want to delete your account?",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, objects, objects[1]);

                if (choice == JOptionPane.OK_OPTION) {

                    try {
                        PreparedStatement statement = con.connection
                                .prepareStatement("delete from registration_detail where email=?");
                        statement.setString(1, GetEmail.g_email);

                        statement.executeUpdate();
                        statement.close();
                        ConnectJDBC.connection.close();

                    } catch (Exception ee) {
                        // TODO: handle exception
                        ee.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(f, "Sucessful", "Password Changed!", JOptionPane.INFORMATION_MESSAGE);
                    f.dispose();
                    // new Login();
                }
            }
        });

        downButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
            }

            public void mouseEntered(MouseEvent e) {

                downButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                downButton.setIcon(upIcon);
                popupMenu.show(downButton, 0, downButton.getHeight());
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // downButton.setIcon(downIcon);
                
            }
            public void mouseReleased(MouseEvent e) {
                downButton.setIcon(downIcon);
                popupMenu.setVisible(false);
            }
        });

        logoutButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Object[] options = { "Logout", "Cancel" };
                int choice = JOptionPane.showOptionDialog(f, "Are you sure want to logout?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (choice == JOptionPane.YES_OPTION) {
                    f.dispose();
                    new Login();

                }
            }

            public void mouseEntered(MouseEvent e) {
                logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.setBounds(0, 0, 790, 50);
        panel.setBackground(Color.BLACK);
        panel.setBorder(new EmptyBorder(0, 0, 0, 10));
        // downButton.setBounds(780,5,10  ,10);
        downButton.setBorder(new EmptyBorder(0, 0, 0, 10));

        panel.add(name);
        panel.add(label);
        panel.add(downButton);
        panel.add(logoutButton);

        f.add(label_travel);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(panel);

        f.setVisible(true);

        b1.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                new TrainTicket();
                
            }

            public void mouseEntered(MouseEvent e) {
                b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
            }
            public void mouseReleased(MouseEvent e) {
                
            }
            
        });

        b2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Flight();
                
            }

            public void mouseEntered(MouseEvent e) {
                b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                b2.setBackground(Color.WHITE);
                b2.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.WHITE);
            }
            public void mouseReleased(MouseEvent e) {
                
            }
            
        });

        b3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new BusTicket();
            }

            public void mouseEntered(MouseEvent e) {
                b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                b3.setBackground(Color.WHITE);
                b3.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b3.setBackground(Color.BLACK);
                b3.setForeground(Color.WHITE);
                
            }
            public void mouseReleased(MouseEvent e) {
                
            }
            
        });

    }

}

class Main {
    public static void main(String[] s) {
        new Choose();
    }
}
