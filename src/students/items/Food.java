package students.items;

public abstract class Food extends Item {
	
	private String afterMatureSymbol;
	private String beforeMatureSymbol;
	private int costToBuy;
	
	public Food(int maturationAge, int deathAge, int monetaryValue, String afterMatureSymbol, String beforeMatureSymbol, int costToBuy) {
		super(maturationAge, deathAge, monetaryValue);
		this.afterMatureSymbol = afterMatureSymbol;
		this.beforeMatureSymbol = beforeMatureSymbol;
		this.costToBuy = costToBuy;
	}

}
