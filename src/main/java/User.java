public class User extends Loginer{
    static long numberOfCitizens;
    User(String name, String id, String loginName, String hashedPassword) {
        super(name, id,loginName,hashedPassword);
        numberOfCitizens++;
    }
}
