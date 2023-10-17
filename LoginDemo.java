import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;

import ConnectJDBC.ConnectJDBC;

class Login {
    JFrame frame;
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2;

    Login() {

        frame = new JFrame("Login");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Font font = new Font("Courier", Font.ITALIC, 50);
        l1 = new JLabel("Email");
        l2 = new JLabel("Password");

        t1 = new JTextField();
        t2 = new JPasswordField();

        b1 = new JButton("Login");
        b2 = new JButton("Registration");

        l1.setBounds(70, 60, 100, 30);
        l2.setBounds(70, 100, 100, 30);

        t1.setBounds(400, 60, 150, 30);
        t2.setBounds(400, 100, 150, 30);

        b1.setBounds(250, 250, 100, 30);
        b2.setBounds(250, 300, 100, 30);

        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(t2);
        frame.add(b1);
        frame.add(b2);

        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ValidEmail = "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$";
                Pattern pattern = Pattern.compile(ValidEmail);

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

                    ConnectJDBC con = new ConnectJDBC();

                    String email = t1.getText();
                    String password = t2.getText();

                    String sql = "Select * from registration_detail where email='" + email + "' and password='"
                            + password + "'";

                    try {
                        Statement statement;
                        statement = con.connection.createStatement();
                        ResultSet rs = statement.executeQuery(sql);

                        if (rs.next()) {
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
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
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
