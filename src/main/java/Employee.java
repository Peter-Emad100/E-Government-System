import java.time.LocalDate;

public class Employee extends Human{
    private LocalDate startingDate;
    public LocalDate getStartingDate(){
        return startingDate;
    }
    Employee(String name, String id){
        super(name,id);
        startingDate=LocalDate.now();
    }
}
