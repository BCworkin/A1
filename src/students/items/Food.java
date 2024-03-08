package students.items;

public abstract class Food extends Item {
	
	public Food(int maturationAge, int deathAge, int monetaryValue) {
		super(maturationAge, deathAge, monetaryValue);
	}
	
	public int getGenerationCount() {
		return 0;
	}


}
