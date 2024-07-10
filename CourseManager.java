
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CourseManager implements JHinterface {

    Scanner input = new Scanner(System.in);
    static File file = new File(".\\JH_DATA\\JH_Course.txt");

    //
    private static boolean courseExist(String code) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            while ((key = reader.readLine()) != null) {
                if (key.equals("##########")) {
                    String idCheck = reader.readLine();
                    if (idCheck.equalsIgnoreCase(code)) {
                        System.out.println("Found course with code: " + code);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking course existence: " + e.getMessage());
        }
        return false;
    }

    public void courseWritter(String code, String title, String units, String yrLvl) {
        String data = "";
        try {
            if (!courseExist(code)) {
                try (FileWriter writer = new FileWriter(file, true)) {
                    data += "##########" + '\n';
                    data += code.toUpperCase() + '\n';
                    data += title.toUpperCase() + '\n';
                    data += units + '\n';
                    data += yrLvl + '\n';

                    writer.write(data);
                    writer.close();
                }
            } else {
                System.out.println("Course already available");
            }
        } catch (IOException e) {
            System.out.println("courseWritter METHOD: " + e);
        }
    }

    public void courseReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            boolean keyDetected = false;
            while ((key = reader.readLine()) != null) {
                if (key.equals("##########")) {
                    keyDetected = true;
                    continue;
                }
                if (keyDetected) {
                    String code = key;
                    String title = reader.readLine();
                    String units = reader.readLine();
                    String yrLvl = reader.readLine();

                    System.out.println("===========================================================");
                    System.out.println("Course Code: " + code);
                    System.out.println("Course: " + title);
                    System.out.println("Units: " + units);
                    System.out.println("Year Level: " + yrLvl);
                    System.out.println("===========================================================");
                }
            }

        } catch (Exception e) {
        }
    }

    public void search(String code) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            while ((key = reader.readLine()) != null) {
                if (key.equals("##########")) {
                    String idCheck = reader.readLine();
                    if (idCheck.equalsIgnoreCase(code)) {
                        String title = reader.readLine();
                        String units = reader.readLine();
                        String yrLvl = reader.readLine();
                        System.out.println("===========================================================");
                        System.out.println("Course Code: " + code);
                        System.out.println("Title: " + title);
                        System.out.println("Units: " + units);
                        System.out.println("Year Level: " + yrLvl);
                        System.out.println("===========================================================");

                        return;
                    }
                }
            }
            System.out.println("Course with code '" + code + "' not found.");
        } catch (Exception e) {
            System.out.println("search METHOD: " + e.getMessage());
        }
    }

    @Override
    public void add() {
        courseWritter("mat00001", "Algebra", "3", "1");
        courseWritter("sci00001", "Physics 2", "3", "2");
        courseWritter("eng00001", "English 3", "3", "3");
    }

    @Override
    public void view() {
        courseReader();
    }

    @Override
    public void edit(String code) {
        try {
            boolean keyDetected = false;
            List<String> updatedCourseData = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String key;
                while ((key = reader.readLine()) != null) {
                    if (key.equals("##########")) {
                        keyDetected = true;
                        updatedCourseData.add(key);
                        // System.out.println("Skey: " + key);
                        continue;
                    }
                    if (keyDetected) {
                        String currentCode = key;
                        if (currentCode.equalsIgnoreCase(code)) {
                            String title = reader.readLine();
                            String units = reader.readLine();
                            String yrLvl = reader.readLine();

                            int choice;
                            String userInput;
                            do {
                                System.out.print("\033\143");
                                System.out.println("What do you want to edit?");
                                System.out.println("[1] Title");
                                System.out.println("[2] Units");
                                System.out.println("[3] Year Level");
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
                                    System.out.println("===========================================================");
                                    System.out.println("CURRENTLY UPDATING");
                                    System.out.println("Course Code: " + code);
                                    System.out.println("Title: " + title);
                                    System.out.println("Units: " + units);
                                    System.out.println("Year Level: " + yrLvl);
                                    System.out.println("===========================================================");
                                    System.out.println("Enter new Course Title ");
                                    System.out.print(">> ");
                                    userInput = input.nextLine();
                                    title = userInput;
                                    break;
                                case 2:
                                    do {
                                        System.out.print("\033\143");
                                        System.out.println("===========================================================");
                                        System.out.println("CURRENTLY UPDATING");
                                        System.out.println("Course Code: " + code);
                                        System.out.println("Title: " + title);
                                        System.out.println("Units: " + units);
                                        System.out.println("Year Level: " + yrLvl);
                                        System.out.println("===========================================================");
                                        System.out.print("Update Course units (0, 1 or 3): ");
                                        userInput = input.nextLine();
                                        units = userInput;

                                        if (!(units.equals("0") || units.equals("1") || units.equals("3"))) {
                                            System.out.println("Please enter 0, 1 or 3.");
                                        }
                                    } while (!(units.equals("0") || units.equals("1") || units.equals("3")));

                                    break;
                                case 3:
                                    do {
                                        System.out.print("\033\143");
                                        System.out.println("===========================================================");
                                        System.out.println("CURRENTLY UPDATING");
                                        System.out.println("Course Code: " + code);
                                        System.out.println("Title: " + title);
                                        System.out.println("Units: " + units);
                                        System.out.println("Year Level: " + yrLvl);
                                        System.out.println("===========================================================");
                                        System.out.println("Update Year Level ");
                                        System.out.print(">> ");
                                        userInput = input.nextLine();
                                        yrLvl = userInput;
                                        if (Integer.parseInt(yrLvl) < 1 || Integer.parseInt(yrLvl) > 4) {
                                            System.out.println("ENTER YEAR [1][2][3][4] <<<<<");
                                        }
                                    } while (Integer.parseInt(yrLvl) < 1 || Integer.parseInt(yrLvl) > 4);
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }

                            updatedCourseData.add(code.toUpperCase());
                            updatedCourseData.add(title.toUpperCase());
                            updatedCourseData.add(units);
                            updatedCourseData.add(yrLvl);
                        } else {
                            updatedCourseData.add(key);
                        }
                    }
                }
            }
            if (!keyDetected) {
                System.out.println("COURSE " + code + " DOES NOT EXIST");
            } else {
                try (FileWriter writer = new FileWriter(file)) {
                    for (String line : updatedCourseData) {
                        writer.write(line + "\n");
                    }
                }
                System.out.println("Course data updated successfully.");
            }
        } catch (IOException e) {
            System.out.println("EDIT METHOD: " + e.getMessage());
        }
    }

    @Override
    public void del(String code) {
        try {
            File inputFile = new File(".\\JH_DATA\\JH_Course.txt");
            File tempFile = new File(".\\JH_DATA\\temp_JH_Course.txt");

            boolean keyDetected = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals("##########")) {
                        String courseCode = reader.readLine();
                        if (courseCode.equals(code)) {
                            for (int i = 0; i < 3; i++) {
                                reader.readLine();
                            }
                            keyDetected = true;
                        } else {
                            writer.write(line + "\n");
                            writer.write(courseCode + "\n");
                        }
                    } else {
                        writer.write(line + "\n");
                    }
                }
            }

            if (keyDetected) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                // System.err.println("COURSE " + code + " HAS BEEN ERASED.");
            } else {
                System.out.println("COURSE " + code + " IS NOT BEING OFFERED CURRENTLY");
            }

            tempFile.delete();
        } catch (IOException e) {
            System.out.println("DEL METHOD: " + e.getMessage());
        }
    }

}
