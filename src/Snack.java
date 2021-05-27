public class Snack {
	private String name;
	private double price;
	private int code;
	private int count;
	
	public Snack() {
		this.name = "";
		this.price = 0.0;
		this.code = 0;
		this.count = 0;
	}
	
	public Snack(String name, double price, int code, int count) {
		this.name = name;
		this.price = price;
		this.code = code;
		this.count = count;
	}
	
 	public String getName() {
		return this.name;
	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public double getPrice() {
		return this.price;
	}
 	
 	public void setPrice(double price) {
 		this.price = price;
 	}
 	
 	public int getCode() {
		return this.code;
	}
 	
 	public void setCode(int code) {
 		this.code = code;
 	}
 	

 	public int getCount() {
		return this.count;
	}
 	
 	public void setCount(int count) {
 		this.count = count;
 	}
 	
 	public void isAvailable() {
 		if (this.count >= 0)
 			System.out.println("The snack " + this.name + " is available, and priced : " + this.price + " $");
 		else
 			System.out.println("Sorry, the snack is not available at the moment.");
 	} 
}
