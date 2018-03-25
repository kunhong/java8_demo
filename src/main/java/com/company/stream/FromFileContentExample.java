package com.company.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample {
    public static void main(String[] args) throws IOException {
        // 파일의 경로 정보를 가지고 있는 Path 객체 생성
        Path path = Paths.get("src/main/resources/linedata.txt");
        Stream<String> stream;

        stream= Files.lines(path, Charset.defaultCharset());
        stream.forEach(System.out :: println);

        // BufferedReader 의 lines() 메소드 이용
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        stream = br.lines();
        stream.forEach(System.out :: println);

        Files.list(Paths.get("."))
                .forEach(System.out::println);

        Files.list(Paths.get("."))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

    }
}
