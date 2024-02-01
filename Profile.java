import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;

public class Profile extends Login {

    public String get_Id(String user_name)
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT USER_ID FROM CUSTOMER WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getInt("USER_ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String flag = String.valueOf(id);
        return flag;
    }
    public String get_Password(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PASSWORD FROM CUSTOMER WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("PASSWORD");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_Email(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT EMAIL FROM CUSTOMER WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("EMAIL");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_Contact(String user_name)
    {
        long id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PHONE_NO FROM CUSTOMER WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getLong("PHONE_NO");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String flag = String.valueOf(id);
        return flag;
    }

    public String get_Gender(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT GENDER FROM CUSTOMER WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("GENDER");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_HouseNo(String user_name)
    {
        long id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT HOUSE_NO FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getInt("HOUSE_NO");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String flag = String.valueOf(id);
        return flag;
    }

    public String get_StreetNo(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT STREET FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("STREET");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_City(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT CITY FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("CITY");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_State(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT STATE FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("STATE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_Country(String user_name)
    {
        String flag = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT COUNTRY FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                flag = rs.getString("COUNTRY");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public String get_Code(String user_name)
    {
        long id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT POSTAL_CODE FROM ADDRESS WHERE USER_NAME = '"+ user_name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getLong("POSTAL_CODE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String flag = String.valueOf(id);
        return flag;
    }
    private JPanel contentPane;
    private JTextField id_Field;
    private JTextField name_Field;
    private JTextField pass_Field;
    private JTextField mail_Field;
    private JTextField contact_Field;
    private JTextField gender_Field;
    private JTextField house_Field;
    private JTextField street_Field;
    private JTextField city_Field;
    private JTextField state_Field;
    private JTextField country_Field;
    private JTextField code_Field;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Profile frame = new Profile();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Profile() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 450);//850 650
        setLocation(250,40);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("USER PROFILE");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 19));
        title_Label.setBounds(295, 17, 150, 14);
        contentPane.add(title_Label);

        JPanel profile_Panel = new JPanel();
        profile_Panel.setBackground(new Color(0,0,0,80));
        profile_Panel.setBounds(128, 42, 445, 358);
        contentPane.add(profile_Panel);
        profile_Panel.setLayout(null);

        JLabel id_Label = new JLabel("User ID");
        id_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        id_Label.setBounds(71, 32, 63, 14);
        profile_Panel.add(id_Label);

        JLabel name_Label = new JLabel("User Name");
        name_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        name_Label.setBounds(71, 57, 63, 14);
        profile_Panel.add(name_Label);

        JLabel pass_Label = new JLabel("Password");
        pass_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        pass_Label.setBounds(71, 82, 63, 14);
        profile_Panel.add(pass_Label);

        JLabel mail_Label = new JLabel("Email");
        mail_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        mail_Label.setBounds(71, 107, 63, 14);
        profile_Panel.add(mail_Label);

        JLabel contact_Label = new JLabel("Contact");
        contact_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        contact_Label.setBounds(71, 132, 63, 14);
        profile_Panel.add(contact_Label);

        JLabel gender_Label = new JLabel("Gender");
        gender_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        gender_Label.setBounds(71, 157, 63, 14);
        profile_Panel.add(gender_Label);

        String a = get_Name();
        id_Field = new JTextField();
        id_Field.setBounds(182, 30, 166, 20);
        profile_Panel.add(id_Field);
        id_Field.setText(get_Id(a));
        id_Field.setColumns(10);
        id_Field.setEditable(false);

        name_Field = new JTextField();
        name_Field.setBounds(181, 55, 167, 20);
        profile_Panel.add(name_Field);
        name_Field.setColumns(10);
        name_Field.setText(a);
        name_Field.setEditable(false);

        pass_Field = new JTextField();
        pass_Field.setBounds(182, 80, 166, 20);
        profile_Panel.add(pass_Field);
        pass_Field.setColumns(10);
        pass_Field.setText(get_Password(a));
        pass_Field.setEditable(false);

        mail_Field = new JTextField();
        mail_Field.setBounds(182, 105, 166, 20);
        profile_Panel.add(mail_Field);
        mail_Field.setColumns(10);
        mail_Field.setText(get_Email(a));
        mail_Field.setEditable(false);

        contact_Field = new JTextField();
        contact_Field.setBounds(182, 130, 166, 20);
        profile_Panel.add(contact_Field);
        contact_Field.setColumns(10);
        contact_Field.setText("0"+get_Contact(a));
        contact_Field.setEditable(false);

        gender_Field = new JTextField();
        gender_Field.setBounds(182, 155, 166, 20);
        profile_Panel.add(gender_Field);
        gender_Field.setColumns(10);
        gender_Field.setText(get_Gender(a));
        gender_Field.setEditable(false);

        JLabel house_Label = new JLabel("House No.");
        house_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        house_Label.setBounds(71, 183, 63, 14);
        profile_Panel.add(house_Label);

        house_Field = new JTextField();
        house_Field.setBounds(182, 181, 166, 20);
        profile_Panel.add(house_Field);
        house_Field.setColumns(10);
        house_Field.setText(get_HouseNo(a));
        house_Field.setEditable(false);

        JLabel street_Label = new JLabel("Street No.");
        street_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        street_Label.setBounds(71, 208, 63, 14);
        profile_Panel.add(street_Label);

        street_Field = new JTextField();
        street_Field.setBounds(182, 206, 166, 20);
        profile_Panel.add(street_Field);
        street_Field.setColumns(10);
        street_Field.setText(get_StreetNo(a));
        street_Field.setEditable(false);

        JLabel city_Label = new JLabel("City");
        city_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        city_Label.setBounds(71, 233, 63, 14);
        profile_Panel.add(city_Label);

        city_Field = new JTextField();
        city_Field.setBounds(182, 231, 166, 20);
        profile_Panel.add(city_Field);
        city_Field.setColumns(10);
        city_Field.setText(get_City(a));
        city_Field.setEditable(false);

        JLabel state_Label = new JLabel("State");
        state_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        state_Label.setBounds(71, 258, 63, 14);
        profile_Panel.add(state_Label);

        state_Field = new JTextField();
        state_Field.setBounds(182, 256, 166, 20);
        profile_Panel.add(state_Field);
        state_Field.setColumns(10);
        state_Field.setText(get_State(a));
        state_Field.setEditable(false);

        JLabel country_Label = new JLabel("Country");
        country_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        country_Label.setBounds(71, 283, 63, 14);
        profile_Panel.add(country_Label);

        country_Field = new JTextField();
        country_Field.setBounds(182, 281, 166, 20);
        profile_Panel.add(country_Field);
        country_Field.setColumns(10);
        country_Field.setText(get_Country(a));
        country_Field.setEditable(false);

        JLabel code_Label = new JLabel("Zip Code");
        code_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        code_Label.setBounds(71, 308, 63, 14);
        profile_Panel.add(code_Label);

        code_Field = new JTextField();
        code_Field.setBounds(182, 306, 166, 20);
        profile_Panel.add(code_Field);
        code_Field.setColumns(10);
        code_Field.setText(get_Code(a));
        code_Field.setEditable(false);

        JButton back_Button = new JButton("< Previous");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cust_Homepage frame = new cust_Homepage();
                frame.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_Button.setBounds(10, 377, 105, 23);
        contentPane.add(back_Button);

        JButton edit_Button = new JButton("Edit Info.");
        edit_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update_personal frame = new update_personal();
                frame.setVisible(true);
                dispose();
            }
        });
        edit_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        edit_Button.setBounds(589, 378, 105, 23);
        contentPane.add(edit_Button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel.setBounds(0, 0, 720, 450);
        contentPane.add(lblNewLabel);
    }
}

