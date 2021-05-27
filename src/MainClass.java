import java.util.Scanner;

public class MainClass {

	public void start() {
		
	}
	
	public static void main(String[] args) {
		int _codeNumber = 0, rowIndex = 0, columnIndex = 0;
		double totalPrice = 0.0, insertMoney = 0.0, change = 0.0;
		Scanner input = new Scanner(System.in);
		SnackMachine snackMachine = new SnackMachine();
		
		// Let experimental information
		for(int i = 0; i < snackMachine.getRow(); i++) {
			for(int j = 0; j < snackMachine.getColumn(); j++) {
				double demoPrice = i + 10;
				int demoCode = ((i + 1) * 10) + j;
				int countDemo = i * 2;
				snackMachine.setSnakes("Snack [ " + i + ", " + j + " ]", demoPrice, demoCode, countDemo, i, j);
			}	
		}
		
		// case 1 : Customer wants to purchase snack.
		System.out.println("Hello in SnackMachine System.");
		
		do {
			// case 2 : Customer selects an code number by the keypad 
			System.out.println("Please enter the snack code number.");
			System.out.print("Code number : " );
			_codeNumber = input.nextInt();
			
			// case 3 : Snack is available for the selected code number and priced.
			rowIndex = (_codeNumber / 10) - 1;
			columnIndex = _codeNumber % 10;
		
			if(rowIndex < 0)
				rowIndex = 0;	
			if(rowIndex > 4 || columnIndex > 4) {
				System.out.println("This code number does not exist");
				rowIndex = 4; 
				columnIndex = 4;
			} else if(snackMachine.getSnakes(rowIndex, columnIndex).getCode() == _codeNumber) {
				snackMachine.getSnakes(rowIndex, columnIndex).isAvailable();
			} else {
				System.out.println("This code number does not exist");
			}
			
		} while(snackMachine.getSnakes(rowIndex, columnIndex).getCode() != _codeNumber);
		
		// case 4 : Customer inserts the money.
		// case 8: (Condition inside while) VM monitors the amount of the accepted money.
		while(totalPrice < snackMachine.getSnakes(rowIndex, columnIndex).getPrice()) {	
			System.out.print("Insert money : ");
			insertMoney =  (double) input.nextDouble();
			if(insertMoney <= 1 &&  insertMoney > 0) {
				Coin _coin = new Coin();
				// case 5 : VM validates money.
				if(_coin.checkCoin(insertMoney)) { 
					_coin.setCoin(insertMoney);
					// case 6 : Accepts the money. 
					snackMachine.addCoin(_coin);
					// case 7 : VM displays the accumulated amount of money.
					totalPrice = snackMachine.totalPrice();
					System.out.println("The amount of money : " + totalPrice + " $");
				} else {
					System.out.println("************************************************");
					System.out.println("Sorry, our dear customer.");
					System.out.println("The Snack Machine only accepts 10c, 20c, 50c, 1$");
					System.out.println("************************************************");
				}
			} else if(insertMoney > 1) {
				Note _note = new Note();
				// case 5 : VM validates money.
				if(_note.checkNote((int)insertMoney)) {
					_note.setNote((int)insertMoney);
					// case 6 : Accepts the money. 
					snackMachine.addNote(_note);
					// case 7 : VM displays the accumulated amount of money.
					totalPrice = snackMachine.totalPrice();
					System.out.println("The amount of money : " + totalPrice + " $");
				} else {
					System.out.println("*****************************************");
					System.out.println("Sorry, our dear customer.");
					System.out.println("The Snack Machine only accepts 20$ or 50$");
					System.out.println("*****************************************");
				}
			}
		}
		System.out.println("Thank you, dear customer, eat your snack with pleasure.");
		change = snackMachine.change(rowIndex, columnIndex);
		
		// case 10 : VM displays the change. 
		if(change > 0) {
			System.out.println("Receive the change money: " + change + " $");
			// case 11 : VM dispenses change.
			int note50 = 0, note20 = 0, coin1 = 0, coin50c = 0, coin20c = 0, coin10c = 0;
			while(change != 0) {
				if(change >= 50) {
					change -= 50;
					note50++;
				} else if (change >= 20) {
					change -= 20;
					note20++;
				} else if (change >= 1) {
					change -= 1;
					coin1++;
				} else if (change >= 0.5) {
					change -= 0.5;
					coin50c++;
				} else if (change >= 0.2) {
					change -= 0.2;
					coin20c++;
				}  else if (change >= 0.1) {
					change -= 0.1;
					coin10c++;
				}
			}
			if(note50 > 0) 
				System.out.println("The rest " + note50 + " coin of 50 $");
			else if (note20 > 0) 
				System.out.println("The rest " + note20 + " coin of 20 $");
			else if (coin1 > 0) 
				System.out.println("The rest " + coin1 + " coin of 1 $");
			else if (coin50c > 0)
				System.out.println("The rest " + coin50c + " coin of 50 cent");
			else if (coin20c > 0)
				System.out.println("The rest " + coin20c + " coin of 20 cent");
			else if (coin10c > 0) 
				System.out.println("The rest " + coin10c + " coin of 10 cent");
		} else {
			System.out.println("There is no money left.");
		}
		
		input.close();
	}
}
