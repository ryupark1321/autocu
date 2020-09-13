package Store;

import java.util.HashMap;

public class Store{
/**
Store should keep track of all the itemtypes, itemheaps.
It keeps track of all itemheaps using {@link HashMap}
Adding an itemheap can only occur when an itemheap contains one item at least.  
Total report for defective items will occur in the server so just file a report to the server.
*/
	private HashMap<String, ItemHeap> items_map;

  public Store(){
		items_map = new HashMap<String,ItemHeap>(100);
  }
	
	public Store(ItemHeap[] given){
		this();
		for (int len = 0; len < given.length; len++){
			addItemHeap(given[len]);
		} 	
	}

	public HashMap<String, ItemHeap> getMap(){
		return items_map;
	}

	public void remove_from_Map(String s){
		items_map.remove(s);
	}

	public ItemHeap addItemHeap(ItemHeap ih){
		return items_map.put(ih.firstitem.name, ih);
	}

	//update needs to be more efficient, maybe take in a tuple of input?
	//also, assume that only the same sort of items are in the same row 
	public void update(Item[][] items){
		for (int r = 0; r < items.length; r++){
			ItemHeap ih = items_map.get(items[r][0].name);
			boolean b = false;
			int c = 0;
			while (!b){
				Item item = items[r][c];
				if (item != null) {
					ih.add(item);
					c++;
				}else{
					b = true;
				}
			}
		}
		items_map.forEach(new Updater());
	}
}