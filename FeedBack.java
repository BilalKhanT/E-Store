import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FeedBack extends Login {

    public int get_User_Id(String user_Name){
        int id = 0;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "SELECT USER_ID FROM CUSTOMER WHERE USER_NAME ='"+ user_Name +"'";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet m = st.executeQuery(sql);
            while(m.next())
            {
                id = m.getInt("USER_ID");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }


    private JPanel contentPane;
    private JTextField User_textField;
    private JTextField feeback_textfield;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FeedBack frame = new FeedBack();
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
    public FeedBack() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 751, 520);
        setLocation( 250, 40);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(64, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(22, 67, 677, 369);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("User Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(10, 11, 75, 16);
        panel.add(lblNewLabel_1);
        User_textField = new JTextField();
        User_textField.setText(get_Name());
        User_textField.setFont(new Font("Tahoma", Font.BOLD, 13));
        User_textField.setEnabled(false);
        User_textField.setBounds(108, 10, 134, 20);
        panel.add(User_textField);
        User_textField.setColumns(10);


        JLabel lblNewLabel_2 = new JLabel("Rating:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setBounds(10, 69, 75, 14);
        panel.add(lblNewLabel_2);

        JSlider slider = new JSlider();
        slider.setMajorTickSpacing(1);
        slider.setToolTipText("");
        slider.setPaintLabels(true);
        slider.setMaximum(5);
        slider.setBounds(108, 66, 200, 31);
        panel.add(slider);

        JLabel lblNewLabel_3 = new JLabel("FEEDBACK:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_3.setBounds(10, 150, 75, 14);
        panel.add(lblNewLabel_3);

        feeback_textfield = new JTextField();
        feeback_textfield.setBounds(108, 148, 320, 118);
        panel.add(feeback_textfield);
        feeback_textfield.setColumns(10);


        JButton back_button = new JButton("Back ");
        back_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        back_button.setBounds(40, 317, 89, 23);
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cust_Homepage frame = new cust_Homepage();
                frame.setVisible(true);
                dispose();
            }
        });

        panel.add(back_button);

        int iD = get_User_Id(name);
        JButton submit_button = new JButton("Submit");
        submit_button.setFont(new Font("Tahoma", Font.BOLD, 12));
        submit_button.setBounds(547, 317, 89, 23);
        panel.add(submit_button);
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String des = feeback_textfield.getText();
                    int rating = slider.getValue();
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    // System.out.println("sdriver registed");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maindb", "bilal");
                    //System.out.println("sConnection secured");
                    Statement st = con.createStatement();
                    st.executeUpdate("INSERT INTO FEEDBACK VALUES("+ iD +",'"+ des +"',"+ rating +",'"+ name +"')");
                    // System.out.println("insert");
                    JOptionPane.showMessageDialog(null, "Thanks For your Valuable Feedback", "Feedback Submitted", 2);
                    st.close();
                    con.close();
                } catch (Exception var3) {
                    JOptionPane.showMessageDialog(null, "Sorry FeedBack is too Long", "Feedback not  Submitted", 2);
                }

            }


        });

        JLabel lblNewLabel = new JLabel("FEEDBACK SUGGESTIONS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(256, 21, 270, 17);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_7.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel_7);
    }
}
