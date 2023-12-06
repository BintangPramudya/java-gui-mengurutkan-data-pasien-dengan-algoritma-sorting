
package TB.CekKonektor;

import java.sql.Connection;
import java.sql.DriverManager;


public class CheckConnector {
    public static Connection conn;
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB_NAME = "dt_mhs";
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME, USER, PASS);
        }   catch (Exception ex){
            System.out.println(ex);
        }
        if (conn != null){
            System.out.println("Koneksi Berhasil");
        } else {
            System.out.println("Koneksi gagal");
        }
    }
}
