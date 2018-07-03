
public class TestSandwich {

	public static void main(String[] args) {
		//create two sandwich objects, first with default constructor and second custom
		Sandwich Tuna = new Sandwich();
		Sandwich Turkey = new Sandwich("turkey", "rye", 5.99);
		
		//display sandwich properties
		display(Tuna);
		display(Turkey);
		
		//use set methods to change sandwich properties 
		Tuna.setIngredient("tuna with onions");
		Tuna.setBreadType("white");
		Tuna.setPrice(5.49);
		
		//display new 'Tuna' sandwich
		display(Tuna);
	}
	public static void display(Sandwich s) {
		//static display method making use of 'get' methods
		System.out.println("Sandwich\nMain Ingredient: " + s.getIngredient() + "\nBread Type: " + s.getBreadType() + "\nPrice: $" + s.getPrice() + "\n");
	}
}
