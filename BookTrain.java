import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

class TrainTicket {

    JFrame f;
    JLabel label;
    JLabel imgL, iconL, seatL, busL,dateL,childL,adultL;
    JComboBox<String> deptBox, destBox, seatBox, busBox;
    ImageIcon img, swapIcon;
    JButton searchB, cancelB;
    JTextField TfDate,TfChild,Tfadult;

    TrainTicket() {

        f = new JFrame("Train Ticket");
        f.setSize(800, 500);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.WHITE);

        Border border = new LineBorder(Color.BLACK, 2);

        label = new JLabel("Train Ticket");
        label.setFont(new Font("", Font.BOLD, 30));
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        label.setBounds(0, 0, f.getWidth(), 50);

        img = new ImageIcon("train.jpg");
        imgL = new JLabel(img);
        imgL.setBounds(370, 20, 450, 416);

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
        TfDate.setBorder(border);
        
        childL = new JLabel("CHILD      :");
        childL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        TfChild = new JTextField();
        TfChild.setFont(new Font("Sans-Sarif", Font.BOLD, 13));
        TfChild.setBorder(border);

        adultL = new JLabel("ADULT      :");
        adultL.setFont(new Font("Sans-Sarif", Font.BOLD, 18));

        Tfadult = new JTextField();
        Tfadult.setFont(new Font("Sans-Sarif", Font.BOLD, 13));
        Tfadult.setBorder(border);

        String[] indian_railway_stations = {
            "from",
    "New Delhi",
    "Mumbai Central",
    "Chennai Central",
    "Kolkata Howrah",
    "Bengaluru City",
    "Hyderabad Deccan",
    "Ahmedabad Junction",
    "Pune Junction",
    "Jaipur Junction",
    "Lucknow Junction",
    "Patna Junction",
    "Bhopal Junction",
    "Kochi Ernakulam",
    "Guwahati Junction",
    "Chandigarh Junction",
    "Vadodara Junction",
    "Varanasi Junction",
    "Thiruvananthapuram Central",
    "Bhubaneswar",
    "Indore Junction",
    "Nagpur Junction",
    "Agra Cantt",
    "Amritsar Junction",
    "Rajkot Junction",
    "Jodhpur Junction",
    "Visakhapatnam Junction",
    "Secunderabad Junction",
    "Surat",
    "Kanpur Central",
    "Coimbatore Junction",
    "Raipur Junction",
    "Ranchi Junction",
    "Gorakhpur Junction",
    "Jamshedpur Tatanagar",
    "Allahabad Junction",
    "Mysuru Junction",
    "Trichy Junction",
    "Vijayawada Junction",
    "Madurai Junction",
    "Ahmednagar",
    "Amravati",
    "Jalandhar City",
    "Ludhiana Junction",
    "Tirupati Main",
    "Gwalior Junction",
    "Hisar",
    "Jhansi Junction",
    "Ajmer Junction",
    "Kota Junction",
    "Dhanbad Junction",
    "Hajipur Junction",
    "Udaipur City",
    "Jammu Tawi",
    "Siliguri Junction",
    "Aurangabad",
    "Cuttack",
    "Kollam Junction",
    "Dehradun",
    "Kottayam",
    "Gaya Junction",
    "Warangal",
    "Rourkela",
    "Salem Junction",
    "Nellore",
    "Patiala",
    "Guntur Junction",
    "Ratlam Junction",
    "Aligarh Junction",
    "Durgapur",
    "Vellore Katpadi",
    "Dibrugarh",
    "Guntakal Junction",
    "Kakinada Junction",
    "Tirunelveli Junction",
    
        };


