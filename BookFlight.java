import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ConnectJDBC.ConnectJDBC;
import java.time.LocalDate;

class Flight implements ActionListener {
    JFrame f;
    JLabel l3, l4, l5, l6,swapL,label,imgL;
    JTextField t3, t4, t5, t6;
    JButton b1, b2;
    ImageIcon img, swapIcon;
    ConnectJDBC con = new ConnectJDBC();
    JComboBox<String> comboBox1, comboBox2;

    Flight() {
        f = new JFrame("Book Your Flight");
        f.setSize(800, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.WHITE);

        label = new JLabel("Flight Ticket");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        label.setBounds(0, 0, f.getWidth(), 50);

        img = new ImageIcon("aeroplane.jpg");
        imgL = new JLabel(img);
        imgL.setBounds(370, 20, 450, 416);

        swapIcon = new ImageIcon("swap.png");
        swapL = new JLabel(swapIcon);
        swapL.setBounds(210, 90, 50, 50);

        Border border = new LineBorder(Color.BLACK, 2);

        l3 = new JLabel("Departure Date      :");
        l4 = new JLabel("Adult       :");
        l5 = new JLabel("Children       :");

        LocalDate date = LocalDate.now();
        t3 = new JTextField(String.valueOf(date));
        t4 = new JTextField();
        t5 = new JTextField();

        t3.setBorder(border);
        t4.setBorder(border);
        t5.setBorder(border);

        t3.setFont(new Font("Sans-Sarif", Font.BOLD, 13));
        t4.setFont(new Font("Sans-Sarif", Font.BOLD, 13));
        t5.setFont(new Font("Sans-Sarif", Font.BOLD, 13));

        b1 = new JButton("Search");
        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        l3.setBounds(70, 150, 180, 25);
        l4.setBounds(150, 200, 100, 20);
        l5.setBounds(120, 250, 100, 20);

        l3.setFont(new Font("Sans-Sarif", Font.BOLD, 18));
        l4.setFont(new Font("Sans-Sarif", Font.BOLD, 18));
        l5.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        t3.setBounds(270, 150, 150, 30);
        t4.setBounds(270, 200, 150, 30);
        t5.setBounds(270, 250, 150, 30);

        b1.setBounds(120, 300, 100, 30);
        b2.setBounds(250, 300, 100, 30);

        String[] airports = {
                "From",
                "Agartala (IXA)",
                "Agra (AGR)",
                "Ahmedabad (AMD)",
                "Aizawl (AJL)",
                "Amritsar (ATQ)",
                "Aurangabad (IXU)",
                "Bagdogra (IXB)",
                "Bareilly (BEK)",
                "Belagavi (IXG)",
                "Bengaluru (BLR)",
                "Bhopal (BHO)",
                "Bhubaneswar (BBI)",
                "Chandigarh (IXC)",
                "Chennai (MAA)",
                "Coimbatore (CJB)",
                "Darbhanga (DBR)",
                "Dehradun (DED)",
                "Delhi (DEL)",
                "Deoghar (DGH)",
                "Dibrugarh (DIB)",
                "Dimapur (DMU)",
                "Durgapur (RDP)",
                "Gaya (GAY)",
                "Goa (GOI)",
                "Gorakhpur (GOP)",
                "Guwahati (GAU)",
                "Gwalior (GWL)",
                "Hubli (HBX)",
                "Hyderabad (HYD)",
                "Imphal (IMF)",
                "Indore (IDR)",
                "Itanagar (HGI)",
                "Jabalpur (JLR)",
                "Jaipur (JAI)",
                "Jammu (IXJ)",
                "Jodhpur (JDH)",
                "Jorhat (JRH)",
                "Kadapa (CDP)",
                "Kannur (CNN)",
                "Kanpur (KNU)",
                "Kochi (COK)",
                "Kolhapur (KLH)",
                "Kolkata (CCU)",
                "Kozhikode (CCJ)",
                "Kurnool (KJB)",
                "Leh (IXL)",
                "Lucknow (LKO)",
                "Madurai (IXM)",
                "Mangaluru (IXE)",
                "Mumbai (BOM)",
                "Mysuru (MYQ)",
                "Nagpur (NAG)",
                "North Goa (GOX)",
                "Pantnagar (PGH)",
                "Patna (PAT)",
                "Port-Blair (IXZ)",
                "Prayagraj (IXD)",
                "Pune (PNQ)",
                "Raipur (RPR)",
                "Rajahmundry (RJA)",
                "Rajkot (RAJ)",
                "Ranchi (IXR)",
                "Shillong (SHL)",
                "Shirdi (SAG)",
                "Silchar (IXS)",
                "Srinagar (SXR)",
                "Surat (STV)",
                "Thiruvananthapuram (TRV)",
                "Tiruchirappalli (TRZ)",
                "Tirupati (TIR)",
                "Tuticorin (TCR)",
                "Udaipur (UDR)",
                "Vadodara (BDQ)",
                "Varanasi (VNS)",
                "Vijayawada (VGA)",
                "Visakhapatnam (VTZ)"
        };

        String[] airports1 = {
                "To",
                "Agartala (IXA)",
                "Agra (AGR)",
                "Ahmedabad (AMD)",
                "Aizawl (AJL)",
                "Amritsar (ATQ)",
                "Aurangabad (IXU)",
                "Bagdogra (IXB)",
                "Bareilly (BEK)",
                "Belagavi (IXG)",
                "Bengaluru (BLR)",
                "Bhopal (BHO)",
                "Bhubaneswar (BBI)",
                "Chandigarh (IXC)",
                "Chennai (MAA)",
                "Coimbatore (CJB)",
                "Darbhanga (DBR)",
                "Dehradun (DED)",
                "Delhi (DEL)",
                "Deoghar (DGH)",
                "Dibrugarh (DIB)",
                "Dimapur (DMU)",
                "Durgapur (RDP)",
                "Gaya (GAY)",
                "Goa (GOI)",
                "Gorakhpur (GOP)",
                "Guwahati (GAU)",
                "Gwalior (GWL)",
                "Hubli (HBX)",
                "Hyderabad (HYD)",
                "Imphal (IMF)",
                "Indore (IDR)",
                "Itanagar (HGI)",
                "Jabalpur (JLR)",
                "Jaipur (JAI)",
                "Jammu (IXJ)",
                "Jodhpur (JDH)",
                "Jorhat (JRH)",
                "Kadapa (CDP)",
                "Kannur (CNN)",
                "Kanpur (KNU)",
                "Kochi (COK)",
                "Kolhapur (KLH)",
                "Kolkata (CCU)",
                "Kozhikode (CCJ)",
                "Kurnool (KJB)",
                "Leh (IXL)",
                "Lucknow (LKO)",
                "Madurai (IXM)",
                "Mangaluru (IXE)",
                "Mumbai (BOM)",
                "Mysuru (MYQ)",
                "Nagpur (NAG)",
                "North Goa (GOX)",
                "Pantnagar (PGH)",
                "Patna (PAT)",
                "Port-Blair (IXZ)",
                "Prayagraj (IXD)",
                "Pune (PNQ)",
                "Raipur (RPR)",
                "Rajahmundry (RJA)",
                "Rajkot (RAJ)",
                "Ranchi (IXR)",
                "Shillong (SHL)",
                "Shirdi (SAG)",
                "Silchar (IXS)",
                "Srinagar (SXR)",
                "Surat (STV)",
                "Thiruvananthapuram (TRV)",
                "Tiruchirappalli (TRZ)",
                "Tirupati (TIR)",
                "Tuticorin (TCR)",
                "Udaipur (UDR)",
                "Vadodara (BDQ)",
                "Varanasi (VNS)",
                "Vijayawada (VGA)",
                "Visakhapatnam (VTZ)"
        };

        DefaultComboBoxModel<String> cityComboBoxModel = new DefaultComboBoxModel<>(airports);
        comboBox1 = new JComboBox<>(cityComboBoxModel);
        comboBox1.setBounds(50, 100, 150, 30);
        comboBox1.setBorder(border);
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setForeground(Color.BLACK);

        DefaultComboBoxModel<String> cityComboBoxModel2 = new DefaultComboBoxModel<>(airports1);
        comboBox2 = new JComboBox<>(cityComboBoxModel2);
        comboBox2.setBounds(270, 100, 150, 30);
        comboBox2.setBorder(border);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setForeground(Color.BLACK);

        f.add(label);
        f.add(imgL);
        f.add(l3);
        f.add(l4);
        f.add(l5);

        f.add(comboBox1);
        f.add(comboBox2);
        f.add(swapL);
        f.add(t3);
        f.add(t4);
        f.add(t5);

        f.getRootPane().setDefaultButton(b1);
        f.add(b1);
        f.add(b2);

        f.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            if (t3.getText().isEmpty() || t4.getText().isEmpty()
                    || t5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(f, "All Fields are Mandatory!", "Error!",
                        JOptionPane.WARNING_MESSAGE);  
            }

            else if ((comboBox1.getSelectedIndex() == 0) || (comboBox2.getSelectedIndex() == 0)) {
                JOptionPane.showMessageDialog(f, "Please select place", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else if (comboBox1.getSelectedItem() == comboBox2.getSelectedItem()) {
                JOptionPane.showMessageDialog(f, "Both Places are same. Please select different.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if ((!t4.getText().matches("[0-9]+")) ||
                    (!t5.getText().matches("[0-9]+"))) {
                JOptionPane.showMessageDialog(f, "Please enter valid Detail", "error!",
                        JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                GetFlightDetail.dept = (String) comboBox1.getSelectedItem();
                GetFlightDetail.dest = (String) comboBox2.getSelectedItem();
                GetFlightDetail.date = t3.getText();
                GetFlightDetail.adult = t4.getText();
                GetFlightDetail.child = t5.getText();

                new FlightList();
            }

        }
        if (e.getSource() == b2) {
            f.dispose();
            
        }
    }
}

class BookFlight {
    public static void main(String[] s) {
        new Flight();
    }
}