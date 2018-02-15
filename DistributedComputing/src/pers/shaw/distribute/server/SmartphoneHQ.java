package pers.shaw.distribute.server;  

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface SmartphoneHQ extends Remote {
  public HashMap<String, Integer> getSmartphoneStock() throws RemoteException;
  public void updateSmartphoneHQProductStock(int num) throws RemoteException;
}
