package oneshot.util.crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oneshot.model.dto.Menu;

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

    public static List<Menu> selectMenu(int brandId) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM oneshot.menu WHERE brand_id = " + brandId;
        List<Menu> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oneshot?serverTimezone=UTC", "ssafy",
                    "ssafy");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMenuId(rs.getInt("menu_id"));
                menu.setBrandId(rs.getInt("brand_id"));
                menu.setMenuName(rs.getString("menu_name"));
                menu.setImg(rs.getString("img"));
                menu.setType(rs.getString("type"));
                menu.setCreatedTime(rs.getString("created_time"));
                menu.setUpdatedTime(rs.getString("updated_time"));

                list.add(menu);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public static int insertMenuDetail(String query) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oneshot?serverTimezone=UTC", "ssafy",
                    "ssafy");
            stmt = conn.createStatement();
            String sql = "INSERT IGNORE INTO oneshot.menu_detail (menu_id, price, size, size_name, temperature) VALUES"
                    + query;
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
