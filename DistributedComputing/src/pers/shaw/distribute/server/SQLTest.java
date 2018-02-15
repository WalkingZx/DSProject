 

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLTest {

  static String sql = null;
  static ConnectionTool db1 = null;
  static ResultSet ret = null;

  public static void main(String[] args) {
    sql = "select * from users;";
    db1 = new ConnectionTool(sql);
    try {
      ret = db1.pst.executeQuery();
      while (ret.next()) {
        String uname = ret.getString(1);
        String uid = ret.getString(2);
        System.out.println(uname + "\t" + uid + "\t");
      }
      ret.close();
      db1.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
