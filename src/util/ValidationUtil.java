package util;

import java.time.LocalTime;

public class ValidationUtil {

    // Validate student ID
    public static boolean isValidStudentId(String studentId) {

        return studentId != null
                && !studentId.trim().isEmpty();
    }

    // Validate student name
    public static boolean isValidName(String name) {

        return name != null
                && !name.trim().isEmpty();
    }

    // Validate year
    public static boolean isValidYear(int year) {

        return year >= 1 && year <= 5;
    }

    // Validate time range
    public static boolean isValidTime(
            LocalTime start,
            LocalTime end) {

        return start != null
                && end != null
                && start.isBefore(end);
    }

    // Validate activity name
    public static boolean isValidActivityName(
            String activityName) {

        return activityName != null
                && !activityName.trim().isEmpty();
    }

    // Validate group name
    public static boolean isValidGroupName(
            String groupName) {

        return groupName != null
                && !groupName.trim().isEmpty();
    }
}
