import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements JHinterface{
    ArrayList<Student>students = new ArrayList<>();
    
    private Scanner uInput = new Scanner(System.in);

    @Override
    public void add() 
    {
        System.out.print("Enter student ID: ");
        int id;
        System.out.print("Enter first name: ");
        String fName;
        System.out.print("Enter middle name: ");
        String mName;
        System.out.print("Enter last name: ");
        String lName;
        System.out.print("Enter Address: ");
        String address;
        System.out.print("Enter gender: ");
        System.out.print("Enter Birthdate: ");
        System.out.print("Enter Degree: ");
        System.out.print("Enter year level: ");
    }

    @Override
    public void view() {
        // use printStudent() function
        for (Student student : students) 
        {
            System.out.println("--------------------");
            System.out.println("ID: " + student.getID());
            System.out.println("Name: " + student.getfName());
            System.out.println("Year: " + student.getyrLvl());
            System.out.println("Address: " + student.getAddress());
            System.out.println("--------------------");

        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'view'");
        }
    }

    @Override
    public void edit() {
        // ask for student id to identify student
        // ask for what part of information to edit
        // example 
        // What do you want to edit?
        // [1] Name
        // [2] Year
        // [3] Address
        // only allow 1/2/3 as input

        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'edit'");

    }

    @Override
    public void delete() {
        // ask for student id to identify student

        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
