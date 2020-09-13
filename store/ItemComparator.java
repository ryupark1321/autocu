package store;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.function.ToIntFunction;

public class ItemComparator implements Comparator<Item>{
    private boolean FreshFirst;

    public ItemComparator(){
      FreshFirst = false;
    }

    @Override
    public int compare(Item i1, Item i2) {
      if (!FreshFirst){  return i1.isFresher(i2);}
      return i2.isFresher(i1);
    }
  
    protected void setOldFresh(boolean new_one){
      FreshFirst = new_one;
    }

    @Override
    public Comparator<Item> reversed() {
        ItemComparator a = new ItemComparator();
        a.setOldFresh(!FreshFirst);
        return a;
    }
  
    @Override 
    public boolean equals(Object obj){
      if (obj.getClass().getName().equals("ItemComparator")){
        ItemComparator ic = (ItemComparator) obj;
        return ((FreshFirst && ic.FreshFirst) || (!FreshFirst && !ic.FreshFirst));
      }
      return false;
    }
}