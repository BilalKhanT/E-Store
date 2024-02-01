import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.*;

public class order_History extends Login {

    public void show_History(String c_Name)
    {
        int ord_Id;
        String date;
        int total;
        long price;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM ORDERS WHERE USER_NAME = '"+ c_Name +"'";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while (m.next()) {
                ord_Id = m.getInt("ORDER_ID");
                date = m.getDate("ORDER_DATE").toString();
                total = m.getInt("NO_OF_PRODUCTS");
                price = m.getLong("TOTAL_PRICE");
                model.addRow(new Object[]{ord_Id,date,total,price});
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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    order_History frame = new order_History();
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
    public order_History() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 580);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("Order History");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
        title_Label.setBounds(323, 22, 134, 20);
        contentPane.add(title_Label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(107, 80, 553, 375);
        contentPane.add(scrollPane);

        model = new DefaultTableModel();
        Object [] coloumn = {"ORDER ID","ORDER DATE","TOTAL PRODUCTS","PRICE"};
        model.setColumnIdentifiers(coloumn);
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);

        JButton back_Button = new JButton("< Previous");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cust_Homepage form = new cust_Homepage();
                form.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        back_Button.setBounds(246, 493, 111, 37);
        contentPane.add(back_Button);

        JButton load_Button = new JButton("Load Data");
        load_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = get_Name();
                show_History(name);
            }
        });
        load_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        load_Button.setBounds(415, 493, 111, 37);
        contentPane.add(load_Button);

        JLabel bg_Label = new JLabel("");
        bg_Label.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        bg_Label.setBounds(0, 0, 800, 650);
        contentPane.add(bg_Label);
    }
}
