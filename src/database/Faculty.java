package database;

public class Faculty extends Employee {

	private Course[] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	
	
	public Faculty() {
		super();
		coursesTaught = new Course[100];// We create an array with 100 spaces because the UML says the most courses teacher can teach is 100
		numCoursesTaught = 0;			// And its an array 
		isTenured = false;
	}
	
	public Faculty(boolean isTenured) {   // Were creating a faculty object were we already the person isTenured
		super();
		coursesTaught = new Course[100];  // The person could teach up to 100 courses 
		numCoursesTaught = 0;
		this.isTenured = isTenured; // We already have this information so connecting to the private field
		}
	public Faculty(String deptName, boolean isTenured) {
		
		super(deptName); // Calls the employee constructer  that accepts the deparmentName
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
		
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name,birthYear,deptName);
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
		}
	
	public boolean isTenured() {
		return isTenured; //returns whether the faculty member is tenured.
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught; //returns how many courses are currently
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured; //allows us to change their tenure status.
	}
	
	public void addCourseTaught(Course course) {  // So now we have a method to help add a new course 
		 if (numCoursesTaught < coursesTaught.length) { // This checks if we have space in the array 

		        coursesTaught[numCoursesTaught] = course;  //Here, I'm using the number of courses taught to keep track of the next available position in my array
//Since arrays start at zero, if a professor already teaches two courses, the next course goes into index two. After adding it, I increase the number of courses taught by one.
		        numCoursesTaught++;
		    }
		
	}
	
	public void  addCoursesTaught(Course[] courses) { //This method just helps me add multiple courses 

	    for (int i = 0; i < courses.length; i++) { // It uses a counter so it can go thought each course and when i call my addcourseTaught it adds to it 

	        addCourseTaught(courses[i]);
	    }
	
	
			}
	
	public Course getCourseTaught(int index) { // This is a getter to basiclly just get the index of a course 

	    if (index >= 0 && index < numCoursesTaught) { // So if the course isnt negative and its less than the array then give us the index
	        return coursesTaught[index];
	    }

	    return null; // if not then return nothing
	}
	
	public String getCourseTaughtAsString(int index) { // We basiclly want to get the course As a string 

	    Course course = getCourseTaught(index); // First we assin couse as the indec

	    if (course == null) { // then we set a conditon if the index is invalid and returns null 
	        return "";
	    }                            // But if not then we return then We get the Course Decription And the number as well with the Dash

	    return course.getCourseDept() + "-" + course.getCourseNum();
	}
	
	public String getAllCoursesTaughtAsString() {

	    String result = ""; // first we declare result to store our info In

	    for (int i = 0; i < numCoursesTaught; i++) { // This is a counter that goes through the Courses 

	        if (i > 0) {
	            result += ", "; // Each time we find a course we add a comma 
	        }

	        result += getCourseTaughtAsString(i); // Then this makes it so we add the course name ever time 
	    }

	    return result;	// And returns everything
	}
	
	@Override
	public boolean equals(Object obj) {

	    if (!(obj instanceof Faculty)) {
	        return false;
	    }

	    Faculty other = (Faculty) obj;

	    if (!super.equals(other)) {
	    	return false;
	    	//Calls the employee method , if all the inheritated info doesnt match return false 
	    }

	    if (isTenured != other.isTenured ||                //if the fields in this class do not match return false
	        numCoursesTaught != other.numCoursesTaught) {
	        return false;
	    }

	    for (int i = 0; i < numCoursesTaught; i++) {		// because we are comparing arrays we will need a counter , if the index dont math
	        if (!coursesTaught[i].equals(other.coursesTaught[i])) { // return false
	            return false;
	        }
	    }

	    return true; //if all conditions match return true
	}
	@Override
	public String toString() {
		String tenure;                 //To string is how we make the info in object Readable 
		if (isTenured) {				// The UML wants is to make it a certain way and says istenured/NotTrenured
		      tenure = "Is Tenured"; // So we can declares a string and make it a condition to fuful that in the String.format
		    } else {
		        tenure = "Not Tenured";
		    }

		    return super.toString() +
		        String.format(
		            " Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
		            tenure, numCoursesTaught, getAllCoursesTaughtAsString()
		        );
		}
	@Override
	public int compareTo(Person p) {

	    if (p instanceof Faculty) {

	        Faculty other = (Faculty) p;

	        return Integer.compare(
	            this.numCoursesTaught,
	            other.numCoursesTaught
	        );
	    }

	    return super.compareTo(p);
	}











}
	
	

	
	
	
	
	
	
	
	
	

