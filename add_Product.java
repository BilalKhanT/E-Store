import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class add_Product {

    public static void add_inv(int id,String name,int quantity,String u_name,String type)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO INVENTORY VALUES("+ id +",'"+ name +"',"+ quantity +",'"+ u_name +"','"+ type +"')";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
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
    public static void add_Food(int id,String name,int quantity,int price,String type)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO ELECTRONICS VALUES("+ id +",'"+ name +"',"+ quantity +","+ price +",'"+ type +"')";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
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
    public  static void add_Product(int id,String type,String name,int quantity,int price,String admin_name,String des,int stock)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "maindb";
        String pass = "bilal";
        Connection con = null;
        String sql = "INSERT INTO PRODUCT VALUES("+ id +",'"+ type +"','"+ name +"',"+ price +",'"+ admin_name +"','"+ des +"',"+ stock +")";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // System.out.println("sdriver registed");
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("sConnection secured");
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

    public static void main(String[] args) {
        add_Product(12,"Electronic","Laptop",100,150000,"AdminAccount","Laptops are computers that you can take everywhere with you without hassle. They can take up very little space and be used for hours without access to power..",100);
        add_Food(12,"Laptop",100,150000,"Laptops are computers that you can take everywhere with you without hassle. They can take up very little space and be used for hours without access to power..");
        add_inv(12,"Laptop",100,"AdminAccount","Electronic");
    }
}
