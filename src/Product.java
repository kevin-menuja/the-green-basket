public class Product {

    private String name;
    private String category;
    private String supplier;
    private double price;

    public Product(String name, String category, String supplier, double price) {
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.price = price;
    }

    public String toFileString() {
        return name + "," + category + "," + supplier + "," + price;
    }
}
