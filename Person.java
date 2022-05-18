package proiect;

public abstract class Person {
    protected String cnp;
    protected String address;
    protected int height;

    Person(){
        this.cnp = " ";
        this.address = " ";
        this.height = 0;
    }
    Person(String cnp, String address, int height){
        this.cnp = cnp;
        this.address = address;
        this.height = height;
    }

    public abstract void work();

    @Override
    public String toString(){
        return "CNP-ul este: "+cnp+" ,adresa este "+address+", inaltimea este "+height;
    }
}
