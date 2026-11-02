package shop;

/** 商品项：名称、单价、重量、描述。 */
public class Product {
    private String title;
    private double price;
    private double weight;
    private String description;

    public Product(String title, double price, double weight, String description) {
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public double getPriceForQuantity(int quantity) {
        return price * quantity;
    }

    public double getWeight() {
        return weight;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
