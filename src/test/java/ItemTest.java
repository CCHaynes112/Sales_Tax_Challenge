import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testGetTax() {
		Item item1 = new Item("BookTest", ItemType.Book, 11.99, false);
		Item item2 = new Item("OtherTest", ItemType.Other, 23.00, false);
		
		Item item3 = new Item("ImportBookTest", ItemType.Book, 3.23, true);
		Item item4 = new Item("ImportOtherTest", ItemType.Other, 491.18, true);
		
		assertEquals(0, item1.getTax(), 0.1);
		assertEquals(2.3, item2.getTax(), 0.1);
		
		assertEquals(0.15, item3.getTax(), 0.1);
		assertEquals(73.7, item4.getTax(), 0.1);
	}
	
	@Test
	public void testGetItemTotal() {
		Item item1 = new Item("BookTest", ItemType.Book, 11.99, false);
		Item item2 = new Item("OtherTest", ItemType.Other, 23.00, false);
		
		Item item3 = new Item("ImportBookTest", ItemType.Book, 3.23, true);
		Item item4 = new Item("ImportOtherTest", ItemType.Other, 491.18, true);
		
		assertEquals(11.99, item1.getItemTotal(), 0.1);
		assertEquals(25.3, item2.getItemTotal(), 0.1);
		
		assertEquals(3.38, item3.getItemTotal(), 0.1);
		assertEquals(564.88, item4.getItemTotal(), 0.1);
	}

}
