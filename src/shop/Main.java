package shop;

import java.time.LocalDate;
import java.util.Locale;

/** 演示程序：创建客户、下单、计算金额与重量、完成支付与状态流转。 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);

        Customer customer = new Customer("张三", "13800000000", "湖北省宜昌市大学路 8 号");
        customer.activate();
        System.out.println("客户：" + customer.getName() + "，激活状态：" + customer.isActive());

        Product book = new Product("《软件工程》教材", 59.80, 0.65, "UML 与面向对象设计");
        Product cup = new Product("保温杯", 89.00, 0.40, "304 不锈钢");
        Product pen = new Product("签字笔", 3.50, 0.02, "黑色 0.5mm");

        Order order = customer.placeOrder();
        order.addDetail(new OrderDetail(book, 2));
        order.addDetail(new OrderDetail(cup, 1));
        order.addDetail(new OrderDetail(pen, 5));

        System.out.printf("订单创建时间：%tc%n", order.getCreateDate());
        System.out.println("订单状态：" + order.getStatus() + "（" + order.getStatus().getLabel() + "）");
        for (OrderDetail d : order.getDetails()) {
            System.out.printf("  %s x%d：小计 %.2f 元，重量 %.2f kg%n",
                    d.getProduct().getTitle(), d.getQuantity(),
                    d.calculateSubTotal(), d.calculateWeight());
        }
        System.out.printf("订单总额：%.2f 元，总重量：%.2f kg%n",
                order.calculateTotal(), order.calculateWeight());

        Payment payment = new AliPay(order.calculateTotal(), "zhangsan@example.com");
        order.pay(payment);
        System.out.println("支付后状态：" + order.getStatus() + "（" + order.getStatus().getLabel() + "）");

        order.ship();
        System.out.println("发货后状态：" + order.getStatus() + "（" + order.getStatus().getLabel() + "）");
        order.deliver();
        System.out.println("送达后状态：" + order.getStatus() + "（" + order.getStatus().getLabel() + "）");

        System.out.println("---- 多态支付方式演示 ----");
        Payment[] payments = {
                new Credit(199.00, "6222020202021234", "VISA", LocalDate.now().plusYears(2)),
                new Cash(88.50, 100.00),
                new WireTransfer(500.00, "ICBC-001", "中国工商银行"),
                new AliPay(66.00, "zhangsan@example.com"),
                new WeixinPay(128.00, "wx_zhangsan")
        };
        for (Payment p : payments) {
            p.pay();
        }
    }
}
