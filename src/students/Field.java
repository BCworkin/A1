package students;

import students.items.*;

public class Field {
	
	private int height;
	private int width;
	private Item[][] field;
	private int totalValue;
	private int weedCount;
	private int untilledSoilCount;
	private int soilCount;
	private int applesCount;
	private int grainCount;
	private int chomperCount;
	private Item[][] originalItem;
	
	public Field(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.field = new Item[width][height];
		this.totalValue = 0;
		//for bird 
		this.originalItem = new Item[width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	// modified tick to return coins if any birds were eaten when farm was attacked
	public void tick() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j].tick();
				if (field[i][j] instanceof Soil && field[i][j].monetaryValue == 0) {
	                if(Math.random() < 0.2) {
	                    field[i][j] = new Weed();
	                } else {
	                	field[i][j] = new Soil();
	                }
				} else if (field[i][j].age > field[i][j].deathAge) {
					field[i][j].died();
					field[i][j] = new UntilledSoil();
				} 
			}
	    }
		birdAttack();
	}
	
	public void birdAttack() {
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (field[i][j] instanceof Apples || field[i][j] instanceof Grain || field[i][j] instanceof Chomper) {
					// bird targeted produce will show a symbol
	                if(Math.random() < 0.5) {
	                	// store the original produce before replacing it
	                    originalItem[i][j] = field[i][j];
	                    
	                    // replace the produce with a BirdTargetedSpot
	                    field[i][j] = new BirdTargetedSpot();
	                }
					//bird successfully stole produce
				} else if (field[i][j] instanceof BirdTargetedSpot) {
					if (originalItem[i][j] instanceof Chomper) {
						//uses the instance of the previously created chomper to eat the bird
						Chomper c = (Chomper) originalItem[i][j];
						c.eatBird();
				        field[i][j] = c;
	                	System.out.println("\n");
					} else {
                	System.out.println("Birds stole the produce at " + i + "," + j + ", *laughs in bird language!*");
                	System.out.println("\n");
                    field[i][j] = new Soil();
				}
				}
			}
		}
	}
	
	// will be called when user wants to chase bird away from stealing produce
	public void chase(int x, int y) {
	    // checks if the spot contains a BirdTargetedSpot and restore the original produce
	    if (field[x][y] instanceof BirdTargetedSpot) {
	        System.out.println("Bird chased away at " + x + "," + y +". SHOOOOOOOO");
	        System.out.println("\n");
	        field[x][y] = originalItem[x][y];
	    }
	}
	
	public int harvest(int x, int y) {
		
		// soldPrice will be the worth of that specific produce
		int soldPrice = field[x][y].monetaryValue;	
		if (field[x][y] instanceof Apples) {
			applesCount --;
			System.out.println("Sold 'A' for 3");
			field[x][y] = new Soil();
		} else if (field[x][y] instanceof Grain) {
			grainCount --;		
			System.out.println("Sold 'G' for 2");
			field[x][y] = new Soil();
		} else if (field[x][y] instanceof Chomper) {
			chomperCount --;		
			System.out.println("Sold 'C' for 8");
			field[x][y] = new Soil();
		} else {
			System.out.println("There's nothing to harvest.");
		}
		return soldPrice;
	}
	
	public Object get(int x, int y) {
		
		return field[x][y];
	}
	
	public void plant( int x, int y , Item item) {
				
	    if (field[x][y] instanceof Weed) {
	    	System.out.println("Can't plant on these annoying weeds my friend. Look carefully next time. :(");
	    	System.out.println("\n");
	    } else if (field[x][y] instanceof UntilledSoil) {
	    	System.out.println("Can't plant on untilled soil my friend. Start tilling. :(");
	    	System.out.println("\n");
	    } else if (field[x][y] instanceof Chomper) {
	    	System.out.println("CHOMP!");
	    	System.out.println("\n");
	    } else if (field[x][y] instanceof Apples || field[x][y] instanceof Grain) {
	    	System.out.println("Can't plant on produce, plant elsewhere.");
	    	System.out.println("\n");
	    } else if (item instanceof Apples || item instanceof Grain || item instanceof Chomper) {
	        Food foodItem = (Food) item;
	        field[x][y] = foodItem;
	        }
		}
	
	// just to till soil 
	public void till(int x, int y) {
		
		field[x][y] = new Soil();
	}
	
	//getValue of the field 
	public int getValue() {
		
		totalValue = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				totalValue += field[i][j].getValue();
			}
		}
		return totalValue;
	}
	
	//to print map of farm
	public String toString() {
		
		StringBuilder fieldDisplay = new StringBuilder();
		fieldDisplay.append("  ");
	    for (int i = 0; i < width; i++) {
	        fieldDisplay.append(i + 1).append(" ");
	    } 
	    fieldDisplay.append("\n"); 
	    for (int j = 0; j < height; j++) {
	        fieldDisplay.append(j + 1).append(" ");
	        for (int i = 0; i < width; i++) {
	            fieldDisplay.append(field[i][j].toString()).append(" "); 
	        }
	        fieldDisplay.append("\n"); 
	    }
	    return fieldDisplay.toString();
	}
	
	// get summary of the game so far
	public void getSummary() {
		
		applesCount = 0;
		grainCount = 0;
		weedCount = 0;
		untilledSoilCount = 0;
		soilCount = 0;
		chomperCount = 0;
				
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (field[i][j] instanceof Weed) {
					weedCount++;
				} else if (field[i][j] instanceof UntilledSoil) {
					untilledSoilCount++;
				} else if (field[i][j] instanceof Chomper) {
					chomperCount++;
				} else if (field[i][j] instanceof Apples) {
					applesCount++;
				} else if (field[i][j] instanceof Grain) {
					grainCount++;
				} else {
					soilCount++;
				}
			}
		}
		//string builder to connect all the statistics
		StringBuilder summary = new StringBuilder();
		summary.append("Apples:        " + applesCount);
		summary.append("\n");
		summary.append("Grains:        " + grainCount);
		summary.append("\n");
		summary.append("Chompers:      " + chomperCount);
		summary.append("\n");
		summary.append("Soil:          " + soilCount);
		summary.append("\n");
		summary.append("Untilled:      " + untilledSoilCount);
		summary.append("\n");
		summary.append("Weed:          " + weedCount);
		summary.append("\n");
		summary.append("For a total off $" + getValue());
		summary.append("\n");
		summary.append("Total apples created:    " + Apples.getGenerationCount());
		summary.append("\n");
		summary.append("Total grain created:     " + Grain.getGenerationCount());
		summary.append("\n");
		summary.append("Total chompers created:  " + Chomper.getGenerationCount());
		summary.append("\n");
		System.out.println(summary);
	}
}

