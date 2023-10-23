
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ConnectJDBC.ConnectJDBC;


class Sign {
    ConnectJDBC con = new ConnectJDBC();

    JFrame frame;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton submitButton;

    public boolean isUserExist(String Email){
    boolean userExist = false;

    String sql = "Select * from registration_detail where email = ?";

    try (PreparedStatement statement = con.connection.prepareStatement(sql)){
        statement.setString(1, Email);
        try(ResultSet rs = statement.executeQuery()){
            userExist = rs.next();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userExist;

    }

    public boolean isNumberExist(String Number){
    boolean numberExist = false;

    String sql = "Select * from registration_detail where mobile_no = ?";

    try (PreparedStatement statement = con.connection.prepareStatement(sql)){
        statement.setString(1, Number);
        try(ResultSet rs = statement.executeQuery()){
            numberExist = rs.next();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return numberExist;
}

    Sign() {

        frame = new JFrame("Sign Up");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel l1 = new JLabel("First Name*");
        JLabel l2 = new JLabel("Middle Name");
        JLabel l3 = new JLabel("Last Name*");
        JLabel l4 = new JLabel("Address*");
        JLabel l5 = new JLabel("Mobile Number*");
        JLabel l6 = new JLabel("E-Mail*");
        JLabel l7 = new JLabel("Password*");
        JLabel l8 = new JLabel("Confirm Password*");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JPasswordField();
        t8 = new JPasswordField();

        submitButton = new JButton("Submit");

        l1.setBounds(70, 60, 100, 30);
        l2.setBounds(70, 100, 100, 30);
        l3.setBounds(70, 140, 100, 30);
        l4.setBounds(70, 180, 100, 30);
        l5.setBounds(70, 220, 100, 30);
        l6.setBounds(70, 260, 100, 30);
        l7.setBounds(70, 300, 100, 30);
        l8.setBounds(70, 340, 150, 30);

        t1.setBounds(400, 60, 160, 30);
        t2.setBounds(400, 100, 160, 30);
        t3.setBounds(400, 140, 160, 30);
        t4.setBounds(400, 180, 160, 30);
        t5.setBounds(400, 220, 160, 30);
        t6.setBounds(400, 260, 160, 30);
        t7.setBounds(400, 300, 160, 30);
        t8.setBounds(400, 340, 160, 30);

        submitButton.setBounds(350, 400, 100, 30);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);

        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);
        frame.add(t8);
        frame.getRootPane().setDefaultButton(submitButton);
        frame.add(submitButton);

        
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

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

                else if (t5.getText().length() < 10 || t5.getText().length() > 10 || (!t5.getText().matches("[0-9]+"))) {
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

                else if(isNumberExist(getNumber)){
                    JOptionPane.showMessageDialog(frame, "Number is already Exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if(isUserExist(getEmail)){
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

                            PreparedStatement preparedStatement = con.connection.prepareStatement("INSERT INTO registration_detail VALUES(?,?,?,?,?,?,?)");
                            preparedStatement.setString(1, t1.getText());
                            preparedStatement.setString(2, t2.getText());
                            preparedStatement.setString(3, t3.getText());
                            preparedStatement.setString(4, t4.getText());
                            preparedStatement.setString(5, t5.getText());
                            preparedStatement.setString(6, t6.getText());
                            preparedStatement.setString(7, t7.getText());

                            preparedStatement.executeUpdate();
                            preparedStatement.close();
                            con.connection.close();

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

        frame.setVisible(true);
    }
    
}

public class SignUp {
    public static void main(String[] args) {

        new Sign();
    }
}
