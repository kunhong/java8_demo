package com.company.JavaEnum;

public class PayGroupExample {
    public static void main(String[] args) {
        PayType payType = PayType.COUPON;
        PayGroup payGroup = PayGroup.findByPayCode(payType);

        System.out.println("payGroup = [" + payGroup.getTitle() + "]");
    }
}
