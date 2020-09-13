package store;

import java.util.Date;

public class Item{

  public final ItemType type;
  public final int sernum;
  public final Date importedate;
  public final String name;
  public final Date expr;
  public double price;
  public String brandname;
     
  public Item(ItemType t, int s, Date i, String n, Date e, double p, String b){
    type = t;
    sernum = s;
    importedate = i;
    name = n;
    expr = e;
    price = p;
		brandname = b;
  }

  public boolean equals(Item i){
    return (i.type.equals(type)) && (i.sernum == sernum) && (i.importedate.equals(importedate)) && (name.equals(i.name)) && (expr.equals(i.expr)) && (price == i.price) && (brandname.equals(i.brandname));
  }
            
  public String toString(Item i){
    return name;
  }
            
  public void showInfo(){
    System.out.println("Name : " + name);
    System.out.println("Serial Number : " + Integer.toString(sernum));
    System.out.println("Item Classification : " + type.toString());
    if (type.perishable) {
      System.out.println("Expiration Date : " + expr.toString());
    }
    System.out.println("Imported Date : " + importedate.toString());
    System.out.println("Price : " + Double.toString(price));
		System.out.println("Brand : " + brandname);
  }

  /** Precondition: Item is perishable. */
  public boolean isExpired(){
    Date now = new Date();
    return (expr.after(now));
  }
    
  /** Precondition: Same itemtype, same product, different items.
  Returns positive if current item is fresher than the other one.*/
  public int isFresher(Item a){
    int impr_comp = importedate.compareTo(a.importedate);
    if (type.perishable){
      int expr_comp = expr.compareTo(a.expr);
      if (expr_comp == 0) { return impr_comp; }
      return expr_comp;
    } 
    return impr_comp;
  }
    
  public void setPrice(double f){
    price = f;
  }
}