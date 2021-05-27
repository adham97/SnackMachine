public class Note {
	private int value;
	
	public Note() {
		this.value = 0;
	}
	
	public Note(int value) {
		if(checkNote(value)) {
			this.value = value;
		} else {
			System.out.println("Sorry, our dear customer.");
			System.out.println("The Snack Machine only accepts 20$ or 50$");
		}
	}
	
	boolean checkNote(int value) {
		return (value == 20 || value == 50);
	}
	
	public void setNote(int value) {
		if(checkNote(value)) {
			this.value = value;
		} else {
			System.out.println("Sorry, our dear customer.");
			System.out.println("The Snack Machine only accepts 20$ or 50$");
		}
	}
	
	public int getCoin() {
		return value;
	}
}
