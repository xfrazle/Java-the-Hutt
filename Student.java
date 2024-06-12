public class Student extends Person
{
    private int id;
    private int yrLvl;
    private String address;
    private String program;
    // private String schedule;
    Student(int id, int yrLvl, String fName, String mName, String lName, String address, String program/*, String schedule*/)
    {
        this.id = id;
        this.yrLvl = yrLvl;
        setfName(fName.toUpperCase());
        setmName(mName.toUpperCase());
        setlName(lName.toUpperCase());
        this.address = address.toUpperCase();
        this.program = program.toUpperCase();
        // this.schedule = schedule;
    }
    void printStudent()
    {
        System.out.println("Name:       " + getlName() + ", " + getfName() + " " + getmName());
        System.out.println("ID:         " + getID());
        System.out.println("Year:       " + getyrLvl());
        System.out.println("Address:    " + getAddress());
        System.out.println("Program:    " + getProgram());        
    }
    // public void setID(int id){this.id = id;}
    public int getID(){return this.id;}

    // public void setyrLvl(int yrLvl){this.yrLvl = yrLvl;}
    public int getyrLvl(){return this.yrLvl;}

    // public void setfName(String fName) { this.fName = fName; }
    // public String getfName() { return this.fName; }

    // public void setmName(String mName) { this.mName = mName; }
    // public String getmName() { return this.mName; }

    // public void setlName(String lName) { this.lName = lName; }
    // public String getlName() { return this.lName; }

    // public void setAddress(String address) { this.address = address; }
    public String getAddress() { return this.address; }

    // public void setProgram(String program) { this.program = program; }
    public String getProgram() { return this.program; }

    // public void setSchedule(String schedule) { this.schedule = schedule; }
    // public String getSchedule() { return this.schedule; }
}