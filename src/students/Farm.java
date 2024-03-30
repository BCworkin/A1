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
		boolean continueProgram = true;
	    Field actualField = new Field(fieldWidth, fieldHeight);

		while (continueProgram) {
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
	        System.out.println("\n");
	        String choice = s.next();
	        switch(choice) {
		        case "t":
		        case "h":
		        case "p":
		        	int x = s.nextInt() - 1;
		        	int y = s.nextInt() - 1;

		            switch (choice) {
			            case "t":
			                actualField.till(x, y);
			                break;
			            case "p":
			                System.out.println("Enter: ");
			                System.out.println("- 'a' to buy an apple for $2");
			                System.out.println("- 'g' to buy grain for $1");
			                String foodChoice = s.next();
			                if (foodChoice.equals("a") && startingFunds >= 2) {
			                	Apples a = new Apples();
			                	startingFunds -= a.costToBuy;
			                    actualField.plant(x, y, a);
			                } else if (foodChoice.equals("g") && startingFunds >= 1) {
			                	Grain g = new Grain();
			                	startingFunds -= g.costToBuy;
			                    actualField.plant(x, y, g);
			                } else {
			                	System.out.println("You do not have enough money to make purchase.");
			                }
			                break;
			            case "h":
			                startingFunds += actualField.harvest(x, y);
			                break;
			        }
		            break;
		        case "s":
		        	actualField.getSummary();
		        	break;
			    case "w":
			        break;
			    case "q":
			        continueProgram = false;
			        break;
			    default:
			        System.out.println("Invalid choice. Please try again.");
			}
	        actualField.tick();
	    }
		    s.close(); 
	}
}
