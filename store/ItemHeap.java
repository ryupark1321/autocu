package store;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Comparator;

public class ItemHeap extends PriorityQueue<Item> {
	public Item firstitem;
	public HashMap<Integer, Item> map; // have the sernum, you can find the item.
	public String brand;
	public String itemname;
	/** want to have a unique number for the item classification. Decode it. */

	// There needs to be at least one item for
	public ItemHeap(Item i) {
		super(new ItemComparator());
		map = new HashMap<Integer, Item>();
		super.add(i);
		map.put(i.sernum, i);
		firstitem = i;
		brand = i.brandname; // in case the itemheap becomes empty
	}

	public boolean equals(ItemHeap p) {
		return (firstitem.equals(p.firstitem)) && (map.equals(p.map)) && brand.equals(p.brand);
	}

	@Override
	public String toString() {
		Item[] a = new Item[0];
		String items = "";
		for (Item item : toArray(a)){
			items += item.toString() + " ";
		}
		if (firstitem == null){return "Catalog for " + brand + " " + itemname + " and the freshest item is : " + " NULL"
				+ " and the items in the list are : " + items;}
		return "Catalog for " + brand + " " + itemname + " and the freshest item is : " + firstitem.showInfo()
				+ " and the items in the list are : " + items;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	public void remove_expired() {
		int len = size();
		if (len == 0) {
			return;
		}
		Iterator<Item> looper = iterator();
		while(looper.hasNext()){
			Item item = looper.next();
			if (item.isExpired()) {
				remove(item);
			}
		}
	}

	@Override
	public boolean add(Item new_item) {
		if (new_item == null) {
			return false;
		}
		if (new_item.isExpired()) {
			return false;
		}
		boolean a = (map.put(new_item.sernum, new_item) == null);
		boolean b = super.add(new_item);
		if (firstitem == null){ firstitem = new_item;}
		return a && b;
	}

	@Override
	public boolean remove(Object object){
		if ((object instanceof Item) == false) {
			return false;
		}
		Item the_item = (Item) object;
		if (map.get(the_item.sernum) == null){	return false;}
		boolean a = (map.remove(the_item.sernum, the_item));
		boolean b = super.remove(object);
		if (firstitem.equals(the_item)){firstitem = null;}
		return a && b;
	}

	@Override
	public void clear() {
		super.clear();
		map.clear();
		firstitem = null;
	}

	/** return null if the item was not there in the first place. */
	public String findItem_String(int i) {
		Integer j = i;
		return map.get(j).toString();
	}

	public Item findItem(int i) {
		Integer j = i;
		return map.get(j);
	}

	/**
	 * <i> is the serial number of the item. So, the assumption is that reading the
	 * barcode will automatically identify the serial number.
	 */
	@Override
	public boolean contains(Object object) {
		if ((object instanceof Item) == false){
			return false;
		}
		return map.containsKey(((Item) object).sernum);
	}

	/**
	 * swap(self,target) switches the position of [self] and [target] in catalog.
	 
	private void swap(int self, int target) {
		Item item_a = catalog.get(self);
		catalog.set(self, catalog.get(target));
		catalog.set(target, item_a);
	}

	private void bubbleUp() {
		boolean b = false;
		int position = catalog.size() - 1;
		Item balloon_item = catalog.get(position);
		int target_pos = 0;
		int comparison = 0;
		while (!b) {
			if (position % 2 == 0) {
				target_pos = position / 2 - 1;
			} else {
				target_pos = (position - 1) / 2;
			}
			comparison = balloon_item.isFresher(catalog.get(target_pos));
			if (comparison == 0 || comparison < 0) {
				return;
			}
			swap(position, target_pos);
			if (target_pos == 0) {
				b = true;
			}
			position = target_pos;
		}
	}

	private void bubbleDown() {
		int position = 0;
		boolean b = (2 > catalog.size());
		Item parachute_item = catalog.get(position);
		int target_pos_one = 0;
		int target_pos_two = 0;
		int comparison = 0;
		while (!b) {
			if (2 * position + 2 == catalog.size()) {
				target_pos_one = 2 * position + 1;
				comparison = catalog.get(target_pos_one).isFresher(parachute_item);
				if (comparison == 0 || comparison < 0) {
					return;
				}
				swap(position, target_pos_one);
				b = true;
			} else {
				target_pos_one = 2 * position + 1;
				target_pos_two = 2 * position + 2;
				// since we need the freshest item on the top, we must compare all three items.
				boolean one_fresher_than_two = (catalog.get(target_pos_one).isFresher(parachute_item) >= 0);
				if (one_fresher_than_two) {
					comparison = catalog.get(target_pos_one).isFresher(parachute_item);
					if (comparison == 0 || comparison < 0) {
						return;
					}
					swap(position, target_pos_one);
					b = (2 * position + 2 > catalog.size());
				} else {
					comparison = catalog.get(target_pos_two).isFresher(parachute_item);
					if (comparison == 0 || comparison < 0) {
						return;
					}
					swap(position, target_pos_two);
					b = (2 * position + 2 > catalog.size());
				}
			}
		}
	}*/
}