package students.items;

public class Cow extends Food {

    private static int cowGenerationCount = 0;
    
	public Cow() {
		super(6,12,13,"M","m",8);
		cowGenerationCount++;

	}
	
	public static int getGenerationCount() {
		
		return cowGenerationCount;
		
	}
}
