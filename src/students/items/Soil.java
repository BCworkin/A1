package students.items;

public class Soil extends Item {

	public String symbol;
	
	public Soil() {
		super(1000, 1000, 0);
		this.symbol = ".";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}

