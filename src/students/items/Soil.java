package students.items;

public class Soil extends Item {

	public String symbol;
	
	public Soil() {
		super(0, 0, -1);
		this.symbol = ".";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}

