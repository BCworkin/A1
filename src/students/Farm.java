package students;

import students.*;


public class Farm {
	
	private int fieldWidth;
	private int fieldHeight; 
	private int startingFunds;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.startingFunds = startingFunds;
	}
	
	public void run()
	{
		Field actualField = new Field(fieldWidth, fieldHeight);
		System.out.println(actualField);
		System.out.println("Bank balance: $" + startingFunds);
	}
	
}
