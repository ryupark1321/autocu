import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.*;
import store.*;


public class ItemHeapTest {

	@Test
	public void typetest() {
		System.out.println("we started here");
		ItemType type1 = new ItemType("Electronics",false);
		ItemType type2 = new ItemType("LifeStyle",true);
		ItemType type3 = new ItemType("Food",true);
		ItemType type4 = new ItemType("Dairy",true);
		
		//Constructor Test
		assertEquals(type1.perishable, false);
		assertEquals(type1.type, "Electronics");
		assertEquals(type2.perishable, true);
		assertEquals(type2.type, "LifeStyle");
		assertEquals(type3.perishable, true);
		assertEquals(type3.type, "Food");
		assertEquals(type4.perishable, true);
		assertEquals(type4.type, "Dairy");
		
		//toString Test
		assertEquals(type1.toString(), "Electronics");
		assertEquals(type2.toString(), "LifeStyle");
		assertEquals(type3.toString(), "Food");
		assertEquals(type4.toString(), "Dairy");

		//equals Test
		ItemType type5 = new ItemType("Electronics",false);
		ItemType type6 = new ItemType("LifeStyle",false);
		ItemType type7 = new ItemType("Food",true);
		ItemType type8 = new ItemType("Office Supply",true);

		assertEquals(type1.equals(type5), true);
		assertEquals(type2.equals(type6), false);
		assertEquals(type3.equals(type7), true);
		assertEquals(type4.equals(type8), false);
	}
	@Test
	public void itemtest() {
		ItemType type1 = new ItemType("Electronics",false);
		ItemType type2 = new ItemType("LifeStyle",true);
		ItemType type3 = new ItemType("Food",true);
		ItemType type4 = new ItemType("Dairy",true);

		Date day1 = new Date(2021,1,1);
		Date day2 = new Date(2021,1,2);
		Date day3 = new Date(2021,1,3);
		Date day4 = new Date(2021,1,4);

		String name1 = "name1";
		String name2 = "name2";
		String name3 = "name3";
		String name4 = "name4";

		Date eday1 = new Date(2022,1,1);
		Date eday2 = new Date(2022,1,2);
		Date eday3 = new Date(2022,1,3);
		Date eday4 = new Date(2022,1,4);
	
		double f1 = 1.99;
		double f2 = 2.99;
		double f3 = 3.99;
		double f4 = 4.99;

		String b1 = "b1";
		String b2 = "b2";
		String b3 = "b3";
		String b4 = "b4";

		Item item1 = new Item(type1, 11111111, day1, name1, eday1, f1, b1);
		Item item2 = new Item(type2, 12121212, day2, name2, eday2, f2, b2);
		Item item3 = new Item(type3, 13131313, day3, name3, eday3, f3, b3);
		Item item4 = new Item(type4, 14141414, day4, name4, eday4, f4, b4);
		
		//Constructor Test
		assertEquals(item1.type, type1);
		assertEquals(item2.type, type2);
		assertEquals(item3.type, type3);
		assertEquals(item4.type, type4);
		assertEquals(item1.sernum, 11111111);
		assertEquals(item2.sernum, 12121212);
		assertEquals(item3.sernum, 13131313);
		assertEquals(item4.sernum, 14141414);
		assertEquals(item1.importedate, new Date(2021,1,1));
		assertEquals(item2.importedate, new Date(2021,1,2));
		assertEquals(item3.importedate, new Date(2021,1,3));
		assertEquals(item4.importedate, new Date(2021,1,4));
		assertEquals(item1.name, "name1");
		assertEquals(item2.name, "name2");
		assertEquals(item3.name, "name3");
		assertEquals(item4.name, "name4");
		assertEquals(item1.expr, new Date(2022,1,1));
		assertEquals(item2.expr, new Date(2022,1,2));
		assertEquals(item3.expr, new Date(2022,1,3));
		assertEquals(item4.expr, new Date(2022,1,4));
		assertEquals(item1.price, 1.99);
		assertEquals(item2.price, 2.99);
		assertEquals(item3.price, 3.99);
		assertEquals(item4.price, 4.99);
		assertEquals(item1.brandname, "b1");
		assertEquals(item2.brandname, "b2");
		assertEquals(item3.brandname, "b3");
		assertEquals(item4.brandname, "b4");

		//Equals Test
		Item item5 = new Item(type1, 11111111, day1, name1, eday1, f1, b1);
		Item item6 = new Item(type2, 12121212, day2, name2, eday2, f2, b2);
		Item item7 = new Item(type3, 13131313, day3, name3, eday3, f3, b3);
		Item item8 = new Item(type4, 14141414, day4, name4, eday4, f4, b4);

		assertEquals(item1.equals(item5), true);
		assertEquals(item2.equals(item6), true);
		assertEquals(item3.equals(item7), true);
		assertEquals(item4.equals(item8), true);
		assertEquals(item1.equals(item6), false);
		assertEquals(item2.equals(item7), false);
		assertEquals(item3.equals(item8), false);
		assertEquals(item4.equals(item5), false);

		//toString Test
		assertEquals(item1.toString(), "name1");
		assertEquals(item2.toString(), "name2");
		assertEquals(item3.toString(), "name3");
		assertEquals(item4.toString(), "name4");

		//isExpired Test
		Date eday5 = new Date(2020,10,5);
		Date eday6 = new Date(2020,10,6);
		Date eday7 = new Date(2020,10,7);
		Date eday8 = new Date(2020,10,8);

		Item item9 = new Item(type1, 11111111, day1, name1, eday5, f1, b1);
		Item item10 = new Item(type2, 12121212, day2, name2, eday6, f2, b2);
		Item item11 = new Item(type3, 13131313, day3, name3, eday7, f3, b3);
		Item item12 = new Item(type4, 14141414, day4, name4, eday8, f4, b4);

		assertEquals(item9.isExpired(), true);
		assertEquals(item10.isExpired(), true);
		assertEquals(item11.isExpired(), true);
		assertEquals(item12.isExpired(), true);
		assertEquals(item1.isExpired(), false);
		assertEquals(item2.isExpired(), false);
		assertEquals(item3.isExpired(), false);
		assertEquals(item4.isExpired(), false);

		//isFresher Test
		assertEquals(item1.isFresher(item2), true);
		assertEquals(item2.isFresher(item3), true);
		assertEquals(item3.isFresher(item4), true);
		assertEquals(item4.isFresher(item3), false);
		assertEquals(item3.isFresher(item2), false);
		assertEquals(item2.isFresher(item1), false);

		//setPrice Test
		item1.setPrice(2.99);
		item2.setPrice(3.99);
		item3.setPrice(4.99);
		item4.setPrice(5.99);

		assertEquals(item1.price, 2.99);
		assertEquals(item2.price, 3.99);
		assertEquals(item3.price, 4.99);
		assertEquals(item4.price, 5.99);
	}
	
