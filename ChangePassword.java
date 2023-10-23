import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import ConnectJDBC.ConnectJDBC;

public class ChangePassword implements ActionListener {
    JFrame f;
    JLabel pass, c_pass;
    JPasswordField t_pass, t_c_pass;
    JButton confirmButton, cancelButton;
    ConnectJDBC con = new ConnectJDBC();

    ChangePassword() {
        f = new JFrame("Book Ticket");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);

        pass = new JLabel("New Password");
        c_pass = new JLabel("Confirm Password");

        t_pass = new JPasswordField();
        t_c_pass = new JPasswordField();

        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("cancel");

        pass.setBounds(20, 50, 100, 30);
        c_pass.setBounds(20, 100, 100, 30);
        t_pass.setBounds(150, 50, 100, 30);
        t_c_pass.setBounds(150, 100, 100, 30);
        confirmButton.setBounds(50, 150, 100, 30);
        cancelButton.setBounds(180, 150, 100, 30);

        f.add(pass);
        f.add(c_pass);
        f.add(t_pass);
        f.add(t_c_pass);
        f.getRootPane().setDefaultButton(confirmButton);
        f.add(confirmButton);
        f.add(cancelButton);

        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirmButton) {
            String pass = new String(t_pass.getPassword());

            if (pass.isEmpty() || new String(t_c_pass.getPassword()).isEmpty()) {

                JOptionPane.showMessageDialog(f, "All Fields are Mandatory!", "Error!",
                        JOptionPane.WARNING_MESSAGE);

            } else if (pass.length() < 8) {
                JOptionPane.showMessageDialog(f, "Password length should be 8 character.", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!pass.matches(new String(t_c_pass.getPassword()))) {
                JOptionPane.showMessageDialog(f, "Password doesn't match!", "password",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {
                try {
                    PreparedStatement statement = con.connection
                            .prepareStatement("update registration_detail set password=? where email=?");
                    statement.setString(1, pass);
                    statement.setString(2, GetEmail.g_email);

                    statement.executeUpdate();
                    statement.close();
                    con.connection.close();

                } catch (Exception ee) {
                    // TODO: handle exception
                    ee.printStackTrace();
                }

                JOptionPane.showMessageDialog(f, "Sucessful", "Password Changed!", JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                System.exit(0);
                
            }
            new Login();
        }

        else if (e.getSource() == cancelButton) {
            f.dispose();
        }
    }
}