        String[] indian_railway_stations1 = {
            "To",
    "New Delhi",
    "Mumbai Central",
    "Chennai Central",
    "Kolkata Howrah",
    "Bengaluru City",
    "Hyderabad Deccan",
    "Ahmedabad Junction",
    "Pune Junction",
    "Jaipur Junction",
    "Lucknow Junction",
    "Patna Junction",
    "Bhopal Junction",
    "Kochi Ernakulam",
    "Guwahati Junction",
    "Chandigarh Junction",
    "Vadodara Junction",
    "Varanasi Junction",
    "Thiruvananthapuram Central",
    "Bhubaneswar",
    "Indore Junction",
    "Nagpur Junction",
    "Agra Cantt",
    "Amritsar Junction",
    "Rajkot Junction",
    "Jodhpur Junction",
    "Visakhapatnam Junction",
    "Secunderabad Junction",
    "Surat",
    "Kanpur Central",
    "Coimbatore Junction",
    "Raipur Junction",
    "Ranchi Junction",
    "Gorakhpur Junction",
    "Jamshedpur Tatanagar",
    "Allahabad Junction",
    "Mysuru Junction",
    "Trichy Junction",
    "Vijayawada Junction",
    "Madurai Junction",
    "Ahmednagar",
    "Amravati",
    "Jalandhar City",
    "Ludhiana Junction",
    "Tirupati Main",
    "Gwalior Junction",
    "Hisar",
    "Jhansi Junction",
    "Ajmer Junction",
    "Kota Junction",
    "Dhanbad Junction",
    "Hajipur Junction",
    "Udaipur City",
    "Jammu Tawi",
    "Siliguri Junction",
    "Aurangabad",
    "Cuttack",
    "Kollam Junction",
    "Dehradun",
    "Kottayam",
    "Gaya Junction",
    "Warangal",
    "Rourkela",
    "Salem Junction",
    "Nellore",
    "Patiala",
    "Guntur Junction",
    "Ratlam Junction",
    "Aligarh Junction",
    "Durgapur",
    "Vellore Katpadi",
    "Dibrugarh",
    "Guntakal Junction",
    "Kakinada Junction",
    "Tirunelveli Junction",
    
        };


        DefaultComboBoxModel<String> cityComboBoxModel = new DefaultComboBoxModel<>(indian_railway_stations);
        deptBox = new JComboBox<>(cityComboBoxModel);
        deptBox.setBorder(border);
        deptBox.setBackground(Color.WHITE);
        deptBox.setForeground(Color.BLACK);


        DefaultComboBoxModel<String> cityCComboBoxModel = new DefaultComboBoxModel<>(indian_railway_stations1);
        destBox = new JComboBox<>(cityCComboBoxModel);
        destBox.setBorder(border);
        destBox.setBackground(Color.WHITE);
        destBox.setForeground(Color.BLACK);

        String[] seatType = {
                "Seater", "Sleeper", "Semi-Sleeper"
        };

        DefaultComboBoxModel<String> citySComboBoxModel = new DefaultComboBoxModel<>(seatType);
        seatBox = new JComboBox<>(citySComboBoxModel);
        seatBox.setBorder(border);
        seatBox.setBackground(Color.WHITE);
        seatBox.setForeground(Color.BLACK);

        String[] trainType = {
                "AC", "Non-AC"
        };

        DefaultComboBoxModel<String> cityBComboBoxModel = new DefaultComboBoxModel<>(trainType);
        busBox = new JComboBox<>(cityBComboBoxModel);
        busBox.setBorder(border);
        busBox.setBackground(Color.WHITE);
        busBox.setForeground(Color.BLACK);

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

        searchB.setBounds(120, 400, 100, 30);
        cancelB.setBounds(250, 400, 100, 30);

        f.add(label);
        f.add(iconL);
        f.add(imgL);
        f.add(deptBox);
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
        f.add(searchB);
        f.add(cancelB);
        f.setVisible(true);


        // Search button implementation

        searchB.addMouseListener(new MouseListener() {

       
            public void mouseClicked(MouseEvent e) {
                
                if(deptBox.getSelectedIndex() == 0 || destBox.getSelectedIndex() == 0){

                    JOptionPane.showMessageDialog(f, "Please Select Station", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else if(deptBox.getSelectedItem() == destBox.getSelectedItem()){

                    JOptionPane.showMessageDialog(f, "Please Select Different Station", "Error", JOptionPane.ERROR_MESSAGE);

                }

                else if(TfDate.getText().isEmpty() || TfChild.getText().isEmpty()|| Tfadult.getText().isEmpty()){
                    JOptionPane.showMessageDialog(f, "Please enter details", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else if((!TfChild.getText().matches("[0-9]+")) || 
                            (!Tfadult.getText().matches("[0-9]+"))){

                    JOptionPane.showMessageDialog(f, "Please enter valid detail, Number Only!", "Error", JOptionPane.ERROR_MESSAGE);
                }


                else{

                    GetTrainDetail.dept = (String) deptBox.getSelectedItem();
                    GetTrainDetail.dest = (String) destBox.getSelectedItem();
                    GetTrainDetail.seat = (String) seatBox.getSelectedItem();
                    GetTrainDetail.bus = (String) busBox.getSelectedItem();
                    GetTrainDetail.date = TfDate.getText();
                    GetTrainDetail.adult = Tfadult.getText();
                    GetTrainDetail.child = TfChild.getText(); 
 
                    new TrainList();

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
                f.dispose();
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

class BookTrain {
    public static void main(String[] args) {
        new TrainTicket();
    }
}