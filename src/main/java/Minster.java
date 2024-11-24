import java.time.LocalTime;
public class Minster extends Human{
    LocalTime startingDate;
    Minster(String name,String id){
        super(name,id);
        startingDate=LocalTime.now();
    }

}
