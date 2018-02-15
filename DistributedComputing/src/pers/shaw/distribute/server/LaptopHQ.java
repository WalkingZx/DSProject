package pers.shaw.distribute.server;  

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface LaptopHQ extends Remote {
  public HashMap<String, Integer> getLaptopStock() throws RemoteException;
  public void updateLaptopsHQProductStock(int num) throws RemoteException;
}
