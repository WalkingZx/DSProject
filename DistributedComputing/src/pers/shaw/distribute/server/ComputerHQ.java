package pers.shaw.distribute.server; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface ComputerHQ extends Remote {
  public HashMap<String, Integer> getComputerStock() throws RemoteException;
  public void updateComputerHQProductStock(int num) throws RemoteException;
}
