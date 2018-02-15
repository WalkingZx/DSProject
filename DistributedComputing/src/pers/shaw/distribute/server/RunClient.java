package pers.shaw.distribute.server;  

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RunClient {
  @SuppressWarnings("resource")
  final int BUY_FROM_SHOP = 1;
  final int BUY_FROM_HQ = 2;
  final int NOSTOCK = 0;
  final int SYSTEM_ERROR = -1;

  final String computer = "desktop computers";
  final String laptop = "laptops";
  final String smartphone = "smartphones";

  public RunClient() {
    try {
      BranchService is = (BranchService) Naming.lookup("rmi://127.0.0.1:6600/branchService");
      this.MainMenu(is);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void MainMenu(BranchService is) throws RemoteException {
    System.out.println("Press any button to continue.");
    new Scanner(System.in).nextLine();
    System.out.println("\n\t *********************************************\t");
    System.out.println("Please select which info you need");
    System.out.println("1: Get all users info;");
    System.out.println("2: Get all stock and sell info of branch;");
    System.out.println("3: Purchase Computer;");
    System.out.println("4: Purchase Smartphone;");
    System.out.println("5: Purchase Laptop;");
    System.out.println("0: Quit;");
    System.out.println("\t *********************************************\t");
    Scanner in = new Scanner(System.in);
    int input = in.nextInt();
    switch (input) {
      case 0:
        System.out.println("Thank you, bye bye!");
      case 1:
        List<User> userlist = is.GetUserList();
        for (User u : userlist) {
          System.out.println("ID:" + u.getId() + " Name:" + u.getName());
        }
        System.out.println("\n Select one user to view his all shoping record! \n");
        int usrInput = in.nextInt();
        List<OrderRecord> o_r = new LinkedList<OrderRecord>();
        o_r = is.checkShopRecord(usrInput);
        if (!o_r.isEmpty()) {
          for (OrderRecord o : o_r)
            System.out.println("Name: " + o.getName() + "\n" + "Product:" + o.getProductName()
                + "\n" + "Quantity: " + o.getQuantity() + "\n" + "Order Id: " + o.getOrderId()
                + "\n" + "Date: " + o.getDate() + "\n");
        } else {
          System.out.println("No record for this user or no this user!");
        }
        this.MainMenu(is);
        break;
      case 2:
        List<ShopRecord> shoprecordlist = is.GetShopRecordList();
        System.out.println("Product Name    " + "    Selling    " + "    Stock    ");
        for (ShopRecord r : shoprecordlist) {
          System.out
              .println(r.getProductName() + "     " + r.getSellNum() + "    " + r.getStockNum());
        }
        this.MainMenu(is);
        break;
      case 3:
        System.out.println("How many computers do you need to buy?");
        int input_cmp = in.nextInt();
        // int result = is.RequestForCmp(input_cmp);
        int result = is.RequesForProduct(computer, input_cmp);
        switch (result) {
          case SYSTEM_ERROR:
            System.out.println("System Error in HQ server");
            break;
          case NOSTOCK:
            System.out.println("Sorry, no stock!");
            break;
          case BUY_FROM_SHOP:
            System.out.println("Can get stocks from the shop!");
            break;
          case BUY_FROM_HQ:
            System.out.println(
                "Can get stocks from the HQ server, the shop had moved enough computers from HQ!");
            break;
          default:
            System.out.println("Connection Error");
            break;
        }
        this.MainMenu(is);
        break;
      case 4:
        System.out.println("How many smartphones do you need to buy?");
        int input_smp = in.nextInt();
        // int result_smp = is.RequestForSmp(input_smp);
        int result_smp = is.RequesForProduct(smartphone, input_smp);
        switch (result_smp) {
          case SYSTEM_ERROR:
            System.out.println("System Error in HQ server");
            break;
          case NOSTOCK:
            System.out.println("Sorry, no stock!");
            break;
          case BUY_FROM_SHOP:
            System.out.println("Can get stocks from the shop!");
            break;
          case BUY_FROM_HQ:
            System.out.println(
                "Can get stocks from the HQ server, the shop had moved enough smartphones from HQ!");
            break;
          default:
            System.out.println("Connection Error");
            break;
        }
        this.MainMenu(is);
        break;
      case 5:
        System.out.println("How many laptops do you need to buy?");
        int input_lat = in.nextInt();
        // int result_lat = is.RequestForLtp(input_lat);
        int result_lat = is.RequesForProduct(laptop, input_lat);
        switch (result_lat) {
          case SYSTEM_ERROR:
            System.out.println("System Error in HQ server");
            break;
          case NOSTOCK:
            System.out.println("Sorry, no stock!");
            break;
          case BUY_FROM_SHOP:
            System.out.println("Can get stocks from the shop!");
            break;
          case BUY_FROM_HQ:
            System.out.println(
                "Can get stocks from the HQ server, the shop had moved enough laptops from HQ!");
            break;
          default:
            System.out.println("Connection Error");
            break;
        }
        this.MainMenu(is);
        break;
      default:
        System.out.println("No this selection, input Again!");
        input = in.nextInt();
        break;
    }
  }

  public static void main(String[] args) {
    new RunClient();
  }
}
