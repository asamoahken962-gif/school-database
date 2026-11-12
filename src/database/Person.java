package database;

public class Person implements Comparable <Person> {

	private String  name;
	private int birthYear;
	
	public Person() {
		name = "";
		birthYear = 0;
		}
	
	public Person(String name,  int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String name) {
			this.name = name;
	}
	public void setBirthYear(int year) {
		 this.birthYear = year;
	}
	
	public boolean equals(Object Obj) {
		if(!(Obj instanceof Person)) {
			return false;
		}
			
			Person other = (Person) Obj;
			
			return name.equals(other.name)
			&& birthYear == other.birthYear;
			}
	
	@Override
	
	public String toString() {
		
		return String.format("Person: Name: %30s | Birth Year: %4d",name, birthYear );
		
	}
	
	@Override 
	
	public int compareTo(Person p) {
		
		return Integer.compare(this.birthYear, p.birthYear);
	}
	
	
	
}
