public class Loginer extends Human {
    private String loginName;
    private String Password;
    Loginer(String name, String id,String loginName,String Password) {
        super(name, id);
        this.loginName=loginName;
        this.Password=Password;

    }
    protected String getLoginName(){
        return loginName;
    }
    protected String getPassword(){
        return Password;
    }

}
