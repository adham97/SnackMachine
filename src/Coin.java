public class Coin {
	private double value;
	
	public Coin() {
		this.value = 0.0;
	}
	
	public Coin(double value) {
		if(checkCoin(value)) {
			this.value = value;
		} else {
			System.out.println("Sorry, our dear customer.");
			System.out.println("The Snack Machine only accepts 10c, 20c, 50c, 1$");
		}
	}
	
	boolean checkCoin(double value) {
		return (value == 0.1 || value == 0.2 || value == 0.5 || value == 1);
	}
	
	public void setCoin(double value) {
		this.value = value;
	}
	
	public double getCoin() {
		return value;
	}
}
