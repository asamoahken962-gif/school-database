package database;

public class Employee extends Person  {

	private  String deptName;
	private static int numEmployees = 0; // because this field is static we know that the numEmployees will increase as another employee gets a new Id
	private int employeeID;
	
	
	public Employee() {
		super();
		deptName = "";
		numEmployees++;// If we get another employee we want the counter to add 1
		employeeID = numEmployees;// We want the employee ID to equal the amount of employees we have
		
		}
	
	public Employee(String deptName){ //This is a constructor for if we only have the employees DeptName
		super();						// We dont have the other info so we Call the person constructor with No values and only 
		this.deptName = deptName;		//have the deptName declared to the private field, this.deptName = deptName;
		numEmployees++;					//And since its an employee we use the counter to add one and make the employee ID MAtch the numEmployees
		employeeID = numEmployees;
		}
	
	
	public Employee(String name, int birthYear, String deptName) {
		super(name,birthYear);
		this.deptName = deptName;
		numEmployees++;
		employeeID = numEmployees;
	}
	
	public  String getDeptName() {
		return deptName;
	}
	public static int getNumEmployees() {
			return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override 
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Employee)) {
			return false;
		}
	
	Employee other = (Employee) obj;
	
	       return super.equals(other) // were comparing everything including the information inherited from the person contructor 
			&& deptName.equals(other.deptName)
			&& employeeID == other.employeeID;
	
	}
	@Override         // my toString method makes the info in my object readable 
	public String toString() {
		return super.toString() + // i used super.toString to call the persons class to string which gives the name,birthYea
		 String.format(" Employee: Department: %20s | Employee Number: %3d",deptName, employeeID );//then use sting.format to add the deptName and Id
	}
	
	@Override
	
	public int compareTo(Person p) { // Im comparing to Employees
		if(p instanceof Employee) { //First my person checks if the person is actually an employye if they are compare Id 
			Employee other = (Employee) p;
			return Integer.compare(this.employeeID, other.employeeID);
		}
		return super.compareTo(p);  // But if they aren't call the parent compareTo to compare their birth years
	
	
	}
	
	
	
	
	
	
	
	
}
