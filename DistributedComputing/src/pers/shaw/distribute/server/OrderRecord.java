package pers.shaw.distribute.server;  

import java.io.Serializable;
import java.sql.Date;

public class OrderRecord implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -5211652083459658313L;
  private int userId;
  private Date date;
  private int orderId;
  private String name;
  private String productName;
  private int quantity;

  public OrderRecord(int userId, Date date, int orderId, String name, String productName, int quantity) {
    // TODO Auto-generated constructor stub
    this.userId = userId;
    this.date = date;
    this.orderId = orderId;
    this.name = name;
    this.productName = productName;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }
  
  public String getProductName() {
    return productName;
  }

  public int getUserId() {
    return userId;
  }

  public Date getDate() {
    return date;
  }

  public int getOrderId() {
    return orderId;
  }

  public String getName() {
    return name;
  }
}
