package pers.shaw.distribute.server;  

import java.io.Serializable;

public class User implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -1019744464626011978L;
  private String name;
  private int Id;

  public int getId() {
    return Id;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    Id = id;
  }

  public void setName(String name) {
    this.name = name;
  }


}
