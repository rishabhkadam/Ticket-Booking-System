import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ConnectJDBC.ConnectJDBC;


class Flight implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t3, t4, t5, t6;
    JButton b1, b2;
    ConnectJDBC con = new ConnectJDBC();
    JComboBox<String> comboBox1,comboBox2;
    
    Flight() {
        f = new JFrame("Book Your Flight");
        f.setSize(500, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        l1 = new JLabel("From");
        l2 = new JLabel("To");
        l3 = new JLabel("Departure Date");
        l4 = new JLabel("Adult");
        l5 = new JLabel("Children");

        // t1 = new JTextField();
        // t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();

        b1 = new JButton("Search");
        b2 = new JButton("Cancel");

        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(50, 100, 100, 20);
        l3.setBounds(50, 150, 180, 25);
        l4.setBounds(50, 200, 100, 20);
        l5.setBounds(50, 250, 100, 20);

        
        t3.setBounds(300, 150, 150, 30);
        t4.setBounds(300, 200, 150, 30);
        t5.setBounds(300, 250, 150, 30);

        b1.setBounds(100, 400, 150, 40);
        b2.setBounds(300, 400, 150, 40);

        String[] airports = {
            "Select",
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
        comboBox1.setBounds(300, 50, 150, 30);
        
        DefaultComboBoxModel<String> cityComboBoxModel2 = new DefaultComboBoxModel<>(airports);
        comboBox2 = new JComboBox<>(cityComboBoxModel2);
        comboBox2.setBounds(300, 100, 150, 30);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);

        f.add(comboBox1);
        f.add(comboBox2);
        f.add(t3);
        f.add(t4);
        f.add(t5);

        f.getRootPane().setDefaultButton(b1);
        f.add(b1);
        f.add(b2);

        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l2.setFont(new Font("Arial", Font.BOLD, 24));
        l3.setFont(new Font("Arial", Font.BOLD, 24));
        l4.setFont(new Font("Arial", Font.BOLD, 24));
        l5.setFont(new Font("Arial", Font.BOLD, 24));

        b1.setFont(new Font("Dialog", Font.BOLD, 30));
        b2.setFont(new Font("Dialog", Font.BOLD, 30));

        // t1.setFont(new Font("Arial", Font.BOLD, 30));
        f.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            // if (t1.getText().isEmpty() || t2.getText().isEmpty() ||
            // t3.getText().isEmpty() || t4.getText().isEmpty()
            // || t5.getText().isEmpty()) {
            // JOptionPane.showMessageDialog(f, "All Fields are Mandatory!", "Error!",
            // JOptionPane.WARNING_MESSAGE);
            // } else if ((!t4.getText().matches("[0-9]+")) ||
            // (!t5.getText().matches("[0-9]+"))) {
            // JOptionPane.showMessageDialog(f, "Please enter valid Detail", "error!",
            // JOptionPane.WARNING_MESSAGE);
            // }

            // }
            if (e.getSource() == b2) {
                f.dispose();
                new Choose();
            }
        }
    }
}

class BookFlight {
    public static void main(String[] s) {
        new Flight();
    }
}