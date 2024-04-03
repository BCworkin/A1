package students.items;

public class BirdTargetedSpot extends Item {

	public String symbol;
	
	public BirdTargetedSpot() {
		super(5, 5, 0);
		this.symbol = "!";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}
