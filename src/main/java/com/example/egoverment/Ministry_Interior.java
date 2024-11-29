package com.example.egoverment;
import java.util.ArrayList;
import java.util.Date;

public class Ministry_Interior extends Ministry {


    public Ministry_Interior(String name, String id)
    {
        super(name, id);
        super.departments=new ArrayList<>();
        super.addDepartmentsToMinistry("Department of Civil Status", 1);
        super.departments.get(0).addFormtoDepartment("Renew Social Security Number", 1);

    }

    public void addrequest(int deptID, int formID, String Rname, String Rid, String Rnotices, String Rlocation, Date RbirthDate)
    {
        if(deptID>super.departments.size())
        {
            System.out.println("invalid department id");
        }
        else{
            for(int i=0;i<super.departments.size();i++)
            {
                if(super.departments.get(i).getDepartmentID() == deptID)
                {
                    for(int j=0;j<super.departments.get(i).forms.size();j++)
                    {
                        if(formID == super.departments.get(i).forms.get(j).getFormId())
                        {
                            super.departments.get(deptID).forms.get(formID).addRequesttoForm(Rname, Rid, Rnotices, Rlocation, RbirthDate);
                        }
                    }
                }
            }
        }



    }









}
