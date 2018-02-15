 package pers.shaw.distribute.server; 

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BalanceLoaderServiceImpl extends UnicastRemoteObject implements BalanceLoaderService {

  /**
   * 
   */
  private static final long serialVersionUID = 190227194261034299L;

  protected BalanceLoaderServiceImpl() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }

  final String computer = "desktop computers";
  final String laptop = "laptops";
  final String smartphone = "smartphones";

  @Override
  public HashMap<String, Integer> getProductStock(String productName) throws RemoteException {
    // TODO Auto-generated method stub
    System.out
        .println("[BalanceLoader]:  A request for <" + productName + "> is under processing!");
    HashMap<String, Integer> productStock = new HashMap<String, Integer>();
    try {
      switch (productName) {
        case computer:
          ComputerHQ cmpHQ;
          cmpHQ = (ComputerHQ) Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
          productStock = cmpHQ.getComputerStock();
          break;
        case laptop:
          LaptopHQ lptHQ = (LaptopHQ) Naming.lookup("rmi://127.0.0.1:6603/laptopHQ");
          productStock = lptHQ.getLaptopStock();
          break;
        case smartphone:
          SmartphoneHQ smpHQ = (SmartphoneHQ) Naming.lookup("rmi://127.0.0.1:6602/smartphoneHQ");
          productStock = smpHQ.getSmartphoneStock();
          break;
        default:
          break;
      }
    } catch (MalformedURLException | NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return productStock;
  }

  @Override
  public void updateProductStockFromHQ(String productName, int num) throws RemoteException {
    // TODO Auto-generated method stub
    try {
      switch (productName) {
        case computer:
          ComputerHQ cmpHQ;
          cmpHQ = (ComputerHQ) Naming.lookup("rmi://127.0.0.1:6601/computerHQ");
          cmpHQ.updateComputerHQProductStock(num);
          break;
        case laptop:
          LaptopHQ lptHQ = (LaptopHQ) Naming.lookup("rmi://127.0.0.1:6603/laptopHQ");
          lptHQ.updateLaptopsHQProductStock(num);
          break;
        case smartphone:
          SmartphoneHQ smpHQ = (SmartphoneHQ) Naming.lookup("rmi://127.0.0.1:6602/smartphoneHQ");
          smpHQ.updateSmartphoneHQProductStock(num);
          break;
        default:
          break;
      }
    } catch (MalformedURLException | NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
