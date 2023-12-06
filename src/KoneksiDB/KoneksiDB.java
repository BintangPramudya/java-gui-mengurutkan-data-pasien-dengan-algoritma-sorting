/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KoneksiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class KoneksiDB {
    public static Connection conn;
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB_NAME = "db_inf";

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
            System.out.println("koneksi berhasil");
        } else {
            JOptionPane.showMessageDialog(null, "koneksi gagal !!!");
        }
        return conn;
    }
}
