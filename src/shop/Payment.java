package shop;

/** 支付方式抽象类，五种具体支付方式继承它。 */
public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract boolean pay();

    public double getAmount() {
        return amount;
    }
}
