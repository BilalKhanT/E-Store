import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class update_personal extends Login {



    public void add_Cust( String password, String mail, long phone, String username ) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "UPDATE CUSTOMER SET EMAIL = '"+mail+"' , PHONE_NO = "+phone+" , PASSWORD = '"+password+"' WHERE USER_NAME= '"+username+"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();

            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void add_Input( String password, String mail, long phone , String username ) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "UPDATE PERSON SET EMAIL = '"+mail+"' , PHONE_NO = "+phone+" , PASSWORD = '"+password+"' WHERE USER_NAME= '"+username+"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();

            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add_ADDRRES(int house, String street, String city, String state, String country, int  zip , String username)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "UPDATE ADDRESS SET HOUSE_NO = "+house+" , STREET = '"+street+"' , CITY = '"+city+"' , STATE = '"+state+"' , COUNTRY = '"+country+"' , POSTAL_CODE = "+zip+" WHERE USER_NAME= '"+username+"' ";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }








    public boolean name_Availability(String name)
    {
        boolean flag = true;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "huzaifa";
        String pass = "orcl";
        Connection con = null;
        String sql = "SELECT USER_NAME FROM CUSTOMER";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
           // System.out.println("sConnection secured");
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
        String regex = "^(?=.[0-9])" + "(?=.[a-z])(?=.[A-Z])" + "(?=.[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
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

    public static boolean validation_No(String number) {
        boolean flag = false;
        if (number == null) {
            return false;
        }
        try {
            Integer.parseInt(number);
            flag = true;
            return flag;
        } catch (NumberFormatException e) {
            flag = false;
            return flag;
        }
    }

    private JPanel contentPane;
    private JTextField id_textField;
    private static JTextField name_textField;
    private JTextField email_textField;
    private JTextField phone_textfield;
    private JTextField password_textField;
    private JTextField house_textField;
    private JTextField street_textField;
    private JTextField city_textField;
    private JTextField state_textField;
    private JTextField country_textField;
    private JTextField zip_textField;


    public static void getInfo(String username) {

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    update_personal frame = new update_personal();
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
    public update_personal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("EDIT PERSONAL INFORMATION");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(198, 10, 269, 14);
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(139, 35, 448, 465);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("User_ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(51, 11, 58, 14);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_2.setBounds(51, 45, 46, 14);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Email");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_3.setBounds(51, 81, 46, 14);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Phone No");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_4.setBounds(51, 117, 68, 14);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Password");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_5.setBounds(51, 157, 68, 14);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("House No:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_6.setBounds(51, 192, 68, 14);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Street No:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_7.setBounds(51, 234, 68, 14);
        panel.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("City:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_8.setBounds(51, 282, 46, 14);
        panel.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("State:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_9.setBounds(51, 325, 46, 14);
        panel.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Country:");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_10.setBounds(51, 369, 58, 14);
        panel.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Zip Code");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_11.setBounds(51, 405, 58, 14);
        panel.add(lblNewLabel_11);

        id_textField = new JTextField();
        id_textField.setBounds(250, 9, 135, 20);
        panel.add(id_textField);
        id_textField.setColumns(10);

        name_textField = new JTextField();
        name_textField.setBounds(250, 43, 135, 20);
        panel.add(name_textField);
        name_textField.setColumns(10);

        email_textField = new JTextField();
        email_textField.setBounds(250, 79, 135, 20);
        panel.add(email_textField);
        email_textField.setColumns(10);

        phone_textfield = new JTextField();
        phone_textfield.setBounds(250, 115, 135, 20);
        panel.add(phone_textfield);
        phone_textfield.setColumns(10);

        password_textField = new JTextField();
        password_textField.setBounds(250, 155, 135, 20);
        panel.add(password_textField);
        password_textField.setColumns(10);

        house_textField = new JTextField();
        house_textField.setBounds(250, 190, 135, 20);
        panel.add(house_textField);
        house_textField.setColumns(10);

        street_textField = new JTextField();
        street_textField.setBounds(250, 232, 135, 20);
        panel.add(street_textField);
        street_textField.setColumns(10);

        city_textField = new JTextField();
        city_textField.setBounds(250, 280, 135, 20);
        panel.add(city_textField);
        city_textField.setColumns(10);

        state_textField = new JTextField();
        state_textField.setBounds(250, 323, 135, 20);
        panel.add(state_textField);
        state_textField.setColumns(10);

        country_textField = new JTextField();
        country_textField.setBounds(250, 367, 135, 20);
        panel.add(country_textField);
        country_textField.setColumns(10);

        zip_textField = new JTextField();
        zip_textField.setBounds(250, 403, 135, 20);
        panel.add(zip_textField);
        zip_textField.setColumns(10);

        JButton Load_button = new JButton("Load Data");
        Load_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name;
                String pswd;
                String email;
                long phone;
                String gender;
                int id;
                int house;
                String street;
                String city;
                String state;
                String country;
                int postal;
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "maindb";
                String pass = "bilal";
                Connection con = null;
                String username = get_Name();

                String sql = "SELECT * FROM CUSTOMER INNER JOIN ADDRESS ON CUSTOMER.USER_NAME = ADDRESS.USER_NAME AND CUSTOMER.USER_NAME = '"+username+"' ";
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next())
                    {
                        id =rs.getInt("USER_ID");
                        id_textField.setText(String.valueOf(id));
                        name = rs.getString("USER_NAME");
                        name_textField.setText(name);
                        pswd = rs.getString("PASSWORD");
                        password_textField.setText(pswd);
                        email = rs.getString("EMAIL");
                        email_textField.setText(email);
                        phone = rs.getLong("PHONE_NO");
                        phone_textfield.setText(String.valueOf(phone));
                        house = rs.getInt("HOUSE_NO");
                        house_textField.setText(String.valueOf(house));
                        street = rs.getString("STREET");
                        street_textField.setText(street);
                        city = rs.getString("CITY");
                        city_textField.setText(city);
                        state = rs.getString("STATE");
                        state_textField.setText(state);
                        country = rs.getString("COUNTRY");
                        country_textField.setText(country);
                        postal = rs.getInt("POSTAL_CODE");
                        zip_textField.setText(String.valueOf(postal));


                    }

                }
                catch (SQLException e1) {
                    throw new RuntimeException(e1);
                } catch (ClassNotFoundException e1) {
                    throw new RuntimeException(e1);
                }

            }
        });
        Load_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        Load_button.setBounds(152, 442, 115, 23);
        panel.add(Load_button);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Profile frame = new Profile();
                frame.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(10, 477, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                {
                    String user_Id = id_textField.getText();
                    String user_Name = name_textField.getText();
                    String password = password_textField.getText();
                    String email = email_textField.getText();
                    String contact = phone_textfield.getText();
                    String no = house_textField.getText();
                    String street = street_textField.getText();
                    String city = city_textField.getText();
                    String state = state_textField.getText();
                    String country = country_textField.getText();
                    String zip = zip_textField.getText();


                    boolean flag = true;

                    flag = validation_Username(user_Name);


                    if (flag == true) {
                        flag = validation_Password(password);
                        if (flag == true) {
                            flag = validation_Email(email);
                            if (flag == true) {
                                flag = validation_Contact(contact);
                                if (flag == true) {
                                    if (validation_No(no) == true) {
                                        if (validation_No(street) == true) {
                                            if (validation_Place(city) == true) {
                                                if (validation_Place(state) == true) {
                                                    if (validation_Place(country) == true) {
                                                        if (validation_zip(zip) == true) {


                                                        } else {
                                                            zip_textField.setText(null);
                                                            JOptionPane.showMessageDialog(panel, "Invalid Zip Code",
                                                                    "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    } else {
                                                        country_textField.setText(null);
                                                        JOptionPane.showMessageDialog(panel, "Invalid Country Name",
                                                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                } else {
                                                    state_textField.setText(null);
                                                    JOptionPane.showMessageDialog(panel, "Invalid State Name",
                                                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                city_textField.setText(null);
                                                JOptionPane.showMessageDialog(panel, "Invalid City Name",
                                                        "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            street_textField.setText(null);
                                            JOptionPane.showMessageDialog(panel, "Invalid Street Number",
                                                    "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        house_textField.setText(null);
                                        JOptionPane.showMessageDialog(panel, "Invalid House Number",
                                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    phone_textfield.setText(null);
                                    JOptionPane.showMessageDialog(panel, "Invalid Contact",
                                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                email_textField.setText(null);
                                JOptionPane.showMessageDialog(panel, "Invalid Email",
                                        "Swing Tester", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }else {
                        password_textField.setText(null);
                        JOptionPane.showMessageDialog(panel, "Invalid Password",
                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }
                    add_Input(password, email, Long.parseLong(contact) , get_Name());
                    add_Cust(password, email, Long.parseLong(contact),get_Name());
                    add_ADDRRES(Integer.parseInt(no), street, city, state, country, Integer.parseInt(zip),get_Name());

                }




            }




        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(635, 477, 89, 23);
        contentPane.add(btnNewButton_1);
    }

}
