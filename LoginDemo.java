
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.regex.Pattern;

import ConnectJDBC.ConnectJDBC;

class Login {
    JFrame frame;
    JTextField t1;
    JTextField t2;
    JButton b1;
    JLabel b2;
    JLabel l1, l2;
    JLabel back;
    ImageIcon img;
    ConnectJDBC con = new ConnectJDBC();

    Login() {

        frame = new JFrame("Login");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);


        img = new ImageIcon("login.png");
        back = new JLabel(img);

        l1 = new JLabel("Email");
        l2 = new JLabel("Password");

        t1 = new JTextField();
        t2 = new JPasswordField();

        Border border = new LineBorder(Color.BLACK, 2);

        b1 = new JButton("Login");
        b1.setBorder(border);
        b2 = new JLabel("Registration");
        b2.setFont(new Font("", 0, 12));

        Font font = new Font("Sans-Sarif", Font.BOLD, 17);

        l1.setBounds(70, 100, 100, 30);
        l2.setBounds(70, 160, 100, 30);

        l1.setFont(font);
        l2.setFont(font);

        t1.setBorder(border);
        t2.setBorder(border);
        t1.setFont(new Font("", Font.BOLD, 15));
        t2.setFont(new Font("", Font.BOLD, 15));
        
        t1.setBounds(70, 132, 200, 30);
        t2.setBounds(70, 192, 200, 30);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b1.setBounds(70, 240, 200, 30);
        b2.setBounds(70, 270, 80, 30);

        back.setBounds(350, 5, 450, 450);

        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(t2);
        frame.add(back);
        frame.getRootPane().setDefaultButton(b1);
        frame.add(b1);
        frame.add(b2);
        frame.setVisible(true);
        b1.addMouseListener(new MouseListener() {

            String ValidEmail = "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$";
            Pattern pattern = Pattern.compile(ValidEmail);

            @Override
            public void mouseClicked(MouseEvent e) {

                if (t1.getText().isEmpty() || t2.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(frame, "All Fields are Mandatory!", "Error!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (!pattern.matcher(t1.getText()).matches()) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid Email!", "Error",
                            JOptionPane.WARNING_MESSAGE);

                } else if (t2.getText().length() < 8) {
                    JOptionPane.showMessageDialog(frame, "Password length should be 8 character.", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }

                else {

                    String email = t1.getText();
                    String password = t2.getText();

                    String sql = "Select * from registration_detail where email='" + email + "' and password='"
                            + password + "'";

                    try {
                        Statement statement;
                        statement = con.connection.createStatement();
                        ResultSet rs = statement.executeQuery(sql);

                        if (rs.next()) {
                            GetEmail.g_email = t1.getText();
                            frame.dispose();
                            new Choose();


                        } else {
                            JOptionPane.showMessageDialog(frame, "Email or password is wrong!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            t1.setText("");
                            t2.setText("");
                        }

                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                b1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

        });

        b2.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                b2.setForeground(Color.BLUE);
                b2.setFont(new Font("", Font.BOLD, 13));
                b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                b2.setForeground(Color.BLACK);
                b2.setFont(new Font("", 0, 12));
                b2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Sign();
            }

        });

    }

}

public class LoginDemo {
    public static void main(String[] args) {
        new Login();
    }
}