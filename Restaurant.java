package proiect;

import java.util.*;

public class Restaurant implements Comparable<Restaurant>{
    private String restaurantName;
    private String address;
    private int postalCode;
    private List<Department> departments = new ArrayList<>();

    public Restaurant(){
        restaurantName = " ";
        address = " ";
        postalCode = 0;
        departments = null;
    }

    public Restaurant(String restaurantName, String address, int postalCode,List departments) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.postalCode = postalCode;
        this.departments = new ArrayList<>(departments);
        Collections.copy(this.departments,departments);
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public List getDepartments() {
        return departments;
    }
    public void setDepartments(List departments) {
        this.departments = departments;
    }

    @Override
    public String toString(){
        return "Restauratnul " + restaurantName + " are adresa " + address + " si codul postal " + postalCode +
                " iar departamentele sunt"+Arrays.toString(departments.toArray());
    }

    @Override
    public int compareTo(Restaurant j){
        Integer _postalCode = new Integer(this.postalCode);
        return _postalCode.compareTo(j.postalCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return postalCode == that.postalCode && Objects.equals(restaurantName, that.restaurantName) &&
                Objects.equals(address, that.address);
    }
}
