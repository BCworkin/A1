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
	
	public Field(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.field = new Item[width][height];
		this.totalValue = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
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
				}    else if (field[i][j].age > field[i][j].deathAge) {
						field[i][j].died();
						field[i][j] = new UntilledSoil();
				}
			}
		}
	}
	
	public int harvest(int x, int y) {
		int soldPrice = field[x][y].monetaryValue;	
		if (field[x][y] instanceof Apples) {
			applesCount --;
			System.out.println("Sold 'A' for 3");
		} else if (field[x][y] instanceof Grain) {
			grainCount --;		
			System.out.println("Sold 'G' for 2");
		}
		field[x][y] = new Soil();
		return soldPrice;
	}
	  
	
	public Object get(int x, int y) {
		return field[x][y];
	}
	
	public void plant( int x, int y , Item item) {
				
		if (item instanceof Food) {
	        Food foodItem = (Food) item;
	        field[x][y] = foodItem;
	        }
		}
	
	public void till(int x, int y) {
		field[x][y] = new Soil();
	}
	
	public int getValue() {
		
		totalValue = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				totalValue += field[i][j].getValue();
			}
		}
		return totalValue;
	}
	
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
	
	public void getSummary() {
		
		applesCount = 0;
		grainCount = 0;
		weedCount = 0;
		untilledSoilCount = 0;
		soilCount = 0;
				
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (field[i][j] instanceof Weed) {
					weedCount++;
				} else if (field[i][j] instanceof UntilledSoil) {
					untilledSoilCount++;
				} else if (field[i][j] instanceof Apples) {
					applesCount++;
				} else if (field[i][j] instanceof Grain) {
					grainCount++;
				} else {
					soilCount++;
				}
			}
		}
		StringBuilder summary = new StringBuilder();
		summary.append("Apples:        " + applesCount);
		summary.append("\n");
		summary.append("Grains:        " + grainCount);
		summary.append("\n");
		summary.append("Soil:          " + soilCount);
		summary.append("\n");
		summary.append("Untilled:      " + untilledSoilCount);
		summary.append("\n");
		summary.append("Weed:          " + weedCount);
		summary.append("\n");
		summary.append("For a total off $" + getValue());
		summary.append("\n");
		summary.append("Total apples created: " + Apples.getGenerationCount());
		summary.append("\n");
		summary.append("Total grain created:  " + Grain.getGenerationCount());
		summary.append("\n");
		System.out.println(summary);
	}
}

