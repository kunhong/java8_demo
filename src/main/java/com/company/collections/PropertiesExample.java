package com.company.collections;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

// Properties는 HashTable의 하위 클래스로 키와 값을 String 타입으로 제한한 컬렉션이다.
// 주로 .properties 파일을 읽을 때 주로 사용한다.
public class PropertiesExample {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // 프로퍼티 파일은 일반적으로 클래스 파일(.class)과 함께 저장한다.
        // 클래스 파일을 기준으로 상대 경로를 이용해서 프로퍼티 파일의 경로를 얻으려면 Class의 getResource() 메소드를 이용하면 된다.
        // getResource()는 주어진 파일의 상대 경로를 URL 객체로 리턴하는데, URL의 getPtah()는 파일의 절대 경로를 리턴한다.
        String path = Thread.currentThread().getContextClassLoader().getResource("database.properties").getPath();
        try {
            // 한글이 있는 경우 한글을 복원
            path = URLDecoder.decode(path, "utf-8");
            properties.load(new FileReader(path));
        } catch (Exception err) {
            err.printStackTrace();
        }

        System.out.println("driver = [" + properties.getProperty("driver") + "]");

    }
}
