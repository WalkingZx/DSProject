 package pers.shaw.distribute.server; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BranchService extends Remote {
  public List<User> GetUserList() throws RemoteException;

  public List<ShopRecord> GetShopRecordList() throws RemoteException;

  // public int RequestForCmp(int num) throws RemoteException;
  // public int RequestForLtp(int num) throws RemoteException;
  // public int RequestForSmp(int num) throws RemoteException;
  public int RequesForProduct(String productName, int num) throws RemoteException;

  public void updateShopProductStock(String productName, int num) throws RemoteException;

  public List<OrderRecord> checkShopRecord(int num) throws RemoteException;
}
