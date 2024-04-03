package students.items;

public abstract class Item {
	
	public int age;
	public int maturationAge;
	public int deathAge;
	public int monetaryValue;
	
	public Item(int maturationAge, int deathAge, int monetaryValue) {
		
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue;
		 
	}

	public void tick() {
		age ++;
	}
	
	public void setAge(int age) {
		
		this.age = age;
	}
	
	public boolean died() {
		
		return age > deathAge;
	}
	
	public int getValue() {
		
		if (age >= maturationAge) {
			return monetaryValue;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Object obj) {
		
		Item comparingObj = (Item) obj;
		if (age == comparingObj.age && maturationAge == comparingObj.maturationAge && deathAge == comparingObj.deathAge && monetaryValue == comparingObj.monetaryValue) {
			return true;
		} else {
			return false;
		}
	}
	
	// abstract method that will be inherited by child classes
	public abstract String toString();
}

