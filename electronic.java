import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class electronic extends Login {
    public String get_Name(int id)
    {
        String des = "";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRODUCT_NAME FROM ELECTRONICS WHERE PRODUCT_ID ="+ id +"";
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
        String sql = "SELECT DESCRIPTION FROM ELECTRONICS WHERE PRODUCT_ID ="+ id +"";
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
        String sql = "SELECT PRICE FROM ELECTRONICS WHERE PRODUCT_ID ="+ id +"";
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
    private JTextField ipad_quantity;
    private JTextField ipad_description_field;
    private JTextField earphones_quantity;
    private JTextField earphone_description_field;
    private JTextField phone_quantity;
    private JTextField phone_description_field;
    private JTextField laptop_quantity;
    private JTextField laptop_description_field;

    static int ipad_Count = 0;
    static int head_Count = 0;
    static int phone_Count = 0;
    static int laptop_Count = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    electronic frame = new electronic();
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
    public electronic() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation( 250, 30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel ipad_Panel = new JPanel();
        ipad_Panel.setBounds(26, 47, 316, 210);
        contentPane.add(ipad_Panel);
        ipad_Panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(64, 0, 64));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\pad.jpg"));
        lblNewLabel.setBounds(10, 23, 135, 120);
        ipad_Panel.add(lblNewLabel);

        int ipad_Id = 9;
        JLabel Price_label = new JLabel("Price:");
        Price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label.setForeground(new Color(64, 0, 64));
        Price_label.setBounds(2, 154, 46, 14);
        ipad_Panel.add(Price_label);

        JLabel ipad_price_label = new JLabel(get_Price(ipad_Id));
        ipad_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        ipad_price_label.setBounds(63, 154, 46, 14);
        ipad_Panel.add(ipad_price_label);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setText(get_Name(ipad_Id));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(0, 0, 55, 14);
        ipad_Panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(0, 185, 56, 14);
        ipad_Panel.add(lblNewLabel_2);

        ipad_quantity = new JTextField();
        ipad_quantity.setBounds(59, 182, 39, 20);
        ipad_Panel.add(ipad_quantity);
        ipad_quantity.setColumns(10);

        JButton ipadplus_button = new JButton("+");
        ipadplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ipad_Count <= 9) {
                    ipad_Count = ipad_Count + 1;
                    ipad_quantity.setText(String.valueOf(ipad_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        ipadplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        ipadplus_button.setBounds(108, 181, 46, 23);
        ipad_Panel.add(ipadplus_button);

        JButton ipadminus_button = new JButton("-");
        ipadminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ipad_Count >= 1) {
                    ipad_Count = ipad_Count - 1;
                    ipad_quantity.setText(String.valueOf(ipad_Count));
                }
            }
        });
        ipadminus_button.setBounds(157, 181, 46, 23);
        ipad_Panel.add(ipadminus_button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(157, 44, 143, 99);
        ipad_Panel.add(scrollPane);
        JTextArea ipad_textArea = new JTextArea();
        ipad_textArea.setText(get_Description(ipad_Id));
        ipad_textArea.setEditable(false);
        scrollPane.setViewportView(ipad_textArea);

        JLabel lblNewLabel_3 = new JLabel("Description:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(150, 23, 71, 20);
        ipad_Panel.add(lblNewLabel_3);

        JCheckBox ipad_checkbox = new JCheckBox("Select");
        ipad_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        ipad_checkbox.setBounds(222, 150, 78, 49);
        ipad_Panel.add(ipad_checkbox);

        JPanel earphones_Panel = new JPanel();
        earphones_Panel.setLayout(null);
        earphones_Panel.setBounds(449, 47, 316, 210);
        contentPane.add(earphones_Panel);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\head.jpeg"));
        lblNewLabel_4.setBackground(new Color(64, 0, 64));
        lblNewLabel_4.setBounds(10, 23, 135, 120);
        earphones_Panel.add(lblNewLabel_4);

        int head_Id = 10;
        JLabel Price_label_1 = new JLabel("Price:");
        Price_label_1.setForeground(new Color(64, 0, 64));
        Price_label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_1.setBounds(2, 154, 46, 14);
        earphones_Panel.add(Price_label_1);

        JLabel earphone_price_label = new JLabel("");
        earphone_price_label.setText(get_Price(head_Id));
        earphone_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        earphone_price_label.setBounds(63, 154, 46, 14);
        earphones_Panel.add(earphone_price_label);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setText(get_Name(head_Id));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(0, 0, 85, 14);
        earphones_Panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1 = new JLabel("Quantity");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_1.setBounds(0, 185, 56, 14);
        earphones_Panel.add(lblNewLabel_2_1);

        earphones_quantity = new JTextField();
        earphones_quantity.setColumns(10);
        earphones_quantity.setBounds(59, 182, 39, 20);
        earphones_Panel.add(earphones_quantity);

        JButton earphoneplus_button = new JButton("+");
        earphoneplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (head_Count <= 9) {
                    head_Count = head_Count + 1;
                    earphones_quantity.setText(String.valueOf(head_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        earphoneplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        earphoneplus_button.setBounds(108, 181, 46, 23);
        earphones_Panel.add(earphoneplus_button);

        JButton earphoneminus_button = new JButton("-");
        earphoneminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (head_Count >= 1) {
                    head_Count = head_Count - 1;
                    earphones_quantity.setText(String.valueOf(head_Count));
                }
            }
        });
        earphoneminus_button.setBounds(157, 181, 46, 23);
        earphones_Panel.add(earphoneminus_button);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(155, 43, 145, 100);
        earphones_Panel.add(scrollPane_1);
        JTextArea head_textArea = new JTextArea();
        head_textArea.setText(get_Description(head_Id));
        head_textArea.setEditable(false);
        scrollPane_1.setViewportView(head_textArea);

        JLabel lblNewLabel_3_1 = new JLabel("Description:");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_1.setBounds(150, 23, 71, 20);
        earphones_Panel.add(lblNewLabel_3_1);

        JCheckBox earphone_checkbox = new JCheckBox("Select");
        earphone_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        earphone_checkbox.setBounds(222, 150, 78, 49);
        earphones_Panel.add(earphone_checkbox);

        JPanel phone_panel = new JPanel();
        phone_panel.setLayout(null);
        phone_panel.setBounds(26, 297, 316, 210);
        contentPane.add(phone_panel);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\phone.jpg"));
        lblNewLabel_5.setBackground(new Color(64, 0, 64));
        lblNewLabel_5.setBounds(10, 23, 135, 120);
        phone_panel.add(lblNewLabel_5);

        int phone_Id = 11;
        JLabel Price_label_2 = new JLabel("Price:");
        Price_label_2.setForeground(new Color(64, 0, 64));
        Price_label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2.setBounds(2, 154, 46, 14);
        phone_panel.add(Price_label_2);

        JLabel phone_price_label = new JLabel("");
        phone_price_label.setText(get_Price(phone_Id));
        phone_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        phone_price_label.setBounds(63, 154, 46, 14);
        phone_panel.add(phone_price_label);

        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setText(get_Name(phone_Id));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(0, 0, 55, 14);
        phone_panel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_2_2 = new JLabel("Quantity");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2.setBounds(0, 185, 56, 14);
        phone_panel.add(lblNewLabel_2_2);

        phone_quantity = new JTextField();
        phone_quantity.setColumns(10);
        phone_quantity.setBounds(59, 182, 39, 20);
        phone_panel.add(phone_quantity);

        JButton phoneplus_button = new JButton("+");
        phoneplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (phone_Count <= 9) {
                    phone_Count = phone_Count + 1;
                    phone_quantity.setText(String.valueOf(phone_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        phoneplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        phoneplus_button.setBounds(108, 181, 46, 23);
        phone_panel.add(phoneplus_button);

        JButton phoneminus_button = new JButton("-");
        phoneminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (phone_Count >= 1) {
                    phone_Count = phone_Count - 1;
                    phone_quantity.setText(String.valueOf(phone_Count));
                }
            }
        });
        phoneminus_button.setBounds(157, 181, 46, 23);
        phone_panel.add(phoneminus_button);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(155, 43, 145, 100);
        phone_panel.add(scrollPane_2);
        JTextArea phone_textArea = new JTextArea();
        phone_textArea.setText(get_Description(phone_Id));
        phone_textArea.setEditable(false);
        scrollPane_2.setViewportView(phone_textArea);

        JLabel lblNewLabel_3_2 = new JLabel("Description:");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2.setBounds(150, 23, 71, 20);
        phone_panel.add(lblNewLabel_3_2);

        JCheckBox rice_checkbox = new JCheckBox("Select");
        rice_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        rice_checkbox.setBounds(222, 150, 78, 49);
        phone_panel.add(rice_checkbox);

        JPanel laptop_panel = new JPanel();
        laptop_panel.setLayout(null);
        laptop_panel.setBounds(449, 297, 316, 210);
        contentPane.add(laptop_panel);

        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\lap.jpg"));
        lblNewLabel_5_1.setBackground(new Color(64, 0, 64));
        lblNewLabel_5_1.setBounds(10, 23, 135, 120);
        laptop_panel.add(lblNewLabel_5_1);

        int lap_Id = 12;
        JLabel Price_label_2_1 = new JLabel("Price:");
        Price_label_2_1.setForeground(new Color(64, 0, 64));
        Price_label_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        Price_label_2_1.setBounds(2, 154, 46, 14);
        laptop_panel.add(Price_label_2_1);

        JLabel laptop_price_label = new JLabel("");
        laptop_price_label.setText(get_Price(lap_Id));
        laptop_price_label.setFont(new Font("Tahoma", Font.BOLD, 11));
        laptop_price_label.setBounds(63, 154, 46, 14);
        laptop_panel.add(laptop_price_label);

        JLabel lblNewLabel_1_2_1 = new JLabel("");
        lblNewLabel_1_2_1.setText(get_Name(lap_Id));
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2_1.setBounds(0, 0, 55, 14);
        laptop_panel.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_2_2_1 = new JLabel("Quantity");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2_1.setBounds(0, 185, 56, 14);
        laptop_panel.add(lblNewLabel_2_2_1);

        laptop_quantity = new JTextField();
        laptop_quantity.setColumns(10);
        laptop_quantity.setBounds(59, 182, 39, 20);
        laptop_panel.add(laptop_quantity);

        JButton laptopplus_button = new JButton("+");
        laptopplus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (laptop_Count <= 9) {
                    laptop_Count = laptop_Count + 1;
                    laptop_quantity.setText(String.valueOf(laptop_Count));
                }
                else {
                    JOptionPane.showMessageDialog(null, "The Limited Quantity you can choose is 10", "Limit Exceed", 2);
                }
            }
        });
        laptopplus_button.setFont(new Font("Tahoma", Font.PLAIN, 9));
        laptopplus_button.setBounds(108, 181, 46, 23);
        laptop_panel.add(laptopplus_button);

        JButton laptopminus_button = new JButton("-");
        laptopminus_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (laptop_Count >= 1) {
                    laptop_Count = laptop_Count - 1;
                    laptop_quantity.setText(String.valueOf(laptop_Count));
                }
            }
        });
        laptopminus_button.setBounds(157, 181, 46, 23);
        laptop_panel.add(laptopminus_button);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(157, 48, 143, 95);
        laptop_panel.add(scrollPane_3);
        JTextArea lap_textArea = new JTextArea();
        lap_textArea.setText(get_Description(lap_Id));
        lap_textArea.setEditable(false);
        scrollPane_3.setViewportView(lap_textArea);

        JLabel lblNewLabel_3_2_1 = new JLabel("Description:");
        lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3_2_1.setBounds(150, 23, 71, 20);
        laptop_panel.add(lblNewLabel_3_2_1);

        JCheckBox laptop_checkbox = new JCheckBox("Select");
        laptop_checkbox.setFont(new Font("Tahoma", Font.BOLD, 13));
        laptop_checkbox.setBounds(222, 150, 78, 49);
        laptop_panel.add(laptop_checkbox);

        JLabel lblNewLabel_6 = new JLabel("ELECTRONICS ");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(304, 0, 147, 25);
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

                if (ipad_checkbox.isSelected())
                {
                    p_Id = 9;
                    p_Name = lblNewLabel_1.getText();
                    quan = ipad_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Electronic";

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
                if (earphone_checkbox.isSelected())
                {
                    p_Id = 10;
                    p_Name = lblNewLabel_1_1.getText();
                    quan = earphones_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Electronic";

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
                    p_Id = 11;
                    p_Name = lblNewLabel_1_2.getText();
                    quan = phone_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Electronic";

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
                if (laptop_checkbox.isSelected())
                {
                    p_Id = 12;
                    p_Name = lblNewLabel_1_2_1.getText();
                    quan = laptop_quantity.getText();
                    quant = Integer.parseInt(quan);
                    type = "Electronic";

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

