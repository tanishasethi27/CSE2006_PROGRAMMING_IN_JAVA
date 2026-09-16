# Project Statement

# SYNCSPACE — Student Free Time Management & Collaborative Activity Scheduler

## Problem Statement

The challenge faced by college students is coordinating a common free time for group activities. Students have different class schedules, project commitments, club activities, study sessions, competitions, and personal responsibilities. Manually comparing individual schedules or repeatedly messaging group members is time-consuming and can lead to scheduling conflicts and missed meetings.

An effective solution requires a practical system that can store student availability, organize students into groups, identify common free-time intervals, and help schedule collaborative activities while detecting conflicts.

**SyncSpace** provides a console-based Java solution that allows students to manage their availability and find suitable common time slots for group activities.

# Scope of the Project

The scope is to create a modular, console-based application in Java that helps students manage their free time and coordinate group activities. The system uses Java collections for managing students, groups, schedules, and activities, while Java file-handling features are used for basic data storage.

## In Scope

1. **Student Management:** Allowing users to register students with Student ID, Name, Department, and Academic Year.
2. **Free-Time Management:** Allowing students to add and manage available time slots.
3. **Group Management:** Allowing users to create groups and add students as group members.
4. **Common Free-Time Finder:** Calculating overlapping free-time intervals among all members of a group.
5. **Activity Scheduling:** Creating project discussions, club meetings, study sessions, and competition activities.
6. **Conflict Detection:** Checking scheduled activities for overlapping dates and times.
7. **Reporting:** Displaying total students, groups, activities, and meetings.
8. **File Handling:** Creating directories and saving project information using Java `Files` and `Path`.
9. **Error Handling:** Handling invalid input, duplicate records, invalid time ranges, and scheduling conflicts.

## Out of Scope (Future Enhancements)

1. Database integration for permanent structured storage.
2. User authentication and password management.
3. Online calendar synchronization.
4. Email or mobile notifications.
5. Graphical user interface using JavaFX.
6. Real-time calendar updates.
7. Cloud-based data synchronization.
8. Advanced recurring schedule management.

# Target Users

The primary target users are:

1. **College Students:** Requiring a simple way to find common free time for projects, study groups, clubs, competitions, and other collaborative activities.

2. **Project Teams:** Needing to coordinate project discussions and meetings without repeatedly comparing individual schedules.

3. **Club and Competition Teams:** Requiring a convenient method to identify time slots when all members are available.

4. **Study Groups:** Looking for suitable common periods for collaborative study sessions.

5. **Java Students:** To demonstrate practical knowledge of object-oriented programming, collections, exception handling, assertions, file handling, `Files`, and `Path`.

# High-level Features

1. **Student Management Module:** Registers students and validates Student IDs, names, and academic years.

2. **Free-Time Management Module:** Allows users to add and manage student availability using start and end times.

3. **Group Management Module:** Allows users to create groups and add students while preventing duplicate group members.

4. **Common-Time Matching Module:** Compares the availability of multiple students and calculates the time intervals that are common to all members.

5. **Activity Scheduling Module:** Records activity details such as activity ID, title, type, date, time, and location.

6. **Conflict Detection Module:** Checks new activities against existing meetings and rejects overlapping schedules.

7. **Reporting Module:** Provides a summary of students, groups, activities, and meetings managed by the system.

8. **File Management Module:** Demonstrates Java NIO operations using `Files` and `Path` for creating directories and saving project information.

9. **Validation and Error Handling:** Prevents invalid data and provides meaningful error messages without terminating the entire application.
