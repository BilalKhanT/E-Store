import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.IOException;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.sql.*;


public class Login extends JFrame  {

    public int get_Cart_Id()
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT CART_ID FROM CART";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                id = m.getInt("CART_ID");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        id = id + 1;
        return id;
    }

    static int cart_ID;
    public static void set_id_Cart(int id)
    {
        cart_ID = id;
    }

    public static int get_id_Cart()
    {
        return cart_ID;
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

    public static Connection getConnection( ) {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maindb", "bilal");
            //System.out.println("sConnection secured");

        } catch (Exception e) {
            // System.out.println("Connection not estalished");

        }
        return con;
    }
    public boolean checkPassword_Cust(String password, String name){
        boolean checkpassword = false;

        String query = "SELECT PASSWORD FROM CUSTOMER WHERE user_name  ='"+name+"'";
        try{
            Statement ps = Login.getConnection().createStatement();
            ResultSet rs = ps.executeQuery(query);
            while(rs.next())
            {
                String s = rs.getString("PASSWORD");
                if (password.equals(s)){
                    checkpassword = true;
                }


            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Record Not Found");
        }
        return checkpassword;
    }

    public boolean checkPassword_Admin(String password, String name){
        boolean checkpassword = false;

        String query = "SELECT PASSWORD FROM ADMIN WHERE user_name  ='"+name+"'";
        try{
            Statement ps = Login.getConnection().createStatement();
            ResultSet rs = ps.executeQuery(query);
            while(rs.next())
            {
                String s = rs.getString("PASSWORD");
                if (password.equals(s)){
                    checkpassword = true;
                }


            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Record Not Found");
        }
        return checkpassword;
    }
    public boolean checkUsername_Cust(String username)
    {


        boolean checkUser = false;
        String query = "SELECT user_name FROM CUSTOMER WHERE user_name ='"+username+"'";

        try {
            Statement ps = Login.getConnection().createStatement();
            ResultSet rs =  ps.executeQuery(query);



            while(rs.next())
            {if(rs.getString(1).equals(username)){
                checkUser = true;
            }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Record Not Found");
        }
        return checkUser;
    }

    public boolean checkUsername_Admin(String username)
    {


        boolean checkUser = false;
        String query = "SELECT user_name FROM ADMIN WHERE user_name ='"+username+"'";

        try {
            Statement ps = Login.getConnection().createStatement();
            ResultSet rs =  ps.executeQuery(query);



            while(rs.next())
            {if(rs.getString(1).equals(username)){
                checkUser = true;
            }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Record Not Found");
        }
        return checkUser;
    }

    private JPanel contentPane;
    private JTextField user_Field;
    private JPasswordField password_Field;
    JCheckBox show_checkbox = new JCheckBox("Show Password");

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        setLocation( 330, 50);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel login_panel = new JPanel();
        login_panel.setBackground(new Color (0, 0, 0));
        login_panel.setForeground(new Color(0, 0, 0));
        login_panel.setBounds(180, 91, 315, 190 );
        contentPane.add(login_panel);
        login_panel.setLayout(null);

        JLabel user_label = new JLabel("User Name");
        user_label.setForeground(Color.WHITE);
        user_label.setBackground(Color.WHITE);
        user_label.setFont(new Font("Tahoma", Font.BOLD, 14));
        user_label.setBounds(10, 11, 80, 20);
        login_panel.add(user_label);

        user_Field = new JTextField();
        user_Field.setBounds(114, 12, 160, 20);
        login_panel.add(user_Field);
        user_Field.setColumns(10);

        JLabel pass_label = new JLabel("Password");
        pass_label.setForeground(Color.WHITE);
        pass_label.setFont(new Font("Tahoma", Font.BOLD, 14));
        pass_label.setBounds(10, 50, 80, 14);
        login_panel.add(pass_label);

        JButton signin_button = new JButton("Sign in");
        signin_button.setFont(new Font("Tahoma", Font.BOLD, 11));
        signin_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                ResultSet rs;
                String user_name = user_Field.getText();
                String pass = password_Field.getText();



                if (checkUsername_Cust(user_name) && checkPassword_Cust(pass , user_name)) {
                    JOptionPane.showMessageDialog(null, "Welcome", "Login sucessfull", 2);
                    set_Name(user_name);
                    set_id_Cart(get_Cart_Id());
                    cust_Homepage form = new cust_Homepage();
                    form.setVisible(true);
                    dispose();
                }
                else if (checkUsername_Admin(user_name) && checkPassword_Admin(pass , user_name))
                {
                    JOptionPane.showMessageDialog(null, "Welcome", "Login sucessfull", 2);
                    set_Name(user_name);
                    System form = new System();
                    form.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }


            }
        });

        signin_button.setBounds(47, 131, 89, 23);
        login_panel.add(signin_button);

        JButton signup_button = new JButton("Sign up");
        signup_button.setFont(new Font("Tahoma", Font.BOLD, 11));
        signup_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sign_Up_Gui form = new sign_Up_Gui();
                form.setVisible(true);
                dispose();
            }
        });
        signup_button.setBounds(160, 131, 89, 23);
        login_panel.add(signup_button);

        password_Field = new JPasswordField();
        password_Field.setBounds(114, 48, 160, 20);
        login_panel.add(password_Field);


        show_checkbox.setFont(new Font("Tahoma", Font.BOLD, 10));
        show_checkbox.setBounds(94, 75, 105, 23);
        login_panel.add(show_checkbox);
        show_checkbox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (show_checkbox.isSelected()) {
                    password_Field.setEchoChar((char) 0);
                } else {
                    password_Field.setEchoChar('*');
                }
            }
        });


        JLabel lblNewLabel_2 = new JLabel("ONLINE GROCERY STORE");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(203, 27, 278, 14);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_3.setBounds(0, 0, 700, 450);
        contentPane.add(lblNewLabel_3);
    }


}
