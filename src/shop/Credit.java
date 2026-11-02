package shop;

import java.time.LocalDate;

/** 信用卡支付。 */
public class Credit extends Payment {
    private String number;
    private String type;
    private LocalDate expireDate;

    public Credit(double amount, String number, String type, LocalDate expireDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }

    @Override
    public boolean pay() {
        boolean valid = expireDate != null && !expireDate.isBefore(LocalDate.now());
        System.out.printf("信用卡[%s %s]支付 %.2f 元：%s%n",
                type, mask(number), amount, valid ? "成功" : "失败（卡已过期）");
        return valid;
    }

    private String mask(String cardNo) {
        if (cardNo == null || cardNo.length() < 4) {
            return "****";
        }
        return "****" + cardNo.substring(cardNo.length() - 4);
    }
}
