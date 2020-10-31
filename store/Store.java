package store;

import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Store extends HashMap<String, ItemHeap>{
/**
Store should keep track of all the itemtypes, itemheaps.
It keeps track of all itemheaps using {@link HashMap}
Adding an itemheap can only occur when an itemheap contains one item at least.  
Total report for defective items will occur in the server so just file a report to the server.
*/
	
	/** maybe have a server and db?
			think of heapnum algo.
			how many bits.
			maybe brandshould have a number to?
			where should the transition from brandname to brand happen
	*/

	private static HashMap<ItemType, String> type_to_num; 
	private static HashMap<String, String> brand_to_num;
	private static HashMap<String, String> name_to_num;

	//static method for converting item into a heapnum: need to figure this out
	private static String item_to_heapnum(Item item){
		return type_to_num.get(item.type) + brand_to_num.get(item.brandname) + name_to_num.get(item.name);
	}

  public Store(){
		super();
  }
	
	public Store(ItemHeap[] given){
		this();
		for (int len = 0; len < given.length; len++){
			put(Store.item_to_heapnum(given[len].firstitem), given[len]);
		} 	
	}

	public void freshen_up(){
		Iterator<String> alicia_keys = keySet().iterator();
		while(alicia_keys.hasNext()){
			ItemHeap of_interest = get(alicia_keys.next());
			of_interest.remove_expired();
		}
	}

	/** we must sort out the new items and place them on the right itemheap*/
	public void restock(Item[] newitems){
		for (Item item : newitems){
			String heapnum = Store.item_to_heapnum(item);
			ItemHeap heap = get(heapnum);
			heap.add(item);
		}
	}
}