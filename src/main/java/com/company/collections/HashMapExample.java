package com.company.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


// 만약 멀티스레드 환경에서 안전하게 객체를 관리하려면 HashMap이 아닌 Hashtable을 이용하자
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("김가라", 85);
        map.put("홍길동", 70);
        map.put("동장군", 60);

        map.computeIfAbsent("홍건", old -> {
            return 100;
        });

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }

        System.out.println();

        map.remove("홍길동");
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        map.clear();
    }
}
