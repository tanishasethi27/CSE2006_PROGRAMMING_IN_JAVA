package model;

public class Student {

    private String studentId;
    private String name;
    private String department;
    private int year;

    public Student(String studentId, String name,
                   String department, int year) {

        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be empty."
            );
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    "Student name cannot be empty."
            );
        }

        if (year < 1 || year > 4) {
            throw new IllegalArgumentException(
                    "Year must be between 1 and 4."
            );
        }

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public void displayStudent() {

        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Year       : " + year);
    }
}
