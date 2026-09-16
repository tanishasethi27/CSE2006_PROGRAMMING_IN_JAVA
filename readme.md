# 🚀 SYNCSPACE — Student Free Time Management & Collaborative Activity Scheduler

## 📌 Overview

This project implements a console-based Java application that helps
college students coordinate their schedules and find common free time
for collaborative activities.

The system allows students to:

- Register their details
- Add available time slots
- Create groups
- Add group members
- Find common free time
- Schedule activities
- Detect scheduling conflicts
- Generate basic reports
- Save project data to a file

The main goal is to reduce the difficulty of manually comparing
multiple student schedules.

---

## 🎯 Objective

To design and implement a Java-based scheduling system that:

- Manages student information
- Stores student availability
- Organizes students into groups
- Finds common free-time intervals
- Schedules collaborative activities
- Detects conflicting meetings
- Demonstrates practical Java programming concepts

---

## 🧠 Concepts Used

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Constructors
- ArrayList
- HashMap
- Java Collections
- Exception Handling
- Custom Exceptions
- Assertions and Invariants
- File Handling
- `Files` Class
- `Path` Interface
- `LocalDate`
- `LocalTime`
- Scheduling Algorithms
- Input Validation

---

## ⚙️ Technologies

- Java 11 or later
- Java Collections Framework
- Java NIO File API
- Git
- GitHub
- Console / Command-Line Interface

---

## 🧩 Problem Setup

The system manages:

- Students
- Student free-time slots
- Collaborative groups
- Group activities
- Scheduled meetings

Example:

```text
Student A → 04:00 PM - 07:00 PM
Student B → 05:00 PM - 08:00 PM
Student C → 05:30 PM - 07:30 PM
Student D → 06:00 PM - 08:00 PM
```
The system identifies:
Common Free Time → 06:00 PM - 07:00 PM

---

## 🧮 Common-Time Calculation

For two time intervals, the common interval is calculated using:

Common Start = MAX(Start Time 1, Start Time 2)

Common End = MIN(End Time 1, End Time 2)

A valid common interval exists when:

Common Start < Common End

For multiple students, the system repeatedly compares the current
common availability with the next student's free-time slots.

---

## 🔍 Algorithms Used
1. Time Interval Intersection

The system compares the free-time slots of group members to identify
overlapping intervals.

Example:

Student A → 04:00 - 07:00
Student B → 05:00 - 08:00

Common Time → 05:00 - 07:00
2. Conflict Detection

Before scheduling a meeting, the system checks existing activities.

Two activities conflict when:

Same Date
    AND
Time Intervals Overlap

If a conflict is detected, the meeting is rejected.

---

## 🧩 Project Modules
1. Student Management

Registers students using:

- Student ID
- Name
- Department
- Academic Year

2. Free-Time Management

Stores available time slots for each student.

3. Group Management

Creates groups and manages group members.

4. Common-Time Matching

Finds the time intervals when all members of a group are available.

5. Activity Management

Creates and manages project, club, study, and competition activities.

6. Meeting Management

Schedules meetings and checks for conflicts.

7. Reporting

Displays:

- Total students
- Total groups
- Total activities
- Total meetings

8. File Management

Uses Java Files and Path APIs for file and directory operations.

---



