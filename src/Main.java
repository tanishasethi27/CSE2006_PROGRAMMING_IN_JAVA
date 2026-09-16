import model.Student;
import model.TimeSlot;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" STUDENT FREE TIME MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        Student student = new Student(
                "S101",
                "Rahul",
                "CSE",
                2
        );

        System.out.println("\nStudent Details:");
        student.displayStudent();

        TimeSlot freeTime = new TimeSlot(
                LocalTime.of(16, 0),
                LocalTime.of(19, 0)
        );

        System.out.println("\nFree Time:");
        freeTime.displaySlot();

        System.out.println("\nSystem started successfully.");
    }
}
