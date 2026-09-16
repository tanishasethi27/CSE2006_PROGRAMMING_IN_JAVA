package service;

import model.Student;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleService {

    private Map<String, List<TimeSlot>> schedules;

    public ScheduleService() {
        schedules = new HashMap<>();
    }

    /*
     * Adds a student to the schedule system.
     */
    public void registerStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        schedules.putIfAbsent(
                student.getStudentId(),
                new ArrayList<>()
        );
    }

    /*
     * Adds a free-time slot for a student.
     */
    public void addFreeTime(
            Student student,
            TimeSlot slot) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        if (slot == null) {
            throw new IllegalArgumentException(
                    "Time slot cannot be null."
            );
        }

        registerStudent(student);

        schedules.get(
                student.getStudentId()
        ).add(slot);
    }

    /*
     * Returns the free-time schedule
     * of a particular student.
     */
    public List<TimeSlot> getSchedule(
            String studentId) {

        if (!schedules.containsKey(studentId)) {
            throw new IllegalArgumentException(
                    "Student schedule not found."
            );
        }

        return schedules.get(studentId);
    }

    /*
     * Displays the schedule of a student.
     */
    public void displaySchedule(
            String studentId) {

        List<TimeSlot> slots =
                getSchedule(studentId);

        System.out.println("\n==================================");
        System.out.println("        STUDENT SCHEDULE");
        System.out.println("==================================");

        if (slots.isEmpty()) {

            System.out.println(
                    "No free-time slots available."
            );

            return;
        }

        for (TimeSlot slot : slots) {

            System.out.println(
                    slot.getStartTime()
                            + " - "
                            + slot.getEndTime()
            );
        }
    }

    /*
     * Returns all student schedules.
     */
    public Map<String, List<TimeSlot>> getAllSchedules() {

        return schedules;
    }

    /*
     * Removes all schedules from the system.
     */
    public void clearSchedules() {

        schedules.clear();
    }
}
