package pers.shaw.distribute.server;  

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LaptopHQImpl extends UnicastRemoteObject implements LaptopHQ {

  /**
   * 
   */
  private static final long serialVersionUID = 190227194261034299L;

  protected LaptopHQImpl() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }

  public HashMap<String, Integer> getLaptopStock() throws RemoteException {
    // TODO Auto-generated method stub
    System.out.println("[HQ_Laptop]:  A request is under processing!");
    HashMap<String, Integer> laptopStock = new HashMap<String, Integer>();
    String sql = "SELECT product_name, stock_num FROM HQ_info WHERE `product_name` = 'laptops'; ";
    ConnectionTool db = new ConnectionTool(sql);
    try {
      ResultSet ret = db.pst.executeQuery();
      if (ret.next())
        laptopStock.put(ret.getString("product_name"), ret.getInt("stock_num"));
      ret.close();
      db.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return laptopStock;
  }

  @Override
  public void updateLaptopsHQProductStock(int num) throws RemoteException {
    // TODO Auto-generated method stub
    System.out.println("[HQ_Computer]: Still have  " +num +" laptops in warehouse!");
    String sql = "UPDATE `Pmpjn11_Shaw_lectures`.`HQ_info` SET `stock_num` = " + num +" WHERE `product_name` = 'laptops'" + 
        ";";
    System.out.println(sql);
    ConnectionTool db = new ConnectionTool(sql);
    try {
      db.pst.executeLargeUpdate(sql);
      db.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  
  }

}
