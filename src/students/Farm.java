package students;

import students.items.*;
import java.util.Scanner;
import java.util.Random;

import students.items.*;
import java.util.Random;

import students.items.*;


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
	                        } else if (foodChoice.equals("g") && startingFunds >= 1) {
	                            Grain g = new Grain();
	                            startingFunds -= g.costToBuy;
	                            actualField.plant(x, y, g);
	                        } else if (foodChoice.equals("c") && startingFunds >= 8) {
	                            Chomper c = new Chomper();
	                            startingFunds -= c.costToBuy;
	                            actualField.plant(x, y, c);
	                        } else {
	                            System.out.println("You do not have enough money to make purchase.");
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
	         // cow release
//            case "r":
//                System.out.println("Enter: ");
//                System.out.println("- 'm' to buy a cow for $8");
//                String animalChoice = s.next();
//                if (animalChoice.equals("m") && startingFunds >= 8) {
//                    Cow m = new Cow();
//                    startingFunds -= m.costToBuy;
//                    actualField.release(m);
//                } else if (animalChoice.equals("a") || animalChoice.equals("g")) {
//                    System.out.println("You can't release produce.");
//                } else if (animalChoice.equals("m") && startingFunds <= 8) {
//                	System.out.println("Not enough funds to buy.");
//                } else {
//                	System.out.println("Invalid input");
//                }
//    	        cowLoop = false;
//                break;
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
	    }
		    s.close(); 
	}
}
