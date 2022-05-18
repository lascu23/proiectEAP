package proiect;

public class Product implements Comparable<Product>{
    private int productID;
    private String productName;

    public Product() {
        this.productID = 0;
        this.productName = " ";
    }

    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String toString(){
        return "Cea mai buna mancare este " + productName + " si are codul " + productID;
    }

    public int compareTo(Product j){
        String _productName = new String(this.productName);
        return _productName.compareTo(j.productName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;
        Product products = (Product) o;
        return productID == products.productID && productName.equals(products.productName);
    }
}
