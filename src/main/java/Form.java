import java.util.ArrayList;
public class Form {
    private String formName;
    ArrayList<Request>requests;
    public Form (String formName){
    this.formName=formName;
    requests=new ArrayList<Request>();
    }
    public String getFormName() {
        return formName;
    }
}
