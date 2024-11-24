public class Loginer extends Human {
    String loginName;
    String Password;
    public String getLoginName(){
        return loginName;
    }
    public String getPassword(){
        return Password;
    }
    static long numberOfCitizens;
    Loginer(String name, String id,String loginName,String Password) {
        super(name, id);
        this.loginName=loginName;
        this.Password=Password;
        numberOfCitizens++;
    }
}
