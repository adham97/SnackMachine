import java.util.ArrayList;

public class SnackMachine {
	private int row = 5 , column = 5;
	private Snack snacks[][];
	private ArrayList<Coin> coins;
	private double totalCoin;
	private ArrayList<Note> notes;
	private int totalNote;
	private double totalPrice;
	private double change;
	
	SnackMachine() {
		this.row = 5;
		this.column = 5;
		this.snacks = new Snack[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column ; j++) {
				snacks[i][j] = new Snack();
			}	
		}
		this.coins = new ArrayList<Coin>();
		totalCoin = 0.0;
		this.notes = new ArrayList<Note>();		
		totalNote = 0;
		change = 0.0;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public Snack getSnakes(int rowIndex, int columnIndex) {
		return this.snacks[rowIndex][columnIndex];
	}
	
	public void setSnakes(String name, double price, int code, int count, int rowIndex, int columnIndex) {
		this.snacks[rowIndex][columnIndex].setName(name);
		this.snacks[rowIndex][columnIndex].setPrice(price);
		this.snacks[rowIndex][columnIndex].setCode(code);
		this.snacks[rowIndex][columnIndex].setCount(count);
	}
	
	public void addCoin(Coin coin) {
		this.coins.add(coin);
	}
	
	public double totalCoin() {
		totalCoin = 0.0;
		if(coins.size() != 0) {
			for(int i = 0; i < coins.size(); i++) {
				totalCoin += coins.get(i).getCoin();
			}	
		}
		return totalCoin;
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}
	
	public int totalNote() {
		totalNote = 0;
		if(!notes.isEmpty()) {
			for(int i = 0; i < notes.size(); i++) {
				totalNote += notes.get(i).getCoin();
			}	
		}
		return totalNote;
	}
	
	public double totalPrice() {
		totalPrice = 0.0;
		return this.totalPrice = this.totalCoin() + this.totalNote();
	}
	
	public double change(int rowIndex, int columnIndex) {
		change = 0.0;
		this.change = this.totalPrice - this.snacks[rowIndex][columnIndex].getPrice();
		return this.change;
	}
}
