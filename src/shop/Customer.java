package shop;

import java.util.ArrayList;
import java.util.List;

/** 客户：下订单、激活账户。 */
public class Customer {
    private String name;
    private String contact;
    private String deliveryAddress;
    private boolean active;
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String contact, String deliveryAddress) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = false;
    }

    public Order placeOrder() {
        if (!active) {
            throw new IllegalStateException("账户未激活，不能下单");
        }
        Order order = new Order(this);
        orders.add(order);
        return order;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
