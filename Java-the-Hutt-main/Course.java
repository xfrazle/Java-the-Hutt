public class Course 
{
    private String code;
    private String title;
    private String units;
    private String yrLvl;

    public Course(String code, String title, String units, String yrLvl) {
        this.code = code;
        this.title = title;
        this.units = units;
        this.yrLvl = yrLvl;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnits() {
        return this.units;
    }

    public void setYrLvl(String yrLvl) {
        this.yrLvl = yrLvl;
    }

    public String getYrLvl() {
        return this.yrLvl;
    }
}