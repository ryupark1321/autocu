import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Comparator;

public class ItemHeap extends PriorityQueue<Item> {
	/**
	 * Programming Notes
	 * 
	 * ## Big Picture Analysis - Maybe have a server that controls all the stores? -
	 * Each store contains an array of pointers to each ItemHeap - Here, we need to
	 * think about what we exactly need. The store does not necessarily have to look
	 * for a specific item, we just need to be able to pull out the first items.
	 */
	public Item firstitem;
	public HashMap<Integer, Item> map; // have the sernum, you can find the item.
	public ArrayList<Item> catalog;
	private boolean isFull;
	public String brand;

	// There needs to be at least one item for
	public ItemHeap(Item i) {
		firstitem = i;
		catalog = new ArrayList<Item>(100);
		map = new HashMap<Integer, Item>();
		catalog.add(i);
		map.put(i.sernum, i);
		isFull = false;
		brand = i.brandname; // in case the itemheap becomes empty
	}

	public boolean equals(ItemHeap p) {
		return (firstitem.equals(p.firstitem)) && (map.equals(p.map)) && (catalog.equals(p.catalog));
	}

	public String toString() {
		return "Catalog for " + firstitem.type.toString() + " and the freshest item is : " + firstitem.toString();
	}

	public boolean isEmpty() {
		return catalog.isEmpty();
	}

	public void remove_expired(){
		int len = catalog.size();
		if (len == 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			Item item = catalog.get(i);
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
		boolean a = (map.put(new_item.sernum, new_item) != null);
		boolean b = catalog.add(new_item);
		int size = catalog.size();
		isFull = (100 <= size);
		bubbleUp();
		if (isFull) {
			catalog.trimToSize();
		}
		if (size == 1 || peek().equals(new_item)){
			firstitem = new_item;
		}
		return a && b;
	}

	@Override
	public boolean remove(Object object) {
		if (object.getClass().getName() != "Item") {
			return false;
		}
		Item sold_item = map.remove(((Item) object).sernum);
		if (sold_item != null) {
			int last_position = catalog.size() - 1;
			catalog.set(catalog.indexOf(sold_item), catalog.get(last_position));
			catalog.remove(last_position);
			bubbleDown();
			isFull = (100 <= catalog.size());
			if (isFull) {
				catalog.trimToSize();
			}
			int size = catalog.size();
			if (size == 0){
				firstitem = null;
			}else{
				firstitem = peek();
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("In progress: needs poll");
	}

	public Item peek() {
		return catalog.get(0);
	}

	public void clear() {
		map.clear();
		catalog.clear();
		firstitem = null;
	}

	public int size() {
		return map.size();
	}

	public boolean offer(Item item) {
		if (isFull) {
			return false;
		}
		return add(item);
	}

	public Iterator<Item> iterator() {
		return catalog.iterator();
	}

	public Object[] toArray() {
		return catalog.toArray();
	}

	public <Item> Item[] toArray(Item[] a) {
		return catalog.toArray(a);
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

	public Comparator<Item> comparator() {
		return (new ItemComparator());
	}

	/**
	 * <i> is the serial number of the item. So, the assumption is that reading the
	 * barcode will automatically identify the serial number.
	 */
	public boolean contains(Object object) {
		if (object instanceof Item) {
			return false;
		}
		return map.containsKey(((Item) object).sernum);
	}

	/**
	 * swap(self,target) switches the position of [self] and [target] in catalog.
	 */
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
	}

}