package com.company.stream.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 7100),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        // 거래자가 근무하는 모든 도시를 중복 없이 나열
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList()); // distinct 대신에 그냥 collect(toSet())을 해도 된다.


        // 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
        String tradeStr =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1, n2) -> n1 + n2); // reduce 대신에 collect(joining()); // 내부적으로 StringBuilder이용
        System.out.println(tradeStr); // AlanBrianMarioRaoul

        // 전체 트랜잭션 중 최댓값은?
        Optional<Integer> highestValue =
                transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));





    }
}
