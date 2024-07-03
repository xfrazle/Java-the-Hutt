
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//  part of the program where the user can add a new course to be offered. The fields needed are: course code, course title, number of units, and year level

public class CourseManager extends Course implements JHinterface {

    int courseItem = 0;
    Scanner input = new Scanner(System.in);
    static File file = new File(".\\JH_DATA\\JH_Course.txt");

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
        System.out.println("Course not found with code: " + code);
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
    
                    courseItem++;
                    writer.write(data);
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String key;
            boolean keyDetected = false;
            while ((key = reader.readLine()) != null) {
                if (key.equals("##########")) {
                    String idCheck = reader.readLine();
                    

                    if (idCheck.equalsIgnoreCase(code)) { 
                        
                        
                    }
                }
            }
            System.out.println("Course with code '" + code + "' not found.");
        } catch (Exception e) {
            System.out.println("search METHOD: " + e.getMessage());
        }
    }

    @Override
    public void del(String id) {

    }

}
