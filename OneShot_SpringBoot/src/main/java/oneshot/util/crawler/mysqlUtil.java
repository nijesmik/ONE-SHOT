package oneshot.util.crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlUtil {
    public static int insertMenu(String query) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oneshot?serverTimezone=UTC", "ssafy",
                    "ssafy");
            stmt = conn.createStatement();
            String sql = "INSERT IGNORE INTO oneshot.menu (brand_id, menu_name, img, type) VALUES" + query;
            conn.setAutoCommit(false);
            int rs = stmt.executeUpdate(sql);
            conn.commit();
            return rs;
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
