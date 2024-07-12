
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class EnrollStudent {

    ScheduleManager manageSchedule = new ScheduleManager();
    Scanner input = new Scanner(System.in);
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

    public void registration(String studentID) {
        System.out.print("\033\143");
        System.out.println("===========================================================");
        System.out.println("AVAILABLE COURSES");
        System.out.println("===========================================================");
        manageSchedule.view();
        System.out.println("ENTER COURSE CODE OF DESIRED SUBJECT");
        System.out.print(">> ");
        String courseCode = input.nextLine();
        for (int i = 0; i < availableSchedules.length; i++) {
            System.out.println("[" + (i + 1) + "]" + availableSchedules[i]);
        }

        System.out.println("ENTER SCHEDULE OF DESIRED SUBJECT");
        int courseSchedule = input.nextInt();
        input.nextLine();
        String selectedSchedule = availableSchedules[courseSchedule - 1];

    }

    private static boolean duplicateCourse(String courseCode, String studentID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\JH_DATA\\Enrolled_Subjects.txt"))) {
            String key;
            while ((key = reader.readLine()) != null) {
                String checkStudentID = reader.readLine();

                if (key.equalsIgnoreCase(courseCode) && checkStudentID.equalsIgnoreCase(studentID)) {
                    // System.out.println("COURSECODE: " + key);
                    // System.out.println("CHECKSTUDENTID: " + checkStudentID);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean courseLvl(String studentID, String courseCode) {
        try {
            int studentYear = 0;
            int courseYear = 0;
            ArrayList<String> studentInfo = new ArrayList<>();
            ArrayList<String> courseInfo = new ArrayList<>();
            try (BufferedReader readStudent = new BufferedReader(new FileReader(".\\JH_DATA\\Student_Info.txt"))) {
                String key;
                while ((key = readStudent.readLine()) != null) {
                    if (key.equals(("**********"))) {
                        String idCheck = readStudent.readLine();
                        if (idCheck.equals(studentID)) {
                            // System.err.println("idCheck debug: " + idCheck);
                            String yrLvl = readStudent.readLine();
                            // System.err.println("Yr Lvl: " + yrLvl);
                            studentYear = Integer.parseInt(yrLvl);
                        }
                    }
                }
                readStudent.close();
            }
            try (BufferedReader readCourse = new BufferedReader(new FileReader(".\\JH_DATA\\JH_Course.txt"))) {
                String key;
                while ((key = readCourse.readLine()) != null) {
                    if (key.equalsIgnoreCase("##########")) {
                        String codeCheck = readCourse.readLine();
                        if (codeCheck.equalsIgnoreCase(courseCode)) {
                            String skip = readCourse.readLine();
                            skip = readCourse.readLine();

                            skip = readCourse.readLine();
                            courseYear = Integer.parseInt(skip);
                            // System.err.println("Course Year: " + courseYear);
                        }
                    }
                }
            }
            // System.err.println("student " + studentYear);
            // System.err.println("course " + courseYear);
            if (studentYear >= courseYear) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void enrollmentWriter(String studentID, String courseCode, int courseSchedule) {
        String selectedSchedule = availableSchedules[courseSchedule - 1];
        try {
            boolean keyDetected = false;
            boolean scheduleFOUND = false;
            ArrayList<String> enrollInfo = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(".\\JH_DATA\\JH_Schedule.txt"))) {
                String key;

                while ((key = reader.readLine()) != null) {
                    if (key.equals("$$$$$$$$$$")) {
                        keyDetected = true;

                        continue;
                    }
                    if (keyDetected) {
                        String currentSection = key;
                        String currentSchedule = reader.readLine();
                        String currentRoom = reader.readLine();
                        String currentCODE = reader.readLine();
                        String currentTITLE = reader.readLine();
                        String currentUNITS = reader.readLine();
                        String currentYRLVL = reader.readLine();
                        if (currentCODE.equalsIgnoreCase(courseCode) && currentSchedule.equalsIgnoreCase(selectedSchedule)) {
                            scheduleFOUND = true;
                            // System.err.println("|||||||||||||||||||||||||||||||||||||||||");
                            // System.out.println("CURRENTLY DEBUGGING");
                            // System.err.println("|||||||||||||||||||||||||||||||||||||||||");
                            // System.out.println("Section: " + currentSection);
                            // System.out.println("Schedule: " + currentSchedule);
                            // System.out.println("Room: " + currentRoom);
                            // System.out.println("Course Code: " + currentCODE);
                            // System.out.println("Course Title: " + currentTITLE);
                            // System.out.println("Units: " + currentUNITS);
                            // System.out.println("Year Level: " + currentYRLVL);

                            enrollInfo.add(currentCODE);
                            enrollInfo.add(studentID);
                            enrollInfo.add(currentSection);
                            enrollInfo.add(currentSchedule);
                            System.out.println(enrollInfo);
                            if (!duplicateCourse(courseCode, studentID)) {
                                if (courseLvl(studentID, courseCode)) {
                                    try (FileWriter writer = new FileWriter(".\\JH_DATA\\Enrolled_Subjects.txt", true)) {
                                        for (String line : enrollInfo) {
                                            writer.write(line + "\n");
                                        }

                                        writer.close();
                                    }
                                } else {
                                    System.out.println("Student " + studentID + " Year Level is still too low for this subject ");
                                }

                            } else {
                                System.out.println("Student " + studentID + " is already enroll in " + courseCode + "[" + currentTITLE + "]");
                            }

                        }
                    }
                }

                reader.close();
            }
            if (!scheduleFOUND) {
                System.out.println("COURSE " + courseCode + " with schedule: " + selectedSchedule + " does not exist");
            }
        } catch (IOException e) {
        }
    }

    public void add() {
        String id;
        String code;
        int schedule;
        String confirm;

        do {
            String userInput;
            int intInput;
            System.out.print("\033\143");
            System.out.println("STUDENT ENROLLMENT");
            System.out.println("Enter student ID: ");
            System.out.print(">> ");
            userInput = input.nextLine();
            id = userInput;
    
            manageSchedule.view();
            System.out.println("Enter course code: ");
            System.out.print(">> ");
            userInput = input.nextLine();
            code = userInput.toUpperCase();
    
            for (int i = 0; i < availableSchedules.length; i++) {
                System.out.println("[" + (i + 1) + "]" + availableSchedules[i]);
            }
            System.out.println("Enter schedule: ");
            System.out.print(">> ");
            intInput = input.nextInt();
            input.nextLine();
            schedule = intInput;
            System.out.print("\033\143");
            System.out.println("DATA ENTERED");
            System.out.println("STUDENT ID: " + id);
            System.out.println("COURSE: " + code);
            System.out.println("SCHEDULE: " + schedule);
            System.out.println("data entered are valid? [Y/N] ");
            System.out.print(">> ");
            confirm = input.nextLine();
        } while (!confirm.equalsIgnoreCase("Y"));

        enrollmentWriter(id, code, schedule);
        input.nextLine();
    }

    public void view() {
        System.out.println('\n');
        LinkedHashMap<String, List<String>> courseDetails = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\JH_DATA\\Enrolled_Subjects.txt"))) {
            String line;
            String courseCode = "";
            String schedule = "";
            String section = "";
            String key = "";

            while ((line = reader.readLine()) != null) {
                if (line.matches("[A-Z]{3}[0-9]{5}")) {
                    courseCode = line;
                    line = reader.readLine();
                    section = reader.readLine();
                    schedule = reader.readLine();
                    key = courseCode + " [" + schedule + "] " + section;
                    if (!courseDetails.containsKey(key)) {
                        courseDetails.put(key, new ArrayList<>());
                    }
                }
                courseDetails.get(key).add(line);
            }
            // System.out.println("courseCode: " + courseCode);
            // System.out.println("Student ID: " + line);
            // System.out.println("Section: " + section);
            // System.out.println("Schedule: " + schedule);

            System.out.print("\033\143");
            System.out.println("===========================================================");
            System.out.println("Java the Hutt Enrolled Students");
            for (String courseKey : courseDetails.keySet()) {
                System.out.println("===========================================================");
                System.out.println(courseKey);
                // for (String id : courseDetails.get(courseKey)) {
                //     System.out.println(id);
                List<String> students = courseDetails.get(courseKey); // Get the list of students for this course key
                for (String id : students) {
                    System.out.print(id);

                    try (BufferedReader studentReader = new BufferedReader(new FileReader(".\\JH_DATA\\Student_Info.txt"))) {
                        String studentKEY;
                        boolean studentkeyDETECTED = false;
                        while ((studentKEY = studentReader.readLine()) != null) {
                            if (studentKEY.equals("**********")) {
                                studentkeyDETECTED = true;
                                continue;
                            }
                            if (studentkeyDETECTED) {
                                String currentID = studentKEY;
                                if (currentID.equals(id)) {
                                    String yrLvl = studentReader.readLine();
                                    String fName = studentReader.readLine();
                                    String mName = studentReader.readLine();
                                    String lName = studentReader.readLine();
                                    String skip = studentReader.readLine();
                                    String degree = studentReader.readLine();
                                    String specialization = studentReader.readLine();
                                    System.out.println(" - " + lName + " " + fName + " " + mName + "[" + degree + " " + specialization + "]");
                                }
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
        }
    }

}

// For Enrolment menu:
// Enroll a Student - this part of your program must let the user select the student (by entering their ID Number or their name). 
// After the student has been selected, the program will then show the list of available courses. 
// The user will then select which courses the student will enrol. 
// Make sure that a course must not be enrolled twice by the same student and a student can only enroll courses for his/her year level.


// View List of Enrolees - this part of the program will display all the students that are currectly enrolled together with the courses they are enrolled in.
