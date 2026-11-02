package shop;

/** 微信支付。 */
public class WeixinPay extends Payment {
    private String number;

    public WeixinPay(double amount, String number) {
        super(amount);
        this.number = number;
    }

    @Override
    public boolean pay() {
        System.out.printf("微信账号[%s]支付 %.2f 元：成功%n", number, amount);
        return true;
    }
}
