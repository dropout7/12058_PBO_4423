package database;
import java.sql.*;
import javax.swing.JOptionPane;
public class KoneksiDb {
	public static Connection Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/db_coba", "root", "");
            return connection;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
