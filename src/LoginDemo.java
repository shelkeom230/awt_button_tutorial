//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click

class Menu
{
    Menu() {
        JFrame f;
        JMenuBar mb;
        JMenu Home, Add_items, Delivery, check_Stock, Print_invoice;
        JMenuItem daily,weekly,monthly,yearly;
        JTextArea ta;
        f=new JFrame();
        mb = new JMenuBar();
        daily=new JMenuItem("daily");
        weekly=new JMenuItem("weekly");
        monthly=new JMenuItem("monthly");
        yearly=new JMenuItem("yearly");
        ActionListener al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daily.addActionListener(this);
                weekly.addActionListener(this);
                monthly.addActionListener(this);
                yearly.addActionListener(this);
            }
        };
        //check_Stock.add(daily); check_Stock.add(weekly);
       // check_Stock.add(monthly); check_Stock.add(yearly);


        Home=new JMenu("Home");
        Add_items=new JMenu("Add_items");
        Delivery=new JMenu("Delivery");
        check_Stock=new JMenu("check_Stock");
        Print_invoice=new JMenu("Print_invoice");
        mb.add(Home); mb.add(Add_items); mb.add(Delivery); mb.add(check_Stock); mb.add(Print_invoice);
        ta=new JTextArea();
        ta.setBounds(5,5,360,320);
        f.add(mb); f.add(ta);
        f.setJMenuBar(mb);
        f.setSize(600,600);
        f.setVisible(true);


    }
}
class CreateLoginForm extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field
    JButton b1,b2;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;
    JFrame frame=new JFrame();

    //calling constructor
    CreateLoginForm()
    {

        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Username");//set label value for textField1
        userLabel.setBackground(Color.GREEN);

        //create text field to get username from the user
        textField1 = new JTextField(15);    //set length of the text

        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Password");      //set label value for textField2
        passLabel.setBackground(Color.GREEN);

        //create text field to get password from the user
        textField2 = new JPasswordField(15);    //set length for the password

        //create submit button
        b1 = new JButton("SUBMIT"); //set label to button
        b1.setBackground(Color.CYAN);
        b2=new JButton("Exit");
        b2.setBackground(Color.CYAN);


        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(b1);           //set button to panel
        newPanel.add(b2);           //set button2 to panel

        //set border to panel
        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        b1.addActionListener(this);     //add action listener to button
        setTitle("Haldiram Food Products,Pvt.Ltd");//set title to the login form
        frame.setBackground(Color.DARK_GRAY);
    }

    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue=textField1.getText();        //get user entered username from the textField1
        String passValue=textField2.getText();        //get user entered pasword from the textField2

        //check whether the credentials are authentic or not
        if (userValue.equals("gpa") && passValue.equals("java")) {  //if authentic, navigate user to a new page
            //create a welcome label and set it to the new page
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame,"Login successful");
                    }
                });
        }
        else{

            //show error message
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"Invalid username or Password !");
                }
            });
        }
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
//create the main class
public class LoginDemo
{
    //main() method start
    public static void main(String arg[])
    {
       try
        {
           //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,170);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
       }
        catch(Exception e)
       {
//            handle exception
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        new Menu();
    }
}
