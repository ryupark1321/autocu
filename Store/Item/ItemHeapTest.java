import org.junit.Test;
 
import static org.junit.Assert.*;

import java.util.*;

import Store.Item.*;

public class ItemHeapTest{

	@Test
	public void itemtypetest1(){
		ItemType type1 = new ItemType("Electronics",false);
		ItemType type2 = new ItemType("LifeStyle",true);
		ItemType type3 = new ItemType("Food",true);
		ItemType type4 = new ItemType("Dairy",true);

		assertEquals(type1.perishable, false);
		assertEquals(type1.type, "Electronics");
		assertEquals(type2.perishable, true);
		assertEquals(type2.type, "LifeStyle");
		assertEquals(type3.perishable, true);
		assertEquals(type3.type, "Food");
		assertEquals(type4.perishable, true);
		assertEquals(type4.type, "Dairy");

		//toSTring tests
		assertEquals(type1.toString(), "Electronics");
		assertEquals(type2.toString(), "LifeStyle");
		assertEquals(type3.toString(), "Food");
		assertEquals(type4.toString(), "Dairy");

		//equals tests
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
	public void itemtest(){
		ItemType type1 = new ItemType("Electronics",false);
		ItemType type2 = new ItemType("LifeStyle",true);
		ItemType type3 = new ItemType("Food",true);
		ItemType type4 = new ItemType("Dairy",true);

		/**
		Item item1 = new Item(type1, 11111111, Date i, "Yonex Ezone 98 305g", Date e, 11.99, String b);
		Item item2 = new Item(type2, 12121212, Date i, String n, Date e, float p, String b);
		Item item3 = new Item(type3, 13131313, Date i, String n, Date e, float p, String b);
		Item item4 = new Item(type4, 14141414, Date i, String n, Date e, float p, String b);
		*/
	}
	




}