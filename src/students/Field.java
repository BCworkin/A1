package students;

import students.items.*;

public class Field {
	
	private int height;
	private int width;
	private Item[][] field;
	private int totalValue;
	
	public Field(int height, int width) {
		
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		this.totalValue = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	public void tick() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j].tick();
				if (field[i][j].age > field[i][j].deathAge) {
					field[i][j].died();
					field[i][j] = new UntilledSoil();
				}
				if (field[i][j].monetaryValue == 0) {
					if(Math.random() < 0.2) {
						field[i][j] = new Weed();
					}
				}
			}
		}
	}
	
	
	public Object get(int x, int y) {
		return field[x][y];
	}
	
	public void plant(int x, int y, Item item) {
		field[x][y] = item;
	}
	
	public void till(int x, int y) {
		field[x][y] = new Soil();
	}
	
	public int getValue() {
		
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
}
