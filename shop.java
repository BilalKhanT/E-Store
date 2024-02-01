import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class shop extends JFrame {


    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    shop frame = new shop();
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
    public shop() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 810,580);
        setLocation( 270, 50);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("Grocery Store");
        title_Label.setBounds(342, 11, 129, 30);
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(title_Label);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 70));
        panel.setBounds(39, 170, 192, 232);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton food_Button = new JButton("Food Item");
        food_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                food frame = new food();
                frame.setVisible(true);
                dispose();
            }
        });
        food_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        food_Button.setBounds(33, 11, 118, 23);
        panel.add(food_Button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\gro.png"));
        lblNewLabel.setBounds(37, 65, 145, 122);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0,0,0,70));
        panel_1.setBounds(302, 170, 192, 232);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton clothing_Button = new JButton("Clothing");
        clothing_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clothing frame = new clothing();
                frame.setVisible(true);
                dispose();
            }
        });
        clothing_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        clothing_Button.setBounds(39, 11, 118, 23);
        panel_1.add(clothing_Button);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\clot.jpg"));
        lblNewLabel_1.setBounds(46, 68, 111, 119);
        panel_1.add(lblNewLabel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0,0,0,70));
        panel_2.setBounds(556, 170, 192, 232);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JButton elect_Button = new JButton("Electronics");
        elect_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                electronic frame = new electronic();
                frame.setVisible(true);
                dispose();
            }
        });
        elect_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        elect_Button.setBounds(39, 11, 118, 23);
        panel_2.add(elect_Button);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\electr.jpg"));
        lblNewLabel_2.setBounds(44, 72, 113, 120);
        panel_2.add(lblNewLabel_2);

        JButton prev_Button = new JButton("< Previous");
        prev_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cust_Homepage frame = new cust_Homepage();
                frame.setVisible(true);
                dispose();
            }
        });
        prev_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        prev_Button.setBounds(37, 484, 109, 23);
        contentPane.add(prev_Button);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel_3.setBounds(0, 0, 794, 541);
        contentPane.add(lblNewLabel_3);
    }
}

