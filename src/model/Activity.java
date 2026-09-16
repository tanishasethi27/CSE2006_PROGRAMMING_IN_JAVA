package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Activity {

    private String activityId;
    private String title;
    private String type;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;

    public Activity(String activityId,
                    String title,
                    String type,
                    LocalDate date,
                    LocalTime startTime,
                    LocalTime endTime,
                    String location) {

        if (activityId == null || activityId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Activity ID cannot be empty."
            );
        }

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException(
                    "Activity title cannot be empty."
            );
        }

        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException(
                    "Activity time cannot be null."
            );
        }

        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException(
                    "Start time must be before end time."
            );
        }

        this.activityId = activityId;
        this.title = title;
        this.type = type;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getActivityId() {
        return activityId;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public boolean conflictsWith(Activity other) {

        if (!date.equals(other.date)) {
            return false;
        }

        return startTime.isBefore(other.endTime)
                && other.startTime.isBefore(endTime);
    }

    public void displayActivity() {

        System.out.println("\n------------------------------");
        System.out.println("Activity ID : " + activityId);
        System.out.println("Title       : " + title);
        System.out.println("Type        : " + type);
        System.out.println("Date        : " + date);
        System.out.println("Time        : "
                + startTime + " - " + endTime);
        System.out.println("Location    : " + location);
        System.out.println("------------------------------");
    }
}
