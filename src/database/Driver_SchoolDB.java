package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver_SchoolDB {

    public static void main(String[] args) {
    	ArrayList<Course> courses = new ArrayList<>();// Creates a list that stores course objects
    	ArrayList<Faculty> faculty = new ArrayList<>();		// Creates a list that stores Faculty objects
    	ArrayList<Student> students = new ArrayList<>(); // Creates a list that stores Student Objects
    	ArrayList<GeneralStaff> staff = new ArrayList<>();// Creates a list that stores Student Objects
    	
    	
    	
    	
    	
    	
    	
    	
    	try {										   //Courses is the name we give that list 
        											   //new ArrayList<>() creates an empty list
        	File file = new File("SchoolDB_Initial.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                System.out.println(line);
                								// Also this is also how its knows were to start 
                if (line.startsWith("Course:")) {  // We are taking the string and turning it into a course object: Confirms if its a course
                //I am converting the text file information into the neccesary data types for the course object im going to Use 
                    String information = line.substring(7).trim();				// This removes the course and the semi colon

                    String[] parts = information.split(",");		//Separates words by commas

                    boolean graduate = Boolean.parseBoolean(parts[0].trim());		

                    int number = Integer.parseInt(parts[1].trim()); //Integer.parseInt turns string numbers into Integers

                    String department = parts[2].trim(); //Removes any surrounding white spaces

                    int credits = Integer.parseInt(parts[3].trim());

                    Course course = new Course(                  
                        graduate, number, department, credits // 
                    );

                    courses.add(course);	//And this Stores the object in the array list 
                }
               
                
                
                
                else if (line.startsWith("Faculty:")) {

                    String information = line.substring(8).trim();

                    String[] parts = information.split(",");

                    Faculty professor = null;

                    if (information.isEmpty()) {

                        professor = new Faculty();

                    } else if (parts.length == 1) {

                        boolean tenured = Boolean.parseBoolean(parts[0].trim());

                        professor = new Faculty(tenured);

                    } else if (parts.length == 2) {

                        String department = parts[0].trim();

                        boolean tenured = Boolean.parseBoolean(parts[1].trim());

                        professor = new Faculty(department, tenured);

                    } else if (parts.length == 4) {

                        String name = parts[0].trim();

                        int birthYear = Integer.parseInt(parts[1].trim()); 

                        String department = parts[2].trim();

                        boolean tenured = Boolean.parseBoolean(parts[3].trim());

                        professor = new Faculty(name, birthYear, department, tenured);
                    }

                    if (professor != null) { // Our code Only handles 0,1,2,4 values so this checks that 

                        faculty.add(professor);
                    }
                }
                
                else if (line.startsWith("Student:")) {

                    String information = line.substring(8).trim();

                    String[] parts = information.split(",");

                    Student student = null;

                    if (information.isEmpty()) {

                        student = new Student();

                    } else if (parts.length == 1) {

                        boolean isGraduate = Boolean.parseBoolean(parts[0].trim());

                        student = new Student(isGraduate);

                    } else if (parts.length == 2) {

                        String major = parts[0].trim();

                        boolean isGraduate = Boolean.parseBoolean(parts[1].trim());

                        student = new Student(major, isGraduate);

                    } else if (parts.length == 4) {

                        String name = parts[0].trim();

                        int birthYear = Integer.parseInt(parts[1].trim());

                        String major = parts[2].trim();

                        boolean isGraduate = Boolean.parseBoolean(parts[3].trim());

                        student = new Student(name, birthYear, major, isGraduate);
                    }

                    if (student != null) {

                        students.add(student);
                    }
                }
                else if (line.startsWith("GeneralStaff:")) {

                    String information = line.substring(13).trim();

                    String[] parts = information.split(",");

                    GeneralStaff worker = null;

                    if (information.isEmpty()) {

                        worker = new GeneralStaff();

                    } else if (parts.length == 1) {

                        String duty = parts[0].trim();

                        worker = new GeneralStaff(duty);

                    } else if (parts.length == 2) {

                        String department = parts[0].trim();

                        String duty = parts[1].trim();

                        worker = new GeneralStaff(department, duty);

                    } else if (parts.length == 4) {

                        String name = parts[0].trim();

                        int birthYear = Integer.parseInt(parts[1].trim());

                        String department = parts[2].trim();

                        String duty = parts[3].trim();

                        worker = new GeneralStaff(name, birthYear, department, duty);
                    }

                    if (worker != null) {

                        staff.add(worker);
                    }
                }
                
                
                
                
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
        }
        
    	 // This is an enhanced for loop, since courses is my array list it goes through every course stored
        //Then Prints accordingly. And Since i have a toString in my course it prints a certain way   
        //This is a header  
          
    	
    	
    	
    	
    	System.out.println("\nCOURSES IN DATABASE:");

    	for (Course course : courses) {
    	    System.out.println(course);
    	}


    	System.out.println("\nGENERAL STAFF IN DATABASE:");

    	for (GeneralStaff worker : staff) {
    	    System.out.println(worker);
    	}

    	System.out.println("\nFACULTY IN DATABASE:");

    	for (Faculty professor : faculty) {
    	    System.out.println(professor);
    	}

    	System.out.println("\nSTUDENTS IN DATABASE:");

    	for (Student student : students) {
    	    System.out.println(student);
    	}
        
        
    	Scanner scnr = new Scanner(System.in);
    	
    	int choice = -1; // Set choice to -1 not because its a value the user would type but it makes my loop actually work 
    	
    	while(choice !=0) {
    		
    		System.out.println("\nSCHOOL DATABASE MENU"); // Header for my menu
    		
    		
    		// What the UML Whats me to tell the user 
    		System.out.println("1. Create 3 new Course objects");
    		System.out.println("2. Create 3 new Faculty objects");
    		System.out.println("3. Create 3 new GeneralStaff objects");
    		System.out.println("4. Create 3 new Student objects");

    		System.out.println("5. Add 2 Courses to a Faculty object");
    		System.out.println("6. Add 2 Courses to a Student object");

    		System.out.println("7. Add an array of 2 Courses to a Faculty object");
    		System.out.println("8. Add an array of 2 Courses to a Student object");

    		System.out.println("9. Get a Course at an index from Faculty");
    		System.out.println("10. Get a Course at an index from Student");

    		System.out.println("11. Check whether Faculty teaches a Course");

    		System.out.println("12. Find Faculty with most and least courses");
    		System.out.println("13. Find minimum and maximum Course");
    		System.out.println("14. Find Student with most and least credits");

    		System.out.println("15. Display all database objects");
    		System.out.println("16. Save database to file");

    		System.out.println("0. Exit");
    		
    		System.out.print("\nEnter your choice: ");
    		choice =  scnr.nextInt();
    		scnr.nextLine();
    		switch(choice) {
    		
    		case 1:
    			
    			for(int i = 1; i <= 3; i++) { 		//For loop is very important because i want to repeat this case 3 times
    				System.out.println("\nCourse " + i);
    				// Im basing these questions according to my constructors
    				System.out.print("Is the course a graduate course?  (true/false)");
    				boolean isGraduateCourse = scnr.nextBoolean();
    				
    				System.out.println("What is the Course number?");
    				int courseNum = scnr.nextInt();
    				
    				System.out.println("What is the course department?");
    				String courseDept = scnr.next();
    				
    				System.out.println("How many Credits is the course worth");
    				int numCredits = scnr.nextInt();
    				
    				Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits); // Store what i got from the user into a 
    				// course object , the structor that takes 4 
    				courses.add(course);// add to the array list
    				
    				System.out.println("Course added successfully");
    				
    			}
    		
    		break;
    		
    		case 2:

    		    for (int i = 1; i <= 3; i++) {

    		        System.out.println("\nFaculty " + i);

    		        System.out.println("What is the faculty member's name?");
    		        String name = scnr.nextLine();

    		        System.out.println("What is their birth year?");
    		        int birthYear = scnr.nextInt();

    		        System.out.println("What is their department?");
    		        String deptName = scnr.next();

    		        System.out.println("Is this faculty member tenured? (true/false):");
    		        boolean isTenured = scnr.nextBoolean();
    		        scnr.nextLine();
    		        Faculty professor = new Faculty(
    		            name, birthYear, deptName, isTenured
    		        );

    		        faculty.add(professor);

    		        System.out.println("Faculty member added successfully!");
    		    }

    		    break;
    		
    		case 3:

    		    for (int i = 1; i <= 3; i++) {

    		        System.out.println("\nGeneral Staff " + i);

    		        System.out.println("What is the staff member's name?");
    		        String name = scnr.nextLine();

    		        System.out.println("What is their birth year?");
    		        int birthYear = scnr.nextInt();

    		        System.out.println("What is their department?");
    		        String deptName = scnr.next();
    		        scnr.nextLine();
    		        System.out.println("What is their duty?");
    		        String duty = scnr.nextLine();

    		        GeneralStaff worker = new GeneralStaff(
    		            name, birthYear, deptName, duty
    		        );

    		        staff.add(worker);

    		        System.out.println("Staff member added successfully!");
    		    }

    		    break;
    		
    		case 4:

    		    for (int i = 1; i <= 3; i++) {

    		        System.out.println("\nStudent " + i);

    		        System.out.println("What is the student's name?");
    		        String name = scnr.nextLine();

    		        System.out.println("What is their birth year?");
    		        int birthYear = scnr.nextInt();

    		        System.out.println("What is their major?");
    		        String major =scnr.next();

    		        System.out.println("Is this a graduate student? (true/false):");
    		        boolean isGraduate = scnr.nextBoolean();
    		        scnr.nextLine();
    		        Student student = new Student(
    		            name, birthYear, major, isGraduate
    		        );

    		        students.add(student);

    		    }
    		break;
    	
    		case 5:{

    		    System.out.println("Select a Faculty member:");

    		    for (int i = 0; i < faculty.size(); i++) {

    		        System.out.println(i + ". " + faculty.get(i).getName()); // This displayes the faculty list 
    		    }

    		    System.out.println("Enter the Faculty index:");
    		    int facultyIndex = scnr.nextInt();

    		    if (facultyIndex >= 0 && facultyIndex < faculty.size()) { // Makes sure the index is valid 

    		        Faculty selectedFaculty = faculty.get(facultyIndex);

    		        for (int i = 1; i <= 2; i++) { // The uml asks to add 2 courses to one professor
    		            System.out.println("\nSelect Course " + i);

    		            for (int j = 0; j < courses.size(); j++) {

    		                System.out.println(j + ". " + courses.get(j).getCourseName()); // This prints the courses plus the course name
    		            }

    		            System.out.println("Enter the Course index:");
    		            int courseIndex = scnr.nextInt();

    		            if (courseIndex >= 0 && courseIndex < courses.size()) { // Checks if the course index is valid 

    		                Course selectedCourse = courses.get(courseIndex);

    		                selectedFaculty.addCourseTaught(selectedCourse);

    		                System.out.println("Course added successfully!");

    		            } else {

    		                System.out.println("Invalid Course index.");
    		            }
    		        }

    		    } else {

    		        System.out.println("Invalid Faculty index.");
    		    }

    		    break;
    		
    		}
    		case 6: {

    		    System.out.println("Select a Student:");

    		    for (int i = 0; i < students.size(); i++) {
    		        System.out.println(i + ". " + students.get(i).getName());
    		    }

    		    System.out.println("Enter the Student index:");
    		    int studentIndex = scnr.nextInt();

    		    if (studentIndex >= 0 && studentIndex < students.size()) {

    		        Student selectedStudent = students.get(studentIndex);

    		        for (int i = 1; i <= 2; i++) {

    		            System.out.println("\nSelect Course " + i);

    		            for (int j = 0; j < courses.size(); j++) {
    		                System.out.println(j + ". " + courses.get(j).getCourseName());
    		            }

    		            System.out.println("Enter the Course index:");
    		            int courseIndex = scnr.nextInt();

    		            if (courseIndex >= 0 && courseIndex < courses.size()) {

    		                Course selectedCourse = courses.get(courseIndex);

    		                selectedStudent.addCourseTaken(selectedCourse);

    		                System.out.println("Course added successfully!");

    		            } else {
    		                System.out.println("Invalid Course index.");
    		            }
    		        }

    		    } else {
    		        System.out.println("Invalid Student index.");
    		    }

    		    break;
    		}
    		    
    		
    		
    		
    		case 7: {

    		    System.out.println("Select a Faculty member:");

    		    for (int i = 0; i < faculty.size(); i++) {
    		        System.out.println(i + ". " + faculty.get(i).getName());
    		    }

    		    System.out.println("Enter the Faculty index:");
    		    int facultyIndex = scnr.nextInt();

    		    if (facultyIndex >= 0 && facultyIndex < faculty.size()) {

    		        Faculty selectedFaculty = faculty.get(facultyIndex);

    		        Course[] selectedCourses = new Course[2];

    		        boolean valid = true;

    		        for (int i = 0; i < 2; i++) {

    		            System.out.println("\nSelect Course " + (i + 1));

    		            for (int j = 0; j < courses.size(); j++) {
    		                System.out.println(j + ". " + courses.get(j).getCourseName());
    		            }

    		            System.out.println("Enter the Course index:");
    		            int courseIndex = scnr.nextInt();

    		            if (courseIndex >= 0 && courseIndex < courses.size()) {

    		                selectedCourses[i] = courses.get(courseIndex);

    		            } else {

    		                System.out.println("Invalid Course index.");
    		                valid = false;
    		                break;
    		            }
    		        }

    		        if (valid) {

    		            selectedFaculty.addCoursesTaught(selectedCourses);

    		            System.out.println("Courses added successfully!");
    		        }

    		    } else {
    		        System.out.println("Invalid Faculty index.");
    		    }

    		    break;
    		}   
    		    

case 8: {

    System.out.println("Select a Student:");

    for (int i = 0; i < students.size(); i++) {
        System.out.println(i + ". " + students.get(i).getName());
    }

    System.out.println("Enter the Student index:");
    int studentIndex = scnr.nextInt();

    if (studentIndex >= 0 && studentIndex < students.size()) {

        Student selectedStudent = students.get(studentIndex);

        Course[] selectedCourses = new Course[2];

        boolean valid = true;

        for (int i = 0; i < 2; i++) {

            System.out.println("\nSelect Course " + (i + 1));

            for (int j = 0; j < courses.size(); j++) {
                System.out.println(j + ". " + courses.get(j).getCourseName());
            }

            System.out.println("Enter the Course index:");
            int courseIndex = scnr.nextInt();

            if (courseIndex >= 0 && courseIndex < courses.size()) {

                selectedCourses[i] = courses.get(courseIndex);

            } else {

                System.out.println("Invalid Course index.");
                valid = false;
                break;
            }
        }

        if (valid) {

            selectedStudent.addCoursesTaken(selectedCourses);

            System.out.println("Courses added successfully!");
        }

    } else {
        System.out.println("Invalid Student index.");
    }

    break;
}

case 9: {

    System.out.println("Select a Faculty member:");

    for (int i = 0; i < faculty.size(); i++) {
        System.out.println(i + ". " + faculty.get(i).getName());
    }

    System.out.println("Enter the Faculty index:");
    int facultyIndex = scnr.nextInt();

    if (facultyIndex >= 0 && facultyIndex < faculty.size()) {

        Faculty selectedFaculty = faculty.get(facultyIndex);

        System.out.println("Courses taught by this Faculty member:");

        for (int i = 0; i < selectedFaculty.getNumCoursesTaught(); i++) {
            System.out.println(i + ". " + selectedFaculty.getCourseTaughtAsString(i));
        }

        System.out.println("Enter the Course index:");
        int courseIndex = scnr.nextInt();

        Course selectedCourse = selectedFaculty.getCourseTaught(courseIndex);

        if (selectedCourse != null) {
            System.out.println(selectedCourse);
        } else {
            System.out.println("Invalid Course index.");
        }

    } else {
        System.out.println("Invalid Faculty index.");
    }

    break;
}

case 10: {

    System.out.println("Select a Student:");

    for (int i = 0; i < students.size(); i++) {
        System.out.println(i + ". " + students.get(i).getName());
    }

    System.out.println("Enter the Student index:");
    int studentIndex = scnr.nextInt();

    if (studentIndex >= 0 && studentIndex < students.size()) {

        Student selectedStudent = students.get(studentIndex);

        System.out.println("Courses taken by this Student:");

        for (int i = 0; i < selectedStudent.getNumCoursesTaken(); i++) {
            System.out.println(i + ". " + selectedStudent.getCourseTakenAsString(i));
        }

        System.out.println("Enter the Course index:");
        int courseIndex = scnr.nextInt();

        Course selectedCourse = selectedStudent.getCourseTaken(courseIndex);

        if (selectedCourse != null) {
            System.out.println(selectedCourse);
        } else {
            System.out.println("Invalid Course index.");
        }

    } else {
        System.out.println("Invalid Student index.");
    }

    break;
}
 

case 11: {

    System.out.println("Select a Faculty member:");

    for (int i = 0; i < faculty.size(); i++) {
        System.out.println(i + ". " + faculty.get(i).getName());
    }

    System.out.println("Enter the Faculty index:");
    int facultyIndex = scnr.nextInt();

    if (facultyIndex >= 0 && facultyIndex < faculty.size()) {

        Faculty selectedFaculty = faculty.get(facultyIndex);

        System.out.println("Select a Course:");

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ". " + courses.get(i).getCourseName());
        }

        System.out.println("Enter the Course index:");
        int courseIndex = scnr.nextInt();

        if (courseIndex >= 0 && courseIndex < courses.size()) {

            Course selectedCourse = courses.get(courseIndex);
            boolean teaches = false;

            for (int i = 0; i < selectedFaculty.getNumCoursesTaught(); i++) {

                if (selectedFaculty.getCourseTaught(i).equals(selectedCourse)) {
                    teaches = true;
                    break;
                }
            }

            if (teaches) {
                System.out.println("This Faculty member teaches the Course.");
            } else {
                System.out.println("This Faculty member does not teach the Course.");
            }

        } else {
            System.out.println("Invalid Course index.");
        }

    } else {
        System.out.println("Invalid Faculty index.");
    }

    break;
}
		    

case 12: {

    if (faculty.size() == 0) {
        System.out.println("No Faculty members in the database.");
    } else {

        Faculty most = faculty.get(0);
        Faculty least = faculty.get(0);

        for (int i = 1; i < faculty.size(); i++) {

            Faculty current = faculty.get(i);

            if (current.getNumCoursesTaught() > most.getNumCoursesTaught()) {
                most = current;
            }

            if (current.getNumCoursesTaught() < least.getNumCoursesTaught()) {
                least = current;
            }
        }

        System.out.println("Faculty teaching the most courses:");
        System.out.println(most);

        System.out.println("Faculty teaching the least courses:");
        System.out.println(least);
    }

    break;
}

case 13: {

    if (courses.size() == 0) {
        System.out.println("No Courses in the database.");
    } else {

        Course min = courses.get(0);
        Course max = courses.get(0);

        for (int i = 1; i < courses.size(); i++) {

            Course current = courses.get(i);

            if (current.compareTo(min) < 0) {
                min = current;
            }

            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        System.out.println("Minimum Course:");
        System.out.println(min);

        System.out.println("Maximum Course:");
        System.out.println(max);
    }

    break;
}
  

case 14: {

    if (students.size() == 0) {
        System.out.println("No Students in the database.");
    } else {

        Student most = students.get(0);
        Student least = students.get(0);

        for (int i = 1; i < students.size(); i++) {

            Student current = students.get(i);

            if (current.compareTo(most) > 0) {
                most = current;
            }

            if (current.compareTo(least) < 0) {
                least = current;
            }
        }

        System.out.println("Student with the most credits:");
        System.out.println(most);

        System.out.println("Student with the least credits:");
        System.out.println(least);
    }

    break;
}

case 15: {

    System.out.println("\nCOURSES IN DATABASE:");

    for (Course course : courses) {
        System.out.println(course);
    }

    System.out.println("\nPERSONS IN DATABASE:");

    System.out.println("\nEMPLOYEES IN DATABASE:");

    System.out.println("\nGENERAL STAFF IN DATABASE:");

    for (GeneralStaff worker : staff) {
        System.out.println(worker);
    }

    System.out.println("\nFACULTY IN DATABASE:");

    for (Faculty professor : faculty) {
        System.out.println(professor);
    }

    System.out.println("\nSTUDENTS IN DATABASE:");

    for (Student student : students) {
        System.out.println(student);
    }

    break;
}


case 16: {

    try {

        PrintWriter output = new PrintWriter("SchoolDB_Output.txt");

        for (Course course : courses) {

            output.println("Course: " +
                    course.isGraduateCourse() + "," +
                    course.getCourseNum() + "," +
                    course.getCourseDept() + "," +
                    course.getNumCredits());
        }

        for (Faculty professor : faculty) {

            output.println("Faculty: " +
                    professor.getName() + "," +
                    professor.getBirthYear() + "," +
                    professor.getDeptName() + "," +
                    professor.isTenured());
        }

        for (Student student : students) {

            output.println("Student: " +
                    student.getName() + "," +
                    student.getBirthYear() + "," +
                    student.getMajor() + "," +
                    student.isGraduate());
        }

        for (GeneralStaff worker : staff) {

            output.println("GeneralStaff: " +
                    worker.getName() + "," +
                    worker.getBirthYear() + "," +
                    worker.getDeptName() + "," +
                    worker.getDuty());
        }

        output.close();

        System.out.println("Database saved successfully!");

    } catch (FileNotFoundException e) {

        System.out.println("Error saving database.");
    }

    break;
}
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		    
    		



















































    		
    		}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}