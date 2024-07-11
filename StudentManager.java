
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements JHinterface {

    Scanner input = new Scanner(System.in);

    public static boolean studentExist(String id) {
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
                        // System.out.println("Year " + yrLvl);
                        System.out.println("Name: " + fName + " " + mName + " " + lName);
                        // System.out.println("Age: " + bDate + " " + bMonth + " " + bYear);
                        // System.out.println("Address: " + address);
                        // System.out.println("Degree: " + degree);
                        // System.out.println("Specialization: " + specialization);
                        // System.out.println("Gender: " + gender);
                        // System.out.println("===========================================================");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add() {
        String confirm;
        String id;
        String yrLvl;
        String fName;
        String mName;
        String lName;
        String address;
        String degree;
        String specialization;
        String gender;
        String bMonth;
        String bDay;
        String bYear;

        do {
            System.out.print("\033\143");
            System.out.println("Enter student ID");
            System.out.print(">> ");
            id = input.nextLine();
            System.out.println("Year Level");
            System.out.print(">> ");
            yrLvl = input.nextLine();
            System.out.println("Enter First Name");
            System.out.print(">> ");
            fName = input.nextLine();
            System.out.println("Enter Middle Name");
            System.out.print(">> ");
            mName = input.nextLine();
            System.out.println("Enter Last Name");
            System.out.print(">> ");
            lName = input.nextLine();
            System.out.println("Enter Address");
            System.out.print(">> ");
            address = input.nextLine();
            do {
                System.out.println("Enter Degree");
                System.out.print(">> ");
                degree = input.nextLine();
                System.out.println("Enter Specialization");
                System.out.print(">> ");
                specialization = input.nextLine();
                if (!degree.equalsIgnoreCase("IT") & !degree.equalsIgnoreCase("CS")) {
                    System.out.println("INPUT IT or CS <<<<<");
                }
            } while (!degree.equalsIgnoreCase("IT") & !degree.equalsIgnoreCase("CS"));

            do {
                System.out.println("Enter Gender");
                System.out.print(">> ");
                gender = input.nextLine();
                if (!gender.equalsIgnoreCase("M") & !gender.equalsIgnoreCase("F")) {
                    System.out.println("INPUT M or F <<<<<");
                }
            } while (!gender.equalsIgnoreCase("M") & !gender.equalsIgnoreCase("F"));

            String[] months = {
                "January", "Febraury", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
            };
            for (int i = 0; i < months.length; i++) {
                months[i] = months[i].toUpperCase();
            }

            do {

                System.out.println("Enter Birth Month");
                System.out.print(">> ");
                bMonth = input.nextLine();
                int month = Integer.parseInt(bMonth);
                if (month < 1 || month > 12) {
                    System.out.println("Please enter a value between 1 and 12. <<<<<");
                }
            } while (!bMonth.matches("\\d+") || Integer.parseInt(bMonth) < 1 || Integer.parseInt(bMonth) > 12);

            do {
                System.out.println("Enter Birth Day");
                System.out.print(">> ");
                bDay = input.nextLine();
                int day = Integer.parseInt(bDay);
                if (day < 1 || day > 31) {
                    System.out.println("Invalid day. Please enter a value between 1 and 31.");
                }
            } while (!bDay.matches("\\d+") || Integer.parseInt(bDay) < 1 || Integer.parseInt(bDay) > 31);

            do {
                System.out.println("Enter Birth Year");
                System.out.print(">> ");
                bYear = input.nextLine();
                if (bYear.length() != 4 || !bYear.matches("\\d{4}")) {
                    System.out.println("Invalid input. Please enter a 4-digit year.");
                }
            } while (bYear.length() != 4 || !bYear.matches("\\d{4}"));

            System.out.print("\033\143");
            System.out.println("DATA ENTERED");
            System.out.println("Student ID: " + id);
            System.out.println("Year: Level" + yrLvl);
            System.out.println("Full Name: " + lName + " " + fName + " " + mName);
            System.out.println("Address: " + address);
            System.out.println(degree + specialization);
            System.out.println("Gender: " + gender);
            System.out.println("Birth Date: " + months[Integer.parseInt(bMonth) - 1] + " - " + bDay + " - " + bYear);

            System.out.println("data entered are valid? [Y/N] ");
            System.out.print(">> ");
            confirm = input.nextLine();
        } while (!confirm.equalsIgnoreCase("Y"));
        studentWriter(id, yrLvl, fName, mName, lName, address, degree, specialization, gender, bDay, bMonth, bYear);
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

                            System.out.print("\033\143");
                            System.out.println("===========================================================");
                            System.out.println("CURRENTLY EDITING");
                            System.out.println("ID: " + id);
                            System.out.println("Year " + yrLvl);
                            System.out.println("Name: " + fName + " " + mName + " " + lName);
                            System.out.println("BirthDate: " + bDate + " " + bMonth + " " + bYear);
                            System.out.println("Address: " + address);
                            System.out.println("Degree: " + degree);
                            System.out.println("Specialization: " + specialization);
                            System.out.println("Gender: " + gender);

                            int choice;
                            // int intUserInput;
                            String userInput;

                            do {
                                System.out.println("What do you want to edit?");
                                System.out.println("[1] Year level");
                                System.out.println("[2] Full Name");
                                System.out.println("[3] Address");
                                System.out.println("[4] Course");
                                // System.out.println("[5] Gender");
                                System.out.println("[5] Birth date");
                                System.out.print(">> ");
                                try {
                                    choice = input.nextInt();
                                    input.nextLine();
                                    if (choice < 1 || choice > 5) {
                                        System.out.println("INVALID CHOICE");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter an integer.");
                                    input.nextLine();
                                    choice = 0;
                                }
                            } while (choice < 1 || choice > 6);

                            switch (choice) {
                                case 1:
                                    do {
                                        System.out.println("===========================================================");
                                        System.out.println("CURRENTLY EDITING");
                                        System.out.println("ID: " + id);
                                        System.out.println("Year " + yrLvl);
                                        System.out.println("Name: " + fName + " " + mName + " " + lName);
                                        System.out.println("Age: " + bDate + " " + bMonth + " " + bYear);
                                        System.out.println("Address: " + address);
                                        System.out.println("Degree: " + degree);
                                        System.out.println("Specialization: " + specialization);
                                        System.out.println("Gender: " + gender);
                                        System.out.println("===========================================================");
                                        System.out.println("Enter new year level: ");
                                        System.out.print(">> ");
                                        try {
                                            userInput = input.nextLine();
                                            yrLvl = userInput;
                                            if (Integer.parseInt(yrLvl) < 1 || Integer.parseInt(yrLvl) > 5) {
                                                System.out.println("ENTER YEAR [1][2][3][4][5] <<<<<");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter an integer.");
                                            System.out.print("\033\143");
                                        }
                                    } while (Integer.parseInt(yrLvl) < 1 || Integer.parseInt(yrLvl) > 5);

                                    break;
                                case 2: // NAMENAMENAMEN
                                    System.out.print("\033\143");
                                    System.out.println("===========================================================");
                                    System.out.println("CURRENTLY EDITING");
                                    System.out.println("ID: " + id);
                                    System.out.println("Year " + yrLvl);
                                    System.out.println("Name: " + fName + " " + mName + " " + lName);
                                    System.out.println("Age: " + bDate + " " + bMonth + " " + bYear);
                                    System.out.println("Address: " + address);
                                    System.out.println("Degree: " + degree);
                                    System.out.println("Specialization: " + specialization);
                                    System.out.println("Gender: " + gender);
                                    System.out.println("===========================================================");
                                    System.out.println("Enter First name: ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    fName = userInput;
                                    System.out.println("Enter Middle name: ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    mName = userInput;
                                    System.out.println("Enter Last name: ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    lName = userInput;
                                    break;
                                case 3:
                                    System.out.print("\033\143");
                                    System.out.println("Enter new Address: ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    address = userInput;
                                    break;
                                case 4:
                                    do {
                                        System.out.print("\033\143");
                                        System.out.println("Enter new Course");
                                        System.out.println("DEGREE");
                                        System.out.print(">> ");
                                        try {
                                            userInput = input.nextLine();
                                            degree = userInput;
                                            System.out.println("debug: " + degree);
                                            System.out.print("\033\143");
                                        } catch (InputMismatchException e) {
                                            e.getMessage();
                                        }
                                        if (!degree.equalsIgnoreCase("IT") & !degree.equalsIgnoreCase("CS")) {
                                            System.out.println("INPUT IT or CS <<<<<");
                                        }
                                    } while (!degree.equalsIgnoreCase("IT") & !degree.equalsIgnoreCase("CS"));
                                    // if(degree.equalsIgnoreCase("IT"))
                                    // if(degree.equalsIgnoreCase("CS"))
                                    System.out.println("SPECIALIZATION");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    specialization = userInput;
                                    break;
                                case 5:
                                    System.out.print("\033\143");
                                    String[] months = {
                                        "January", "Febraury", "March", "April",
                                        "May", "June", "July", "August",
                                        "September", "October", "November", "December"
                                    };
                                    for (int i = 0; i < months.length; i++) {
                                        months[i] = months[i].toUpperCase();
                                    }
                                    do {
                                        System.out.print("\033\143");
                                        System.out.println(">MONTH<" + " DAY" + " YEAR");
                                        System.out.println("Enter new Birth Month (1-12):");
                                        System.out.print(">> ");
                                        try {
                                            bMonth = input.nextLine();
                                            int month = Integer.parseInt(bMonth);
                                            if (month < 1 || month > 12) {
                                                System.out.println("Please enter a value between 1 and 12.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter an integer.");
                                        }
                                    } while (!bMonth.matches("\\d+") || Integer.parseInt(bMonth) < 1 || Integer.parseInt(bMonth) > 12);

                                    do {
                                        System.out.print("\033\143");
                                        System.out.println(months[Integer.parseInt(bMonth) - 1] + " >DAY<" + " YEAR");
                                        System.out.println("Enter new Birth Day (1-31):");
                                        System.out.print(">> ");
                                        try {
                                            bDate = input.nextLine();
                                            int day = Integer.parseInt(bDate);
                                            if (day < 1 || day > 31) {
                                                System.out.println("Invalid day. Please enter a value between 1 and 31.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter an integer.");
                                        }
                                    } while (!bDate.matches("\\d+") || Integer.parseInt(bDate) < 1 || Integer.parseInt(bDate) > 31);

                                    do {
                                        System.out.print("\033\143");
                                        System.out.println(months[Integer.parseInt(bMonth) - 1] + " " + bDate + " >YEAR<");
                                        System.out.println("Enter new Birth Year (4 digits):");
                                        System.out.print(">> ");
                                        try {
                                            bYear = input.nextLine();
                                            if (bYear.length() != 4 || !bYear.matches("\\d{4}")) {
                                                System.out.println("Invalid input. Please enter a 4-digit year.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter an integer.");
                                        }
                                    } while (bYear.length() != 4 || !bYear.matches("\\d{4}"));

                                    System.out.println("Birth Date: " + months[Integer.parseInt(bMonth) - 1] + " - " + bDate + " - " + bYear);

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

    public void search(String id) { // I DONT KNOW WHY I WROTE THIS LAST
        File file = new File(".\\JH_DATA\\Student_Info.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            while ((key = reader.readLine()) != null) {
                if (key.equals("**********")) {
                    String studentID = reader.readLine();
                    if (studentID.equals(id)) {
                        String yrLvl = reader.readLine();
                        String fName = reader.readLine();
                        String mName = reader.readLine();
                        String lName = reader.readLine();
                        String address = reader.readLine();
                        String degree = reader.readLine();
                        String specialization = reader.readLine();
                        String gender = reader.readLine();
                        String bMonth = reader.readLine();
                        String bDate = reader.readLine();
                        String bYear = reader.readLine();
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

        } catch (Exception e) {
            System.out.println("SEARCH METHOD: " + e);
        }
    }

}
