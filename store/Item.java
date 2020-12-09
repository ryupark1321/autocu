package store;

import java.util.Date;

public class Item{

  public final ItemType type; // type is the itemtype the item falls under
  public final int sernum; // sernum is the serial number of the item
  public final Date importedate; // importedate is the date of import to the store
  public final String name; // name is the literal name of the item given by the company
  public final Date expr; // expr is the expiration date of the item
  public double price;
  public String brandname; //literal name of the brand

  /** Item made from this constructor is an unperishable item without an expiration date. */
  public Item(ItemType t, int s, Date i, String n, double p, String b){
    type = t;
    sernum = s;
    importedate = i;
    name = n;
    price = p;
	brandname = b;
	expr = null;
  }
	
  /** Item made from this constructor is an unperishable item with an expiration date. */
  public Item(ItemType t, int s, Date i, String n, Date e, double p, String b){
    this(t,s,i,n,p,b);
	expr = e;
  }

  /** equals returns whether an item i and this item are the same item. */
  public boolean equals(Item i){
    return (i.type.equals(type)) && (i.sernum == sernum) && (i.importedate.equals(importedate)) && (name.equals(i.name)) && (expr.equals(i.expr)) && (price == i.price) && (brandname.equals(i.brandname));
  }
            
  /** toString returns only the name of this item */
  public String toString(){
    return name;
  }
            
  /** 
    showInfo prints detailed information about this item including name, serial number, itemtype, 
    expiration date, imported date, price, and brandname. 
  */
  public String showInfo(){
    String str_1 = "Name : " + name + " \n" + "Serial Number : " + Integer.toString(sernum) + " \n" +
		"Item Classification : " + type.toString() + " \n"; 
    if (type.perishable) {
      str_1 += "Expiration Date : " + expr.toString() + " \n";
    }
    String str_2 = "Imported Date : " + importedate.toString() + " \n" + "Price : " + Double.toString(price) + " \n" +
		"Brand : " + brandname;
		return (str_1+str_2);
  }

  /** 
    isExpired returns whether the item is expired or not.
  	Precondition: Item is perishable. 
  */
  public boolean isExpired(){
    Date now = new Date();
    return (now.after(expr));
  }
    
  /** 
    [isFresher] returns < 0 if this item is fresher than item [a],
	returns 0 if this item is as old as item [a],
	and returns > 0 if this item is older than item [a].
	Comparison is done by first taking a look at expiration dates 
	and if both items are unperishable or have the same expiration date, 
	comparison result is dependent on imported dates.

	Precondition: Same itemtype, same product, different items.
    Returns positive if current item is fresher than the other one.
  */
  public int isFresher(Item a){
    int impr_comp = importedate.compareTo(a.importedate);
    if (type.perishable){
      int expr_comp = expr.compareTo(a.expr);
      if (expr_comp == 0) { return impr_comp; }
      return expr_comp;
    } 
    return impr_comp;
  }

  /**
    [setPrice] sets the price to [f]. 
  */
  public void setPrice(double f){
    price = f;
	return;
  }
}