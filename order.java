import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class order extends Login {

    public void insert_Sales_Report(int o_Id,int p_Id,int price,String cust_Name,String p_Name,int quant)
    {
        int total = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO SALES_REPORT VALUES("+ o_Id +","+ p_Id +","+ price +",'"+ cust_Name +"','"+ p_Name +"',"+ quant +","+ quant +")";
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

    public int get_Total_Price(int o_Id)
    {
        int total = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT TOTAL_PRICE FROM ORDERS WHERE ORDER_ID = "+ o_Id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                total = m.getInt("TOTAL_PRICE");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }
    public void update_Clothing(int p_id,int updated)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "UPDATE CLOTHING SET QUANTITY = "+ updated +" WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_Electronic(int p_id,int updated)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "UPDATE ELECTRONICS SET QUANTITY = "+ updated +" WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_Food(int p_id, int updated)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "UPDATE FOOD SET QUANTITY = "+ updated +" WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete_All(int id)
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
    public void update_Prod(int p_id, int updated)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "UPDATE PRODUCT SET AVAILABLE_STOCK = "+ updated +" WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    ArrayList <Integer> arr = new ArrayList <Integer>();
    public int get_Order_Quan(int c_id,int p_id)
    {
        int quan = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRODUCT_QUANTITY FROM CART WHERE CART_ID = "+ c_id +" AND PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                quan = m.getInt("PRODUCT_QUANTITY");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quan;
    }
    public int get_Available(int p_id)
    {
        int stock = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT STOCK FROM INVENTORY WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                stock = m.getInt("STOCK");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stock;
    }
    public void get_pid(int c_id)
    {
        int sum;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRODUCT_ID FROM CART WHERE CART_ID = "+ c_id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while (m.next())
            {
                sum = m.getInt("PRODUCT_ID");
                arr.add(sum);
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_Inventory(int p_id,int updated)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "UPDATE INVENTORY SET STOCK = "+ updated +" WHERE PRODUCT_ID = "+ p_id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private JTextField prod_Field;
    private JTextField price_Field;
    private JTextField date_Field;

    public int get_Order_pid(String name,int id)
    {
        int p_id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT CART_PRODUCT_ID FROM ORDERS WHERE USER_NAME = '"+ name +"' AND CART_ID = "+ id +"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                p_id = m.getInt("CART_PRODUCT_ID");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p_id;
    }
    public void display_Order(int cart_Id,int ID)
    {
        int prod_Id;
        String prod_Name;
        int prod_Quan;
        int total;
        int no_Prod;
        String date;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM ORDERS INNER JOIN CART ON ORDERS.CART_ID = CART.CART_ID WHERE ORDERS.CART_ID = "+ cart_Id +" AND ORDERS.CART_PRODUCT_ID = "+ ID +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while (m.next())
            {
                prod_Id = m.getInt("PRODUCT_ID");
                prod_Name = m.getString("PRODUCT_NAME");
                prod_Quan = m.getInt("PRODUCT_QUANTITY");
                total = m.getInt("TOTAL_PRICE");
                no_Prod = m.getInt("NO_OF_PRODUCTS");
                date = m.getDate("ORDER_DATE").toString();
                model.addRow(new Object[]{prod_Id,prod_Name,prod_Quan});
                String prod = String.valueOf(no_Prod);
                String price = String.valueOf(total);
                prod_Field.setText(prod);
                price_Field.setText(price);
                date_Field.setText(date);
            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public int get_Cust_Cartid(String cu_name)
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT CART_ID FROM CART WHERE USER_NAME = '"+ cu_name +"'";
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
        return id;
    }

    private JPanel contentPane;
    private JTable table;

    DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    order frame = new order();
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
    public order() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("ORDER");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
        title_Label.setBounds(391, 11, 81, 20);
        contentPane.add(title_Label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(128, 49, 570, 260);
        contentPane.add(scrollPane);

        model = new DefaultTableModel();
        Object [] coloumn = {"PRODUCT ID","PRODUCT Name","QUANTITY"};
        model.setColumnIdentifiers(coloumn);
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(223, 344, 377, 140);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel no_Prod_Label = new JLabel("Total Products");
        no_Prod_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
        no_Prod_Label.setBounds(35, 26, 114, 14);
        panel.add(no_Prod_Label);

        JLabel price_Label = new JLabel("Total Price");
        price_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
        price_Label.setBounds(35, 62, 114, 14);
        panel.add(price_Label);

        JLabel date_Label = new JLabel("Order Date");
        date_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
        date_Label.setBounds(35, 100, 114, 14);
        panel.add(date_Label);

        prod_Field = new JTextField();
        prod_Field.setEditable(false);
        prod_Field.setFont(new Font("Tahoma", Font.BOLD, 14));
        prod_Field.setBounds(215, 23, 128, 20);
        panel.add(prod_Field);
        prod_Field.setColumns(10);

        price_Field = new JTextField();
        price_Field.setEditable(false);
        price_Field.setFont(new Font("Tahoma", Font.BOLD, 14));
        price_Field.setBounds(215, 59, 128, 20);
        panel.add(price_Field);
        price_Field.setColumns(10);

        date_Field = new JTextField();
        date_Field.setEditable(false);
        date_Field.setFont(new Font("Tahoma", Font.BOLD, 14));
        date_Field.setBounds(215, 97, 128, 20);
        panel.add(date_Field);
        date_Field.setColumns(10);

        JButton load_Button = new JButton("Load Data");
        load_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = get_Cust_Cartid(get_Name());
                String name = get_Name();
                int p_id = get_Order_pid(name,id);
                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
                display_Order(id,p_id);
            }
        });
        load_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
        load_Button.setBounds(346, 560, 141, 40);
        contentPane.add(load_Button);

        JButton order_Button = new JButton("Checkout");
        order_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = get_Cust_Cartid(get_Name());
                get_pid(id);
                for (int i = 0; i < arr.size(); i++)
                {
                    int quan = get_Order_Quan(id,arr.get(i));
                    int stock = get_Available(arr.get(i));
                    int updated = stock - quan;
                    update_Inventory(arr.get(i),updated);
                    update_Prod(arr.get(i),updated );
                    if (arr.get(i) <= 4)
                        update_Food(arr.get(i),updated);
                    else if (arr.get(i) > 4 && arr.get(i) <= 8)
                        update_Clothing(arr.get(i),updated);
                    else
                        update_Electronic(arr.get(i),updated);
                }
                arr.clear();
                int prod = get_Order_pid(get_Name(),id);
                String prod_name = "a";
                int total_price = get_Total_Price(id);
                get_pid(id);
                int quan = 0;
                for (int j = 0; j < arr.size(); j++)
                {
                    quan = get_Order_Quan(id,arr.get(j)) + quan;
                }
                insert_Sales_Report(id,prod,total_price,get_Name(),prod_name,quan);
                JOptionPane.showMessageDialog(contentPane, "Order has been confirmed",
                        "Checkout Update", JOptionPane.ERROR_MESSAGE);
            }
        });
        order_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
        order_Button.setBounds(640, 560, 141, 40);
        contentPane.add(order_Button);

        JButton back_Button = new JButton("< Previous");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cart frame = new cart();
                frame.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
        back_Button.setBounds(44, 560, 141, 40);
        contentPane.add(back_Button);

        JLabel bg_Label = new JLabel("");
        bg_Label.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        bg_Label.setBounds(0, 0, 834, 611);
        contentPane.add(bg_Label);
    }
}