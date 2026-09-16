package service;

import model.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityService {

    private List<Activity> activities;

    public ActivityService() {
        activities = new ArrayList<>();
    }

    /*
     * Adds a new activity.
     */
    public void addActivity(Activity activity) {

        if (activity == null) {
            throw new IllegalArgumentException(
                    "Activity cannot be null."
            );
        }

        activities.add(activity);

        System.out.println(
                "Activity added successfully."
        );
    }

    /*
     * Displays all activities.
     */
    public void displayActivities() {

        System.out.println("\n==================================");
        System.out.println("       SCHEDULED ACTIVITIES");
        System.out.println("==================================");

        if (activities.isEmpty()) {

            System.out.println(
                    "No activities scheduled."
            );

            return;
        }

        for (Activity activity : activities) {
            activity.displayActivity();
            System.out.println("----------------------------------");
        }
    }

    /*
     * Returns all activities.
     */
    public List<Activity> getActivities() {

        return activities;
    }

    /*
     * Removes an activity using its name.
     */
    public boolean removeActivity(String activityName) {

        if (activityName == null ||
                activityName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Activity name cannot be empty."
            );
        }

        for (Activity activity : activities) {

            if (activity.getTitle()
                    .equalsIgnoreCase(activityName)) {

                activities.remove(activity);

                System.out.println(
                        "Activity removed successfully."
                );

                return true;
            }
        }

        System.out.println(
                "Activity not found."
        );

        return false;
    }

    /*
     * Clears all activities.
     */
    public void clearActivities() {

        activities.clear();

        System.out.println(
                "All activities have been cleared."
        );
    }
}