	@Test
	public void heaptest() {
		ItemType type1 = new ItemType("Electronics",false);
		Date day1_1 = new Date(2021,1,1);
		Date day1_2 = new Date(2021,1,2);
		Date day1_3 = new Date(2021,1,3);
		Date day1_4 = new Date(2021,1,4);
		String name1 = "name1";
		Date eday1_1 = new Date(2022,1,1);
		Date eday1_2 = new Date(2022,1,2);
		Date eday1_3 = new Date(2022,1,3);
		Date eday1_4 = new Date(2022,1,4);
		double f1 = 1.99;
		String b1 = "b1";
		Item item1_1 = new Item(type1, 11111111, day1_1, name1, eday1_1, f1, b1);
		Item item1_2 = new Item(type1, 12121212, day1_2, name1, eday1_2, f1, b1);
		Item item1_3 = new Item(type1, 13131313, day1_3, name1, eday1_3, f1, b1);
		Item item1_4 = new Item(type1, 14141414, day1_4, name1, eday1_4, f1, b1);

		//Constructor Test
		ItemHeap iheap1 = new ItemHeap(item1_1);
		ItemHeap iheap2 = new ItemHeap(item1_2);
		ItemHeap iheap3 = new ItemHeap(item1_3);
		ItemHeap iheap4 = new ItemHeap(item1_4);
		System.out.println(iheap1.toString());
		System.out.println(iheap2.toString());
		System.out.println(iheap3.toString());
		System.out.println(iheap4.toString());

		//Equals Test
		ItemHeap iheap5 = new ItemHeap(item1_1);
		ItemHeap iheap6 = new ItemHeap(item1_2);
		ItemHeap iheap7 = new ItemHeap(item1_3);
		ItemHeap iheap8 = new ItemHeap(item1_4);
		assertEquals(iheap1.equals(iheap5), true);
		assertEquals(iheap2.equals(iheap6), true);
		assertEquals(iheap3.equals(iheap7), true);
		assertEquals(iheap4.equals(iheap8), true);

		//is_empty, remove, add, toString Test
		assertEquals(iheap1.remove(item1_1), true);
		assertEquals(iheap2.remove(item1_2), true);
		assertEquals(iheap1.remove(item1_1), false);
		assertEquals(iheap2.remove(item1_2), false);
		String test1 = iheap1.toString();
		String test2 = iheap2.toString();
		assertEquals(iheap1.isEmpty(), true);
		assertEquals(iheap2.isEmpty(), true);
		assertEquals(iheap1.add(item1_2), true);
		assertEquals(iheap2.add(item1_1), true);
		assertEquals(test1 == iheap2.toString(), true);
		assertEquals(test2 == iheap1.toString(), true);
		assertEquals(iheap1.add(item1_1), true);
		assertEquals(iheap2.add(item1_2), true);
		assertEquals(iheap1.equals(iheap2), true);

		//findItem Test
		assertEquals(iheap1.findItem(item1_1.sernum).equals(item1_1),true);
		assertEquals(iheap2.findItem(item1_2.sernum).equals(item1_2),true);
		//findItem String Test
		assertEquals(iheap1.findItem_String(item1_1.sernum).equals(item1_1.toString()),true);
		assertEquals(iheap2.findItem_String(item1_2.sernum).equals(item1_2.toString()),true);
	}
}