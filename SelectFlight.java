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

class FlightList implements ActionListener {
    JFrame f;
    JLabel label;
    public List f_List, p_List;
    JButton b_Button, c_Button;
    ConnectJDBC con = new ConnectJDBC();
    public String userGetName;
    String userFName;
    String userLName;
    public String totalFare;

    FlightList() {
        f = new JFrame("Select Flight");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);

        // BILL GERERATE FRAME
        // ******************************
        // billFrame = new JFrame();
        // billFrame.setSize(800, 500);
        // billFrame.setLayout(null);
        // billFrame.setLocationRelativeTo(null);
        // billFrame.getContentPane().setBackground(Color.WHITE);

        // ******************************

        label = new JLabel("SELECT FLIGHT");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));

        f_List = new List(16);
        f_List.setFont(new Font("", Font.PLAIN, 15));

        String flit_list[] = { "Air Asia", "Air Carnival", "Air costa", "Air india", "Indigo", "Air India Express",
                "Jet Airways", "Vistara Airlines", "Jet Konnect" };

        for (int i = 0; i < flit_list.length; i++) {
            f_List.add(flit_list[i]);
        }

        p_List = new List(16);
        p_List.setFont(new Font("", Font.PLAIN, 15));

        String price_list[] = { "6925", "7041", "6758", "7584", "7151", "7355", "7000", "7288", "7800" };

        for (int i = 0; i < price_list.length; i++) {
            p_List.add(price_list[i]);
        }

        b_Button = new JButton("Book Now");
        c_Button = new JButton("Cancel");

        label.setBounds(0, 10, f.getWidth(), 50);
        f_List.setBounds(10, 100, 200, 200);
        p_List.setBounds(220, 100, 100, 200);
        f.getRootPane().setDefaultButton(b_Button);
        b_Button.setBounds(30, 350, 100, 30);
        c_Button.setBounds(150, 350, 100, 30);

        f.add(label);
        f.add(f_List);
        f.add(p_List);
        f.add(b_Button);
        f.add(c_Button);

        b_Button.addActionListener(this);
        c_Button.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {

        int flight_price = Integer.parseInt(p_List.getItem(f_List.getSelectedIndex()));
        int price = flight_price * (Integer.parseInt(GetFlightDetail.adult) + Integer.parseInt(GetFlightDetail.child));
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

            String confirm = "Dept: " + GetFlightDetail.dept + "\nDest: " + GetFlightDetail.dest + "\n Date: "
                    + GetFlightDetail.date + " \n Adult: " + GetFlightDetail.adult + "\n Child: "
                    + GetFlightDetail.child + "\n Total Fare: " + totalFare + "";
            int choice = JOptionPane.showConfirmDialog(f, confirm, "confirm", JOptionPane.OK_CANCEL_OPTION);

            if (choice == JOptionPane.OK_OPTION) {

                try {
                    PreparedStatement statement = con.connection
                            .prepareStatement("INSERT INTO flight_booking_detail VALUES(?,?,?,?,?,?,?,?,?)");
                    statement.setString(1, userGetName);
                    statement.setString(2, GetEmail.g_email);
                    statement.setString(3, GetFlightDetail.dept);
                    statement.setString(4, GetFlightDetail.dest);
                    statement.setString(5, GetFlightDetail.date);
                    statement.setString(6, GetFlightDetail.adult);
                    statement.setString(7, GetFlightDetail.child);
                    statement.setString(8, f_List.getSelectedItem());
                    statement.setString(9, totalFare);

                    statement.executeUpdate();
                    statement.close();
                    ConnectJDBC.connection.close();

                    Object[] options = { "Generate Bill" };
                    
                    int Choice = JOptionPane.showOptionDialog(f, "Tickets are booked.", "Book",
                            JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);


                    GetFlightDetail.flightName = f_List.getSelectedItem();
                    GetFlightDetail.fare = totalFare;
                    GetEmail.name = userGetName;

                    if (Choice == JOptionPane.OK_OPTION) {
                            new FlightBilll();
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

class SelectFlight {
    public static void main(String[] args) {
        new FlightList();
    }
}