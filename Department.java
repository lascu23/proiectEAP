package proiect;

import java.lang.reflect.Array;
import java.util.*;

public class Department implements Comparable<Department>{
    private int departmentID;
    private String depName;
    private List<Employee> employees = new ArrayList<>();

    public Department(){
        departmentID = 0;
        depName = " ";
        employees = null;
    }

    public Department(int departmentID, String depName, List employees) {
        this.departmentID = departmentID;
        this.depName = depName;
        this.employees = employees;
    }

    public int getDepartmentID() {
        return departmentID;
    }
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepName() {
        return depName;
    }
    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List getEmployees() {return employees;}
    public void setEmployees(List employees) {
        this.employees = employees;
    }

    @Override
    public String toString(){
        return "Departamentul are numarul "+ departmentID + ", numele " + depName +" si angajatii "+ Arrays.toString(employees.toArray());
    }

    //    @Override
    public int compareTo(Department j){
        Integer _departmentID = new Integer(this.departmentID);
        return _departmentID.compareTo(j.getDepartmentID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return departmentID == that.departmentID && Objects.equals(depName,that.depName);
    }
}
