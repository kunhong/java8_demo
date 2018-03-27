package com.company.JavaEnum;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayGroup {
    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드", Arrays.asList(PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY)),
    ETC("기타", Arrays.asList(PayType.COUPON, PayType.POINT)),
    EMPTY("없음", Collections.EMPTY_LIST);

    @Getter private String title;
    private List<PayType> payList;

    PayGroup(String title, List<PayType> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PayGroup findByPayCode(PayType payType) {
        return Arrays.stream(PayGroup.values())
                .filter(payGroup -> payGroup.hasPayCode(payType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream()
                .anyMatch(pay -> pay == payType);
    }
}
