package proiect;

import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>{
    private String employeeName;
    private String birthDay;

    public Employee() {
        this.employeeName = " ";
        this.birthDay = " ";
    }

    public Employee(String cnp, String address, int height, String employeeName, String birthDay) {
        super(cnp, address, height);
        this.employeeName = employeeName;
        this.birthDay = birthDay;
    }

    public String getCnp(){return cnp;}
    public void setCnp(String cnp){this.cnp=cnp;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public int getHeight(){return height;}
    public void setHeight(int height){this.height=height;}

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public void work() {
        System.out.println("Nu lucrez la restaurant!");
    }

    @Override
    public String toString() {
        return super.toString()+". Numele angajatului este " + employeeName + " si e " +
                "nascut pe " + birthDay;
    }

    @Override
    public int compareTo(Employee j){
        String _employeeName = new String(this.employeeName);
        return _employeeName.compareTo(j.employeeName);
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Employee emp = (Employee) obj;
        return Objects.equals(this.employeeName,emp.employeeName) && Objects.equals(this.birthDay,emp.birthDay);
    }
}
