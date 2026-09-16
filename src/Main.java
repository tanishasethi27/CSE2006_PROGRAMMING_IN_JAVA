import model.Student;
import model.TimeSlot;
import model.Group;
import model.Activity;

import service.ScheduleService;
import service.MatchingService;
import service.ActivityService;
import service.MeetingService;
import util.ValidationUtil;
import util.FileManager;

import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static ScheduleService scheduleService =
            new ScheduleService();

    private static MatchingService matchingService =
            new MatchingService();

    private static ActivityService activityService =
            new ActivityService();

    private static MeetingService meetingService =
            new MeetingService();

    private static List<Student> students =
            new ArrayList<>();

    private static List<Group> groups =
            new ArrayList<>();

    public static void main(String[] args) {

        boolean running = true;
        try {
            FileManager.createDirectory("data");
        } catch (IOException e) {
            System.out.println(
                    "Unable to create data directory: "
                        + e.getMessage()
           );
        }
        

        System.out.println("==============================================");
        System.out.println(" STUDENT FREE TIME MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (running) {

            displayMenu();

            try {

                int choice = Integer.parseInt(
                        scanner.nextLine()
                );

                switch (choice) {

                    case 1:
                        registerStudent();
                        break;

                    case 2:
                        addFreeTime();
                        break;

                    case 3:
                        createGroup();
                        break;

                    case 4:
                        addStudentToGroup();
                        break;

                    case 5:
                        findCommonFreeTime();
                        break;

                    case 6:
                        scheduleActivity();
                        break;

                    case 7:
                        activityService.displayActivities();
                        break;

                    case 8:
                        meetingService.displayMeetings();
                        break;

                    case 9:
                        displayReports();
                        break;

                    case 10:
                        saveDataToFile();
                        break;

                    case 11:
                        running = false;
                        System.out.println(
                                "\nThank you for using the system."
                        );
                        break;

                    default:
                        System.out.println(
                                "\nInvalid choice. "
                                + "Please select 1-10."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nPlease enter a valid number."
                );

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("                  MAIN MENU");
        System.out.println("==============================================");
        System.out.println("1. Register Student");
        System.out.println("2. Add Free Time");
        System.out.println("3. Create Group");
        System.out.println("4. Add Student to Group");
        System.out.println("5. Find Common Free Time");
        System.out.println("6. Schedule Activity");
        System.out.println("7. View Activities");
        System.out.println("8. View Meetings");
        System.out.println("9. View Reports");
        System.out.println("10. Save Data to File");
        System.out.println("11. Exit");
        System.out.println("==============================================");
        System.out.print("Enter your choice: ");
    }

    private static void registerStudent() {

        System.out.println("\n--- Register Student ---");

        System.out.print("Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(
                scanner.nextLine()
        );
        if (!ValidationUtil.isValidStudentId(id)) {
            throw new IllegalArgumentException(
                "Student ID cannot be empty."
            );
        }

        if (!ValidationUtil.isValidName(name)) {
            throw new IllegalArgumentException(
                "Student name cannot be empty."
            );
        }

        if (!ValidationUtil.isValidYear(year)) {
            throw new IllegalArgumentException(
                "Year must be between 1 and 5."
            );
        }

        Student student = new Student(
                id,
                name,
                department,
                year
        );

        if (findStudent(id) != null) {
            throw new IllegalArgumentException(
                    "Student ID already exists."
            );
        }

        students.add(student);

        scheduleService.registerStudent(student);
        System.out.println(
                "Student registered successfully."
        );
    }

    private static void addFreeTime() {

        System.out.println("\n--- Add Free Time ---");

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudent(studentId);

        if (student == null) {

            throw new IllegalArgumentException(
                    "Student not found."
            );
        }

        System.out.print("Start hour (0-23): ");
        int startHour = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("Start minute: ");
        int startMinute = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("End hour (0-23): ");
        int endHour = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("End minute: ");
        int endMinute = Integer.parseInt(
                scanner.nextLine()
        );

        LocalTime start = LocalTime.of(
        startHour,
        startMinute
        );

        LocalTime end = LocalTime.of(
        endHour,
        endMinute
        );

        if (!ValidationUtil.isValidTime(start, end)) {
            throw new IllegalArgumentException(
                    "Start time must be before end time."
            );
        }

        TimeSlot slot = new TimeSlot(start, end);

        scheduleService.addFreeTime(
                student,
                slot
        );

        System.out.println(
                "Free time added successfully."
        );
    }

    private static void createGroup() {

        System.out.println("\n--- Create Group ---");

        System.out.print("Group ID: ");
        String groupId = scanner.nextLine();

        System.out.print("Group Name: ");
        String groupName = scanner.nextLine();

        System.out.print(
                "Activity Type "
                + "(Project/Club/Study/Competition): "
        );

        String type = scanner.nextLine();
        if (findGroup(groupId) != null) {
            throw new IllegalArgumentException(
                    "Group ID already exists."
            );
        }


        Group group = new Group(
                groupId,
                groupName,
                type
        );

        groups.add(group);

        System.out.println(
                "Group created successfully."
        );
    }

    private static void addStudentToGroup() {

        System.out.println("\n--- Add Student to Group ---");

        System.out.print("Group ID: ");
        String groupId = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        Group group = findGroup(groupId);
        Student student = findStudent(studentId);

        if (group == null) {

            throw new IllegalArgumentException(
                    "Group not found."
            );
        }

        if (student == null) {

            throw new IllegalArgumentException(
                    "Student not found."
            );
        }

        group.addMember(student);

        System.out.println(
                "Student added to group successfully."
        );
    }

    private static void findCommonFreeTime() {

        System.out.println(
                "\n--- Find Common Free Time ---"
        );

        System.out.print("Group ID: ");
        String groupId = scanner.nextLine();

        Group group = findGroup(groupId);

        if (group == null) {

            throw new IllegalArgumentException(
                    "Group not found."
            );
        }

        if (group.getMembers().isEmpty()) {

            throw new IllegalArgumentException(
                    "Group has no members."
            );
        }

        Map<String, List<TimeSlot>> schedules =
                scheduleService.getAllSchedules();

        List<TimeSlot> commonSlots =
                matchingService.findCommonFreeTime(
                        group.getMembers(),
                        schedules
                );

        matchingService.displayCommonFreeTime(
                commonSlots
        );
    }

    private static void scheduleActivity() {

        System.out.println(
                "\n--- Schedule Activity ---"
        );

        System.out.print("Activity ID: ");
        String activityId = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print(
                "Type "
                + "(Project/Club/Study/Competition): "
        );

        String type = scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(
                scanner.nextLine()
        );

        System.out.print("Start hour: ");
        int startHour = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("Start minute: ");
        int startMinute = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("End hour: ");
        int endHour = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("End minute: ");
        int endMinute = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("Location: ");
        String location = scanner.nextLine();
        for (Activity existingActivity :
            activityService.getActivities()) {

            if (existingActivity.getActivityId()
                    .equalsIgnoreCase(activityId)) {

                throw new IllegalArgumentException(
                        "Activity ID already exists."
                );
            }
        }

        Activity activity = new Activity(
                activityId,
                title,
                type,
                date,
                LocalTime.of(
                        startHour,
                        startMinute
                ),
                LocalTime.of(
                        endHour,
                        endMinute
                ),
                location
        );

        activityService.addActivity(activity);
        meetingService.scheduleMeeting(activity);
    }

    private static void displayReports() {

        System.out.println("\n==============================================");
        System.out.println("                  REPORTS");
        System.out.println("==============================================");

        System.out.println(
                "Total Students : " + students.size()
        );

        System.out.println(
                "Total Groups   : " + groups.size()
        );

        System.out.println(
                "Total Activities : "
                        + activityService
                        .getActivities()
                        .size()
        );

        System.out.println(
                "Total Meetings : "
                        + meetingService
                        .getMeetings()
                        .size()
        );
    }

    private static Student findStudent(
            String studentId) {

        for (Student student : students) {

            if (student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                return student;
            }
        }

        return null;
    }

    private static Group findGroup(
            String groupId) {

        for (Group group : groups) {

            if (group.getGroupId()
                    .equalsIgnoreCase(groupId)) {

                return group;
            }
        }

        return null;
    }
    private static void saveDataToFile() {

        try {

            FileManager.createDirectory("data");

            StringBuilder data = new StringBuilder();

            data.append("STUDENT FREE TIME MANAGEMENT SYSTEM\n");
            data.append("====================================\n\n");

            data.append("Total Students: ")
                    .append(students.size())
                    .append("\n");

            data.append("Total Groups: ")
                    .append(groups.size())
                    .append("\n");

            data.append("Total Activities: ")
                    .append(activityService.getActivities().size())
                    .append("\n");

            data.append("Total Meetings: ")
                    .append(meetingService.getMeetings().size())
                    .append("\n");

            FileManager.writeFile(
                    "data/project_data.txt",
                    data.toString()
            );

            System.out.println(
                    "Project data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "File error: " + e.getMessage()
            );
        }
    }
}
