package students.items;

public class Weed extends Item {
	
	public String symbol;
	
	public Weed() {
		super(1000, 1000, -1);
		this.symbol = "#";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}
