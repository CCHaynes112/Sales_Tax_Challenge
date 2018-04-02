public class Item {
	private String name;
	private double cost;
	private double tax;
	private boolean imported;
	private ItemType ItemType;
	
	public Item(String n, ItemType t, double c, boolean i)
	{
		this.name = n;
		this.ItemType = t;
		this.cost = c;
		this.imported = i;
		this.tax = calculateTax();
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}
	
	public double getTax() {
		return tax;
	}

	public boolean isImported() {
		return imported;
	}

	public ItemType getItemType() {
		return ItemType;
	}
	
	//Calculates the tax of this item
	private double calculateTax()
	{
		double itemTax = 0;
		double itemTaxImport = 0;
		
		if(ItemType == ItemType.Other)
		{
			itemTax = cost * 0.10;
		}
		
		if(isImported())
		{
			itemTaxImport = cost * 0.05;
		}
		//Using Math.ceil to round up, because its dealing with taxes
		return Math.ceil((itemTax + itemTaxImport) * 20.0) / 20.0;
	}
	
	//Caclulates the total of the item and returns it
	public double getItemTotal()
	{
		return Math.round((cost + tax) * 100.0) / 100.0;
	}
}
