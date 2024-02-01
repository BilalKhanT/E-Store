import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class clothing extends Login {

    public String get_Name(int id)
    {
        String des = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRODUCT_NAME FROM CLOTHING WHERE PRODUCT_ID ="+ id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                // System.out.println("a");
                des = rs.getString("PRODUCT_NAME");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return des;
    }
    public String get_Description(int id)
    {
        String des = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT DESCRIPTION FROM CLOTHING WHERE PRODUCT_ID ="+ id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                // System.out.println("a");
                des = rs.getString("DESCRIPTION");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return des;
    }

    public String get_Price(int id)
    {
        long price = 0;
        String flag;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRICE FROM CLOTHING WHERE PRODUCT_ID ="+ id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                // System.out.println("a");
                price = rs.getLong("PRICE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        flag = String.valueOf(price);
        return flag;
    }
    private JPanel contentPane;
    private JTextField shirt_quantity;
    private JTextField shirt_description_field;
    private JTextField pant_quantity;
    private JTextField pant_description_field;
    private JTextField socks_quantity;
    private JTextField socks_description_field;
    private JTextField coat_quantity;
    private JTextField coat_description_field;

    static int pantcount = 0;
    static int sockcount = 0;
    static int coatcount = 0;
    static int shirtcount = 0;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    clothing frame = new clothing();
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
    public clothing() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation( 250, 30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel shirt_Panel = new JPanel();
        shirt_Panel.setBounds(26, 47, 316, 210);
        contentPane.add(shirt_Panel);
        shirt_Panel.setLayout(null);

        int shirt_Id = 5;
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(64, 0, 64));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\shirt.jpg"));
        lblNewLabel.setBounds(10, 23, 135, 120);
        shirt_Panel.add(lblNewLabel);

        JLabel Price_label = new JLabel("Price:");
        Price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label.setForeground(new Color(64, 0, 64));
        Price_label.setBounds(2, 154, 46, 14);
        shirt_Panel.add(Price_label);

        JLabel shirt_price_label = new JLabel("");
        shirt_price_label.setText(get_Price(shirt_Id));
        shirt_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        shirt_price_label.setBounds(63, 154, 46, 14);
        shirt_Panel.add(shirt_price_label);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setText(get_Name(shirt_Id));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(0, 0, 55, 14);
        shirt_Panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(0, 185, 56, 14);
        shirt_Panel.add(lblNewLabel_2);

        shirt_quantity = new JTextField();
        shirt_quantity.setBounds(59, 182, 39, 20);
        shirt_Panel.add(shirt_quantity);
        shirt_quantity.setColumns(10);

        JButton shirtplus_button = new JButton("+");
        shirtplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (shirtcount <= 9) {
                    shirtcount = shirtcount + 1;
                    shirt_quantity.setText(String.valueOf(shirtcount));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        shirtplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        shirtplus_button.setBounds(108, 181, 46, 23);
        shirt_Panel.add(shirtplus_button);

        JButton shirtminus_button = new JButton("-");
        shirtminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (shirtcount >= 1) {
                    shirtcount = shirtcount - 1;
                    shirt_quantity.setText(String.valueOf(shirtcount));
                }

            }
        });
        shirtminus_button.setBounds(157, 181, 46, 23);
        shirt_Panel.add(shirtminus_button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(157, 44, 143, 99);
        shirt_Panel.add(scrollPane);
        JTextArea shirt_textArea = new JTextArea();
        shirt_textArea.setText(get_Description(shirt_Id));
        shirt_textArea.setEditable(false);
        scrollPane.setViewportView(shirt_textArea);

        JLabel lblNewLabel_3 = new JLabel("Description:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(150, 23, 71, 20);
        shirt_Panel.add(lblNewLabel_3);

        JCheckBox shirt_checkbox = new JCheckBox("Select");
        shirt_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        shirt_checkbox.setBounds(222, 150, 78, 49);
        shirt_Panel.add(shirt_checkbox);

        JPanel pant_Panel = new JPanel();
        pant_Panel.setLayout(null);
        pant_Panel.setBounds(449, 47, 316, 210);
        contentPane.add(pant_Panel);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\pant.jpg"));
        lblNewLabel_4.setBackground(new Color(64, 0, 64));
        lblNewLabel_4.setBounds(10, 23, 135, 120);
        pant_Panel.add(lblNewLabel_4);

        int pant_Id = 6;
        JLabel Price_label_1 = new JLabel("Price:");
        Price_label_1.setForeground(new Color(64, 0, 64));
        Price_label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_1.setBounds(2, 154, 46, 14);
        pant_Panel.add(Price_label_1);

        JLabel pant_price_label = new JLabel("");
        pant_price_label.setText(get_Price(pant_Id));
        pant_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        pant_price_label.setBounds(63, 154, 46, 14);
        pant_Panel.add(pant_price_label);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setText(get_Name(pant_Id));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(0, 0, 85, 14);
        pant_Panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1 = new JLabel("Quantity");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_1.setBounds(0, 185, 56, 14);
        pant_Panel.add(lblNewLabel_2_1);

        pant_quantity = new JTextField();
        pant_quantity.setColumns(10);
        pant_quantity.setBounds(59, 182, 39, 20);
        pant_Panel.add(pant_quantity);


        JButton pantplus_button = new JButton("+");
        pantplus_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (pantcount <= 9) {
                    pantcount = pantcount + 1;
                    pant_quantity.setText(String.valueOf(pantcount));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }

            }
        });
        pantplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        pantplus_button.setBounds(108, 181, 46, 23);
        pant_Panel.add(pantplus_button);

        JButton pantminus_button = new JButton("-");
        pantminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pantcount >= 1){
                    pantcount = pantcount - 1;
                    pant_quantity.setText(String.valueOf(pantcount));

                }

            }
        });
        pantminus_button.setBounds(157, 181, 46, 23);
        pant_Panel.add(pantminus_button);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(155, 43, 145, 100);
        pant_Panel.add(scrollPane_1);
        JTextArea pant_textArea = new JTextArea();
        pant_textArea.setText(get_Description(pant_Id));
        pant_textArea.setEditable(false);
        scrollPane_1.setViewportView(pant_textArea);

        JLabel lblNewLabel_3_1 = new JLabel("Description:");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_1.setBounds(150, 23, 71, 20);
        pant_Panel.add(lblNewLabel_3_1);

        JCheckBox pant_checkbox = new JCheckBox("Select");
        pant_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        pant_checkbox.setBounds(222, 150, 78, 49);
        pant_Panel.add(pant_checkbox);

        JPanel Socks_panel = new JPanel();
        Socks_panel.setLayout(null);
        Socks_panel.setBounds(26, 297, 316, 210);
        contentPane.add(Socks_panel);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\sock.jpg"));
        lblNewLabel_5.setBackground(new Color(64, 0, 64));
        lblNewLabel_5.setBounds(10, 23, 135, 120);
        Socks_panel.add(lblNewLabel_5);

        int sock_Id = 7;
        JLabel Price_label_2 = new JLabel("Price:");
        Price_label_2.setForeground(new Color(64, 0, 64));
        Price_label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2.setBounds(2, 154, 46, 14);
        Socks_panel.add(Price_label_2);

        JLabel phone_price_label = new JLabel("");
        phone_price_label.setText(get_Price(sock_Id));
        phone_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        phone_price_label.setBounds(63, 154, 46, 14);
        Socks_panel.add(phone_price_label);

        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setText(get_Name(sock_Id));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(0, 0, 55, 14);
        Socks_panel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_2_2 = new JLabel("Quantity");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2.setBounds(0, 185, 56, 14);
        Socks_panel.add(lblNewLabel_2_2);

        socks_quantity = new JTextField();
        socks_quantity.setColumns(10);
        socks_quantity.setBounds(59, 182, 39, 20);
        Socks_panel.add(socks_quantity);

        JButton socksplus_button = new JButton("+");
        socksplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sockcount <= 9) {
                    sockcount = sockcount + 1;
                    socks_quantity.setText(String.valueOf(sockcount));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }


            }
        });
        socksplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        socksplus_button.setBounds(108, 181, 46, 23);
        Socks_panel.add(socksplus_button);

        JButton socksminus_button = new JButton("-");
        socksminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sockcount >= 1) {
                    sockcount = sockcount -1;
                    socks_quantity.setText(String.valueOf(sockcount));
                }

            }
        });
        socksminus_button.setBounds(157, 181, 46, 23);
        Socks_panel.add(socksminus_button);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(155, 43, 145, 100);
        Socks_panel.add(scrollPane_2);
        JTextArea socks_textArea = new JTextArea();
        socks_textArea.setText(get_Description(sock_Id));
        socks_textArea.setEditable(false);
        scrollPane_2.setViewportView(socks_textArea);

        JLabel lblNewLabel_3_2 = new JLabel("Description:");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2.setBounds(150, 23, 71, 20);
        Socks_panel.add(lblNewLabel_3_2);

        JCheckBox socks_checkbox = new JCheckBox("Select");
        socks_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        socks_checkbox.setBounds(222, 150, 78, 49);
        Socks_panel.add(socks_checkbox);

        JPanel laptop_panel = new JPanel();
        laptop_panel.setLayout(null);
        laptop_panel.setBounds(449, 297, 316, 210);
        contentPane.add(laptop_panel);

        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\coat.jpg"));
        lblNewLabel_5_1.setBackground(new Color(64, 0, 64));
        lblNewLabel_5_1.setBounds(10, 23, 135, 120);
        laptop_panel.add(lblNewLabel_5_1);

        int coat_Id = 8;
        JLabel Price_label_2_1 = new JLabel("Price:");
        Price_label_2_1.setForeground(new Color(64, 0, 64));
        Price_label_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2_1.setBounds(2, 154, 46, 14);
        laptop_panel.add(Price_label_2_1);

        JLabel laptop_price_label = new JLabel("");
        laptop_price_label.setText(get_Price(coat_Id));
        laptop_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        laptop_price_label.setBounds(63, 154, 46, 14);
        laptop_panel.add(laptop_price_label);

        JLabel lblNewLabel_1_2_1 = new JLabel("");
        lblNewLabel_1_2_1.setText(get_Name(coat_Id));
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2_1.setBounds(0, 0, 55, 14);
        laptop_panel.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_2_2_1 = new JLabel("Quantity");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2_1.setBounds(0, 185, 56, 14);
        laptop_panel.add(lblNewLabel_2_2_1);

        coat_quantity = new JTextField();
        coat_quantity.setColumns(10);
        coat_quantity.setBounds(59, 182, 39, 20);
        laptop_panel.add(coat_quantity);

        JButton coatplus_button = new JButton("+");
        coatplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (coatcount <= 9) {
                    coatcount = coatcount + 1;
                    coat_quantity.setText(String.valueOf(coatcount));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }


            }
        });
        coatplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        coatplus_button.setBounds(108, 181, 46, 23);
        laptop_panel.add(coatplus_button);

        JButton coatminus_button = new JButton("-");
        coatminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (coatcount >= 1) {
                    coatcount = coatcount - 1;
                    coat_quantity.setText(String.valueOf(coatcount));
                }

            }
        });
        coatminus_button.setBounds(157, 181, 46, 23);
        laptop_panel.add(coatminus_button);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(157, 48, 143, 95);
        laptop_panel.add(scrollPane_3);
        JTextArea coat_textArea = new JTextArea();
        coat_textArea.setText(get_Description(coat_Id));
        coat_textArea.setEditable(false);
        scrollPane_3.setViewportView(coat_textArea);

        JLabel lblNewLabel_3_2_1 = new JLabel("Description:");
        lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2_1.setBounds(150, 23, 71, 20);
        laptop_panel.add(lblNewLabel_3_2_1);

        JCheckBox coat_checkbox = new JCheckBox("Select");
        coat_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        coat_checkbox.setBounds(222, 150, 78, 49);
        laptop_panel.add(coat_checkbox);

        JLabel lblNewLabel_6 = new JLabel("CLOTHING ");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(332, 0, 126, 25);
        contentPane.add(lblNewLabel_6);

        JButton back_button = new JButton("Back");
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shop frame = new shop();
                frame.setVisible(true);
                dispose();
            }
        });
        back_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_button.setBounds(26, 562, 89, 38);
        contentPane.add(back_button);

        JButton addtocart_button = new JButton("Add to Cart");
        addtocart_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int cart_id = get_id_Cart();
                String cust_name = get_Name();
                int p_Id = 0;
                String p_Name = "";
                String quan = "";
                int quant = 0;
                String type = "";

                if (shirt_checkbox.isSelected())
                {
                    p_Id = 5;
                    p_Name = lblNewLabel_1.getText();
                    quan = shirt_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Clothing";

                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    String user = "maindb";
                    String pass = "bilal";
                    Connection con = null;
                    String sql = "INSERT INTO CART VALUES("+ cart_id +",'"+ cust_name +"',"+ p_Id +",'"+ p_Name +"',"+ quan +",'"+ type +"')";
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

                    } catch (SQLException en) {
                        throw new RuntimeException(en);
                    } catch (ClassNotFoundException en) {
                        throw new RuntimeException(en);
                    }
                }
                if (pant_checkbox.isSelected())
                {
                    p_Id = 6;
                    p_Name = lblNewLabel_1_1.getText();
                    quan = pant_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Clothing";

                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    String user = "maindb";
                    String pass = "bilal";
                    Connection con = null;
                    String sql = "INSERT INTO CART VALUES("+ cart_id +",'"+ cust_name +"',"+ p_Id +",'"+ p_Name +"',"+ quan +",'"+ type +"')";
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

                    } catch (SQLException ep) {
                        throw new RuntimeException(ep);
                    } catch (ClassNotFoundException ep) {
                        throw new RuntimeException(ep);
                    }

                }
                if (socks_checkbox.isSelected())
                {
                    p_Id = 7;
                    p_Name = lblNewLabel_1_2.getText();
                    quan = socks_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Clothing";

                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    String user = "maindb";
                    String pass = "bilal";
                    Connection con = null;
                    String sql = "INSERT INTO CART VALUES("+ cart_id +",'"+ cust_name +"',"+ p_Id +",'"+ p_Name +"',"+ quan +",'"+ type +"')";
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

                    } catch (SQLException ea) {
                        throw new RuntimeException(ea);
                    } catch (ClassNotFoundException ea) {
                        throw new RuntimeException(ea);
                    }
                }
                if (coat_checkbox.isSelected())
                {
                    p_Id = 8;
                    p_Name = lblNewLabel_1_2_1.getText();
                    quan = coat_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Clothing";

                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    String user = "maindb";
                    String pass = "bilal";
                    Connection con = null;
                    String sql = "INSERT INTO CART VALUES("+ cart_id +",'"+ cust_name +"',"+ p_Id +",'"+ p_Name +"',"+ quan +",'"+ type +"')";
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

                    } catch (SQLException eb) {
                        throw new RuntimeException(eb);
                    } catch (ClassNotFoundException eb) {
                        throw new RuntimeException(eb);
                    }
                }
            }
        });
        addtocart_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        addtocart_button.setBounds(663, 562, 112, 38);
        contentPane.add(addtocart_button);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel_7);
    }
}
