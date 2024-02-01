import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class view_Sales extends JFrame {

    ArrayList <Integer> arry = new ArrayList<>();
    private JPanel contentPane;
    private JTable table;
    static DefaultTableModel model;
    private JButton Back_button;
    private JButton Load_button;

    public void get_Order()
    {
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT ORDER_ID FROM ORDERS";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println("sConnection secured");
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while (m.next())
            {
                id = m.getInt("ORDER_ID");
                arry.add(id);
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSales(int id){
        String cust_name = "";
        int order_id = 0;
        String order_date = "";
        int total_products = 0;
        int price = 0;

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM ORDERS INNER JOIN sales_report ON orders.order_id = sales_report.order_id AND orders.order_id = "+id+"";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                cust_name = m.getString("USER_NAME");
                order_id= m.getInt("ORDER_ID");
                order_date = String.valueOf(m.getDate("ORDER_DATE"));
                total_products = m.getInt("PRODUCT_TOTAL");
                price = m.getInt("PRICE");
                model.addRow(new Object[]{cust_name,order_id,order_date,total_products,price});
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    view_Sales frame = new view_Sales();
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
    public view_Sales() {





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 550);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sales Report");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(328, 11, 141, 25);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 46, 814, 428);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        model = new DefaultTableModel();
        Object [] coloumn = {"Order ID","Customer Name","Order Date","Total Products","Price"};
        model.setColumnIdentifiers(coloumn);
        table.setModel(model);

        Back_button = new JButton("Back");
        Back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System frame = new System();
                frame.setVisible(true);
                dispose();
            }
        });
        Back_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        Back_button.setBounds(0, 485, 89, 23);
        contentPane.add(Back_button);

        Load_button = new JButton("Load Data");
        Load_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                get_Order();
                for (int i = 0; i < arry.size(); i++)
                {
                    getSales(arry.get(i));
                }
                arry.clear();
            }
        });
        Load_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        Load_button.setBounds(734, 485, 100, 23);
        contentPane.add(Load_button);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel_7);
    }

}
