import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

class BusTicket {

    JFrame f;
    JLabel label;
    JLabel imgL, iconL, seatL, busL,dateL,childL,adultL;
    JComboBox<String> deptBox, destBox, seatBox, busBox;
    ImageIcon img, swapIcon;
    JButton searchB, cancelB;
    JTextField TfDate,TfChild,Tfadult;
    JCheckBox checkBox;

    BusTicket() {

        f = new JFrame("Bus Ticket");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.WHITE);

        label = new JLabel("Bus Ticket");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        label.setBounds(0, 0, f.getWidth(), 50);

        img = new ImageIcon("bus_img.jpg");
        imgL = new JLabel(img);
        imgL.setBounds(350, 20, 450, 416);

        swapIcon = new ImageIcon("swap.png");
        iconL = new JLabel(swapIcon);

        seatL = new JLabel("SEAT TYPE      :");
        seatL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        busL = new JLabel("BUS TYPE      :");
        busL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        dateL = new JLabel("DATE      :");
        dateL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        TfDate = new JTextField(String.valueOf(LocalDate.now()));
        TfDate.setFont(new Font("Sans-Sarif", Font.BOLD, 13));
        
        childL = new JLabel("CHILD      :");
        childL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        TfChild = new JTextField();
        TfChild.setFont(new Font("Sans-Sarif", Font.BOLD, 13));

        adultL = new JLabel("ADULT      :");
        adultL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        Tfadult = new JTextField();
        Tfadult.setFont(new Font("Sans-Sarif", Font.BOLD, 13));

        checkBox = new JCheckBox("INFANT?");
        checkBox.setFont(new Font("Sans-Sarif", Font.BOLD, 18));


        String[] indianCities = {
                "Departure",
                "Mumbai",
                "Delhi",
                "Bangalore",
                "Hyderabad",
                "Chennai",
                "Kolkata",
                "Ahmedabad",
                "Pune",
                "Jaipur",
                "Lucknow",
                "Kanpur",
                "Nagpur",
                "Visakhapatnam",
                "Indore",
                "Thane",
                "Bhopal",
                "Patna",
                "Vadodara",
                "Ghaziabad",
                "Ludhiana",
                "Agra",
                "Nashik",
                "Faridabad",
                "Meerut",
                "Rajkot",
                "Kalyan-Dombivli",
                "Vasai-Virar",
                "Varanasi",
                "Srinagar",
        };

        String[] indianCities1 = {
                "Destination",
                "Mumbai",
                "Delhi",
                "Bangalore",
                "Hyderabad",
                "Chennai",
                "Kolkata",
                "Ahmedabad",
                "Pune",
                "Jaipur",
                "Lucknow",
                "Kanpur",
                "Nagpur",
                "Visakhapatnam",
                "Indore",
                "Thane",
                "Bhopal",
                "Patna",
                "Vadodara",
                "Ghaziabad",
                "Ludhiana",
                "Agra",
                "Nashik",
                "Faridabad",
                "Meerut",
                "Rajkot",
                "Kalyan-Dombivli",
                "Vasai-Virar",
                "Varanasi",
                "Srinagar",
        };

        DefaultComboBoxModel<String> cityComboBoxModel = new DefaultComboBoxModel<>(indianCities);
        deptBox = new JComboBox<>(cityComboBoxModel);

        DefaultComboBoxModel<String> cityCComboBoxModel = new DefaultComboBoxModel<>(indianCities1);
        destBox = new JComboBox<>(cityCComboBoxModel);

        String[] seatType = {
                "Seater", "Sleeper", "Semi-Sleeper"
        };

        DefaultComboBoxModel<String> citySComboBoxModel = new DefaultComboBoxModel<>(seatType);
        seatBox = new JComboBox<>(citySComboBoxModel);

        String[] busType = {
                "AC", "Non-AC"
        };

        DefaultComboBoxModel<String> cityBComboBoxModel = new DefaultComboBoxModel<>(busType);
        busBox = new JComboBox<>(cityBComboBoxModel);

        searchB = new JButton("Search");
        searchB.setBackground(Color.BLACK);
        searchB.setForeground(Color.WHITE);

        cancelB = new JButton("Cancel");
        cancelB.setBackground(Color.BLACK);
        cancelB.setForeground(Color.WHITE);

        deptBox.setBounds(50, 100, 150, 30);
        iconL.setBounds(210, 90, 50, 50);
        destBox.setBounds(270, 100, 150, 30);

        seatL.setBounds(100, 140, 170, 30);
        seatBox.setBounds(270, 140, 100, 30);

        busL.setBounds(110, 180, 170, 30);
        busBox.setBounds(270, 180, 100, 30);

        dateL.setBounds(152, 220, 100, 30);
        TfDate.setBounds(270, 220, 100, 30);

        childL.setBounds(145, 260, 100, 30);
        TfChild.setBounds(270, 260, 50, 30);

        adultL.setBounds(140, 300, 100, 30);
        Tfadult.setBounds(270, 300, 50, 30);

        checkBox.setBounds(270, 340, 130, 30);

        searchB.setBounds(120, 400, 100, 30);
        cancelB.setBounds(250, 400, 100, 30);

        f.add(label);
        f.add(imgL);
        f.add(deptBox);
        f.add(iconL);
        f.add(destBox);
        f.add(seatL);
        f.add(seatBox);
        f.add(busL);
        f.add(busBox);
        f.add(dateL);
        f.add(TfDate);
        f.add(childL);
        f.add(TfChild);
        f.add(adultL);
        f.add(Tfadult);
        f.add(checkBox);
        f.add(searchB);
        f.add(cancelB);
        f.setVisible(true);


        // Search button implementation

        searchB.addMouseListener(new MouseListener() {

       
            public void mouseClicked(MouseEvent e) {
                
                if(deptBox.getSelectedIndex() == 0 || destBox.getSelectedIndex() == 0){

                    JOptionPane.showMessageDialog(f, "Please Select City", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else if(deptBox.getSelectedItem() == destBox.getSelectedItem()){

                    JOptionPane.showMessageDialog(f, "Please Select Different city", "Error", JOptionPane.ERROR_MESSAGE);

                }

                else if(TfDate.getText().isEmpty() || TfChild.getText().isEmpty()|| Tfadult.getText().isEmpty()){
                    JOptionPane.showMessageDialog(f, "Please enter details", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else if((!TfChild.getText().matches("[0-9]+")) || 
                            (!Tfadult.getText().matches("[0-9]+"))){

                    JOptionPane.showMessageDialog(f, "Please enter valid detail, Number Only!", "Error", JOptionPane.ERROR_MESSAGE);
                }


                else{

                    GetBusDetail.dept = (String) deptBox.getSelectedItem();
                    GetBusDetail.dest = (String) destBox.getSelectedItem();
                    GetBusDetail.seat = (String) seatBox.getSelectedItem();
                    GetBusDetail.bus = (String) busBox.getSelectedItem();
                    GetBusDetail.date = TfDate.getText();
                    GetBusDetail.adult = Tfadult.getText();
                    GetBusDetail.child = TfChild.getText(); 
 
                    new BusList();

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                searchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
                searchB.setBackground(Color.WHITE);
                searchB.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchB.setBackground(Color.BLACK);
                searchB.setForeground(Color.WHITE);
            }
            
        });

        // Cancel button implementation

        cancelB.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelB.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cancelB.setBackground(Color.WHITE);
                cancelB.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelB.setBackground(Color.BLACK);
                cancelB.setForeground(Color.WHITE);
            }
            
        });
    }
}

class BookBus {
    public static void main(String[] args) {
        new BusTicket();
    }
}