public class ItemType{
  public String type;  //type is onto which category of the store the item will be classified to
  public boolean perishable; // self-explanatory

	/** An ItemType defines the category into which the item will be sorted into as well as whether the item is perishable or not. */
  public ItemType(String s, boolean b){
    type = s;
    perishable = b;
		if(s.equals("")){
			raise Exception("NoItemTypeException")
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