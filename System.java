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

public class System extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    System frame = new System();
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
    public System() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        setLocation(250,30);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title_Label = new JLabel("HOME");
        title_Label.setForeground(new Color(255, 255, 255));
        title_Label.setFont(new Font("Tahoma", Font.BOLD, 20));
        title_Label.setBounds(370, 11, 120, 20);
        contentPane.add(title_Label);

        JPanel update_Panel = new JPanel();
        update_Panel.setBounds(41, 75, 193, 191);
        contentPane.add(update_Panel);
        update_Panel.setLayout(null);

        JButton update_Button = new JButton("Update Product");
        update_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update_Product frame = new update_Product();
                frame.setVisible(true);
                dispose();
            }
        });
        update_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        update_Button.setBounds(20, 11, 150, 23);
        update_Panel.add(update_Button);

        JLabel update_Img = new JLabel("");
        update_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\update.jpg"));
        update_Img.setBounds(33, 45, 121, 117);
        update_Panel.add(update_Img);

        JPanel add_Label = new JPanel();
        add_Label.setLayout(null);
        add_Label.setBounds(327, 75, 193, 191);
        contentPane.add(add_Label);

        JButton add_Button = new JButton("Add Employee");
        add_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emp_Registeration frame = new emp_Registeration();
                frame.setVisible(true);
                dispose();
            }
        });
        add_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        add_Button.setBounds(20, 11, 150, 23);
        add_Label.add(add_Button);

        JLabel add_Img = new JLabel("");
        add_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\emp.png"));
        add_Img.setBounds(33, 45, 121, 117);
        add_Label.add(add_Img);

        JPanel employee_Panel = new JPanel();
        employee_Panel.setLayout(null);
        employee_Panel.setBounds(608, 75, 193, 191);
        contentPane.add(employee_Panel);

        JButton employee_Button = new JButton("View Employees");
        employee_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view_Employee frame = new view_Employee();
                frame.setVisible(true);
                dispose();
            }
        });
        employee_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        employee_Button.setBounds(22, 11, 150, 23);
        employee_Panel.add(employee_Button);

        JLabel employee_Img = new JLabel("");
        employee_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\viewemp.png"));
        employee_Img.setBounds(33, 45, 121, 117);
        employee_Panel.add(employee_Img);

        JPanel cust_Panel = new JPanel();
        cust_Panel.setLayout(null);
        cust_Panel.setBounds(41, 323, 193, 191);
        contentPane.add(cust_Panel);

        JButton cust_Button = new JButton("View Customers");
        cust_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view_Customer frame = new view_Customer();
                frame.setVisible(true);
                dispose();
            }
        });
        cust_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        cust_Button.setBounds(22, 11, 150, 23);
        cust_Panel.add(cust_Button);

        JLabel cust_Img = new JLabel("");
        cust_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\viewemp.png"));
        cust_Img.setBounds(33, 45, 121, 117);
        cust_Panel.add(cust_Img);

        JPanel inventory_Panel = new JPanel();
        inventory_Panel.setLayout(null);
        inventory_Panel.setBounds(327, 323, 193, 191);
        contentPane.add(inventory_Panel);

        JButton inventory_Button = new JButton("Inventory Report");
        inventory_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory_report frame = new inventory_report();
                frame.setVisible(true);
                dispose();
            }
        });
        inventory_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        inventory_Button.setBounds(21, 11, 150, 23);
        inventory_Panel.add(inventory_Button);

        JLabel inventory_Img = new JLabel("");
        inventory_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\invnt.png"));
        inventory_Img.setBounds(33, 45, 121, 117);
        inventory_Panel.add(inventory_Img);

        JPanel sales_Panel = new JPanel();
        sales_Panel.setLayout(null);
        sales_Panel.setBounds(608, 323, 193, 191);
        contentPane.add(sales_Panel);

        JButton sales_Button = new JButton("Sales Report");
        sales_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view_Sales frame = new view_Sales();
                frame.setVisible(true);
                dispose();
            }
        });
        sales_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        sales_Button.setBounds(20, 11, 150, 23);
        sales_Panel.add(sales_Button);

        JLabel sales_Img = new JLabel("");
        sales_Img.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\sale.png"));
        sales_Img.setBounds(33, 45, 121, 117);
        sales_Panel.add(sales_Img);

        JButton logout_Button = new JButton("Log Out");
        logout_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login frame = new Login();
                frame.setVisible(true);
                dispose();
            }
        });
        logout_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
        logout_Button.setBounds(711, 555, 89, 23);
        contentPane.add(logout_Button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mbila\\Downloads\\ab.jpeg"));
        lblNewLabel.setBounds(0, 0, 850, 650);
        contentPane.add(lblNewLabel);
    }
}

