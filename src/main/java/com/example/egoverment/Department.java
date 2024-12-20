package com.example.egoverment;

import java.util.ArrayList;
public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;
    protected  ArrayList<Form> forms;


    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<Employee>();
        this.forms = new ArrayList<Form>();
    }

    public ArrayList<Form> getForms() {
        return forms;
    }
    // Setter for forms
    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public boolean removeEmployee(int employeeId) {
        return employees.removeIf(emp -> emp.getId() == employeeId);
    }

    public void addFormToDepartment(String formName) {
        forms.add(new Form(formName));
    }

    public void addForm(Form form) {
        forms.add(form);
    }

    public void removeForm(String formName) {
        forms.removeIf(form -> form.getFormName().equals(formName));
    }
}
