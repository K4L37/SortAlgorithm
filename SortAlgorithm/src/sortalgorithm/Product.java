package sortalgorithm;

public class Product {

	private String _category;
	private String _brand;
	private String _name;	
	private int _qty;
	
	public Product(String name, String category, String brand, int qty) {
		_category = category;
		_brand = brand;		
		_name = name;
		_qty = qty;
	}	
	
	public String getName() {
		return _name;
	}	

	public String getCategory() {
		return _category;
	}
	
	public String getBrand() {
		return _brand;
	}
	
	public int getQty() {
		return _qty;
	}
}
