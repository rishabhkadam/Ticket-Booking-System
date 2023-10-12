import java.awt.*;
class Book
{
Frame f;
TextField t1,t2,t3,t4,t5,t6;
Button b;
Label l1,l2,l3,l4,l5,l6;

Book()
{
f=new Frame("Book Show");
f.setSize(800,500);
f.setLocationRelativeTo(null);
f.setLayout(null);

//Font ft=new Font("Courier",Font.ITALIC,50);
l1=new Label("Theater Name");
l2=new Label("Screen");
l3=new Label("Select Date");
l4=new Label("Show Timing");
l5=new Label("Ticket Type");
l6=new Label("Number Of Ticket");

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();

b=new Button("Book");


l1.setBounds(400,60,100,30);
l2.setBounds(400,100,100,30);
l3.setBounds(400,140,100,30);
l4.setBounds(400,180,100,30);
l5.setBounds(400,220,100,30);
l6.setBounds(400,260,100,30);

t1.setBounds(600,60,140,30);
t2.setBounds(600,100,140,30);
t3.setBounds(600,140,140,30);
t4.setBounds(600,180,140,30);
t5.setBounds(600,220,140,30);
t6.setBounds(600,260,140,30);

b.setBounds(350,400,100,30);


f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);

f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);

f.add(b);


f.setVisible(true);
}
}

class BookMovie
{
public static void main(String[] s)
{
Book bb=new Book();
}
}
