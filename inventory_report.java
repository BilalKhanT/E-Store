import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class inventory_report extends JFrame{
    public String get_Total()
    {
        int total = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM INVENTORY";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                total ++;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String total_S = String.valueOf(total);
        return total_S;
    }
    public void get_get_Cust_Record()
    {
        String name = "";
        int id = 0;
        String password = "";
        String mail = "";
        int stock = 0;
        String type = "";

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT * FROM INVENTORY";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                name = m.getString("PRODUCT_NAME");
                id= m.getInt("PRODUCT_ID");
                //password = m.getString("PASSWORD");
                //mail = m.getString("EMAIL");
                stock = m.getInt("STOCK");
                //String mobile = "0"+phone;
                type = m.getString("PRODUCT_TYPE");
                model.addRow(new Object[]{id,name,stock,type});
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel contentPane;
    private JTable table;
    DefaultTableModel model;
    private JTextField total_Field;




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inventory_report frame = new inventory_report();
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
    public inventory_report() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("Inventory Report");
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
        title_Label.setBounds(343, 11, 173, 23);
        contentPane.add(title_Label);
        model = new DefaultTableModel();
        Object [] coloumn = {"PRODUCT ID","PRODUCT Name","STOCK","PRODUCT TYPE"};
        model.setColumnIdentifiers(coloumn);

        JPanel panel = new JPanel();
        panel.setBounds(71, 52, 694, 494);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 694, 494);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);

        JButton back_Button = new JButton("< Previous");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System frame = new System();
                frame.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        back_Button.setBounds(10, 577, 123, 23);
        contentPane.add(back_Button);

        JButton show_Button = new JButton("Show Record");
        show_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
                get_get_Cust_Record();
                total_Field.setText(get_Total());
            }
        });
        show_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        show_Button.setBounds(685, 578, 139, 23);
        contentPane.add(show_Button);

        JLabel total_Label = new JLabel("Total PRODUCTS");
        total_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
        total_Label.setBounds(198, 569, 130, 14);
        contentPane.add(total_Label);

        total_Field = new JTextField();
        total_Field.setBounds(362, 567, 50, 20);
        total_Field.setEditable(false);
        contentPane.add(total_Field);
        total_Field.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel_7);
    }
}

