import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class emp_Registeration extends JFrame {

    public String get_User_Id()
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT USER_ID FROM EMPLOYEE";
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
    public void add_Department(String name, String depart_Name)
    {
        int id = 0;
        if (depart_Name.equals("Finance"))
            id = 1;
        else if (depart_Name.equals("Inventory"))
            id = 2;
        else
            id = 3;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO DEPARTMENT VALUES('"+ depart_Name +"',"+ id +",'"+ name +"')";
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

    public void add_Employee(String name, int id, String password, String mail, long phone, String gender, String role, long salary, String date, String depart)  {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO EMPLOYEE VALUES('"+ name +"',"+ id +",'"+ password +"','"+ mail +"',"+ phone +",'"+ gender +"','"+ role +"',"+ salary +",'"+ date +"','"+ depart +"')";
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

    public void add_Staff(String name, int id, String password, String mail, long phone, String gender, String role, long salary, String date, String depart)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO STAFF VALUES('"+ name +"','"+ password +"','"+ mail +"',"+ phone +",'"+ gender +"',"+ salary +",'"+ date +"','"+ depart +"','"+ id +"')";
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

    public void add_Cashier(String name, int id, String password, String mail, long phone, String gender, String role, long salary, String date, String depart)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO CASHIER VALUES('"+ name +"','"+ password +"','"+ mail +"',"+ phone +",'"+ gender +"',"+ salary +",'"+ date +"','"+ depart +"','"+ id +"')";
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

    public void add_Manager(String name, int id, String password, String mail, long phone, String gender, String role, long salary, String date, String depart) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO MANAGER VALUES('"+ name +"',"+ id +",'"+ password +"','"+ mail +"',"+ phone +",'"+ gender +"',"+ salary +",'"+ date +"','"+ depart +"')";
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
    private JPanel contentPane;
    private JTextField id_Field;
    private JTextField name_Field;
    private JTextField pass_Field;
    private JTextField mail_Field;
    private JTextField contact_Field;
    private JTextField date_Field;
    private JTextField salary_Field;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    emp_Registeration frame = new emp_Registeration();
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
    public emp_Registeration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("Employee Registeration");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
        title_Label.setBounds(318, 11, 216, 20);
        contentPane.add(title_Label);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(197, 60, 444, 453);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel id_Label = new JLabel("User ID");
        id_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        id_Label.setBounds(33, 21, 93, 14);
        panel.add(id_Label);

        JLabel name_Label = new JLabel("User Name");
        name_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        name_Label.setBounds(33, 62, 93, 14);
        panel.add(name_Label);

        JLabel pass_Label = new JLabel("Password");
        pass_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        pass_Label.setBounds(33, 100, 93, 14);
        panel.add(pass_Label);

        JLabel mail_Label = new JLabel("Email");
        mail_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        mail_Label.setBounds(33, 136, 93, 14);
        panel.add(mail_Label);

        JLabel contact_Label = new JLabel("Contact");
        contact_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        contact_Label.setBounds(33, 176, 93, 14);
        panel.add(contact_Label);

        JLabel join_Label = new JLabel("Join Date");
        join_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        join_Label.setBounds(33, 212, 93, 14);
        panel.add(join_Label);

        JLabel salary_Label = new JLabel("Salary");
        salary_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        salary_Label.setBounds(33, 253, 77, 14);
        panel.add(salary_Label);

        JLabel gender_Label = new JLabel("Gender");
        gender_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        gender_Label.setBounds(33, 296, 77, 14);
        panel.add(gender_Label);

        JLabel role_Label = new JLabel("Role");
        role_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        role_Label.setBounds(33, 337, 77, 14);
        panel.add(role_Label);

        JLabel depart_Label = new JLabel("Department");
        depart_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        depart_Label.setBounds(33, 376, 93, 14);
        panel.add(depart_Label);

        id_Field = new JTextField();
        id_Field.setText(get_User_Id());
        id_Field.setEditable(false);
        id_Field.setBounds(159, 19, 190, 20);
        panel.add(id_Field);
        id_Field.setColumns(10);

        name_Field = new JTextField();
        name_Field.setBounds(159, 60, 190, 20);
        panel.add(name_Field);
        name_Field.setColumns(10);

        pass_Field = new JTextField();
        pass_Field.setBounds(159, 98, 190, 20);
        panel.add(pass_Field);
        pass_Field.setColumns(10);

        mail_Field = new JTextField();
        mail_Field.setBounds(159, 134, 190, 20);
        panel.add(mail_Field);
        mail_Field.setColumns(10);

        contact_Field = new JTextField();
        contact_Field.setBounds(159, 174, 190, 20);
        panel.add(contact_Field);
        contact_Field.setColumns(10);

        date_Field = new JTextField();
        date_Field.setBounds(159, 210, 190, 20);
        panel.add(date_Field);
        date_Field.setColumns(10);

        salary_Field = new JTextField();
        salary_Field.setBounds(157, 251, 192, 20);
        panel.add(salary_Field);
        salary_Field.setColumns(10);

        JComboBox gender_Combo = new JComboBox();
        gender_Combo.setFont(new Font("Tahoma", Font.BOLD, 12));
        gender_Combo.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
        gender_Combo.setBounds(159, 293, 93, 22);
        panel.add(gender_Combo);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Staff","Cashier"}));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        comboBox.setBounds(159, 334, 93, 22);
        panel.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Finance", "Inventory", "Store"}));
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        comboBox_1.setBounds(159, 373, 93, 22);
        panel.add(comboBox_1);

        JButton back_Button = new JButton("< Previous");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System frame = new System();
                frame.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_Button.setBounds(28, 566, 122, 23);
        contentPane.add(back_Button);

        JButton register_Button = new JButton("Register");
        register_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = id_Field.getText();
                String name = name_Field.getText();
                String password = pass_Field.getText();
                String mail = mail_Field.getText();
                String contact = contact_Field.getText();
                String date = date_Field.getText();
                String salary = salary_Field.getText();
                String gender = (String) gender_Combo.getSelectedItem();
                String role = (String) comboBox.getSelectedItem();
                String depart = (String) comboBox_1.getSelectedItem();

                int id_Int = Integer.parseInt(id);
                long phone = Long.parseLong(contact);
                long salary_L = Long.parseLong(salary);
                add_Input(id_Int, name, password, mail, phone, gender);
                add_Employee(name,id_Int,password,mail,phone,gender,role,salary_L,date,depart);
                if (role.equals("Manager"))
                {
                    add_Manager(name,id_Int,password,mail,phone,gender,role,salary_L,date,depart);
                }
                else if (role.equals("Cashier"))
                {
                    add_Cashier(name,id_Int,password,mail,phone,gender,role,salary_L,date,depart);
                }
                else
                {
                    add_Staff(name,id_Int,password,mail,phone,gender,role,salary_L,date,depart);
                }
                add_Department(name,depart);



            }
        });
        register_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        register_Button.setBounds(735, 567, 89, 23);
        contentPane.add(register_Button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel);
    }
}

