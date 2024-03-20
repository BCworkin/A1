package students;

import students.*;
import students.items.*;
import java.util.Scanner;


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
		Scanner s = new Scanner(System.in);
		Field actualField = new Field(fieldWidth, fieldHeight);
		System.out.println(actualField);
		System.out.println("Bank balance: $" + startingFunds);
		System.out.println("\n");
		System.out.println("Enter your next action: ");
		System.out.println("  t x y: till");
		System.out.println("  h x y: harvest");
		System.out.println("  p x y: plant");
		System.out.println("  s: field summary");
		System.out.println("  w: wait");
		System.out.println("  q: quit");
		String choice = s.next();
		int x = s.nextInt();
		int y = s.nextInt();
		if (choice.equals("t")) {
			System.out.println("Hi");
			actualField.till(x, y);
		    actualField.tick();
		    run();
		} else if (choice.equals("p")) {
			Scanner sFood = new Scanner(System.in);
			System.out.println("Enter: ");
			System.out.println("- 'a' to buy an apple for $2");
		    System.out.println("- 'g' to buy grain for $1");
		    String foodChoice = sFood.next();
		    if (foodChoice.equals("a")) {
		    	actualField.plant(x, y, new Apples());
		    } else if (foodChoice.equals("g")) {
		    	actualField.plant(x, y, new Grain());
		    }
		    actualField.tick();
		    run();
		} 
		
	}
	
}
