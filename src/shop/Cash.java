package shop;

/** 现金支付，记录顾客实际交付的现金。 */
public class Cash extends Payment {
    private double cashTendered;

    public Cash(double amount, double cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean pay() {
        boolean enough = cashTendered >= amount;
        System.out.printf("现金支付：应收 %.2f 元，实收 %.2f 元，找零 %.2f 元：%s%n",
                amount, cashTendered, cashTendered - amount, enough ? "成功" : "失败（金额不足）");
        return enough;
    }

    public double getChange() {
        return cashTendered - amount;
    }
}
