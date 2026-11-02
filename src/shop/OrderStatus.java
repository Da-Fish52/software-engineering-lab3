package shop;

/** 订单状态：创建、已支付、配送中、已送达、已取消。 */
public enum OrderStatus {
    CREATE("待支付"),
    PAID("已支付"),
    SHIPPING("配送中"),
    DELIVERED("已送达"),
    CANCEL("已取消");

    private final String label;

    OrderStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
