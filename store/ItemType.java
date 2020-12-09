package store;

public class ItemType{
  public String type;  // type is the name of the classification that the item falls under
  public boolean perishable; // perishable is a variable for telling whether the item has an expiration date

  /** An ItemType defines the category into which the item will be sorted into as well as whether the item is perishable or not. */
  public ItemType(String s, boolean b){
    type = s;
    perishable = b;
		try{
			if(s.equals("")){throw new Exception("NoItemTypeException");}
		}catch (Exception e){
			System.out.println("Try Again");
		}
  }
                
  /** equals(a,t) compares the two fields and returns true if the two fields of the itemtypes a and t matches. */
  public boolean equals(ItemType t){
    return (type.equals(t.type)) && (perishable == t.perishable);
  }
                
  /** toString() returns the type of the item, not whether the item is perishable. */
  public String toString(){
    return type;
  }
 }