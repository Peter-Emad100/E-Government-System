package com.example.egoverment;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministry {
    static int numberOfMinistries;
    private Minister minister;
    protected ArrayList<Department> departments;

    public Ministry(String name, int id){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        minister=new Minister(name,id);
    }
    public Minister getMinster() {
        return minister;
    }

    public void addDepartmentsToMinistry(String DeptName, int ID) {

        departments.add(new Department(DeptName, ID));
    }

    public void addrequest(int minisitryID, int deptID, int formID, String Rname, String Rid, String Rnotices, String Rlocation, LocalDate RbirthDate, boolean gender)
    {
        if(deptID > departments.size())
        {
            System.out.println("invalid department id");
        }
        else{
            for(int i=0 ; i < departments.size() ; i++)
            {
                if(departments.get(i).getDepartmentID() == deptID)
                {
                    for(int j=0 ; j<departments.get(i).forms.size() ; j++)
                    {
                        if(formID == departments.get(i).forms.get(j).getFormId())
                        {
                            departments.get(deptID).forms.get(formID).addRequesttoForm(Rname, Rid, Rnotices, Rlocation, RbirthDate, gender);
                        }
                    }
                }
            }
        }



    }

}
