
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class cust_Homepage extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cust_Homepage frame = new cust_Homepage();
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
    public cust_Homepage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 450);
        setLocation( 330, 50);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("HOME");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 20));
        title_Label.setBounds(313, 11, 131, 20);
        contentPane.add(title_Label);

        JPanel shop_Panel = new JPanel();
        shop_Panel.setBackground(new Color(0,0,0,70));
        shop_Panel.setBounds(22, 48, 142, 152);
        contentPane.add(shop_Panel);
        shop_Panel.setLayout(null);

        JButton shop_Button = new JButton("Shop");
        shop_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shop frame = new shop();
                frame.setVisible(true);
                dispose();
            }
        });
        shop_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        shop_Button.setBounds(24, 11, 89, 23);
        shop_Panel.add(shop_Button);

        JLabel shop_Img = new JLabel("");
        shop_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\1.jpg"));
        shop_Img.setBounds(24, 45, 89, 81);
        shop_Panel.add(shop_Img);

        JPanel review_Panel = new JPanel();
        review_Panel.setLayout(null);
        review_Panel.setBackground(new Color(0,0,0,70));
        review_Panel.setBounds(272, 48, 142, 152);
        contentPane.add(review_Panel);

        JButton review_Button = new JButton("FeedBack");
        review_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FeedBack frame = new FeedBack();
                frame.setVisible(true);
                dispose();
            }
        });
        review_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        review_Button.setBounds(25, 11, 93, 23);
        review_Panel.add(review_Button);

        JLabel review_Img = new JLabel("");
        review_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\2.png"));
        review_Img.setBounds(24, 45, 89, 81);
        review_Panel.add(review_Img);

        JPanel shop_Panel_2 = new JPanel();
        shop_Panel_2.setLayout(null);
        shop_Panel_2.setBackground(new Color(0,0,0,70));
        shop_Panel_2.setBounds(523, 48, 142, 152);
        contentPane.add(shop_Panel_2);

        JButton profile_Button = new JButton("Profile");
        profile_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Profile frame = new Profile();
                frame.setVisible(true);
                dispose();
            }
        });
        profile_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        profile_Button.setBounds(24, 11, 89, 23);
        shop_Panel_2.add(profile_Button);

        JLabel profile_img = new JLabel("");
        profile_img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\prof.png"));
        profile_img.setBounds(24, 45, 89, 81);
        shop_Panel_2.add(profile_img);

        JPanel cart_Panel = new JPanel();
        cart_Panel.setLayout(null);
        cart_Panel.setBackground(new Color(0,0,0,70));
        cart_Panel.setBounds(161, 235, 142, 152);
        contentPane.add(cart_Panel);

        JButton cart_Button = new JButton("Cart");
        cart_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cart frame = new cart();
                frame.setVisible(true);
                dispose();
            }
        });
        cart_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        cart_Button.setBounds(24, 11, 89, 23);
        cart_Panel.add(cart_Button);

        JLabel cart_Img = new JLabel("");
        cart_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\3.jpg"));
        cart_Img.setBounds(15, 45, 98, 81);
        cart_Panel.add(cart_Img);

        JPanel order_his_Panel = new JPanel();
        order_his_Panel.setLayout(null);
        order_his_Panel.setBackground(new Color(0,0,0,70));
        order_his_Panel.setBounds(390, 235, 142, 152);
        contentPane.add(order_his_Panel);

        JButton order_History_Button = new JButton("Order History");
        order_History_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                order_History frame = new order_History();
                frame.setVisible(true);
                dispose();
            }
        });
        order_History_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        order_History_Button.setBounds(10, 11, 122, 23);
        order_his_Panel.add(order_History_Button);

        JLabel ordhis_Img = new JLabel("");
        ordhis_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\5.png"));
        ordhis_Img.setBounds(24, 45, 89, 81);
        order_his_Panel.add(ordhis_Img);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 46, 14);
        contentPane.add(lblNewLabel);

        JButton out_Button = new JButton("Log Out");
        out_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login form = new Login();
                form.setVisible(true);
                dispose();

            }
        });
        out_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        out_Button.setBounds(595, 378, 89, 23);
        contentPane.add(out_Button);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_1.setBounds(0, 0, 694, 411);
        contentPane.add(lblNewLabel_1);
    }
}


