package students.items;

public class Chomper extends Food {

    private static int chomperGenerationCount = 0;
    private int birdsEaten;
    
	public Chomper() {
		super(8,20,8,"C","c",6);
		chomperGenerationCount++;

	}
	
	
	public void eatBird() {
		// when chomper eats a bird, its value increase by $1
		monetaryValue++;
		if (birdsEaten > 1) {
			age++;
			birdsEaten = 0;
		}
		System.out.println("CHOMPER CHOMPS BIRDY, value increases by $1");
	}

	public static int getGenerationCount() {
		
		return chomperGenerationCount;
		
	}
	
	
}
