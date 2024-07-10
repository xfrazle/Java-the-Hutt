
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        StudentManager manageStudent = new StudentManager();
        // manageStudent.add();
        // CourseManager manageCourse = new CourseManager();
        // manageCourse.add();
        // ScheduleManager manageSchedule = new ScheduleManager();
        // manageSchedule.add();
        // manageSchedule.add();

        // manageStudent.studentWriter("201812345", "3", "Khris Guia", "", "Magnaye", "123 Mindanao", "IT", "AGD", "Male",
        // "1", "December", "1996");
        // manageStudent.studentWriter("198012345", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
        // "December", "1996");

        EnrollStudent enrollment = new EnrollStudent();
        // enrollment.registration("201812763");
        // enrollment.enrollmentWriter("201812763", "MAT00001", 1);
        // enrollment.enrollmentWriter("201812763", "SCI00001", 4);
        // enrollment.enrollmentWriter("201812763", "ENG00001", 7);
        // enrollment.enrollmentWriter("201812345", "MAT00001", 1);
        // enrollment.enrollmentWriter("201812345", "SCI00001", 4);
        // enrollment.enrollmentWriter("201812345", "ENG00001", 7);
        // enrollment.enrollmentWriter("198012345", "MAT00001", 1);
        // enrollment.enrollmentWriter("198012345", "SCI00001", 4);
        // enrollment.enrollmentWriter("198012345", "ENG00001", 7);

        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.print("\033\143");
            System.out.println("===========================================================");
            System.out.println("Java the Hutt");
            System.out.println("===========================================================");
            System.out.println("[1]Enroll");
            System.out.println("[2]Student Management");
            System.out.println("[3]Schedule Management");
            System.out.println("[4]Course Management");
            System.out.println("[5]DEBUG");
            System.out.println("[EXIT]Exit Program");
            System.out.print(">> ");

            choice = input.nextLine();
            switch (choice) {
                case "1":
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
                case "2":
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
                            case "4":
                                System.out.print("\033\143");
                                manageStudent.view();
                                System.out.println("Enter Student ID");
                                System.out.print(">> ");
                                String delete;
                                delete = input.nextLine();

                                if (StudentManager.studentExist(delete)) {
                                    manageStudent.del(delete);
                                }
                                input.nextLine();
                            default:
                        }
                    } while (!studentChoice.equals("<"));
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                default:
                    System.out.print("\033\143");
                    System.out.println("===========================================================");
                    System.out.println("INVALID CHOICE <<<<<");
            }

        } while (!choice.equals("EXIT"));

    }
}

// 201812763
// 201812345
// 198012345
