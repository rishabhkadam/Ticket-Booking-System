import java.awt.*;
class Login
{
Frame f;
TextField t1,t2;
Button b1,b2;
Label l1,l2;

Login()
{
f=new Frame("Login");
f.setSize(600,400);
f.setLocationRelativeTo(null);
f.setLayout(null);

Font ft=new Font("Courier",Font.ITALIC,50);
l1=new Label("Email");
l2=new Label("Password");

t1=new TextField();
t2=new TextField();

b1=new Button("Login");
b2=new Button("Registration");

l1.setBounds(70,60,100,30);
l2.setBounds(70,100,100,30);

t1.setBounds(400,60,150,30);
t2.setBounds(400,100,150,30);

b1.setBounds(250,300,100,30);
b2.setBounds(250,350,100,30);

f.add(l1);
f.add(l2);
f.add(t1);
f.add(t2);
f.add(b1);
f.add(b2);

f.setVisible(true);
}
}

class LoginDemo
{
public static void main(String[] s)
{
Login l=new Login();
}
}
