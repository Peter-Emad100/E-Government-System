/*
package com.example.egoverment;

import java.util.ArrayList;

public class Manage_Employees {
        private ArrayList<Department> departments;

        public Manage_Employees() {
            departments = new ArrayList<>();
        }

        // Add a new department
        public void addDepartment(String departmentName) {
            if (getDepartment(departmentName) != null) {
                System.out.println("Department already exists.");
                return;
            }
            departments.add(new Department(departmentName));
            System.out.println("Department added: " + departmentName);
        }

        // Remove a department
        public void removeDepartment(String departmentName) {
            Department department = getDepartment(departmentName);
            if (department == null) {
                System.out.println("Department does not exist.");
                return;
            }
            departments.remove(department);
            System.out.println("Department removed: " + departmentName);
        }

        // Add an employee to a department
        public void addEmployeeToDepartment(String departmentName, String empName, int empID) {
            Department department = getDepartment(departmentName);
            if (department == null) {
                System.out.println("Department does not exist.");
                return;
            }
            department.addEmployeetoDepartment(empName, empID);
            System.out.println("Employee added to department: " + departmentName);
        }

        // Remove an employee from a department
        public void removeEmployeeFromDepartment(String departmentName, int empID) {
            Department department = getDepartment(departmentName);
            if (department == null) {
                System.out.println("Department does not exist.");
                return;
            }
            department.removeEmployeeById(empID);
        }

        // Get department by name
        private Department getDepartment(String departmentName) {
            for (Department dept : departments) {
                if (dept.getDepartmentName().equalsIgnoreCase(departmentName)) {
                    return dept;
                }
            }
            return null;
        }
    }

}
*/
