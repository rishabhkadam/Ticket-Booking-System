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

class BusList implements ActionListener {
    JFrame f;
    JLabel label;
    List b_List, p_List;
    JButton b_Button, c_Button;
    ConnectJDBC con = new ConnectJDBC();
    String userGetName;
    String userFName;
    String userLName;
    String totalFare;

    BusList() {
        f = new JFrame("Select Bus");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);

        label = new JLabel("SELECT BUS");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));

        b_List = new List(16);
        b_List.setFont(new Font("", Font.PLAIN, 15));

        String bus_list[] = { "Tata starbus", "Eicher", "Isuzu", "Mahindra Cruzio", "Ashok Leyland", "Volvo",
                "Marcedes-Benz"};

        for (int i = 0; i < bus_list.length; i++) {
            b_List.add(bus_list[i]);
        }

        p_List = new List(16);
        p_List.setFont(new Font("", Font.PLAIN, 15));

        String price_list[] = { "620", "741", "658", "784", "628", "755", "1500" };

        for (int i = 0; i < price_list.length; i++) {
            p_List.add(price_list[i]);
        }

        b_Button = new JButton("Book Now");
        c_Button = new JButton("Cancel");

        label.setBounds(0, 10, f.getWidth(), 50);
        b_List.setBounds(10, 100, 200, 200);
        p_List.setBounds(220, 100, 100, 200);
        f.getRootPane().setDefaultButton(b_Button);
        b_Button.setBounds(30, 350, 100, 30);
        c_Button.setBounds(150, 350, 100, 30);

        f.add(label);
        f.add(b_List);
        f.add(p_List);
        f.add(b_Button);
        f.add(c_Button);

        b_Button.addActionListener(this);
        c_Button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        int bus_price = Integer.parseInt(p_List.getItem(b_List.getSelectedIndex()));
        int price = bus_price * (Integer.parseInt(GetBusDetail.adult) + Integer.parseInt(GetBusDetail.child));
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

            String confirm = "Dept: " + GetBusDetail.dept + "\nDest: " + GetBusDetail.dest + "\n Date: "
                    + GetBusDetail.date + " \n Adult: " + GetBusDetail.adult + "\n Child: "
                    + GetBusDetail.child + "\n Total Fare: " + totalFare + "";
            int choice = JOptionPane.showConfirmDialog(f, confirm, "confirm", JOptionPane.OK_CANCEL_OPTION);

            int totalSeats = Integer.parseInt(GetBusDetail.adult) + Integer.parseInt(GetBusDetail.child);
            if (choice == JOptionPane.OK_OPTION) {

                try {
                    PreparedStatement statement = con.connection
                            .prepareStatement("INSERT INTO bus_booking_detail VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                    statement.setString(1, userGetName);
                    statement.setString(2, GetEmail.g_email);
                    statement.setString(3, GetBusDetail.dept);
                    statement.setString(4, GetBusDetail.dest);
                    statement.setString(5, GetBusDetail.date);
                    statement.setString(6, GetBusDetail.seat);
                    statement.setString(7, b_List.getSelectedItem());
                    statement.setString(8, String.valueOf(totalSeats));
                    statement.setString(9, totalFare);
                    statement.setString(10, GetBusDetail.child);
                    statement.setString(11, GetBusDetail.adult);

                    statement.executeUpdate();
                    statement.close();
                    ConnectJDBC.connection.close();

                    JOptionPane.showMessageDialog(f, "Tickets are booked.", "Book", JOptionPane.INFORMATION_MESSAGE);
                    f.dispose();
                    new Choose();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            // }
        }
        else if(e.getSource() == c_Button){
            f.dispose();
        }
    }
}

class SelectBus {
    public static void main(String[] args) {
        new BusList();
    }
}