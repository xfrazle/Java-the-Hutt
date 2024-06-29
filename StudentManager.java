
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements JHinterface {

    private static boolean studentExist(String id) {
        try {
            try (BufferedReader studentInfo = new BufferedReader(new FileReader(".\\JH_DATA\\Student_Info.txt"))) {
                String key;
                while ((key = studentInfo.readLine()) != null) {
                    if (key.equals("**********")) {
                        String idCheck = studentInfo.readLine();
                        if (idCheck.equals(id)) {
                            studentInfo.close();
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static void studentWriter(
            String id, String yrLvl, String fName, String mName, String lName, String address, String degree,
            String specialization, String gender, String bDate, String bMonth, String bYear/* , String schedule */) {
        String data = "";
        try {
            if (!studentExist(id)) {
                try (FileWriter studentInfo = new FileWriter(".\\JH_DATA\\Student_Info.txt", true)) {
                    data += "**********" + '\n';
                    data += id + '\n';
                    data += yrLvl + '\n';
                    data += fName.toUpperCase() + '\n';
                    data += mName.toUpperCase() + '\n';
                    data += lName.toUpperCase() + '\n';
                    data += address.toUpperCase() + '\n';
                    data += degree.toUpperCase() + '\n';
                    data += specialization.toUpperCase() + '\n';
                    data += gender.toUpperCase() + '\n';
                    data += bMonth.toUpperCase() + '\n';
                    data += bDate.toUpperCase() + '\n';
                    data += bYear.toUpperCase() + '\n';

                    studentInfo.write(data);
                }
            } else {
                System.out.println("Duplicate student ID detected");
            }
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    public void studentReader(String file) {
        try {
            try (BufferedReader studentInfo = new BufferedReader(new FileReader(file))) {
                String key;
                boolean keyDetected = false;
                while ((key = studentInfo.readLine()) != null) {
                    if (key.equals("**********")) {
                        keyDetected = true;
                        continue;
                    }
                    if (keyDetected) {
                        String id = key;
                        String yrLvl = studentInfo.readLine();
                        String fName = studentInfo.readLine();
                        String mName = studentInfo.readLine();
                        String lName = studentInfo.readLine();
                        String address = studentInfo.readLine();
                        String degree = studentInfo.readLine();
                        String specialization = studentInfo.readLine();
                        String gender = studentInfo.readLine();
                        String bMonth = studentInfo.readLine();
                        String bDate = studentInfo.readLine();
                        String bYear = studentInfo.readLine();
                        System.out.println("===========================================================");
                        System.out.println("ID: " + id);
                        System.out.println("Year " + yrLvl);
                        System.out.println("Name: " + fName + " " + mName + " " + lName);
                        System.out.println("Age: " + bDate + " " + bMonth + " " + bYear);
                        System.out.println("Address: " + address);
                        System.out.println("Degree: " + degree);
                        System.out.println("Specialization: " + specialization);
                        System.out.println("Gender: " + gender);
                        System.out.println();
                        System.out.println("===========================================================");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add() {

        // System.out.print("Enter student ID: ");
        // int id = uInput.nextInt();
        // uInput.nextLine();
        // System.out.print("Enter Year Level: "); // need exceptions
        // int yrLvl = uInput.nextInt();
        // uInput.nextLine();
        // // Personal Infos
        // System.out.print("Enter first name: ");
        // String fName = uInput.nextLine();
        // System.out.print("Enter middle name: ");
        // String mName = uInput.nextLine();
        // System.out.print("Enter last name: ");
        // String lName = uInput.nextLine();
        // System.out.print("Enter Address: ");
        // String address = uInput.nextLine();
        // System.out.print("Enter gender: "); // need exceptions
        // String gender = uInput.nextLine();
        // System.out.print("Enter Birth Month: ");
        // String bMonth = uInput.nextLine();
        // System.out.print("Enter Birth Date: ");
        // String bDate = uInput.nextLine();
        // System.out.print("Enter Birth Year: ");
        // String bYear = uInput.nextLine();
        // // School Info
        // System.out.print("Bachelor's in [IT/CS]: "); // need exceptions
        // String degree = uInput.nextLine();
        // System.out.print("Specialization's in: "); // need exceptions
        // String specialization = uInput.nextLine();
        // Student student = new Student(id, yrLvl, fName, mName, lName, address,
        // degree, specialization, gender, bDate, bMonth, bYear);
        // students.add(student);
        // studentWriter(id, yrLvl, fName, mName, lName, address,
        // degree, specialization, gender, bDate, bMonth, bYear);
        // students.add(student);
        // Student Albert = new Student("201812763", "2", "john albert", "arrubas",
        // "castaneda", "2007 d", "it", "agd",
        // "male",
        // "18", "May", "1998");
        // Student Alison = new Student("201812345", "3", "Khris Guia", "", "Magnaye",
        // "123 Mindanao", "IT", "AGD", "Male",
        // "1", "December", "1996");
        // Student Xen = new Student("198012345", "20", "Floyd", "", "Xamora", "1223
        // Mindanao", "IT", "DA", "Male", "1",
        // "December", "1996");
        // students.add(Albert);
        // students.add(Alison);
        // students.add(Xen);
        studentWriter("201812763", "2", "john albert", "arrubas", "castaneda", "2007 d", "it", "agd", "male",
                "18", "May", "1998");
        studentWriter("201812345", "3", "Khris Guia", "", "Magnaye", "123 Mindanao", "IT", "AGD", "Male",
                "1", "December", "1996");
        studentWriter("198012345", "20", "Floyd", "", "Xamora", "1223 Mindanao", "IT", "DA", "Male", "1",
                "December", "1996");

    }

    @Override
    public void view() {
        // use printStudent() function
        // for (Student student : students) {
        // System.out.println("------------------------------------------------------------");
        // System.out.println("ID: " + student.getID());
        // System.out.println("Year: " + student.getyrLvl());

        // System.out.println("BS" + student.getDegree() + "-" +
        // student.getSpecialization());
        // System.out.println("Name: " + student.getfName() + " " + student.getmName() +
        // " " + student.getlName());
        // System.out.println("Gender: " + student.getGender());
        // System.out
        // .println("Birth Day: " + student.getbMonth() + " " + student.getbDate() + " "
        // + student.getbYear());
        // System.out.println("Address: " + student.getAddress());
        // System.out.println("------------------------------------------------------------");
        // }
        studentReader(".\\JH_DATA\\Student_Info.txt");

    }

    @Override
    public void edit(String id) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What do you want to edit?");
            System.out.println("[1] Year level");
            System.out.println("[2] Full Name");
            System.out.println("[1] Address");
            System.out.println("[2] Course");
            System.out.println("[1] Gender");
            System.out.println("[2] Birth date");
            int choice;
            System.out.print(">> ");
            choice = input.nextInt();
            input.nextLine();
            try {
                String file = ".\\JH_DATA\\Student_Info.txt";
                boolean found = false;
                List<String> updatedStudentData = new ArrayList<>();
                try (BufferedReader studentInfo = new BufferedReader(new FileReader(file))) {
                    String key;
                    boolean keyDetected = false;
                    while ((key = studentInfo.readLine()) != null) {
                        if (key.equals("**********")) {
                            keyDetected = true;
                            updatedStudentData.add(key);
                            continue;
                        }
                        if (keyDetected) {
                            String currentId = key;
                            if (currentId.equals(id)) {
                                String yrLvl = studentInfo.readLine();
                                String fName = studentInfo.readLine();
                                String mName = studentInfo.readLine();
                                String lName = studentInfo.readLine();
                                String address = studentInfo.readLine();
                                String degree = studentInfo.readLine();
                                String specialization = studentInfo.readLine();
                                String gender = studentInfo.readLine();
                                String bMonth = studentInfo.readLine();
                                String bDate = studentInfo.readLine();
                                String bYear = studentInfo.readLine();
                                String userInput;
                                switch (choice) {
                                    case 1:
                                        System.out.print("Enter new year level: ");
                                        userInput = input.nextLine();
                                        yrLvl = userInput;
                                        break;
                                    case 2:
                                        System.out.print("Enter First name: ");
                                        System.out.print("Enter Middle name: ");
                                        System.out.print("Enter Last name: ");
                                        break;
                                    case 3:
                                        System.out.print("Enter new Address: ");
                                        break;
                                    case 4:
                                        System.out.print("Enter new Course ");
                                        break;
                                    case 6:
                                        System.out.print("Enter new Birth Date: ");
                                        userInput = input.nextLine();
                                        yrLvl = userInput;
                                        break;
                                            
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                }
                                updatedStudentData.add(id);
                                updatedStudentData.add(yrLvl);
                                updatedStudentData.add(fName.toUpperCase());
                                updatedStudentData.add(mName.toUpperCase());
                                updatedStudentData.add(lName.toUpperCase());
                                updatedStudentData.add(address.toUpperCase());
                                updatedStudentData.add(degree.toUpperCase());
                                updatedStudentData.add(specialization.toUpperCase());
                                updatedStudentData.add(gender.toUpperCase());
                                updatedStudentData.add(bMonth.toUpperCase());
                                updatedStudentData.add(bDate.toUpperCase());
                                updatedStudentData.add(bYear.toUpperCase());
                                found = true;
                            } else {
                                updatedStudentData.add(key);
                            }
                        }
                    }
                }
                if (!found) {
                    System.out.println("STUDENT ." + id + "DOES NOT EXIST");
                } else {
                    try (FileWriter writer = new FileWriter(file)) {
                        for (String line : updatedStudentData) {
                            writer.write(line + "\n");
                        }
                    }
                    System.out.println("Student data updated successfully.");
                }
            } catch (IOException e) {
                System.out.println("EDIT METOHD: " + e.getMessage());
            }
        }
    }

    @Override
    public void del(String id) {
        try {
            File inputFile = new File(".\\JH_DATA\\Student_Info.txt");
            File tempFile = new File(".\\JH_DATA\\Temp_Student_Info.txt");

            BufferedWriter writer;
            boolean keyDetected;
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                writer = new BufferedWriter(new FileWriter(tempFile));
                String key;
                keyDetected = false;
                while ((key = reader.readLine()) != null) {
                    if (key.equals("**********")) {
                        String studentID = reader.readLine();
                        if (studentID.equals(id)) {
                            for (int i = 0; i < 11; i++) {
                                reader.readLine();
                            }
                            keyDetected = true;
                        } else {

                            writer.write(key + "\n");
                            writer.write(studentID + "\n");

                        }
                    } else {
                        writer.write(key + "\n");
                    }
                }
            }
            writer.close();
            if (keyDetected) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.err.println("STUDENT " + id + " HAS BEEN ERASED.");
            } else {
                System.out.println("STUDENT " + id + " DOES NOT EXIST");
            }
        } catch (IOException e) {
            System.out.println("DEL METHOD:  " + e.getMessage());
        }
    }
}
