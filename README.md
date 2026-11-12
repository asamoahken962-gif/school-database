# Java School Database

A menu-driven, text-file-backed school records application built in Java for a Programming Methods II course at Lehman College.

## Features

- Represents courses, people, employees, faculty, general staff, and students with Java classes and inheritance.
- Loads school records from `SchoolDB_Initial.txt` and displays them in the console.
- Uses an interactive menu to create records, associate courses with students/faculty, inspect courses, and compare records.
- Exports updated course, faculty, student, and staff records to `SchoolDB_Output.txt`.
- Uses arrays, `ArrayList`, constructors, getters, `equals`, `toString`, and comparison methods.

This is an **in-memory and text-file-backed console program**, not an SQL database or a web application.

## Project structure

```text
src/database/
  Course.java
  Person.java
  Employee.java
  Faculty.java
  GeneralStaff.java
  Student.java
  Driver_SchoolDB.java
SchoolDB_Initial.txt
```

## How to run

You need the Java Development Kit (JDK). From the project directory:

```bash
javac -d out src/database/*.java
java -cp out database.Driver_SchoolDB
```

The application looks for `SchoolDB_Initial.txt` in the directory where you run the `java` command. Enter `0` to exit. Menu option `16` saves `SchoolDB_Output.txt` in that same directory.

## Verification

The seven class files compiled successfully with JDK 21. A basic run was checked using the sample text file: read existing data, display database objects (menu option 15), save records (option 16), and exit (option 0). This is a smoke test, not a claim that every interactive menu path has been exhaustively retested here.

## Notes

The included `SchoolDB_Initial.txt` is a small, fictional sample data file prepared for this portfolio copy; it is not claimed to be the original classroom input file. Original implementation was created as a class project, and the source files reflect that work.
