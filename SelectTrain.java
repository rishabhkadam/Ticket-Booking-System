import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import ConnectJDBC.ConnectJDBC;
import java.sql.*;

class TrainList implements ActionListener {
    JFrame f;
    JLabel label;
    List t_List, p_List;
    JButton b_Button, c_Button;
    ConnectJDBC con = new ConnectJDBC();
    String userGetName;
    String userFName;
    String userLName;
    String totalFare;

    TrainList() {
        f = new JFrame("Select Train");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);

        label = new JLabel("SELECT Train");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));

        t_List = new List(16);
        t_List.setFont(new Font("", Font.PLAIN, 15));

        String train_list[] = { "12301 - Rajdhani Express", "12002 - Shatabdi Express", "12213 - Duronto Express",
                "12049 - Gatimaan Express", "12503 - Humsafar", "12203 - Garib R€th Express",
                "22119 - Tejas Express" };

        for (int i = 0; i < train_list.length; i++) {
            t_List.add(train_list[i]);
        }

        p_List = new List(16);
        p_List.setFont(new Font("", Font.PLAIN, 15));

        String price_list[] = { "620", "741", "658", "450", "230", "410", "504" };

        for (int i = 0; i < price_list.length; i++) {
            p_List.add(price_list[i]);
        }

        b_Button = new JButton("Book Now");
        c_Button = new JButton("Cancel");

        label.setBounds(0, 10, f.getWidth(), 50);
        t_List.setBounds(10, 100, 200, 200);
        p_List.setBounds(220, 100, 100, 200);
        f.getRootPane().setDefaultButton(b_Button);
        b_Button.setBounds(30, 350, 100, 30);
        c_Button.setBounds(150, 350, 100, 30);

        f.add(label);
        f.add(t_List);
        f.add(p_List);
        f.add(b_Button);
        f.add(c_Button);

        b_Button.addActionListener(this);
        c_Button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        int train_price = Integer.parseInt(p_List.getItem(t_List.getSelectedIndex()));
        int price = train_price * (Integer.parseInt(GetTrainDetail.adult) + Integer.parseInt(GetTrainDetail.child));
        totalFare = String.valueOf(price);

        String nameSQL = "SELECT * FROM registration_detail WHERE email = '" + GetEmail.g_email + "'";

        try {

            Statement statement = ConnectJDBC.connection.createStatement();

            ResultSet rs = statement.executeQuery(nameSQL);

            while (rs.next()) {
                userFName = rs.getString("first_name");
                userLName = rs.getString("last_name");
            }
            statement.close();

        } catch (Exception ee) {
            System.out.println(ee);

        }
        userGetName = "" + userFName + " " + userLName + "";

        if (e.getSource() == b_Button) {

            String confirm = "Dept: " + GetTrainDetail.dept + "\nDest: " + GetTrainDetail.dest + "\n Date: "
                    + GetTrainDetail.date + " \n Adult: " + GetTrainDetail.adult + "\n Child: "
                    + GetTrainDetail.child + "\n Total Fare: " + totalFare + "";
            int choice = JOptionPane.showConfirmDialog(f, confirm, "confirm", JOptionPane.OK_CANCEL_OPTION);

            int totalSeats = Integer.parseInt(GetTrainDetail.adult) + Integer.parseInt(GetTrainDetail.child);

            GetTrainDetail.trainName = t_List.getSelectedItem();
            GetTrainDetail.fare = totalFare;

            if (choice == JOptionPane.OK_OPTION) {

                try {
                    PreparedStatement statement = con.connection
                            .prepareStatement("INSERT INTO train_booking_detail VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                    statement.setString(1, userGetName);
                    statement.setString(2, GetEmail.g_email);
                    statement.setString(3, GetTrainDetail.dept);
                    statement.setString(4, GetTrainDetail.dest);
                    statement.setString(5, GetTrainDetail.date);
                    statement.setString(6, GetTrainDetail.seat);
                    statement.setString(7, t_List.getSelectedItem());
                    statement.setString(8, String.valueOf(totalSeats));
                    statement.setString(9, GetTrainDetail.adult);
                    statement.setString(10, GetTrainDetail.child);
                    statement.setString(11, totalFare);

                    statement.executeUpdate();
                    statement.close();
                    ConnectJDBC.connection.close();

                     Object[] options = { "Generate Bill" };
                    
                    int Choice = JOptionPane.showOptionDialog(f, "Tickets are booked.", "Book",
                            JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    
                    if (Choice == JOptionPane.OK_OPTION) {
                            new TrainBilll();
                    }
                    f.dispose();
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }

        } else if (e.getSource() == c_Button) {
            f.dispose();
        }
    }
}

class SelectTrain {
    public static void main(String[] args) {
        new TrainList();
    }
}