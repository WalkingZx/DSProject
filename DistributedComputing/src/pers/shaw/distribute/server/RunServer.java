package pers.shaw.distribute.server;  

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
  public static void main(String[] args) {
    try {
      BranchService is = new BranchServiceImpl();
      ComputerHQ ch = new ComputerHQImpl();
      SmartphoneHQ sh = new SmartphoneHQImpl();
      LaptopHQ lh = new LaptopHQImpl();
      BalanceLoaderService bls = new BalanceLoaderServiceImpl();
      LocateRegistry.createRegistry(6600);
      LocateRegistry.createRegistry(6601);
      LocateRegistry.createRegistry(6602);
      LocateRegistry.createRegistry(6603);
      LocateRegistry.createRegistry(6604);

      Naming.rebind("rmi://127.0.0.1:6600/branchService", is);
      Naming.rebind("rmi://127.0.0.1:6601/computerHQ", ch);
      Naming.rebind("rmi://127.0.0.1:6602/smartphoneHQ", sh);
      Naming.rebind("rmi://127.0.0.1:6603/laptopHQ", lh);
      Naming.rebind("rmi://127.0.0.1:6604/balanceLoader", bls);
      System.out.println("All Service are Starting!");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
