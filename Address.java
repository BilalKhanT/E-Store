import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Address extends sign_Up {

    public void add_Address(int house_No, String street, String city, String state, String count, int code)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO ADDRESS VALUES("+ house_No +",'"+ street +"','"+ city +"','"+ state +"','"+ count +"',"+ code +",'"+ name+"')";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
            Statement st = con.createStatement();

            int m = st.executeUpdate(sql);


            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel contentPane;
    private JTextField house_textField;
    private JTextField street_textField;
    private JTextField city_textField;
    private JTextField state_textField;
    private JTextField country_textField;
    private JTextField zip_textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Address frame = new Address();
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
    public Address() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 80));
        panel.setBounds(47, 85, 667, 415);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel House_label = new JLabel("House No ");
        House_label.setForeground(new Color(255, 255, 255));
        House_label.setFont(new Font("Tahoma", Font.BOLD, 12));
        House_label.setBounds(138, 26, 73, 14);
        panel.add(House_label);

        JLabel Street_Label = new JLabel("Street No");
        Street_Label.setForeground(new Color(255, 255, 255));
        Street_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
        Street_Label.setBounds(138, 73, 73, 14);
        panel.add(Street_Label);

        JLabel City_label = new JLabel("City ");
        City_label.setForeground(new Color(255, 255, 255));
        City_label.setFont(new Font("Tahoma", Font.BOLD, 12));
        City_label.setBounds(138, 122, 33, 14);
        panel.add(City_label);

        JLabel State_label = new JLabel("State");
        State_label.setForeground(new Color(255, 255, 255));
        State_label.setFont(new Font("Tahoma", Font.BOLD, 12));
        State_label.setBounds(138, 175, 46, 14);
        panel.add(State_label);

        JLabel Country_label = new JLabel("Country ");
        Country_label.setForeground(new Color(255, 255, 255));
        Country_label.setFont(new Font("Tahoma", Font.BOLD, 12));
        Country_label.setBounds(138, 221, 61, 14);
        panel.add(Country_label);

        JLabel Zip_label = new JLabel("Zip Code");
        Zip_label.setForeground(new Color(255, 255, 255));
        Zip_label.setFont(new Font("Tahoma", Font.BOLD, 12));
        Zip_label.setBounds(138, 275, 61, 14);
        panel.add(Zip_label);

        house_textField = new JTextField();
        house_textField.setBounds(291, 24, 157, 20);
        panel.add(house_textField);
        house_textField.setColumns(10);

        street_textField = new JTextField();
        street_textField.setBounds(291, 71, 157, 20);
        panel.add(street_textField);
        street_textField.setColumns(10);

        city_textField = new JTextField();
        city_textField.setBounds(291, 120, 157, 20);
        panel.add(city_textField);
        city_textField.setColumns(10);

        state_textField = new JTextField();
        state_textField.setBounds(291, 173, 157, 20);
        panel.add(state_textField);
        state_textField.setColumns(10);

        country_textField = new JTextField();
        country_textField.setBounds(291, 219, 157, 20);
        panel.add(country_textField);
        country_textField.setColumns(10);

        zip_textField = new JTextField();
        zip_textField.setBounds(291, 273, 157, 20);
        panel.add(zip_textField);
        zip_textField.setColumns(10);

        JButton back_button = new JButton("< Previous ");
        back_button.setBackground(new Color(255, 255, 255));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sign_Up_Gui form = new sign_Up_Gui();
                form.setVisible(true);
                dispose();
            }
        });
        back_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_button.setBounds(45, 369, 114, 23);
        panel.add(back_button);

        JButton btnNewButton = new JButton("Submit ");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String no = house_textField.getText();
                String street = street_textField.getText();
                String city = city_textField.getText();
                String state = state_textField.getText();
                String country = country_textField.getText();
                String zip = zip_textField.getText();
                if (validation_No(no) == true)
                {
                    if (validation_No(street) == true)
                    {
                        if (validation_Place(city) == true)
                        {
                            if (validation_Place(state) == true)
                            {
                                if (validation_Place(country) == true)
                                {
                                    if (validation_zip(zip) == true)
                                    {
                                        int no_db = Integer.parseInt(no);
                                        int zip_db = Integer.parseInt(zip);
                                        add_Address(no_db, street, city, state, country, zip_db);
                                        Login frame = new Login();
                                        frame.setVisible(true);
                                        dispose();
                                    }
                                    else
                                    {
                                        zip_textField.setText(null);
                                        JOptionPane.showMessageDialog(panel, "Invalid Zip Code",
                                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else
                                {
                                    country_textField.setText(null);
                                    JOptionPane.showMessageDialog(panel, "Invalid Country Name",
                                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else
                            {
                                state_textField.setText(null);
                                JOptionPane.showMessageDialog(panel, "Invalid State Name",
                                        "Swing Tester", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            city_textField.setText(null);
                            JOptionPane.showMessageDialog(panel, "Invalid City Name",
                                    "Swing Tester", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        street_textField.setText(null);
                        JOptionPane.showMessageDialog(panel, "Invalid Street Number",
                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    house_textField.setText(null);
                    JOptionPane.showMessageDialog(panel, "Invalid House Number",
                            "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnNewButton.setBounds(499, 370, 114, 23);
        panel.add(btnNewButton);

        JLabel lblNewLabel_6 = new JLabel("ADDRESS FORM");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_6.setBounds(296, 37, 151, 19);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\b2.jpeg"));
        lblNewLabel.setBounds(0, 0, 784, 511);
        contentPane.add(lblNewLabel);
    }
}

