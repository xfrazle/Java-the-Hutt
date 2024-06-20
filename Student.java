public class Student extends Person
{
    private int id;
    private int yrLvl;
    private String address;
    private String degree;
    private String specialization;
    // private String program;
    // private String schedule;
    Student(int id, int yrLvl, String fName, String mName, String lName, String address, String degree, String specialization, String gender, String bdate, String bMonth, String bYear/*, String schedule*/)
    {
        this.id = id;
        this.yrLvl = yrLvl;
        this.address = address.toUpperCase();
        this.degree = degree.toUpperCase();
        this.specialization = specialization.toUpperCase();
        // this.program = program.toUpperCase();
        setfName(fName.toUpperCase());
        setmName(mName.toUpperCase());
        setlName(lName.toUpperCase());
        setGender(gender.toUpperCase());
        setbDate(bdate);
        setbMonth(bMonth.toUpperCase());
        setbYear(bYear);



        // setBDate(bday.toUpperCase());
        // this.schedule = schedule;
    }
    // void printStudent()
    // {
    //     System.out.println("Name:       " + getlName() + ", " + getfName() + " " + getmName());
    //     System.out.println("ID:         " + getID());
    //     System.out.println("Year:       " + getyrLvl());
    //     System.out.println("Address:    " + getAddress());
    //     System.out.println("Program:    " + getProgram());        
    // }
    public void setID(int id){this.id = id;}
    public int getID(){return this.id;}

    public void setyrLvl(int yrLvl){this.yrLvl = yrLvl;}
    public int getyrLvl(){return this.yrLvl;}

    public void setAddress(String address) { this.address = address; }
    public String getAddress(){ return this.address; }

    public void setDegree(String degree) { this.degree = degree; }
    public String getDegree(){ return this.degree; }
    
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getSpecialization(){ return this.specialization; }
}