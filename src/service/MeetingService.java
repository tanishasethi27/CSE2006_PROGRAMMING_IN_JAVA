package service;

import model.Activity;

import java.util.ArrayList;
import java.util.List;

public class MeetingService {

    private List<Activity> meetings;

    public MeetingService() {
        meetings = new ArrayList<>();
    }

    // Schedule a new meeting
    public void scheduleMeeting(Activity activity) {

        if (activity == null) {
            throw new IllegalArgumentException(
                    "Meeting cannot be null."
            );
        }

        meetings.add(activity);

        System.out.println(
                "Meeting scheduled successfully."
        );
    }

    // Display all scheduled meetings
    public void displayMeetings() {

        System.out.println("\n==================================");
        System.out.println("        SCHEDULED MEETINGS");
        System.out.println("==================================");

        if (meetings.isEmpty()) {
            System.out.println(
                    "No meetings scheduled."
            );
            return;
        }

        for (Activity meeting : meetings) {

            meeting.displayActivity();

            System.out.println(
                    "----------------------------------"
            );
        }
    }

    // Check whether meetings exist
    public boolean hasMeetings() {

        return !meetings.isEmpty();
    }

    // Return all meetings
    public List<Activity> getMeetings() {

        return meetings;
    }

    // Remove all meetings
    public void clearMeetings() {

        meetings.clear();

        System.out.println(
                "All meetings have been removed."
        );
    }
}
