package students.items;

public class Grain extends Food {
	
	private static int grainGenerationCount = 0;

	public Grain() {
		super(2,6,2,"G","g",1);
	}
	
	public static int getGenerationCount() {
		
		return grainGenerationCount;

	}
}
