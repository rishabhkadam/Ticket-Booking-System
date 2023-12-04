import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.io.PrintStream;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class TrainBilll {

    JFrame frame;
    JTextArea textArea;
    JButton p_btn, c_btn;
    JLabel billLabel;
    PrintStream outStream;

    TrainBilll(){
    frame = new JFrame();
    frame.setSize(340, 500);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setVisible(true);
    // frame.setUndecorated(true);

    Random random = new Random();
    int num = random.nextInt(99)+58474;

    Border border = new LineBorder(Color.BLACK, 2);

    String bill = "\n" + "*************************************************" +
    "\n                     JourneyJunction\n"
    + "*************************************************\n" +
    "       Train Ticket " + "|"+" Reciept No.:"+num+"\n"
    + "*************************************************\n" +
    "  Date : " + GetTrainDetail.date + "\n" +
    "  Name :" + GetEmail.name + "\n" +
    "  Flight :" + GetTrainDetail.trainName + "\n" +
    "  Adult :" + GetTrainDetail.adult + "\n" +
    "  Child :" + GetTrainDetail.child + "\n" +
    "*************************************************\n"+
    " \t     Fare : Rs." + GetTrainDetail.fare + "\n" +
    "*************************************************\n" +
    "             Thanks for Choosing Us. \n" + 
    "*************************************************\n";

    billLabel = new JLabel("Reciept");
    billLabel.setBounds(10, 10, 100, 30);
    frame.add(billLabel);

    textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.append(bill);
    textArea.setFont(new Font(null, Font.BOLD, 15));
    textArea.setBounds(10, 40,300, 320);
    textArea.setBorder(border);

    p_btn = new JButton("Print");
    c_btn = new JButton("Cancel");
    p_btn.setBounds(20, 400, 100, 30);
    c_btn.setBounds(160, 400, 100, 30);

    p_btn.setForeground(Color.WHITE);
    p_btn.setBackground(Color.BLACK);

    c_btn.setForeground(Color.WHITE);
    c_btn.setBackground(Color.BLACK);

    frame.add(textArea);
    frame.add(p_btn);
    frame.add(c_btn);

    // Print button

    p_btn.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            JOptionPane.showMessageDialog(frame, "Collect your Receipt.", "Succesfull", JOptionPane.INFORMATION_MESSAGE);
        }
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            p_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            p_btn.setForeground(Color.BLACK);
            p_btn.setBackground(Color.WHITE);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            p_btn.setForeground(Color.WHITE);
            p_btn.setBackground(Color.BLACK);
        }



    });

    c_btn.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

            frame.dispose();
        }
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            c_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            c_btn.setForeground(Color.BLACK);
            c_btn.setBackground(Color.WHITE);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            c_btn.setForeground(Color.WHITE);
            c_btn.setBackground(Color.BLACK);
        }



    });



    }
}

class TrainBill {
    public static void main(String[] args) {
        new TrainBilll();
    }
}