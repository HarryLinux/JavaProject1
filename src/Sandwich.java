
public class Sandwich {
	//variables for data fields
	private String mainIngredient;
	private String breadType;
	private double price;
	
	//default constructor for sandwich object
	public Sandwich() {
		mainIngredient = "tuna";
		breadType = "wheat";
		price = 4.99;
	}
	
	//overloaded constructor for custom sandwiches
	public Sandwich(String i, String b, double p) {
		mainIngredient = i;
		breadType = b;
		price = p;
	}
	
	//get methods for data fields
	public String getIngredient() {
		return mainIngredient;
	}
	public String getBreadType() {
		return breadType;
	}
	public double getPrice() {
		return price;
	}
	
	//set methods for data fields
	public void setIngredient(String s) {
		mainIngredient = s;
	}
	public void setBreadType(String s) {
		breadType = s;
	}
	public void setPrice(double p) {
		price = p;
	}
}
