package model;

import java.time.LocalTime;

public class TimeSlot {

    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(LocalTime startTime, LocalTime endTime) {

        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException(
                    "Time cannot be null."
            );
        }

        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException(
                    "Start time must be before end time."
            );
        }

        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(TimeSlot other) {

        return startTime.isBefore(other.endTime)
                && other.startTime.isBefore(endTime);
    }

    public void displaySlot() {

        System.out.println(
                startTime + " - " + endTime
        );
    }
}
