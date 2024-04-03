package students;

import java.util.InputMismatchException;


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
			try {
		        System.out.println(actualField);
		        System.out.println("Bank balance: $" + startingFunds);
		        System.out.println("\n");
		        System.out.println("Enter your next action: ");
		        System.out.println("  t x y: till");
		        System.out.println("  h x y: harvest");
		        System.out.println("  p x y: plant");
		        System.out.println("  c x y: chase bird away");
		        System.out.println("  s: field summary");
		        System.out.println("  w: wait");
		        System.out.println("  q: quit");
		        System.out.println("\n");
		        String choice = s.next();
		        switch (choice) {
		        case "t":
		        case "h":
		        case "p":
		        case "c":
		            int x = s.nextInt() - 1;
		            int y = s.nextInt() - 1;
		            if (x >= 0 && x < fieldWidth && y >= 0 && y < fieldHeight) {
		                switch (choice) {
		                    case "t":
		                        actualField.till(x, y);
		                        break;
		                    case "p":
		                        System.out.println("Enter: ");
		                        System.out.println("- 'a' to buy an apple for $2");
		                        System.out.println("- 'g' to buy grain for $1");
		                        System.out.println("- 'c' to buy chomper for $6");
		                        String foodChoice = s.next();
		                        if (foodChoice.equals("a") && startingFunds >= 2) {
		                            Apples a = new Apples();
		                            startingFunds -= a.costToBuy;
		                            actualField.plant(x, y, a);
		                        } else if (startingFunds <= 2) {
		                            System.out.println("You do not have enough money to buy apples");
		                        } else if (foodChoice.equals("g") && startingFunds >= 1) {
		                            Grain g = new Grain();
		                            startingFunds -= g.costToBuy;
		                            actualField.plant(x, y, g);
		                        } else if (startingFunds <= 1) {
			                            System.out.println("You do not have enough money to buy grain");
		                        } else if (foodChoice.equals("c") && startingFunds >= 8) {
		                            Chomper c = new Chomper();
		                            startingFunds -= c.costToBuy;
		                            actualField.plant(x, y, c);
		                        } else if (startingFunds <= 8) {
		                            System.out.println("You do not have enough money to buy a chomper");
		                        }
		                        break;
		                    case "h":
		                        startingFunds += actualField.harvest(x, y);
		                        break;
		                    case "c":
		                        actualField.chase(x, y);
		                        break;
		                }
		            } else {
		                System.out.println("Numbers given has exceeded the index for the given map.");
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
		            break;
		    }
		        actualField.tick();
	    } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid input.");
            s.next();
	    	}
		}
		s.close();
	} 
}
