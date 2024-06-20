import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StudentManager implements JHinterface {

    ArrayList<Student> students = new ArrayList<>();
    private Scanner uInput = new Scanner(System.in);

    @Override
    public void add() {
        /*
         * System.out.print("Enter student ID: ");
         * int id = uInput.nextInt();
         * uInput.nextLine();
         * System.out.print("Enter Year Level: "); // need exceptions
         * int yrLvl = uInput.nextInt();
         * uInput.nextLine();
         * 
         * // Personal Infos
         * System.out.print("Enter first name: ");
         * String fName = uInput.nextLine();
         * System.out.print("Enter middle name: ");
         * String mName = uInput.nextLine();
         * System.out.print("Enter last name: ");
         * String lName = uInput.nextLine();
         * System.out.print("Enter Address: ");
         * String address = uInput.nextLine();
         * System.out.print("Enter gender: "); // need exceptions
         * String gender = uInput.nextLine();
         * 
         * System.out.print("Enter Birth Month: ");
         * String bMonth = uInput.nextLine();
         * System.out.print("Enter Birth Date: ");
         * String bDate = uInput.nextLine();
         * System.out.print("Enter Birth Year: ");
         * String bYear = uInput.nextLine();
         * 
         * // School Info
         * System.out.print("Bachelor's in [IT/CS]: "); // need exceptions
         * String degree = uInput.nextLine();
         * System.out.print("Specialization's in: "); // need exceptions
         * String specialization = uInput.nextLine();
         */
        // Student student = new Student(id, yrLvl, fName, mName, lName, address,
        // degree, specialization, gender, bDate, bMonth, bYear);
        // students.add(student);

        Student Albert = new Student(201812763, 2, "john albert", "arrubas", "castaneda", "2007 d", "it", "agd", "male",
                "18", "May", "1998");
        Student Alison = new Student(201812345, 3, "Khris Guia", "", "Magnaye", "123 Mindanao", "IT", "AGD", "Male",
                "1", "December", "1996");
        Student Xen = new Student(198012345, 20, "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
                "December", "1996");
        students.add(Albert);
        students.add(Alison);
        students.add(Xen);

    }

    @Override
    public void view() {
        // use printStudent() function
        for (Student student : students) {
            System.out.println("------------------------------------------------------------");
            System.out.println("ID: " + student.getID());
            System.out.println("Year: " + student.getyrLvl());

            System.out.println("BS" + student.getDegree() + "-" + student.getSpecialization());

            System.out.println("Name: " + student.getfName() + " " + student.getmName() + " " + student.getlName());

            System.out.println("Gender: " + student.getGender());
            System.out
                    .println("Birth Day: " + student.getbMonth() + " " + student.getbDate() + " " + student.getbYear());

            System.out.println("Address: " + student.getAddress());
            System.out.println("------------------------------------------------------------");
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter student number of student you want to edit: ");
        int id = uInput.nextInt();
        uInput.nextLine();

        for (Student student : students) {
            if (Integer.valueOf(student.getID()).equals(id)) {
                System.out.println(student.getID() + "found, continue editing " + student.getfName() + " "
                        + student.getmName() + " " + student.getlName());
                System.out.println("What do you want to edit?");
                System.out.println("[1] Name");
                System.out.println("[2] Year");
                System.out.println("[3] Address");
                int choice = uInput.nextInt();
                uInput.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter first name: ");
                        String newfName = uInput.nextLine();
                        student.setfName(newfName);
                        System.out.println("Enter middle name: ");
                        String newmName = uInput.nextLine();
                        student.setmName(newmName);
                        System.out.println("Enter last name: ");
                        String newlName = uInput.nextLine();
                        student.setlName(newlName);
                        break;

                    case 2:
                        System.out.println("Enter year level: ");
                        int newyrLvl = uInput.nextInt();
                        student.setyrLvl(newyrLvl);
                        break;

                    case 3:
                        System.out.println("Enter Address: ");
                        String address = uInput.nextLine();
                        student.setAddress(address);
                        break;

                    // add more options
                }
            }
        }
        System.out.println(id + " Student ID not found");

    }

    @Override
    public void delete() {
        // ask for student id to identify student
        //
        System.out.println("Enter student number of student you want to DELETE: ");
        int id = uInput.nextInt();
        uInput.nextLine();

        boolean idFound = false;

        // for(Student student: students){
        // if(Integer.valueOf(student.getID()).equals(id)){
        // students.remove(id);
        // }
        // }
        Iterator<Student> i = students.iterator();
        while (i.hasNext()) {
            Student student = i.next();
            if (Integer.valueOf(student.getID()).equals(id)) {
                i.remove(); // Remove the student from the list
                idFound = true;
                break; // Exit the loop once found
            }
        }
        if (idFound) {
            System.out.println("Student has been deleted");
        } else {
            System.out.println(id + " Student ID not found");
        }
    }
}