package students.items;

public class Apples extends Food {
	
	private static int appleGenerationCount = 0;
	
	public Apples() {
		super(3,5,3,"A","a",2);
		appleGenerationCount ++;
	}
	
	public static int getGenerationCount() {
		
		return appleGenerationCount;
		
	}
	
	@Override
	public String toString() {
		if (age < maturationAge) {
			return beforeMatureSymbol;
		} else {
		return afterMatureSymbol;
		}
	}
}
