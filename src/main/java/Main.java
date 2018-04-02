import java.util.*;
public class Main {

	public static void main(String[] args) 
	{
		System.out.println("*****Example Receipt:*****");
		output1();
		System.out.print("\n");
		output2();
		System.out.print("\n");
		output3();
		
		
		Scanner reader = new Scanner(System.in);
		
		int userInput = 0;
		while(true)
		{
			try {
				System.out.println("\nWould you like to add an item?\n1.)Yes\n0.)No");
				userInput = reader.nextInt();
				reader.nextLine();
				break;
			}
			catch (Exception e) {
				System.out.print("Error: Invalid Input" + "\n");
				reader.next();
				continue;
			}
		}
		
		Cart cart = new Cart();
		while(userInput == 1)
		{
			userPurchase(reader, cart);
			
			while(true)
			{
				try {
					System.out.print("What would you like to do:\n0.)Print receipt\n1.)Add another item");
					userInput = reader.nextInt();
					reader.nextLine();
					break;
				}
				catch (Exception e) {
					System.out.print("Error: Invalid Input" + "\n");
					reader.next();
					continue;
				}
			}
			
			if(userInput == 0)
			{
				System.out.print("\n");
				cart.displayCart();
				break;
			}
		}
		
		System.out.println("Thank you!");
		reader.close();
		System.exit(0);
	}

	//The first output receipt
	static void output1()
	{
		Cart cart = new Cart();
		
		Item item1 = new Item("book", ItemType.Book, 12.49, false);
		Item item2 = new Item("music CD", ItemType.Other, 14.99, false);
		Item item3 = new Item("chocolate bar", ItemType.Food, 0.85, false);

		cart.addToList(item1);
		cart.addToList(item2);
		cart.addToList(item3);
		
		cart.displayCart();
	}
	
	//The second output receipt
	static void output2()
	{
		Cart cart = new Cart();
		Item item1 = new Item("imported box of chocolates", ItemType.Food, 10.00, true);
		Item item2 = new Item("imported bottle of perfume", ItemType.Other, 47.50, true);
		
		cart.addToList(item1);
		cart.addToList(item2);
		
		cart.displayCart();
	}
	
	//The third output receipt
	static void output3()
	{
		Cart cart = new Cart();
		
		Item item1 = new Item("imported bottle of perfume", ItemType.Other, 27.99, true);	
		Item item2 = new Item("bottle of perfume", ItemType.Other, 18.99, false);
		Item item3 = new Item("packet of headache pills", ItemType.Medical, 9.75, false);
		Item item4 = new Item("imported box of chocolates", ItemType.Food, 11.25, true);
		
		cart.addToList(item1);
		cart.addToList(item2);
		cart.addToList(item3);
		cart.addToList(item4);
		
		cart.displayCart();
	}
	
	//Handles a user created cart
	static void userPurchase(Scanner reader, Cart c)
	{
		String itemName;
		ItemType itemType;
		double itemCost;
		boolean itemImport;

		while(true)
		{
			try {
				System.out.println("Please enter the name of your item: ");
				itemName = reader.nextLine();
				
				System.out.println("What type of product is your item?\n1.)Book\n2.)Food\n3.)Medical\n4.)Other");
				itemType = ItemType.values()[reader.nextInt()-1];
				reader.nextLine();
				
				System.out.println("Please enter the cost of your item: ");
				itemCost = reader.nextDouble();
				reader.nextLine();
				
				System.out.println("Is your item imported?\n1.)Yes\n0.)No");
				itemImport = (reader.nextInt() == 1);
				reader.nextLine();
				
				Item item1 = new Item(itemName, itemType, itemCost, itemImport);
				c.addToList(item1);
				System.out.println(itemName + " has been added to your cart.");
				break;
			}
			catch (Exception e) {
				System.out.print("Error: Invalid Input" + "\n");
				reader.nextLine();
				continue;
			}
		}
	}
}
