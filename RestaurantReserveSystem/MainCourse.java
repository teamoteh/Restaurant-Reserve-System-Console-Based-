package RestaurantReserveSystem;

public class MainCourse {
    private String courseName;
    private double coursePrice;

    public MainCourse(){
        courseName = null;
        coursePrice = 0.0;
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
}
