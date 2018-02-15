 package pers.shaw.distribute.server; 

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BranchServiceImpl extends UnicastRemoteObject implements BranchService {

  final int BuyFromShop = 1;
  final int BuyFromHQ = 2;
  final int NoStock = 0;
  final int SystemError = -1;

  protected BranchServiceImpl() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }

  static final long serialVersionUID = -8870748566777624818L;


  public List<User> GetUserList() throws RemoteException {
    // TODO Auto-generated method stub
    System.out.println("[BranchService] : Request for users list!");
    List<User> personList = new LinkedList<User>();

    String sql = "select * from users;";
    ConnectionTool db1 = new ConnectionTool(sql);
    try {
      ResultSet ret = db1.pst.executeQuery();
      while (ret.next()) {
        String uname = ret.getString(1);
        int uid = ret.getInt(2);

        User u = new User();
        u.setName(uname);
        u.setId(uid);
        personList.add(u);
      }
      ret.close();
      db1.close();
    } catch (SQLException e) {
      System.out.println("Error occurred in getting Users!");
      e.printStackTrace();
    }
    return personList;
  }

  @Override
  public List<ShopRecord> GetShopRecordList() throws RemoteException {
    System.out.println("[BranchService]: Request for shoprecord list!");
    List<ShopRecord> shoplist = new LinkedList<ShopRecord>();
    String sql = "select * from shop_info;";
    ConnectionTool db = new ConnectionTool(sql);
    try {
      ResultSet ret = db.pst.executeQuery();
      while (ret.next()) {
        String prodName = ret.getString(1);
        int Sell = ret.getInt(2);
        int Stock = ret.getInt(3);
        ShopRecord s_r = new ShopRecord(prodName, Sell, Stock);
        shoplist.add(s_r);
      }
      ret.close();
      db.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return shoplist;
  }


  // @Override
  // public int RequestForCmp(int num) throws RemoteException {
  // // TODO Auto-generated method stub
  // int totalStock = 0;
  // int need = 0;
  // String productName = "desktop computers";
  //
  // List<ShopRecord> shoplist = new LinkedList<ShopRecord>();
  // shoplist = this.GetShopRecordList();
  // for(ShopRecord s_r : shoplist) {
  // if(s_r.getProductName().equals(productName)) {
  // totalStock = s_r.getStockNum();
  // System.out.println("Sure");
  // }
  // }
  // System.out.println("Get purchasing request in shop, which is " + num + " and the shop stock is
  // " + totalStock);
  // need = totalStock - num;
  // if (need >=0) {System.out.println("Enough stock in the shop"); return BuyFromShop;}
  // try {
  // System.out.println("Not enough stock in the shop, check the HQ!");
  // ComputerHQ cmpHQ=(ComputerHQ)Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
  // HashMap<String, Integer> productHash = new HashMap<String, Integer>();
  // productHash = cmpHQ.getComputerStock();
  // int HQStock = productHash.get(productName);
  // totalStock += HQStock;
  // need = totalStock -num;
  // if(need >= 0) return BuyFromHQ;
  // }catch (MalformedURLException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }catch (NotBoundException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }
  // return NoStock;
  // }

  // @Override
  // public int RequestForLtp(int num) throws RemoteException {
  // int totalStock = 0;
  // int need = 0;
  // String productName = "laptops";
  //
  // List<ShopRecord> shoplist = new LinkedList<ShopRecord>();
  // shoplist = this.GetShopRecordList();
  // for(ShopRecord s_r : shoplist) {
  // if(s_r.getProductName().equals(productName)) {
  // totalStock = s_r.getStockNum();
  // }
  // }
  // System.out.println("Get purchasing request in shop, which is " + num + " and the shop stock is
  // " + totalStock);
  // need = totalStock - num;
  // if (need >=0) {System.out.println("Enough stock in the shop"); return BuyFromShop;}
  // try {
  // System.out.println("Not enough stock in the shop, check the HQ!");
  //// ComputerHQ cmpHQ=(ComputerHQ)Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
  // LaptopHQ lptHQ = (LaptopHQ) Naming.lookup("rmi://127.0.0.1:6603/laptopHQ");
  // HashMap<String, Integer> productHash = new HashMap<String, Integer>();
  // productHash = lptHQ.getLaptopStock();
  // int HQStock = productHash.get(productName);
  // totalStock += HQStock;
  // need = totalStock -num;
  // if(need >= 0) return BuyFromHQ;
  // }catch (MalformedURLException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }catch (NotBoundException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }
  // return NoStock;
  // }

  // @Override
  // public int RequestForSmp(int num) throws RemoteException {
  // int totalStock = 0;
  // int need = 0;
  // String productName = "smartphones";
  //
  // List<ShopRecord> shoplist = new LinkedList<ShopRecord>();
  // shoplist = this.GetShopRecordList();
  // for(ShopRecord s_r : shoplist) {
  // if(s_r.getProductName().equals(productName)) {
  // totalStock = s_r.getStockNum();
  // }
  // }
  // System.out.println("Get purchasing request in shop, which is " + num + " and the shop stock is
  // " + totalStock);
  // need = totalStock - num;
  // if (need >=0) {System.out.println("Enough stock in the shop"); return BuyFromShop;}
  // try {
  // System.out.println("Not enough stock in the shop, check the HQ!");
  //// ComputerHQ cmpHQ=(ComputerHQ)Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
  //// LaptopHQ lptHQ = (LaptopHQ) Naming.lookup("rmi://127.0.0.1:6603/laptopHQ");
  // SmartphoneHQ smpHQ = (SmartphoneHQ) Naming.lookup("rmi://127.0.0.1:6602/smartphoneHQ");
  // HashMap<String, Integer> productHash = new HashMap<String, Integer>();
  // productHash = smpHQ.getSmartphoneStock();
  // int HQStock = productHash.get(productName);
  // totalStock += HQStock;
  // need = totalStock -num;
  // if(need >= 0) return BuyFromHQ;
  // }catch (MalformedURLException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }catch (NotBoundException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // return SystemError;
  // }
  // return NoStock;
  // }

  @Override
  public int RequesForProduct(String productName, int num) throws RemoteException {
    // TODO Auto-generated method stub
    int totalStock = 0;
    int shopStock = 0;
    int need = 0;

    List<ShopRecord> shoplist = new LinkedList<ShopRecord>();
    shoplist = this.GetShopRecordList();
    for (ShopRecord s_r : shoplist) {
      if (s_r.getProductName().equals(productName)) {
        totalStock = s_r.getStockNum();
        shopStock = totalStock;
      }
    }
    System.out.println("[BranchService] : Get purchasing " + productName
        + " request in shop, which is " + num + " and the shop stock is " + totalStock);
    need = totalStock - num;
    if (need >= 0) {
      System.out.println("[BranchService] Enough stock in the shop");
      return BuyFromShop;
    }
    try {
      System.out.println("[BranchService] Not enough stock in the shop, check the HQ!");
      // ComputerHQ cmpHQ=(ComputerHQ)Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
      // LaptopHQ lptHQ = (LaptopHQ) Naming.lookup("rmi://127.0.0.1:6603/laptopHQ");
      // SmartphoneHQ smpHQ = (SmartphoneHQ) Naming.lookup("rmi://127.0.0.1:6602/smartphoneHQ");
      BalanceLoaderService bls =
          (BalanceLoaderService) Naming.lookup("rmi://127.0.0.1:6604/balanceLoader");
      HashMap<String, Integer> productHash = new HashMap<String, Integer>();
      productHash = bls.getProductStock(productName);
      int HQStock = productHash.get(productName);
      totalStock += HQStock;
      need = totalStock - num;
      if (need >= 0) {
        int requestFromHQ = num - shopStock;
        this.updateShopProductStock(productName, requestFromHQ + shopStock);
        bls.updateProductStockFromHQ(productName, HQStock - requestFromHQ);
        System.out.println(
            "[BranchService] Now the shop has " + (requestFromHQ + shopStock) + " " + productName);
        return BuyFromHQ;
      }
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return SystemError;
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return SystemError;
    }
    return NoStock;
  }

  @Override
  public void updateShopProductStock(String productName, int num) throws RemoteException {
    // TODO Auto-generated method stub
    System.out.println("[BranchService]: Now this shop should have " + num + " " + productName);
    String sql = "UPDATE `Pmpjn11_Shaw_lectures`.`shop_info` SET `stock_num` = " + num
        + " WHERE `product_name` = '" + productName + "'" + ";";
    ConnectionTool db = new ConnectionTool(sql);
    try {
      db.pst.executeLargeUpdate(sql);
      db.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public List<OrderRecord> checkShopRecord(int num) throws RemoteException {
    // TODO Auto-generated method stub
    System.out.println("[BranchService]: Request for orderrecord for userId =" + num);
    List<OrderRecord> shoplist = new LinkedList<OrderRecord>();
    String sql =
        "select Order_id, Date, Product, Name, Quantity from users natural join purchase_history where UserId="
            + num + ";";
    ConnectionTool db = new ConnectionTool(sql);
    try {
      ResultSet ret = db.pst.executeQuery();
      while (ret.next()) {
        String productName = ret.getString("Product");
        int Order_id = ret.getInt("Order_id");
        Date date = ret.getDate("Date");
        String name = ret.getString("Name");
        int quantity = ret.getInt("Quantity");
        OrderRecord s_r = new OrderRecord(num, date, Order_id, name, productName, quantity);
        shoplist.add(s_r);
      }
      ret.close();
      db.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return shoplist;
  }
}
