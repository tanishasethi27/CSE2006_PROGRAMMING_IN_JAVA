package model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private String groupName;
    private String activityType;
    private List<Student> members;

    public Group(String groupId, String groupName, String activityType) {

        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Group ID cannot be empty."
            );
        }

        if (groupName == null || groupName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Group name cannot be empty."
            );
        }

        this.groupId = groupId;
        this.groupName = groupName;
        this.activityType = activityType;
        this.members = new ArrayList<>();
    }

    public void addMember(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        members.add(student);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getActivityType() {
        return activityType;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void displayGroup() {

        System.out.println("\n==============================");
        System.out.println("Group ID   : " + groupId);
        System.out.println("Group Name : " + groupName);
        System.out.println("Activity   : " + activityType);
        System.out.println("Members:");

        if (members.isEmpty()) {
            System.out.println("No members added.");
        } else {
            for (Student student : members) {
                System.out.println(
                        "- " + student.getName()
                        + " (" + student.getStudentId() + ")"
                );
            }
        }

        System.out.println("==============================");
    }
}
