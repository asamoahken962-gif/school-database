package database;

public class Course implements Comparable<Course> {
//The interface that allows us to define how Course objects are compared.
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	//The class is the blueprint, and the constructor tells Java how to initialize an object using the values you provide.
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits){	
				this.isGraduateCourse = isGraduateCourse;
				this.courseNum = courseNum;
				this.courseDept = courseDept;
				this.numCredits = numCredits;
				
				}

	public int getCourseNum() {
		return courseNum;
	}
	public String getCourseDept() {
		return courseDept;
	}
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		String level; // Using the string level to store either "G" or "U"
			if(isGraduateCourse) {
				
				level = "G";
				
			}else {				//if its a graduate course the level will pick between G and U, Remember isGraduateCourse is a boolean
				
				level = "U";
			}
		
		return level + courseDept + courseNum;
				}
	
	@Override		// This method returns if a boolean is true or false
	public boolean equals(Object obj) { 
		if(!(obj instanceof Course)) {
			return false;  //  This checks if the object we are comparing it to is even a course to begin with if its not return false rightaway
		}
	
		Course other = (Course) obj;
		//Casting the object
		//Treat the object as a Course so we can access its Course fields
		
		//Finally we compare its values if it pasted all the conditions
		return isGraduateCourse == other.isGraduateCourse
		        && courseNum == other.courseNum
		        && courseDept.equals(other.courseDept)
		        && numCredits == other.numCredits;
	
	}
		@Override
		public String toString() {
			// We intianalize level because we want it to display wheater the student is a gruaduate or not 
			String level;
			
			if (isGraduateCourse) {
				level = "Graduate";
				
			}else {
				
				level = "Undergraduate";
			}
			//This here is just making the course object we declare have readable code in a certain format
			return String.format( "Course: %3s-%3d | Number of Credits: %02d  | %s",
			        courseDept, courseNum, numCredits, level);
			
			
				}
		// So this method Compares to Coure Objects by their Course Numbers
		@Override
		public int compareTo(Course c) {
		    return Integer.compare(this.courseNum, c.courseNum);// Inter.compare compares them By -1 0 1, -1 being the smaller number 
		}														// Zero Being equal, and 1 being the bigger number goes last
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

