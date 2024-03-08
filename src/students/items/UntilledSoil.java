package students.items;

public class UntilledSoil extends Item {

	public String symbol;
	
	public UntilledSoil() {
		super(0, 0, -1);
		this.symbol = "/";
	}
	
	@Override
	public String toString() {
		return this.symbol;
	}
}

