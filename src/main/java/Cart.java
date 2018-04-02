import java.util.*;

public class Cart {
	private ArrayList<Item> itemList;

	public Cart()
	{
		itemList = new ArrayList<Item>();
	}

	public void addToList(Item item)
	{
		itemList.add(item);
	}
	
	//Calculates the tax of the cart
	private double calculateTax()
	{
		double tax = 0;
		for(Item item: itemList)
		{
			tax += item.getTax();
		}
		//Using Math.ceil to round up, because its dealing with taxes
		return Math.ceil(tax * 20.0) / 20.0;
	}
	
	//Calculates the total of the cart
	private double calculateTotal()
	{		
		double total = 0;
		for(Item item: itemList)
		{
			total += item.getItemTotal();
		}
		return Math.round(total * 100.0) / 100.0;
	}
	
	//Displays all cart information
	public void displayCart()
	{
		for(Item item: itemList)
		{
			System.out.println("1 " + item.getName() + ": " + item.getItemTotal());
		}
		System.out.println("Sales Taxes: " + calculateTax());
		System.out.println("Total: " + calculateTotal());
	}
	
}
