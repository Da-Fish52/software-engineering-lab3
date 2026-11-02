package shop;

/** 在线转账支付。 */
public class WireTransfer extends Payment {
    private String bankID;
    private String bankName;

    public WireTransfer(double amount, String bankID, String bankName) {
        super(amount);
        this.bankID = bankID;
        this.bankName = bankName;
    }

    @Override
    public boolean pay() {
        System.out.printf("在线转账：%s（%s）支付 %.2f 元：成功%n", bankName, bankID, amount);
        return true;
    }
}
