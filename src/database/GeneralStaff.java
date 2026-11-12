package database;

public class GeneralStaff extends Employee{

	private String duty;
	
	
	public GeneralStaff() {
		duty = "";
	}
	
	public GeneralStaff(String duty) {
		super();
		this.duty = duty;
	}
	
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear,deptName );
		this.duty = duty;
	}
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof GeneralStaff)) {
			return false;
		}
	
	GeneralStaff other = (GeneralStaff) obj;
	
	
	return super.equals(other) 
			&& duty.equals(other.duty);
	}
	
	@Override
	 public String toString() {
		
		return super.toString()	+
		String.format(" GeneralStaff: Duty: %10s|", duty );
	}
	
	
}
