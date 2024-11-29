package com.example.egoverment;
import java.util.ArrayList;
import java.util.Date;

public class Ministry_Interior extends Ministry {

    private ArrayList<Department> departments;
    private int size;


    public Ministry_Interior(String name, String id)
    {
        super(name, id);
        departments=new ArrayList<>();
        super.addDepartmentsToMinistry("Department of Civil Status");
        departments.get(0).addFormtoDepartment("Renew Social Security Number");


    }

    public void addrequest(int deptID, String Rname, String Rid, String Rnotices, String Rlocation, Date RbirthDate)
    {
        if(deptID>departments.size())
        {
            System.out.println("invalid department id");
        }
        else{
            for(int i=0;i<departments.size();i++)
            {
                if(departments.get(i).getDepartmentID().equals(deptID))
                {
                    departments.get(deptID).forms.get(deptID).addRequesttoForm(Rname, Rid, Rnotices, Rlocation, RbirthDate);
                }
            }
        }



    }









}
