package RestaurantReserveSystem;

public class MainCourse {
    private String courseName;
    private double coursePrice;
    private String courseDesc;

    public MainCourse(){
        courseName = null;
        coursePrice = 0.0;
        courseDesc = null;
    }

    public MainCourse(String name, double price){
        this.courseName = name;
        this.coursePrice = price;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public double getCoursePrice(){
        return this.coursePrice;
    }

    public String getCourseDesc(){
        return this.courseDesc;
    }

    public void setCourseName(String name){
        this.courseName = name;
    }

    public void setCoursePrice(double price){
        this.coursePrice = price;
    }

    public void setCourseDesc(String desc){
        this.courseDesc = desc;
    }
}
