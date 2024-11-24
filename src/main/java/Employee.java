import java.time.LocalTime;

public class Employee extends Human{
    LocalTime startingDate;
    Employee(String name, String id){
        super(name,id);
        startingDate=LocalTime.now();
    }
}
