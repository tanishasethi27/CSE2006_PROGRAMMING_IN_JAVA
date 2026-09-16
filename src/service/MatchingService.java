package service;

import model.Student;
import model.TimeSlot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchingService {

    /*
     * Finds the common free time available
     * for all students in a group.
     */
    public List<TimeSlot> findCommonFreeTime(
            List<Student> students,
            Map<String, List<TimeSlot>> schedules) {

        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one student is required."
            );
        }
String firstStudentId =
        students.get(0).getStudentId();

List<TimeSlot> firstSchedule =
        schedules.get(firstStudentId);

if (firstSchedule == null) {
    return new ArrayList<>();
}

List<TimeSlot> commonSlots =
        new ArrayList<>(firstSchedule);

        for (int i = 1; i < students.size(); i++) {

            String studentId =
                    students.get(i).getStudentId();

            List<TimeSlot> studentSlots =
                    schedules.get(studentId);

            if (studentSlots == null) {
                return new ArrayList<>();
            }

            commonSlots = findOverlap(
                    commonSlots,
                    studentSlots
            );
        }

        return commonSlots;
    }

    /*
     * Compares two lists of free-time slots
     * and returns their overlapping periods.
     */
    private List<TimeSlot> findOverlap(
            List<TimeSlot> first,
            List<TimeSlot> second) {

        List<TimeSlot> result = new ArrayList<>();

        for (TimeSlot slot1 : first) {

            for (TimeSlot slot2 : second) {

                LocalTime start =
                        slot1.getStartTime()
                                .isAfter(slot2.getStartTime())
                                ? slot1.getStartTime()
                                : slot2.getStartTime();

                LocalTime end =
                        slot1.getEndTime()
                                .isBefore(slot2.getEndTime())
                                ? slot1.getEndTime()
                                : slot2.getEndTime();

                if (start.isBefore(end)) {

                    result.add(
                            new TimeSlot(start, end)
                    );
                }
            }
        }

        return result;
    }

    /*
     * Displays the common free-time slots.
     */
    public void displayCommonFreeTime(
            List<TimeSlot> commonSlots) {

        System.out.println("\n==================================");
        System.out.println("      COMMON FREE TIME");
        System.out.println("==================================");

        if (commonSlots == null ||
                commonSlots.isEmpty()) {

            System.out.println(
                    "No common free time found."
            );

            return;
        }

        for (TimeSlot slot : commonSlots) {
            System.out.println(
                    slot.getStartTime()
                            + " - "
                            + slot.getEndTime()
            );
        }
    }
}
