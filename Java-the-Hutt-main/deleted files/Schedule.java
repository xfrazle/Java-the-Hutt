public class Schedule extends Course
{
    String day;
    String time;
    String room;
    String section;
    Schedule(String code, String title, int units, String day, String time, String room, String section)
    {
        this.code = code.toUpperCase();
        this.title = title.toUpperCase();
        this.units = units;
        this.day = day.toUpperCase();
        this.time = time;
        this.room = room.toUpperCase();
        this.section = section.toUpperCase();
    }
    public String getCode(){return this.code;}
    public String getTitle(){return this.title;}
    public int getUnits(){return this.units;}
    public String getDay(){return this.day;}
    public String getTime(){return this.time;}
    public String getRoom(){return this.room;}
    public String getSection(){return this.section;}
    void printSchedule()
    {
        // System.out.println("Course Code:    " + getCode());
        // System.out.println("Course:         " + getTitle());
        // System.out.println("Units:          " + getUnits());
        // System.out.println("Day:            " + getDay());
        // System.out.println("Time:           " + getTime());
        // System.out.println("Room:           " + getRoom());
        // System.out.println("Section:        " + getSection());  
        System.out.println("|| Course Code: " + getCode() + " || Course: " + getTitle() + " || Units: " + getUnits() + " || Day: " + getDay() + " || Time: " + getTime() + " || Room: " + getRoom() + " || Section: " + getSection() + " ||");
    }
}