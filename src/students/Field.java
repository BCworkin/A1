package students;

import students.items.*;

public class Field {
	
	private int height;
	private int width;
	private Item[][] field;
	
	public Field(int height, int width) {
		
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
			
		}
		
	}
	
	public String get(int x, int y) {
		return field[x][y].toString();
	}
	
	public int getValue() {
		
		public int totalValue;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				totalValue += field[i][j].getValue();
			}
		}
		return totalValue;
	}
	
	public String toString() {
		StringBuilder fieldDisplay = new StringBuilder();
		for (int i = 0; i < width; i++) {
			fieldDisplay.append(i);
		}
		for (int i = 0; i < height; i++) {
			fieldDisplay.append(i + 1);
			for (int j = 0; j < width; j++) {
				fieldDisplay.append(field[i][j].toString());
			}
		return fieldDisplay.toString();
		}
	}
	
}
