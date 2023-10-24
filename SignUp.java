
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ConnectJDBC.ConnectJDBC;

class Sign {

    JFrame frame;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton submitButton;
    ConnectJDBC con = new ConnectJDBC();

    public boolean isUserExist(String Email) {
        boolean userExist = false;

        String sql = "Select * from registration_detail where email = ?";

        try (PreparedStatement statement = ConnectJDBC.connection.prepareStatement(sql)) {
            statement.setString(1, Email);
            try (ResultSet rs = statement.executeQuery()) {
                userExist = rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExist;

    }

    public boolean isNumberExist(String Number) {
        boolean numberExist = false;

        String sql = "Select * from registration_detail where mobile_no = ?";

        try (PreparedStatement statement = ConnectJDBC.connection.prepareStatement(sql)) {
            statement.setString(1, Number);
            try (ResultSet rs = statement.executeQuery()) {
                numberExist = rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberExist;
    }

    Sign() {

        frame = new JFrame("Sign Up");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);

        Font font = new Font("Sans-Sarif", Font.BOLD, 17);
        Border border = new LineBorder(Color.BLACK, 2);

        JLabel l1 = new JLabel("First Name*");
        JLabel l2 = new JLabel("Middle Name");
        JLabel l3 = new JLabel("Last Name*");
        JLabel l4 = new JLabel("Address*");
        JLabel l5 = new JLabel("Mobile Number*");
        JLabel l6 = new JLabel("E-Mail*");
        JLabel l7 = new JLabel("Password*");
        JLabel l8 = new JLabel("Confirm Password*");
        JLabel l9 = new JLabel("' * ' fields are mandatory");
        JLabel sign_up = new JLabel("SIGN UP");
        JLabel cancel = new JLabel("Cancel");

        sign_up.setFont(new Font("", Font.BOLD, 30));
        sign_up.setBackground(Color.BLACK);
        sign_up.setOpaque(true);
        sign_up.setForeground(Color.WHITE);
        sign_up.setBounds(0, 0, 800, 50);
        sign_up.setBorder(new EmptyBorder(0, 10, 0, 0));

        l9.setFont(new Font("", Font.ITALIC, 12));
        l9.setForeground(Color.RED);
        l9.setBounds(250, 50, 200, 20);

        cancel.setForeground(Color.BLACK);

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);
        l8.setFont(font);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JPasswordField();
        t8 = new JPasswordField();

        t1.setBorder(border);
        t2.setBorder(border);
        t3.setBorder(border);
        t4.setBorder(border);
        t5.setBorder(border);
        t6.setBorder(border);
        t7.setBorder(border);
        t8.setBorder(border);

        submitButton = new JButton("Submit");

        l1.setBounds(70, 80, 200, 30);
        l2.setBounds(70, 120, 200, 30);
        l3.setBounds(70, 160, 200, 30);
        l4.setBounds(70, 200, 200, 30);
        l5.setBounds(70, 240, 200, 30);
        l6.setBounds(70, 280, 200, 30);
        l7.setBounds(70, 320, 200, 30);
        l8.setBounds(70, 360, 200, 30);
        cancel.setBounds(370, 435, 40, 15);

        t1.setBounds(250, 80, 160, 30);
        t2.setBounds(250, 120, 160, 30);
        t3.setBounds(250, 160, 160, 30);
        t4.setBounds(250, 200, 160, 30);
        t5.setBounds(250, 240, 160, 30);
        t6.setBounds(250, 280, 160, 30);
        t7.setBounds(250, 320, 160, 30);
        t8.setBounds(250, 360, 160, 30);

        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(border);
        submitButton.setBounds(250, 400, 160, 30);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);

        frame.add(sign_up);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);
        frame.add(t8);
        frame.add(l9);
        frame.getRootPane().setDefaultButton(submitButton);
        frame.add(submitButton);
        frame.add(cancel);  

        submitButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            public void mouseExited(MouseEvent e) {
                submitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                
                String ValidEmail = "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$";

                Pattern pattern = Pattern.compile(ValidEmail);

                String getNumber = t5.getText();
                String getEmail = t6.getText();

                if (t1.getText().isEmpty() || t3.getText().isEmpty() ||
                        t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty() ||
                        t7.getText().isEmpty() || t8.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(frame, "All Fields are Mandatory!", "Error!",
                            JOptionPane.WARNING_MESSAGE);
                }

                else if (t5.getText().length() < 10 || t5.getText().length() > 10
                        || (!t5.getText().matches("[0-9]+"))) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid number!", "Mobile number error!",
                            JOptionPane.WARNING_MESSAGE);
                }

