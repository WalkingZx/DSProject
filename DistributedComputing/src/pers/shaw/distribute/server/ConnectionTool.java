package pers.shaw.distribute.server;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTool {
  public static final String url = "jdbc:mysql://myeusql.dur.ac.uk/Pmpjn11_Shaw_lectures";
  public static final String name = "com.mysql.jdbc.Driver";
  public static final String user = "mpjn11";
  public static final String password = "zx6193466";

  public Connection conn = null;
  public PreparedStatement pst = null;

  public ConnectionTool(String sql) {
    try {
      Class.forName(name);
      conn = DriverManager.getConnection(url, user, password);
      pst = conn.prepareStatement(sql);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      this.conn.close();
      this.pst.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
