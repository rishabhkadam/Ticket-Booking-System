import java.awt.Color;
import java.awt.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

class FlightList {
        JFrame f;
        JLabel label;
        List f_List,p_List;
        JButton b_Button,c_Button;
        
        FlightList(){
            f = new JFrame("Select Flight");
            f.setSize(800, 500);
            f.setLayout(null);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.getContentPane().setBackground(Color.WHITE);


            label = new JLabel("SELECT FLIGHT");
            label.setFont(new Font("",Font.BOLD,30));
            label.setOpaque(true);
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLACK);
            label.setBorder(new EmptyBorder(0, 10, 0, 0));

            
            String flit_list[] = {"Air Asia","Air Carnival","Air costa","Air india","Indigo","Air India Express","Jet Airways","Vistara Airlines","Jet Konnect"};
            
            for (int i = 0; i < flit_list.length; i++) {
                f_List.add(flit_list[i]);
            }

            
            label.setBounds(0, 10, 600, 50);
            f_List.setBounds(10, 200, 100, 100);

            f.add(label);
            f.add(f_List);
            // f.add(p_List);
            // f.add(b_Button);
            // f.add(c_Button);

        }
}

class SelectFlight{
    public static void main(String[] args) {
        new FlightList();
    }
}