                else if (!pattern.matcher(t6.getText()).matches()) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid Email!", "Email Error",
                            JOptionPane.WARNING_MESSAGE);
                }

                else if (t7.getText().length() < 8) {
                    JOptionPane.showMessageDialog(frame, "Password length should be 8 character.",
                            "Password", JOptionPane.WARNING_MESSAGE);
                }

                else if (!t7.getText().matches(t8.getText())) {
                    JOptionPane.showMessageDialog(frame, "Password doesn't match!", "password",
                            JOptionPane.WARNING_MESSAGE);
                }

                else if (isNumberExist(getNumber)) {
                    JOptionPane.showMessageDialog(frame, "Number is already Exist!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                else if (isUserExist(getEmail)) {
                    JOptionPane.showMessageDialog(frame, "Email is already Exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else {

                    String confirmDetail = "\nFirst name : '" + t1.getText() + "'\n Middle name : " + t2.getText()
                            + " \n Last name : " + t3.getText() + "\n Address : " + t4.getText() + "\n Mobile no.: "
                            + t5.getText() + "\n Email : " + t6.getText() + "\n Password : " + t7.getText() + "\n ";

                    int choice = JOptionPane.showConfirmDialog(frame, confirmDetail, "Confirmation",
                            JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {

                        try {

                            PreparedStatement preparedStatement = con.connection
                                    .prepareStatement("INSERT INTO registration_detail VALUES(?,?,?,?,?,?,?)");
                            preparedStatement.setString(1, t1.getText());
                            preparedStatement.setString(2, t2.getText());
                            preparedStatement.setString(3, t3.getText());
                            preparedStatement.setString(4, t4.getText());
                            preparedStatement.setString(5, t5.getText());
                            preparedStatement.setString(6, t6.getText());
                            preparedStatement.setString(7, t7.getText());

                            preparedStatement.executeUpdate();
                            preparedStatement.close();
                            ConnectJDBC.connection.close();

                        } catch (SQLException ae) {

                            ae.printStackTrace();
                        }

                        // con.QueryUpdate(inputerQuery);
                        JOptionPane.showMessageDialog(frame, "You are registered successfully!\nLog in now!",
                                "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        new Login();

                    }

                }
            }
        });

        // submitButton.addActionListener(new ActionListener() {

        //     public void actionPerformed(ActionEvent e) {

        //         String ValidEmail = "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$";

        //         Pattern pattern = Pattern.compile(ValidEmail);

        //         String getNumber = t5.getText();
        //         String getEmail = t6.getText();

        //         if (t1.getText().isEmpty() || t3.getText().isEmpty() ||
        //                 t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty() ||
        //                 t7.getText().isEmpty() || t8.getText().isEmpty()) {

        //             JOptionPane.showMessageDialog(frame, "All Fields are Mandatory!", "Error!",
        //                     JOptionPane.WARNING_MESSAGE);
        //         }

        //         else if (t5.getText().length() < 10 || t5.getText().length() > 10
        //                 || (!t5.getText().matches("[0-9]+"))) {
        //             JOptionPane.showMessageDialog(frame, "Please enter valid number!", "Mobile number error!",
        //                     JOptionPane.WARNING_MESSAGE);
        //         }

        //         else if (!pattern.matcher(t6.getText()).matches()) {
        //             JOptionPane.showMessageDialog(frame, "Please enter valid Email!", "Email Error",
        //                     JOptionPane.WARNING_MESSAGE);
        //         }

        //         else if (t7.getText().length() < 8) {
        //             JOptionPane.showMessageDialog(frame, "Password length should be 8 character.",
        //                     "Password", JOptionPane.WARNING_MESSAGE);
        //         }

        //         else if (!t7.getText().matches(t8.getText())) {
        //             JOptionPane.showMessageDialog(frame, "Password doesn't match!", "password",
        //                     JOptionPane.WARNING_MESSAGE);
        //         }

        //         else if (isNumberExist(getNumber)) {
        //             JOptionPane.showMessageDialog(frame, "Number is already Exist!", "Error",
        //                     JOptionPane.ERROR_MESSAGE);
        //         }

        //         else if (isUserExist(getEmail)) {
        //             JOptionPane.showMessageDialog(frame, "Email is already Exist!", "Error", JOptionPane.ERROR_MESSAGE);
        //         }

        //         else {

        //             String confirmDetail = "\nFirst name : '" + t1.getText() + "'\n Middle name : " + t2.getText()
        //                     + " \n Last name : " + t3.getText() + "\n Address : " + t4.getText() + "\n Mobile no.: "
        //                     + t5.getText() + "\n Email : " + t6.getText() + "\n Password : " + t7.getText() + "\n ";

        //             int choice = JOptionPane.showConfirmDialog(frame, confirmDetail, "Confirmation",
        //                     JOptionPane.YES_NO_OPTION);

        //             if (choice == JOptionPane.YES_OPTION) {

        //                 try {

        //                     PreparedStatement preparedStatement = con.connection
        //                             .prepareStatement("INSERT INTO registration_detail VALUES(?,?,?,?,?,?,?)");
        //                     preparedStatement.setString(1, t1.getText());
        //                     preparedStatement.setString(2, t2.getText());
        //                     preparedStatement.setString(3, t3.getText());
        //                     preparedStatement.setString(4, t4.getText());
        //                     preparedStatement.setString(5, t5.getText());
        //                     preparedStatement.setString(6, t6.getText());
        //                     preparedStatement.setString(7, t7.getText());

        //                     preparedStatement.executeUpdate();
        //                     preparedStatement.close();
        //                     ConnectJDBC.connection.close();

        //                 } catch (SQLException ae) {

        //                     ae.printStackTrace();
        //                 }

        //                 // con.QueryUpdate(inputerQuery);
        //                 JOptionPane.showMessageDialog(frame, "You are registered successfully!\nLog in now!",
        //                         "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
        //                 frame.dispose();
        //                 new Login();

        //             }

        //         }

        //     }

        cancel.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                cancel.setForeground(Color.BLUE);
                cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                cancel.setForeground(Color.BLACK);
                cancel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Login();
            }
        });

    }

}

public class SignUp {
    public static void main(String[] args) {

        new Sign();
    }
}
