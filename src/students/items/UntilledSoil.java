package students.items;

public class UntilledSoil extends Item {

	public String symbol;
	
	public UntilledSoil() {
		super(1000, 1000, -1);
		this.symbol = "/";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}

