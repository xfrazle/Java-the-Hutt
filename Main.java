
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        StudentManager manageStudent = new StudentManager();
        EnrollStudent enrollment = new EnrollStudent();
        CourseManager manageCourse = new CourseManager();
        ScheduleManager manageSchedule = new ScheduleManager();
        // manageStudent.add();
        // 
        // manageCourse.add();
        // 
        // manageSchedule.add();
        // manageSchedule.add();

        // manageStudent.studentWriter("201812345", "3", "Khris Guia", "", "Magnaye", "123 Mindanao", "IT", "AGD", "Male",
        // "1", "December", "1996");
        // manageStudent.studentWriter("198012345", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
        // "December", "1996");
        // enrollment.registration("201812763");
        // enrollment.enrollmentWriter("201812763", "21321323", 9);
        // enrollment.enrollmentWriter("201812763", "SCI00001", 4);
        // enrollment.enrollmentWriter("201812763", "ENG00001", 7);
        // enrollment.enrollmentWriter("201812345", "MAT00001", 1);
        // enrollment.enrollmentWriter("201812345", "SCI00001", 4);
        // enrollment.enrollmentWriter("201812345", "ENG00001", 7);
        // enrollment.enrollmentWriter("198012345", "MAT00001", 1);
        // enrollment.enrollmentWriter("198012345", "SCI00001", 4);
        // enrollment.enrollmentWriter("198012345", "ENG00001", 7);
        String[] availableSchedules = {
            "MONDAY/WEDNESDAY: 09:00 - 12:00",
            "MONDAY/WEDNESDAY: 13:00 - 16:00",
            "MONDAY/WEDNESDAY: 17:00 - 20:00",
            "TUESDAY/FRIDAY: 09:00 - 12:00",
            "TUESDAY/FRIDAY: 13:00 - 16:00",
            "TUESDAY/FRIDAY: 17:00 - 20:00",
            "THURSDAY/SATURDAY: 09:00 - 12:00",
            "THURSDAY/SATURDAY: 13:00 - 16:00",
            "THURSDAY/SATURDAY: 17:00 - 20:00",};

        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.print("\033\143");
            System.out.println("===========================================================");
            System.out.println("Java the Hutt");
            System.out.println("===========================================================");
            System.out.println("[1]Enroll");
            System.out.println("[2]Student Management");
            System.out.println("[3]Course Management");
            System.out.println("[4]Schedule Management");
            System.out.println("[5]DEBUG");
            System.out.println("[EXIT]Exit Program");
            System.out.print(">> ");

            choice = input.nextLine();
            switch (choice) {
                case "1": // enroll a student
                    String enrollChoice;
                    do {
                        System.out.print("\033\143");
                        System.out.println("[1]Enroll Student");
                        System.out.println("[2]View List of Enrolees");
                        System.out.println("[<]go back");
                        System.out.print(">> ");
                        enrollChoice = input.nextLine();
                        switch (enrollChoice) {
                            case "1":
                                enrollment.add();
                                break;
                            case "2":
                                enrollment.view();
                                input.nextLine();
                                break;
                            default:
                        }
                    } while (!enrollChoice.equals("<"));
                    break;
                case "2": // student management
                    String studentChoice;
                    do {
                        System.out.print("\033\143");
                        System.out.println("[1]Add Student");
                        System.out.println("[2]View Student List");
                        System.out.println("[3]Edit Student");
                        System.out.println("[4]Delete Student");
                        System.out.println("[<]go back");
                        System.out.print(">> ");
                        studentChoice = input.nextLine();
                        switch (studentChoice) {
                            case "1":
                                manageStudent.add();
                                break;
                            case "2":
                                System.out.print("\033\143");
                                manageStudent.view();
                                input.nextLine();
                                break;
                            case "3":
                                System.out.print("\033\143");
                                manageStudent.view();
                                System.out.println("Enter Student ID");
                                System.out.print(">> ");
                                String edit = input.nextLine();

                                if (StudentManager.studentExist(edit)) {
                                    manageStudent.edit(edit);
                                }
                                input.nextLine();
                                break;
                            case "4":
                                System.out.print("\033\143");
                                manageStudent.view();
                                System.out.println("Enter Student ID");
                                System.out.print(">> ");
                                String delete;
                                delete = input.nextLine();

                                if (StudentManager.studentExist(delete)) {
                                    manageStudent.del(delete);
                                } else {
                                    System.out.println("STUDENT DOES NOT EXIST");
                                    input.nextLine();
                                }
                                input.nextLine();
                                break;
                            default:
                        }
                    } while (!studentChoice.equals("<"));
                    break;
                case "3": // course management
                    String courseChoice;
                    do {
                        System.out.print("\033\143");
                        System.out.println("[1]Add Course");
                        System.out.println("[2]View Available Courses");
                        System.out.println("[3]Edit a Course");
                        System.out.println("[4]Delete a Course");
                        System.out.println("[<]go back");
                        System.out.print(">> ");
                        courseChoice = input.nextLine();
                        switch (courseChoice) {
                            case "1":
                                manageCourse.add();
                                break;
                            case "2":
                                manageCourse.view();
                                input.nextLine();
                                break;
                            case "3":
                                manageCourse.view();
                                System.out.println("Enter course code");
                                System.out.print(">> ");
                                courseChoice = input.nextLine();
                                manageCourse.edit(courseChoice);
                                break;
                            case "4":
                                manageCourse.view();
                                System.out.println("Enter course code");
                                System.out.print(">> ");
                                courseChoice = input.nextLine();
                                manageCourse.del(courseChoice);

                                break;
                            default:
                        }
                    } while (!courseChoice.equals("<"));
                    break;
                case "4": // schedule management
                    String scheduleChoice;
                    int selectedScheduleIndex;

                    String section;
                    do {
                        System.out.print("\033\143");
                        System.out.println("[1]Add Schedule");
                        System.out.println("[2]View Available Schedule");
                        System.out.println("[3]Edit a Schedule");
                        System.out.println("[4]Delete a Schedule");
                        System.out.println("[<]go back");
                        System.out.print(">> ");
                        scheduleChoice = input.nextLine();
                        switch (scheduleChoice) {
                            case "1":
                                manageCourse.view();
                                manageSchedule.add();
                                break;
                            case "2":
                                manageSchedule.view();
                                input.nextLine();
                                break;
                            case "3":
                                manageSchedule.view();
                                System.out.println("Enter section and schedule to edit");
                                System.out.println("Enter section");
                                System.out.print(">> ");
                                section = input.nextLine();

                                do {
                                    for (int i = 0; i < availableSchedules.length; i++) {
                                        System.out.println("[" + (i + 1) + "] " + availableSchedules[i]);
                                    }
                                    System.out.println("Enter Schedule");
                                    System.out.print(">> ");
                                    String userInput = input.nextLine();
                                    try {
                                        selectedScheduleIndex = Integer.parseInt(userInput);
                                        if (selectedScheduleIndex < 1 || selectedScheduleIndex > availableSchedules.length) {
                                            System.out.println("Invalid index. Please select a valid schedule.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter an integer.");
                                        selectedScheduleIndex = -1;
                                    }
                                } while (selectedScheduleIndex < 1 || selectedScheduleIndex > availableSchedules.length);

                                manageSchedule.edit(section, selectedScheduleIndex);
                                break;
                            case "4":
                                manageSchedule.view();
                                System.out.println("Enter section and schedule to delete");

                                System.out.println("Enter section");
                                System.out.print(">> ");
                                section = input.nextLine();

                                do {
                                    for (int i = 0; i < availableSchedules.length; i++) {
                                        System.out.println("[" + (i + 1) + "] " + availableSchedules[i]);
                                    }
                                    System.out.println("Enter Schedule");
                                    System.out.print(">> ");
                                    String userInput = input.nextLine();
                                    try {
                                        selectedScheduleIndex = Integer.parseInt(userInput);
                                        if (selectedScheduleIndex < 1 || selectedScheduleIndex > availableSchedules.length) {
                                            System.out.println("Invalid index. Please select a valid schedule.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter an integer.");
                                        selectedScheduleIndex = -1;
                                    }
                                } while (selectedScheduleIndex < 1 || selectedScheduleIndex > availableSchedules.length);

                                manageSchedule.del(section, selectedScheduleIndex);
                                break;
                            default:
                        }
                    } while (!scheduleChoice.equals("<"));
                    break;
                case "5": // predefined values
                    String debugChoice;
                    do {
                        System.out.println("Enter debug choice");
                        System.out.println("[1]add 15 random students value");
                        System.out.println("[2]add 15 random course value");
                        System.out.println("[3]fill all schedules");
                        System.out.print(">> ");

                        debugChoice = input.nextLine();

                        switch (debugChoice) {
                            case "1":
                                StudentManager.studentWriter("201899999", "2", "john albert", "arrubas", "castaneda", "2007 d", "it", "agd", "male",
                                        "18", "May", "1998");
                                StudentManager.studentWriter("201812345", "3", "Khris Guia", "", "Magnaye", "123 Mindanao", "IT", "AGD", "Male",
                                        "1", "December", "1996");
                                StudentManager.studentWriter("198012345", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
                                        "December", "1996");

                                StudentManager.studentWriter("201877777", "2", "juan alberto", "arriba", "castaenyeeda", "999 d", "it", "agd", "male",
                                        "18", "May", "1998");
                                StudentManager.studentWriter("211812345", "3", "Khis Giya", "", "MagnaNO", "123 Mindanao", "IT", "AGD", "Male",
                                        "1", "December", "1996");
                                StudentManager.studentWriter("998012345", "20", "Froyd", "", "Xamoria", "1223 Mindanao", "IT", "DA", "Male", "1",
                                        "December", "1996");

                                StudentManager.studentWriter("201871117", "2", "juan alberzo", "arruba", "castaenieeda", "999 d", "it", "agd", "male",
                                        "18", "May", "1998");
                                StudentManager.studentWriter("211855545", "3", "Jiya", "", "Magnayo", "123 Mindanao", "IT", "AGD", "Male",
                                        "1", "December", "1996");
                                StudentManager.studentWriter("998018885", "20", "Froy", "", "Xamory", "1223 Mindanao", "IT", "DA", "Male", "1",
                                        "December", "1996");

                                StudentManager.studentWriter("798012885", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
                                        "December", "1996");
                                StudentManager.studentWriter("798018385", "20", "M", "", "Sain", "1223 Manila", "IT", "DA", "Male", "1",
                                        "December", "1996");
                                StudentManager.studentWriter("798018185", "20", "J", "", "Olazo", "1223 Manila", "IT", "DA", "Female", "1",
                                        "December", "1996");

                                StudentManager.studentWriter("798018885", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
                                        "December", "1996");
                                StudentManager.studentWriter("398018885", "20", "M", "", "Sain", "1223 Manila", "IT", "DA", "Male", "1",
                                        "December", "1996");
                                StudentManager.studentWriter("398018825", "20", "J", "", "Olazo", "1223 Manila", "IT", "DA", "Female", "1",
                                        "December", "1996");

                                System.out.println("15 random names and random id has been added");
                                input.nextLine();
                                break;

                            case "2":
                                CourseManager.courseWritter("mat00001", "Algebra", "3", "1");
                                CourseManager.courseWritter("mat00002", "Geometry", "3", "2");
                                CourseManager.courseWritter("mat00003", "Calculus", "3", "3");

                                CourseManager.courseWritter("sci00001", "Physics 1", "3", "2");
                                CourseManager.courseWritter("sci00002", "Physics 2", "3", "3");
                                CourseManager.courseWritter("sci00003", "Physics 3", "3", "3");

                                CourseManager.courseWritter("eng00001", "English 1", "3", "2");
                                CourseManager.courseWritter("eng00002", "English 2", "3", "2");
                                CourseManager.courseWritter("eng00003", "English 3", "3", "2");

                                CourseManager.courseWritter("pe00001", "physical education 1 - body conditioning", "3", "1");
                                CourseManager.courseWritter("pe00002", "physical education 2 - dance dance dance", "3", "1");
                                CourseManager.courseWritter("pe00003", "physical education 3 - sports", "3", "1");

                                CourseManager.courseWritter("prog00001", "c lang", "3", "1");
                                CourseManager.courseWritter("prog00002", "procedural structure", "3", "2");
                                CourseManager.courseWritter("prog00003", "object oriented", "3", "2");

                                CourseManager.courseWritter("net00001", "cisco 1", "3", "2");
                                CourseManager.courseWritter("net00002", "cisco 2", "3", "3");
                                CourseManager.courseWritter("net00003", "network security", "3", "3");

                                System.out.println("15 subjects has been added");
                                input.nextLine();
                                break;

                            case "3":
                                ScheduleManager.ScheduleWriter("mat00001", "section-a", 1, "aa-10");
                                ScheduleManager.ScheduleWriter("mat00001", "section-b", 2, "bb-10");
                                ScheduleManager.ScheduleWriter("mat00001", "section-c", 3, "cc-10");

                                ScheduleManager.ScheduleWriter("pe00001", "section-a", 4, "aa-10");
                                ScheduleManager.ScheduleWriter("pe00001", "section-b", 5, "bb-10");
                                ScheduleManager.ScheduleWriter("pe00001", "section-c", 6, "cc-10");

                                ScheduleManager.ScheduleWriter("sci00001", "section-a", 7, "aa-10");
                                ScheduleManager.ScheduleWriter("sci00001", "section-b", 7, "bb-10");
                                ScheduleManager.ScheduleWriter("sci00001", "section-c", 8, "cc-10");

                                System.out.println("9 schedule has been added");
                                break;
                        }

                        debugChoice = input.nextLine();
                    } while (!debugChoice.equals("<"));

                    break;
                default:
            }
        } while (!choice.equalsIgnoreCase("EXIT"));
        
        
        input.close();
    }
} // 201812763
// 201812345
// 198012345
