import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;

import static java.awt.TextArea.*;

public class update_Product extends JFrame {

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
    private JPanel contentPane;
    private JTextField product_id_textfield;
    private JTextField price_textField;
    private JTextField quantity_textField;
    private JTextField name_textField;
    JTextArea textArea = new JTextArea();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    update_Product frame = new update_Product();
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
    public update_Product() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 550);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(128, 255, 255));
        contentPane.setBackground(new Color(128, 64, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Update Product");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(313, 10, 136, 20);
        contentPane.add(lblNewLabel);

        JPanel Panel = new JPanel();
        Panel.setBackground(new Color(0,0,0,80));
        Panel.setBounds(207, 46, 373, 65);
        contentPane.add(Panel);
        Panel.setLayout(null);


        JButton Search_Button = new JButton("Search");
        Search_Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                product_id_textfield.setEditable(false);
                name_textField.setEditable(false);
                String id = product_id_textfield.getText();
                int pid = Integer.parseInt(id);
                int price;
                String name;
                String desc;
                int quantity;
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "maindb";
                String pass = "bilal";
                Connection con = null;
                String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = "+pid+" ";
                try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    ResultSet m = st.executeQuery(sql);
                    while(m.next())
                    {
                        price = m.getInt("PRICE");
                        price_textField.setText(String.valueOf(price));
                        name = m.getString("PRODUCT_NAME");
                        name_textField.setText(name);
                        desc = m.getString("Description");
                        textArea.setText(desc);
                        quantity = m.getInt("AVAILABLE_STOCK");
                        quantity_textField.setText(String.valueOf(quantity));




                    }
                } catch (ClassNotFoundException e1) {
                    throw new RuntimeException(e1);
                } catch (SQLException ep) {
                    throw new RuntimeException(ep);
                }


            }
        });
        Search_Button.setBounds(252, 16, 86, 23);
        Panel.add(Search_Button);
        Search_Button.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel lblNewLabel_1 = new JLabel("Enter Product ID:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 20, 116, 14);
        Panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

        product_id_textfield = new JTextField();
        product_id_textfield.setBounds(124, 18, 86, 20);
        Panel.add(product_id_textfield);
        product_id_textfield.setColumns(10);

        JButton back_Button = new JButton("Back");
        back_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System frame = new System();
                frame.setVisible(true);
                dispose();
            }
        });
        back_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_Button.setBounds(26, 477, 89, 23);
        contentPane.add(back_Button);

        JButton update_button = new JButton("Update");
        update_button.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                int price = Integer.parseInt(price_textField.getText());
                                                int quantity = Integer.parseInt((quantity_textField.getText()));
                                                int id = Integer.parseInt(product_id_textfield.getText());
                                                String desc = (textArea.getText());
                                                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                                                String user = "maindb";
                                                String pass = "bilal";
                                                Connection con = null;
                                                String sql =  "UPDATE PRODUCT SET PRICE = "+price+" , AVAILABLE_STOCK = "+quantity+" , DESCRIPTION = '"+desc+"' WHERE PRODUCT_ID= "+id+"";
                                                String sql4 = "Select * FROM PRODUCT WHERE PRODUCT_ID = "+id+"";

                                                try
                                                {
                                                    Class.forName("oracle.jdbc.driver.OracleDriver");
                                                    con = DriverManager.getConnection(url, user, pass);
                                                    Statement st = con.createStatement();
                                                    ResultSet m = st.executeQuery(sql);

                                                    if (id <= 4) {
                                                        int f_price = Integer.parseInt(price_textField.getText());
                                                        int f_quantity = Integer.parseInt(quantity_textField.getText());
                                                        int f_id = Integer.parseInt(product_id_textfield.getText());
                                                        String f_desc = textArea.getText();
                                                        String sql1 = "UPDATE FOOD SET PRICE = " + f_price + " , Quantity = " + f_quantity + " , DESCRIPTION = '" + f_desc + "' WHERE PRODUCT_ID= " + id + "";
                                                        try {
                                                            Class.forName("oracle.jdbc.driver.OracleDriver");
                                                            con = DriverManager.getConnection(url, user, pass);
                                                            Statement sta = con.createStatement();
                                                            ResultSet m1 = st.executeQuery(sql1);


                                                        } catch (ClassNotFoundException e1) {
                                                            throw new RuntimeException(e1);
                                                        } catch (SQLException ep) {
                                                            throw new RuntimeException(ep);
                                                        }

                                                    }

                                                    else if (id > 4 && id <=8) {
                                                        String sql2 ="UPDATE CLOTHING SET PRICE = "+price+" , Quantity ="+quantity+" , Description = '"+desc+"'  WHERE PRODUCT_ID= "+id+"";
                                                        Statement st2 = con.createStatement();
                                                        ResultSet m2 = st2.executeQuery(sql2);
                                                    }

                                                    else {
                                                        String sql3 ="UPDATE ELECTRONICS SET PRICE = "+price+"  WHERE PRODUCT_ID= "+id+"";
                                                        Statement st3 = con.createStatement();
                                                        ResultSet m3 = st3.executeQuery(sql3);
                                                    }
                                                    update_Inventory(id,quantity);

                                                } catch (SQLException ex) {
                                                    throw new RuntimeException(ex);
                                                } catch (ClassNotFoundException ex) {
                                                    throw new RuntimeException(ex);
                                                }

                                            }
                                        }
        );
        update_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        update_button.setBounds(723, 478, 89, 23);
        contentPane.add(update_button);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0,80));
        panel.setBounds(150, 170, 518, 297);
        contentPane.add(panel);
        panel.setLayout(null);

        price_textField = new JTextField();
        price_textField.setBounds(139, 81, 86, 20);
        panel.add(price_textField);
        price_textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Price:");
        lblNewLabel_2.setBounds(10, 80, 45, 20);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel lblNewLabel_3 = new JLabel("Quantity:");
        lblNewLabel_3.setBounds(10, 128, 66, 14);
        panel.add(lblNewLabel_3);
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));

        quantity_textField = new JTextField();
        quantity_textField.setBounds(139, 126, 86, 20);
        panel.add(quantity_textField);
        quantity_textField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Description:");
        lblNewLabel_4.setBounds(10, 183, 86, 14);
        panel.add(lblNewLabel_4);
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));




        textArea.setBounds(139, 179, 287, 107);
        panel.add(textArea);

        JLabel lblNewLabel_6 = new JLabel("Name");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setBounds(10, 33, 46, 14);
        panel.add(lblNewLabel_6);

        name_textField = new JTextField();
        name_textField.setBounds(139, 31, 86, 20);
        panel.add(name_textField);
        name_textField.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel_7);
    }
}