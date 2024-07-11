
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScheduleManager {

    private static Integer scheduleID = 10000000;

    String xcode;
    String xtitle;
    String xunits;
    String xyrLvl;

    Scanner input = new Scanner(System.in);
    ArrayList<Course> availableCourses = new ArrayList<>();
    static File file = new File(".\\JH_DATA\\JH_Schedule.txt");

    private static boolean scheduleExist(String section, int selectedScheduleIndex, String room) {
        String selectedSchedule = availableSchedules[selectedScheduleIndex - 1];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            while ((key = reader.readLine()) != null) {
                if (key.equalsIgnoreCase("$$$$$$$$$$")) {
                    String sectionCheck = reader.readLine();
                    String scheduleCheck = reader.readLine();
                    String roomCheck = reader.readLine();

                    if (section.equalsIgnoreCase(sectionCheck) && selectedSchedule.equals(scheduleCheck) && room.equalsIgnoreCase(roomCheck)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    ScheduleManager() { // available courses
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\JH_DATA\\JH_Course.txt"))) {
            String key;
            while ((key = reader.readLine()) != null) {
                xcode = reader.readLine();
                xtitle = reader.readLine();
                xunits = reader.readLine();
                xyrLvl = reader.readLine();

                Course course = new Course(xcode, xtitle, xunits, xyrLvl);
                availableCourses.add(course);
                // System.err.println("debug schedule manager"); // for debugging purpose
                // System.err.println("code: " + code);
                // System.err.println("title: " + title);
                // System.err.println("units: " + units);
                // System.err.println("yrLvl: " + yrLvl);

                // printAvailableCourses();
            }

        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void printAvailableCourses() { // for debugging purpose
        for (Course course : availableCourses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Units: " + course.getUnits());
            System.out.println("Year Level: " + course.getYrLvl());
            System.out.println();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    static String[] availableSchedules = {
        "MONDAY/WEDNESDAY: 09:00 - 12:00",
        "MONDAY/WEDNESDAY: 13:00 - 16:00",
        "MONDAY/WEDNESDAY: 17:00 - 20:00",
        "TUESDAY/FRIDAY: 09:00 - 12:00",
        "TUESDAY/FRIDAY: 13:00 - 16:00",
        "TUESDAY/FRIDAY: 17:00 - 20:00",
        "THURSDAY/SATURDAY: 09:00 - 12:00",
        "THURSDAY/SATURDAY: 13:00 - 16:00",
        "THURSDAY/SATURDAY: 17:00 - 20:00",};

    static void ScheduleWriter(String code, String section, int selectedScheduleIndex, String room) {
        scheduleID--;

        String selectedSchedule = availableSchedules[selectedScheduleIndex - 1];
        String data = "";
        File inputFile = new File(".\\JH_DATA\\JH_Course.txt");
        boolean ifCourseExist = false;
        if (!scheduleExist(section, selectedScheduleIndex, room)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String key;
                while ((key = reader.readLine()) != null) {
                    if (key.equals("##########")) {
                        String idCheck = reader.readLine();
                        if (idCheck.equalsIgnoreCase(code)) {
                            String courseTitle = reader.readLine();
                            String couseUnits = reader.readLine();
                            String courseYrLvl = reader.readLine();
                            ifCourseExist = true;
                            try (FileWriter writer = new FileWriter(file, true)) {
                                data += "$$$$$$$$$$\n";

                                data += section.toUpperCase() + '\n';
                                data += selectedSchedule + '\n';
                                data += room.toUpperCase() + '\n';

                                data += code.toUpperCase() + '\n';
                                data += courseTitle.toUpperCase() + '\n';
                                data += couseUnits + '\n';
                                data += courseYrLvl + '\n';

                                writer.write(data);
                                writer.close();
                            }
                            return;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("search METHOD: " + e.getMessage());
            }
            if (!ifCourseExist) {
                System.err.println("COURSE: " + code.toUpperCase() + " DOES NOT EXIST \nPLEASE OFFER COURSE IN COURSE MANAGER");
            }
        } else {
            System.out.println("SCHEDULE" + selectedSchedule + " AND ROOM " + room + " IS ALREADY BEING USED PLEASE SELECT DIFFERENT TIME/ROOM");
        }
    }

    public void add() {
        String courseCode;
        String section;
        int selectedScheduleIndex;
        String room;

        String confirm;

        do {
            System.out.print("\033\143");
            printAvailableCourses();
            System.out.println("Enter course code");
            System.out.print(">> ");
            courseCode = input.nextLine();

            System.out.println("Enter section");
            System.out.print(">> ");
            section = input.nextLine();

            do {
                System.out.print("\033\143");
                for (int i = 0; i < availableSchedules.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + availableSchedules[i]);
                }
                System.out.print("Enter schedule index (1-9): ");
                selectedScheduleIndex = input.nextInt();
                input.nextLine();
    
                if (selectedScheduleIndex < 1 || selectedScheduleIndex > 9) {
                    System.out.println("Invalid index. Please select a valid schedule.");
                }
            } while (selectedScheduleIndex < 1 || selectedScheduleIndex > 9);

            System.out.println("Enter room");
            System.out.print(">> ");
            room = input.nextLine();

            System.out.print("\033\143");
            System.out.println("CODE: " + courseCode);
            System.out.println("SECTION: " + section);
            System.out.println("SCHEDULLE: " + availableSchedules[selectedScheduleIndex - 1]);
            System.out.println("YEAR: " + room);

            System.out.println("data entered are valid? [Y/N] ");
            System.out.print(">> ");
            confirm = input.nextLine();
        } while (!confirm.equals("y"));

        ScheduleWriter(courseCode, section, selectedScheduleIndex, room);
    }

    public void view() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            boolean keyDetected = false;
            while ((key = reader.readLine()) != null) {
                if (key.equals("$$$$$$$$$$")) {
                    keyDetected = true;
                    continue;
                }
                if (keyDetected) {
                    String section = key;
                    String schedule = reader.readLine();
                    String room = reader.readLine();
                    String courseCode = reader.readLine();
                    String courseTitle = reader.readLine();
                    String courseUnits = reader.readLine();
                    String courseYRLvl = reader.readLine();

                    System.out.println("===========================================================");
                    System.out.println("Section: " + section);
                    System.out.println("Schedule: " + schedule);
                    System.out.println("Room: " + room);
                    System.out.println("Course Code: " + courseCode);
                    System.out.println("Course Title: " + courseTitle);
                    System.out.println("Units: " + courseUnits);
                    System.out.println("Year Level: " + courseYRLvl);
                }
            }
        } catch (IOException e) {
            System.out.println("VIEW METHOD: " + e.getMessage());
        }
    }

    public void edit(String section, int selectedScheduleIndex) {
        try {
            String selectedSchedule = availableSchedules[selectedScheduleIndex - 1];
            boolean keyDetected = false;
            boolean classExist = false;
            ArrayList<String> updatedSchedule = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String key;
                while ((key = reader.readLine()) != null) {
                    if (key.equals("$$$$$$$$$$")) {
                        keyDetected = true;
                        // updatedSchedule.add(key);

                        continue;
                    }
                    if (keyDetected) {
                        String currentSection = key;
                        String currentSchedule = reader.readLine();
                        String currentRoom = reader.readLine();
                        String courseCODE = reader.readLine();
                        String courseTITLE = reader.readLine();
                        String courseUNITS = reader.readLine();
                        String courseYRLVL = reader.readLine();

                        if (currentSection.equalsIgnoreCase(section) && currentSchedule.equals(selectedSchedule)) {
                            System.out.print("\033\143");
                            System.out.println("CURRENTLY EDITING");
                            System.out.println("Section: " + currentSection);
                            System.out.println("Schedule: " + currentSchedule);
                            System.out.println("Room: " + currentRoom);
                            System.out.println("Course Code: " + courseCODE);
                            System.out.println("Course Title: " + courseTITLE);
                            System.out.println("Units: " + courseUNITS);
                            System.out.println("Year Level: " + courseYRLVL);
                            classExist = true;
                            int choice;
                            String userInput;
                            int intuserInput;
                            do {
                                System.out.println("What do you want to edit?");
                                System.out.println("[1] Section");
                                System.out.println("[2] Schedule");
                                System.out.println("[3] Room");
                                System.out.print(">> ");
                                try {
                                    choice = input.nextInt();
                                    input.nextLine();
                                    if (choice < 1 || choice > 3) {
                                        System.out.println("INVALID CHOICE");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter an integer.");
                                    input.nextLine();
                                    choice = 0;
                                }
                            } while (choice < 1 || choice > 3);
                            switch (choice) {
                                case 1:
                                    System.out.print("\033\143");
                                    System.out.println("CURRENTLY EDITING");
                                    System.out.println("Section: " + currentSection);
                                    System.out.println("Schedule: " + currentSchedule);
                                    System.out.println("Room: " + currentRoom);
                                    System.out.println("Course Code: " + courseCODE);
                                    System.out.println("Course Title: " + courseTITLE);
                                    System.out.println("Units: " + courseUNITS);
                                    System.out.println("Year Level: " + courseYRLVL);
                                    System.out.println("Update section ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    currentSection = userInput;
                                    break;
                                case 2:
                                    System.out.print("\033\143");
                                    System.out.println("CURRENTLY EDITING");
                                    System.out.println("Section: " + currentSection);
                                    System.out.println("Schedule: " + currentSchedule);
                                    System.out.println("Room: " + currentRoom);
                                    System.out.println("Course Code: " + courseCODE);
                                    System.out.println("Course Title: " + courseTITLE);
                                    System.out.println("Units: " + courseUNITS);
                                    System.out.println("Year Level: " + courseYRLVL);
                                    for (int i = 0; i < availableSchedules.length; i++) {
                                        System.out.println("[" + (i + 1) + "]" + availableSchedules[i]);
                                    }
                                    System.out.println("Change Schedule ");
                                    System.out.print(">> ");
                                    intuserInput = input.nextInt();
                                    input.nextLine();
                                    String editselectedSchedule = availableSchedules[intuserInput - 1];
                                    currentSchedule = editselectedSchedule;
                                    break;
                                case 3:
                                    System.out.print("\033\143");
                                    System.out.println("CURRENTLY EDITING");
                                    System.out.println("Section: " + currentSection);
                                    System.out.println("Schedule: " + currentSchedule);
                                    System.out.println("Room: " + currentRoom);
                                    System.out.println("Course Code: " + courseCODE);
                                    System.out.println("Course Title: " + courseTITLE);
                                    System.out.println("Units: " + courseUNITS);
                                    System.out.println("Year Level: " + courseYRLVL);
                                    System.out.println("Change room");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    currentRoom = userInput;
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            // System.err.println("///////////////DEBUG///////////////");                            
                            // System.err.println("SECTION: " + currentSection);
                            // System.err.println("SCHEDULE: " + currentSchedule);
                            // System.err.println("ROOM: " + currentRoom);
                            // System.err.println("COURSE CODE: " + courseCODE);
                            // System.err.println("TITLE: " + courseTITLE);
                            // System.err.println("UNITS: " + courseUNITS);
                            // System.err.println("YEAR LVL: " + courseYRLVL);
                            // System.err.println("///////////////DEBUG///////////////");
                            updatedSchedule.add("$$$$$$$$$$");
                            updatedSchedule.add(currentSection.toUpperCase());
                            updatedSchedule.add(currentSchedule);
                            updatedSchedule.add(currentRoom.toUpperCase());
                            updatedSchedule.add(courseCODE);
                            updatedSchedule.add(courseTITLE);
                            updatedSchedule.add(courseUNITS);
                            updatedSchedule.add(courseYRLVL);
                            // System.err.println("///////////////DEBUG///////////////");
                            // System.err.println(updatedSchedule);
                        } else {
                            updatedSchedule.add("$$$$$$$$$$");
                            updatedSchedule.add(key);
                            updatedSchedule.add(currentSchedule);
                            updatedSchedule.add(currentRoom);
                            updatedSchedule.add(courseCODE);
                            updatedSchedule.add(courseTITLE);
                            updatedSchedule.add(courseUNITS);
                            updatedSchedule.add(courseYRLVL);
                            // System.err.println("///////////////DEBUG///////////////");
                            // System.err.println(updatedSchedule);
                        }
                    }
                }
                reader.close();
                try (FileWriter writer = new FileWriter(file)) {
                    for (String line : updatedSchedule) {
                        writer.write(line + "\n");
                    }
                }
            }
            if (!classExist) {
                System.out.println("CLASS WITH " + section + " " + selectedSchedule + " DOES NOT EXIST");
            }
        } catch (IOException e) {
            System.out.println("EDIT METHOD: " + e.getMessage());
        }
    }

    public void del(String section, int selectedScheduleIndex) {
        try {
            File inputFile = new File(".\\JH_DATA\\JH_Schedule.txt");
            File tempFile = new File(".\\JH_DATA\\temp_JH_Schedule.txt");
            String selectedSchedule = availableSchedules[selectedScheduleIndex - 1];
            boolean keyDetected = false;
            boolean detect = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String key;
                while ((key = reader.readLine()) != null) {
                    if (key.equals("$$$$$$$$$$")) {
                        keyDetected = true;
                        continue;
                    }
                    if (keyDetected) {
                        String currentSection = key;
                        String currentSchedule = reader.readLine();
                        String currentROOM = reader.readLine();
                        String courseCODE = reader.readLine();
                        String courseTITLE = reader.readLine();
                        String courseUNIT = reader.readLine();
                        String courseYRLVL = reader.readLine();

                        if (currentSection.equalsIgnoreCase(section) && currentSchedule.equals(selectedSchedule)) {
                            System.err.println("SECTION: " + currentSection);
                            System.err.println("SECTION: " + currentSchedule);
                            // for (int i = 0; i < 6; i++) {
                            //     reader.readLine();
                            // }
                            detect = true;
                        } else {
                            // System.err.println("///////////////DEBUG///////////////");
                            // System.err.println("DEBUG: " + key);
                            // System.err.println("DEBUG: " + currentSchedule);
                            // System.err.println("///////////////DEBUG///////////////");
                            writer.write("$$$$$$$$$$\n");
                            writer.write(key + '\n');
                            writer.write(currentSchedule + '\n');

                            writer.write(currentROOM + '\n');
                            writer.write(courseCODE + '\n');
                            writer.write(courseTITLE + '\n');
                            writer.write(courseUNIT + '\n');
                            writer.write(courseYRLVL + '\n');

                        }
                    }

                }
                if (keyDetected) {
                    reader.close();
                    writer.close();
                    inputFile.delete();
                    tempFile.renameTo(inputFile);
                }
                if (!detect) {
                    {
                        System.out.println("CLASS WITH " + selectedSchedule + " " + selectedSchedule + " DOES NOT EXIST");
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("DEL METHOD: " + e.getMessage());
        }
    }
}
