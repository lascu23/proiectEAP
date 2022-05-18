package proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RawMaterial implements Comparable<RawMaterial>{
    private String nameRM;
    private int amount;
    private int price;
    private List<Product> products = new ArrayList<>();

    public RawMaterial() {
        this.nameRM = " ";
        this.amount = 0;
        this.price = 0;
        this.products = null;
    }

    public RawMaterial(String nameRM, int amount, int price, List products) {
        this.nameRM = nameRM;
        this.amount = amount;
        this.price = price;
        this.products = new ArrayList<>(products);
        Collections.copy(this.products,products);
    }

    public String getNameRM() {
        return nameRM;
    }

    public void setNameRM(String nameRM) {
        this.nameRM = nameRM;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public String toString(){
        return "Avem " + amount + " kg de " + nameRM + " la pretul de " + price+
                " iar produsele sunt "+Arrays.toString(products.toArray());
    }

    public int compareTo(RawMaterial j){
        Integer _price = new Integer(this.price);
        return _price.compareTo(j.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RawMaterial)) return false;
        if (!super.equals(o)) return false;
        RawMaterial that = (RawMaterial) o;
        return amount == that.amount && price == that.price && nameRM.equals(that.nameRM);
    }
}
