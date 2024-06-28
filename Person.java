abstract class Person {
    private String fName;
    private String mName;
    private String lName;
    private String gender;
    // private String bDate;  
    // birth day variables
    private String bDate;
    private String bMonth;
    private String bYear;

    public void setfName(String fName) { this.fName = fName; }
    public String getfName() { return this.fName; }

    public void setmName(String mName) { this.mName = mName; }
    public String getmName() { return this.mName; }

    public void setlName(String lName) { this.lName = lName; }
    public String getlName() { return this.lName; }

    public void setGender(String gender) { this.gender = gender; }
    public String getGender() { return this.gender; }

    // public void setBDate(String bDate) { this.bDate = bDate; }
    // public String getBDate() { return this.bDate; }
    // bday encapsulation functions
    public void setbDate(String bDay) { this.bDate = bDay; }
    public String getbDate() { return this.bDate; }

    public void setbMonth(String bMonth) { this.bMonth = bMonth; }
    public String getbMonth() { return this.bMonth; }

    public void setbYear(String bYear) { this.bYear = bYear; }
    public String getbYear() { return this.bYear; }
}
// just made this class so we can say we used polymorpism heh