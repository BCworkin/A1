package students.items;


public class Chomper extends Food {

    private static int chomperGenerationCount = 0;
    
	public Chomper() {
		super(6,12,8,"C","c",6);
		chomperGenerationCount++;

	}

	public static int getGenerationCount() {
		
		return chomperGenerationCount;
		
	}
	
	
}
