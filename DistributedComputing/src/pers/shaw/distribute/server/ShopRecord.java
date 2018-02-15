package pers.shaw.distribute.server;  

import java.io.Serializable;

public class ShopRecord implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8323479337172387886L;
  private int sellNum;
  private int stockNum;
  private String productName;

  public ShopRecord(String productName, int sellNum, int stockNum) {
    this.sellNum = sellNum;
    this.stockNum = stockNum;
    this.productName = productName;
  }

  public int getSellNum() {
    return sellNum;
  }

  public int getStockNum() {
    return stockNum;
  }

  public String getProductName() {
    return productName;
  }

  public void setSellNum(int sellNum) {
    this.sellNum = sellNum;
  }

  public void setStockNum(int stockNum) {
    this.stockNum = stockNum;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

}
