import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class food extends Login {



    public void delete_R(int id)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "DELETE FROM CART WHERE CART_ID="+ id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String get_Name(int id)
    {
        String des = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRODUCT_NAME FROM FOOD WHERE PRODUCT_ID ="+ id +"";
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
        String sql = "SELECT DESCRIPTION FROM FOOD WHERE PRODUCT_ID ="+ id +"";
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
        String sql = "SELECT PRICE FROM FOOD WHERE PRODUCT_ID ="+ id +"";
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
    private JTextField olive_quantity;
    private JTextField olive_description_field;
    private JTextField milk_quantity;
    private JTextField milk_description_field;
    private JTextField rice_quantity;
    private JTextField rice_description_field;
    private JTextField sugar_quantity;
    private JTextField sugar_description_field;
    JCheckBox olive_checkbox = new JCheckBox("Select");
    JLabel lblNewLabel_1 = new JLabel("");
    JLabel lblNewLabel_1_1 = new JLabel("");
    JLabel lblNewLabel_1_2 = new JLabel("");
    JLabel lblNewLabel_1_2_1 = new JLabel("");

    static int olive_Count = 0;
    static int milk_Count = 0;
    static int rice_Count = 0;
    static int sugar_Count = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    food frame = new food();
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
    public food() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation( 250, 30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel Olive_Panel = new JPanel();
        Olive_Panel.setBounds(26, 47, 316, 210);
        contentPane.add(Olive_Panel);
        Olive_Panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(64, 0, 64));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\Olive.jpeg"));
        lblNewLabel.setBounds(10, 23, 135, 120);
        Olive_Panel.add(lblNewLabel);

        JLabel Price_label = new JLabel("Price:");
        Price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label.setForeground(new Color(64, 0, 64));
        Price_label.setBounds(2, 154, 46, 14);
        Olive_Panel.add(Price_label);

        int olive_id = 1;
        JLabel olive_price_label = new JLabel("");
        olive_price_label.setText(get_Price(olive_id));
        olive_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        olive_price_label.setBounds(63, 154, 46, 14);
        Olive_Panel.add(olive_price_label);


        lblNewLabel_1.setText(get_Name(olive_id));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(0, 0, 55, 14);
        Olive_Panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(0, 185, 56, 14);
        Olive_Panel.add(lblNewLabel_2);

        olive_quantity = new JTextField();
        olive_quantity.setBounds(59, 182, 39, 20);
        Olive_Panel.add(olive_quantity);
        olive_quantity.setColumns(10);

        JButton oliveplus_button = new JButton("+");
        oliveplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (olive_Count <= 9) {
                    olive_Count = olive_Count + 1;
                    olive_quantity.setText(String.valueOf(olive_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        oliveplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        oliveplus_button.setBounds(108, 181, 46, 23);
        Olive_Panel.add(oliveplus_button);

        JButton oliveminus_button = new JButton("-");
        oliveminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (olive_Count >= 1) {
                    olive_Count = olive_Count - 1;
                    olive_quantity.setText(String.valueOf(olive_Count));
                }
            }
        });
        oliveminus_button.setBounds(157, 181, 46, 23);
        Olive_Panel.add(oliveminus_button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(157, 44, 143, 99);
        Olive_Panel.add(scrollPane);
        JTextArea olive_textArea = new JTextArea();
        olive_textArea.setText(get_Description(olive_id));
        olive_textArea.setEditable(false);
        scrollPane.setViewportView(olive_textArea);

        JLabel lblNewLabel_3 = new JLabel("Description:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(150, 23, 71, 20);
        Olive_Panel.add(lblNewLabel_3);


        olive_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        olive_checkbox.setBounds(222, 150, 78, 49);
        Olive_Panel.add(olive_checkbox);

        JPanel Milk_Panel = new JPanel();
        Milk_Panel.setLayout(null);
        Milk_Panel.setBounds(449, 47, 316, 210);
        contentPane.add(Milk_Panel);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\nestle.png"));
        lblNewLabel_4.setBackground(new Color(64, 0, 64));
        lblNewLabel_4.setBounds(10, 23, 135, 120);
        Milk_Panel.add(lblNewLabel_4);

        int milk_Id = 2;
        JLabel Price_label_1 = new JLabel("Price:");
        Price_label_1.setForeground(new Color(64, 0, 64));
        Price_label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_1.setBounds(2, 154, 46, 14);
        Milk_Panel.add(Price_label_1);

        JLabel milk_price_label = new JLabel("");
        milk_price_label.setText(get_Price(milk_Id));
        milk_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        milk_price_label.setBounds(63, 154, 46, 14);
        Milk_Panel.add(milk_price_label);


        lblNewLabel_1_1.setText(get_Name(milk_Id));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(0, 0, 55, 14);
        Milk_Panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1 = new JLabel("Quantity");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_1.setBounds(0, 185, 56, 14);
        Milk_Panel.add(lblNewLabel_2_1);

        milk_quantity = new JTextField();
        milk_quantity.setColumns(10);
        milk_quantity.setBounds(59, 182, 39, 20);
        Milk_Panel.add(milk_quantity);

        JButton milkplus_button = new JButton("+");
        milkplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (milk_Count <= 9) {
                    milk_Count = milk_Count + 1;
                    milk_quantity.setText(String.valueOf(milk_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        milkplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        milkplus_button.setBounds(108, 181, 46, 23);
        Milk_Panel.add(milkplus_button);

        JButton milkminus_button = new JButton("-");
        milkminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (milk_Count >= 1) {
                    milk_Count = milk_Count - 1;
                    milk_quantity.setText(String.valueOf(milk_Count));
                }
            }
        });
        milkminus_button.setBounds(157, 181, 46, 23);
        Milk_Panel.add(milkminus_button);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(155, 43, 145, 100);
        Milk_Panel.add(scrollPane_1);
        JTextArea milk_textArea = new JTextArea();
        milk_textArea.setText(get_Description(milk_Id));
        milk_textArea.setEditable(false);
        scrollPane_1.setViewportView(milk_textArea);

        JLabel lblNewLabel_3_1 = new JLabel("Description:");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_1.setBounds(150, 23, 71, 20);
        Milk_Panel.add(lblNewLabel_3_1);

        JCheckBox milk_checkbox = new JCheckBox("Select");
        milk_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        milk_checkbox.setBounds(222, 150, 78, 49);
        Milk_Panel.add(milk_checkbox);

        JPanel rice_panel = new JPanel();
        rice_panel.setLayout(null);
        rice_panel.setBounds(26, 297, 316, 210);
        contentPane.add(rice_panel);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\rice1.jpeg"));
        lblNewLabel_5.setBackground(new Color(64, 0, 64));
        lblNewLabel_5.setBounds(10, 23, 135, 120);
        rice_panel.add(lblNewLabel_5);

        int rice_Id = 3;
        JLabel Price_label_2 = new JLabel("Price:");
        Price_label_2.setForeground(new Color(64, 0, 64));
        Price_label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2.setBounds(2, 154, 46, 14);
        rice_panel.add(Price_label_2);

        JLabel rice_price_label = new JLabel("");
        rice_price_label.setText(get_Price(rice_Id));
        rice_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        rice_price_label.setBounds(63, 154, 46, 14);
        rice_panel.add(rice_price_label);


        lblNewLabel_1_2.setText(get_Name(rice_Id));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(0, 0, 55, 14);
        rice_panel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_2_2 = new JLabel("Quantity");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2.setBounds(0, 185, 56, 14);
        rice_panel.add(lblNewLabel_2_2);

        rice_quantity = new JTextField();
        rice_quantity.setColumns(10);
        rice_quantity.setBounds(59, 182, 39, 20);
        rice_panel.add(rice_quantity);

        JButton riceplus_button = new JButton("+");
        riceplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rice_Count <= 9) {
                    rice_Count = rice_Count + 1;
                    rice_quantity.setText(String.valueOf(rice_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        riceplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        riceplus_button.setBounds(108, 181, 46, 23);
        rice_panel.add(riceplus_button);

        JButton riceminus_button = new JButton("-");
        riceminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rice_Count >= 1) {
                    rice_Count = rice_Count - 1;
                    rice_quantity.setText(String.valueOf(rice_Count));
                }
            }
        });
        riceminus_button.setBounds(157, 181, 46, 23);
        rice_panel.add(riceminus_button);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(155, 43, 145, 100);
        rice_panel.add(scrollPane_2);
        JTextArea rice_textArea = new JTextArea();
        rice_textArea.setText(get_Description(rice_Id));
        rice_textArea.setEditable(false);
        scrollPane_2.setViewportView(rice_textArea);

        JLabel lblNewLabel_3_2 = new JLabel("Description:");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2.setBounds(150, 23, 71, 20);
        rice_panel.add(lblNewLabel_3_2);

        JCheckBox rice_checkbox = new JCheckBox("Select");
        rice_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        rice_checkbox.setBounds(222, 150, 78, 49);
        rice_panel.add(rice_checkbox);

        JPanel sugar_panel = new JPanel();
        sugar_panel.setLayout(null);
        sugar_panel.setBounds(449, 297, 316, 210);
        contentPane.add(sugar_panel);

        int sugar_Id = 4;
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\sugar.jpg"));
        lblNewLabel_5_1.setBackground(new Color(64, 0, 64));
        lblNewLabel_5_1.setBounds(10, 23, 135, 120);
        sugar_panel.add(lblNewLabel_5_1);

        JLabel Price_label_2_1 = new JLabel("Price:");
        Price_label_2_1.setForeground(new Color(64, 0, 64));
        Price_label_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2_1.setBounds(2, 154, 46, 14);
        sugar_panel.add(Price_label_2_1);

        JLabel sugar_price_label = new JLabel("");
        sugar_price_label.setText(get_Price(sugar_Id));
        sugar_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        sugar_price_label.setBounds(63, 154, 46, 14);
        sugar_panel.add(sugar_price_label);


        lblNewLabel_1_2_1.setText(get_Name(sugar_Id));
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2_1.setBounds(0, 0, 55, 14);
        sugar_panel.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_2_2_1 = new JLabel("Quantity");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2_1.setBounds(0, 185, 56, 14);
        sugar_panel.add(lblNewLabel_2_2_1);

        sugar_quantity = new JTextField();
        sugar_quantity.setColumns(10);
        sugar_quantity.setBounds(59, 182, 39, 20);
        sugar_panel.add(sugar_quantity);

        JButton sugarplus_button = new JButton("+");
        sugarplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sugar_Count <= 9) {
                    sugar_Count = sugar_Count + 1;
                    sugar_quantity.setText(String.valueOf(sugar_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        sugarplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        sugarplus_button.setBounds(108, 181, 46, 23);
        sugar_panel.add(sugarplus_button);

        JButton sugarminus_button = new JButton("-");
        sugarminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sugar_Count >= 1) {
                    sugar_Count = sugar_Count - 1;
                    sugar_quantity.setText(String.valueOf(sugar_Count));
                }
            }
        });
        sugarminus_button.setBounds(157, 181, 46, 23);
        sugar_panel.add(sugarminus_button);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(157, 48, 143, 95);
        sugar_panel.add(scrollPane_3);
        JTextArea sugar_textArea = new JTextArea();
        sugar_textArea.setText(get_Description(sugar_Id));
        sugar_textArea.setEditable(false);
        scrollPane_3.setViewportView(sugar_textArea);

        JLabel lblNewLabel_3_2_1 = new JLabel("Description:");
        lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2_1.setBounds(150, 23, 71, 20);
        sugar_panel.add(lblNewLabel_3_2_1);

        JCheckBox sugar_checkbox = new JCheckBox("Select");
        sugar_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        sugar_checkbox.setBounds(222, 150, 78, 49);
        sugar_panel.add(sugar_checkbox);

        JLabel lblNewLabel_6 = new JLabel("FOODS");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(345, 0, 84, 25);
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

                if (olive_checkbox.isSelected())
                {
                    p_Id = 1;
                    p_Name = lblNewLabel_1.getText();
                    quan = olive_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Food";

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
                if (milk_checkbox.isSelected())
                {
                    p_Id = 2;
                    p_Name = lblNewLabel_1_1.getText();
                    quan = milk_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Food";

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
                if (rice_checkbox.isSelected())
                {
                    p_Id = 3;
                    p_Name = lblNewLabel_1_2.getText();
                    quan = rice_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Food";

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
                if (sugar_checkbox.isSelected())
                {
                    p_Id = 4;
                    p_Name = lblNewLabel_1_2_1.getText();
                    quan = sugar_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Food";

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

