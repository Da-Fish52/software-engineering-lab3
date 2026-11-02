package shop;

/** 订单详情：数量 + 商品，负责计算小计与重量。 */
public class OrderDetail {
    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("数量必须大于 0");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }

    public double calculateWeight() {
        return product.getWeight() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
