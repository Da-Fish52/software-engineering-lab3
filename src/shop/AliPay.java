package shop;

/** 支付宝支付。 */
public class AliPay extends Payment {
    private String number;

    public AliPay(double amount, String number) {
        super(amount);
        this.number = number;
    }

    @Override
    public boolean pay() {
        System.out.printf("支付宝账号[%s]支付 %.2f 元：成功%n", number, amount);
        return true;
    }
}
