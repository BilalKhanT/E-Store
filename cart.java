import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class cart extends Login {

    public int get_pid(int c_id)
    {
        int sum = 0;
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
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    public int get_Sum(int cart_id)
    {
        int sum = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT SUM (PRODUCT_QUANTITY) FROM CART WHERE CART_ID = "+ cart_id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            if (m.next())
            {
                sum = m.getInt(1);
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    public void insert_Order(int ord_Id,int no_Prod,String cust_name,int car_id,int p_id)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        String ord_date = dateFormat.format(date);
        String total_ = total_price_textfield.getText();
        int total = Integer.parseInt(total_);
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO ORDERS VALUES("+ ord_Id +",'"+ ord_date +"',"+ no_Prod +",'"+ cust_name +"',"+ car_id +","+ total +","+ p_id +")";
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



    public void delete_Record(int id,int p_id)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection conn = null;
        String sql = "DELETE FROM CART WHERE CART_ID = "+ id +" AND PRODUCT_ID = "+ p_id +"";
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
    public int get_Pprice(int item_id)
    {
        int price = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT PRICE FROM PRODUCT WHERE PRODUCT_ID ="+ item_id +"";
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
                price = rs.getInt("PRICE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return price;
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

    public void show_Cart_Data(int id)
    {
        int p_Id;
        String p_Name;
        int p_Quan;
        String p_Type;
        int p_Price;
        int price;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM CART WHERE CART_ID = "+ id +"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while (m.next()) {
                p_Id = m.getInt("PRODUCT_ID");
                p_Name = m.getString("PRODUCT_NAME");
                p_Quan = m.getInt("PRODUCT_QUANTITY");
                p_Type = m.getString("PRODUCT_TYPE");
                p_Price = get_Pprice(p_Id);
                price = p_Price * p_Quan;
                total_Price = total_Price + price;
                model.addRow(new Object[]{p_Id,p_Name,p_Quan,p_Type,price});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private JPanel contentPane;
    private JTable table;
    DefaultTableModel model;
    private JTextField total_price_textfield;
    static int total_Price;
    static int sel_Id;
    JLabel lblNewLabel = new JLabel("Cart");

    public void set_sel_Id(int id)
    {
        sel_Id = id;
    }
    public int get_sel_Id()
    {
        return sel_Id;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cart frame = new cart();
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
    public cart() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 580);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblNewLabel.setBounds(350, 11, 62, 27);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /*int row_Index = table.getSelectedRow();
                String sel = model.getValueAt(row_Index,0).toString();
                model.removeRow(row_Index);
                set_sel_Id(Integer.parseInt(sel));*/
            }
        });
        scrollPane.setBounds(10, 49, 764, 388);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);


        model = new DefaultTableModel();
        Object [] coloumn = {"Product ID","Product Name","Product Quantity","Product Type","Price"};
        model.setColumnIdentifiers(coloumn);
        table.setModel(model);

        JButton back_button = new JButton("Back");
        back_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cust_Homepage frame = new cust_Homepage();
                frame.setVisible(true);
                dispose();
            }
        });
        back_button.setBounds(10, 507, 105, 23);
        contentPane.add(back_button);

        JButton update_button = new JButton("Remove Item");
        update_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        update_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row_Index = table.getSelectedRow();
                String sel = model.getValueAt(row_Index,0).toString();
                model.removeRow(row_Index);
                int p_id = Integer.parseInt(sel);
                int id = get_Cust_Cartid(get_Name());
                delete_Record(id,p_id);
            }
        });
        update_button.setBounds(335, 507, 125, 23);
        contentPane.add(update_button);

        JButton order_button = new JButton("Order");
        order_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        order_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = get_Cust_Cartid(get_Name());
                String c_name = get_Name();
                int quan = get_Sum(id);
                int p_id = get_pid(id);
                insert_Order(id,quan,c_name,id,p_id);
                order frame = new order();
                frame.setVisible(true);
                dispose();
            }
        });
        order_button.setBounds(672, 507, 102, 23);
        contentPane.add(order_button);

        JButton clear_cart_button = new JButton("Remove All");
        clear_cart_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        clear_cart_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = get_Cust_Cartid(get_Name());
                delete_All(id);
                int rows = model.getRowCount();
                for(int i = rows - 1; i >=0; i--)
                {
                    model.removeRow(i);
                }
                total_price_textfield.setText("0");
            }
        });
        clear_cart_button.setBounds(505, 507, 115, 23);
        contentPane.add(clear_cart_button);

        JLabel lblNewLabel_1 = new JLabel("Total Price:");
        lblNewLabel_1.setForeground(new Color(0,0,0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(569, 456, 68, 14);
        contentPane.add(lblNewLabel_1);

        total_price_textfield = new JTextField();
        total_price_textfield.setEditable(false);
        total_price_textfield.setBounds(647, 447, 127, 35);
        contentPane.add(total_price_textfield);
        total_price_textfield.setColumns(10);

        JButton btnNewButton = new JButton("Load Data");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cu_name = get_Name();
                int id = get_Cust_Cartid(cu_name);
                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
                show_Cart_Data(id);
                total_price_textfield.setText(String.valueOf(total_Price));
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(170, 507, 105, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 800, 580);
        contentPane.add(lblNewLabel_7);
    }
}
