import java.util.ArrayList;

public class StudentManager implements JHinterface{
    ArrayList<Student>student = new ArrayList<>();

    @Override
    public void add() {
        // just use the constructor, be sure to add strings

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void view() {
        // use printStudent() fuction

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'view'");
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
        throw new UnsupportedOperationException("Unimplemented method 'edit'");

    }

    @Override
    public void detele() {
        // ask for student id to identify student

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detele'");
    }
}
