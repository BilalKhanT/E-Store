import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class sign_Up extends JFrame
{
    public sign_Up() {
    }

    static String name;

    public void set_Name(String user)
    {
        name = user;
    }
    public String get_Name()
    {

        return name;
    }

    public String get_User_Id()
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT USER_ID FROM CUSTOMER";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                id = m.getInt("USER_ID");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        id = id + 1;
        String ID = String.valueOf(id);
        return ID;
    }
    public boolean name_Availability(String name)
    {
        boolean flag = true;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT USER_NAME FROM CUSTOMER";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String comp = rs.getString("USER_NAME");
                if (name.equals(comp))
                {
                    flag = false;
                }
                else
                {
                    flag = true;
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    public void add_Input(int id, String name, String password, String mail, long phone, String gender ) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO PERSON VALUES('" + name + "','" + password + "','" + mail + "'," + phone + ",'" + gender + "',"+ id +")";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();

            int m = st.executeUpdate(sql);

            // System.out.println("Insert");

            // System.out.println("Not");

            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add_Customer(int id, String name, String password, String mail, long phone, String gender)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO CUSTOMER VALUES('" + name + "','" + password + "','" + mail + "'," + phone + ",'" + gender + "',"+ id +")";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
            Statement st = con.createStatement();

            int m = st.executeUpdate(sql);

            // System.out.println("Insert");

            // System.out.println("Not");

            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static int id;

    public static String generate_User_Id()
    {
        id++;
        String id_str = String.valueOf(id);
        return id_str;
    }

    public static boolean validation_Username(String name)
    {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (name == null)
        {
            return false;
        }
        Matcher matcher = p.matcher(name);
        return matcher.matches();
    }

    public static boolean validation_Password(String pass)
    {
        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (pass == null)
        {
            return false;
        }
        Matcher matcher = p.matcher(pass);
        return matcher.matches();
    }

    public static boolean validation_Email(String mail)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (mail == null)
        {
            return false;
        }
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public static boolean validation_Contact(String contact)
    {
        String regex = "(03)[0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        if (contact == null)
        {
            return false;
        }
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    public static boolean validation_Gender(String gender)
    {
        boolean flag = true;
        if (gender == null)
            flag = false;
        return flag;
    }

    public static boolean validation_zip(String zip)
    {
        String regex = "\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        if (zip == null)
        {
            return false;
        }
        Matcher matcher = pattern.matcher(zip);
        return matcher.matches();
    }

    public static boolean validation_Place(String city)
    {
        String regex = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        if (city == null)
        {
            return false;
        }
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    public static boolean validation_No(String number)
    {
        boolean flag = false;
        if (number == null)
        {
            return false;
        }
        try {
            Integer.parseInt(number);
            flag = true;
            return flag;
        }catch(NumberFormatException e)
        {
            flag = false;
            return flag;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    sign_Up_Gui frame = new sign_Up_Gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
class sign_Up_Gui extends sign_Up {


    private JPanel contentPane;
    private JTextField user_Id_Field;
    JTextField user_Name_Field = new JTextField();

    private JPasswordField password_Field;
    private JTextField email_Field;
    private JTextField contact_Field;
    JPanel panel = new JPanel();
    JComboBox gender_Combo = new JComboBox();

    public sign_Up_Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 407);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(186, 91, 325, 257); //78,44,278,206
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel user_Id_Label = new JLabel("User ID");
        user_Id_Label.setForeground(new Color(255, 255, 255));
        user_Id_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        user_Id_Label.setBounds(20, 11, 73, 14);
        panel.add(user_Id_Label);

        JLabel user_Name_Label = new JLabel("User Name");
        user_Name_Label.setForeground(new Color(255, 255, 255));
        user_Name_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        user_Name_Label.setBounds(20, 45, 73, 14);
        panel.add(user_Name_Label);

        JLabel password_Label = new JLabel("Password");
        password_Label.setForeground(new Color(255, 255, 255));
        password_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        password_Label.setBounds(20, 79, 73, 14);
        panel.add(password_Label);

        JLabel email_Label = new JLabel("Email");
        email_Label.setForeground(new Color(255, 255, 255));
        email_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        email_Label.setBounds(20, 113, 73, 14);
        panel.add(email_Label);

        JLabel contact_Label = new JLabel("Contact");
        contact_Label.setForeground(new Color(255, 255, 255));
        contact_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        contact_Label.setBounds(20, 147, 73, 14);
        panel.add(contact_Label);

        JLabel gender_Label = new JLabel("Gender");
        gender_Label.setForeground(new Color(255, 255, 255));
        gender_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        gender_Label.setBounds(20, 181, 73, 14);
        panel.add(gender_Label);

        user_Id_Field = new JTextField();
        user_Id_Field.setFont(new Font("Tahoma", Font.PLAIN, 13));
        user_Id_Field.setBounds(116, 9, 163, 20);
        user_Id_Field.setText(get_User_Id());
        user_Id_Field.setEditable(false);
        panel.add(user_Id_Field);
        user_Id_Field.setColumns(10);


        user_Name_Field.setFont(new Font("Tahoma", Font.PLAIN, 13));
        user_Name_Field.setBounds(116, 45, 163, 20);
        panel.add(user_Name_Field);
        user_Name_Field.setColumns(10);

        password_Field = new JPasswordField();
        password_Field.setFont(new Font("Tahoma", Font.PLAIN, 13));
        password_Field.setBounds(116, 79, 163, 20);
        panel.add(password_Field);

        email_Field = new JTextField();
        email_Field.setFont(new Font("Tahoma", Font.PLAIN, 13));
        email_Field.setBounds(116, 113, 163, 20);
        panel.add(email_Field);
        email_Field.setColumns(10);

        contact_Field = new JTextField();
        contact_Field.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contact_Field.setBounds(116, 147, 163, 20);
        panel.add(contact_Field);
        contact_Field.setColumns(10);

        gender_Combo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        gender_Combo.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
        gender_Combo.setBounds(116, 181, 79, 22);
        panel.add(gender_Combo);

        JButton next_Button = new JButton("Next");
        next_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String user_Id = user_Id_Field.getText();
                String user_Name = user_Name_Field.getText();
                String password = password_Field.getText();
                String email = email_Field.getText();
                String contact = contact_Field.getText();
                String gender = (String) gender_Combo.getSelectedItem();

                boolean flag = true;

                flag = validation_Username(user_Name);

                if (flag == true)
                {
                    flag = name_Availability(user_Name);
                    if (flag == true) {
                        flag = validation_Password(password);
                        if (flag == true) {
                            flag = validation_Email(email);
                            if (flag == true) {
                                flag = validation_Contact(contact);
                                if (flag == true) {
                                    flag = validation_Gender(gender);
                                    if (flag == true) {
                                        int user_Id_db = Integer.parseInt(user_Id);
                                        long contact_db = Long.parseLong(contact);
                                        set_Name(user_Name);
                                        add_Input(user_Id_db, user_Name, password, email, contact_db, gender);
                                        add_Customer(user_Id_db, user_Name, password, email, contact_db, gender);
                                        Address form = new Address();
                                        form.setVisible(true);
                                        dispose();

                                    } else {
                                        JOptionPane.showMessageDialog(panel, "Please Select Gender",
                                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    contact_Field.setText(null);
                                    JOptionPane.showMessageDialog(panel, "Invalid Contact",
                                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                email_Field.setText(null);
                                JOptionPane.showMessageDialog(panel, "Invalid Email",
                                        "Swing Tester", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            password_Field.setText(null);
                            JOptionPane.showMessageDialog(panel, "Invalid Password",
                                    "Swing Tester", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        user_Name_Field.setText(null);
                        JOptionPane.showMessageDialog(panel, "User Already Exists",
                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }

                }
                else
                {
                    user_Name_Field.setText(null);
                    JOptionPane.showMessageDialog(panel, "Invalid User Name",
                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        next_Button.setBackground(new Color(255, 255, 255));
        next_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        next_Button.setBounds(189, 212, 95, 23);
        panel.add(next_Button);

        JLabel title_Label = new JLabel("Sign Up Form");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
        title_Label.setBounds(263, 27, 278, 24);
        contentPane.add(title_Label);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\b1.jpeg"));
        lblNewLabel.setBounds(0, 0, 694, 368);
        contentPane.add(lblNewLabel);
    }

}
