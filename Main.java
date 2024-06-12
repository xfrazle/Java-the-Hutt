import java.util.ArrayList;

class Main{
    public static void main(String[] args) 
    {
        System.out.println("=====================================================================================================================");
        Student student = new Student(
            201812763, 
            2, 
            "John Albert", 
            "Arribas", 
            "Castaneda", 
            "2007 Balintawak", 
            "BSCSSE");
        student.printStudent();
        System.out.println("=====================================================================================================================");
        Schedule sched = new Schedule(
            "cs01", 
            "programming", 
            3, 
            "mon", 
            "13:00", 
            "j107", 
            "xd001");
        sched.printSchedule();
        System.out.println("=====================================================================================================================");
    }
}