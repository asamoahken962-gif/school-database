package database;

public class Student extends Person {

	private static int numStudents = 0;
	private int studentID;
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	public Student() {
		super();
		
		numStudents++;
		studentID = numStudents;
		
		coursesTaken = new Course[50];
		numCoursesTaken= 0;
		isGraduate = false;
		major = "undeclared";
	}
	
	public Student(boolean isGraduate) {
		super();
		numStudents++;
		studentID = numStudents;
		
		coursesTaken = new Course[50];
		numCoursesTaken= 0;
		
		major = "undeclared";
		this.isGraduate = isGraduate;
		
	}
	
	public Student(String major, boolean isGraduate) {
		super();
		numStudents++;
		studentID = numStudents;
		
		coursesTaken = new Course[50];
		numCoursesTaken= 0;
		this.major = major;
		this.isGraduate = isGraduate;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name,birthYear);
		numStudents++;
		studentID = numStudents;
		
		coursesTaken = new Course[50];
		numCoursesTaken= 0;
		this.major = major;
		this.isGraduate = isGraduate;
		
	}
	
	public boolean isGraduate() {
		return this.isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	public int getStudentID() {
		return studentID;
	}
	public String getMajor() {
		return major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {					  // coursesTaken = the list of courses
																// numCoursesTaken = how many courses are already stored,
		if (numCoursesTaken < coursesTaken.length)	{			// which tells us the next available index
																	//course = the new Course object we're adding
	        coursesTaken[numCoursesTaken] = course; 

	        numCoursesTaken++;
	    }
	}

public void addCoursesTaken(Course[] courses) {

    for (int i = 0; i < courses.length; i++) {
        addCourseTaken(courses[i]);
    }
}

	public Course getCourseTaken(int index) { //if the method receives a index check if its valid

	    if (index >= 0 && index < numCoursesTaken) {
	        return coursesTaken[index]; // it returns what ever course is at that index
	    }

	    return null;
	}													
//
	public String getCourseTakenAsString(int index) { //if the method recieves a sti

	    Course course = getCourseTaken(index);

	    if (course == null) {
	        return "";
	    }

	    return course.getCourseDept() + "-" + course.getCourseNum();
	}
	
	public String getAllCoursesTakenAsString() {

	    String result = "";

	    for (int i = 0; i < numCoursesTaken; i++) {

	        if (i > 0) {
	            result += ", ";
	        }

	        result += getCourseTakenAsString(i);
	    }

	    return result;
	}
	
	@Override
	public boolean equals(Object obj) {

	    if (!(obj instanceof Student)) {
	        return false;
	    }

	    Student other = (Student) obj;

	    if (!super.equals(other)) {
	        return false;
	    }

	    if (studentID != other.studentID ||
	        isGraduate != other.isGraduate ||
	        !major.equals(other.major) ||
	        numCoursesTaken != other.numCoursesTaken) {
	        return false;
	    }

	    for (int i = 0; i < numCoursesTaken; i++) {

	        if (!coursesTaken[i].equals(other.coursesTaken[i])) {
	            return false;
	        }
	    }

	    return true;
	}
	
	@Override
	public String toString() {

	    String level = "";

	    if (isGraduate) {
	        level = "Graduate";
	    } else {
	        level = "Undergraduate";
	    }

	    return super.toString() +
	           String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
	               studentID, major, level, numCoursesTaken, getAllCoursesTakenAsString());
	}
	private int getTotalCredits() {
	    int total = 0;

	    for (int i = 0; i < numCoursesTaken; i++) {
	        total += coursesTaken[i].getNumCredits();
	    }

	    return total;
	}

	@Override
	public int compareTo(Person p) {

	    if (p instanceof Student) {
	        Student other = (Student) p;

	        return Integer.compare(
	            this.getTotalCredits(),
	            other.getTotalCredits()
	        );
	    }

	    return super.compareTo(p);
	}
	
	
	
	
	
	
	
	
	
}
