 package pers.shaw.distribute.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface BalanceLoaderService extends Remote {
  public HashMap<String, Integer> getProductStock(String productName) throws RemoteException;
  public void updateProductStockFromHQ(String productName, int num) throws RemoteException;
}
