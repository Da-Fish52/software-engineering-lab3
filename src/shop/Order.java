package shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 订单：聚合订单详情，关联支付方式，使用订单状态枚举。 */
public class Order {
    private final Date createDate;
    private OrderStatus status;
    private Customer customer;
    private Payment payment;
    private final List<OrderDetail> details = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
        this.createDate = new Date();
        this.status = OrderStatus.CREATE;
    }

    public void addDetail(OrderDetail detail) {
        details.add(detail);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : details) {
            total += detail.calculateSubTotal();
        }
        return total;
    }

    public double calculateWeight() {
        double weight = 0;
        for (OrderDetail detail : details) {
            weight += detail.calculateWeight();
        }
        return weight;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean pay(Payment payment) {
        this.payment = payment;
        boolean ok = payment.pay();
        if (ok) {
            this.status = OrderStatus.PAID;
        }
        return ok;
    }

    public void ship() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException("订单未支付，不能发货");
        }
        status = OrderStatus.SHIPPING;
    }

    public void deliver() {
        if (status != OrderStatus.SHIPPING) {
            throw new IllegalStateException("订单未发货，不能确认送达");
        }
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status == OrderStatus.SHIPPING || status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("订单已发货，不能取消");
        }
        status = OrderStatus.CANCEL;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }
}
