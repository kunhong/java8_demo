package com.company.stream;

import com.company.data.MaleStudent;
import com.company.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CollectCustomContainer {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, 20, "남자"),
                new Student("김여자", 10, 20, "여자"),
                new Student("홍남자", 10, 20, "남자"),
                new Student("김남자", 10, 20, "남자"),
                new Student("아남자", 10, 20, "남자")

        );

//        Stream<Student> totalStream = totalList.stream();
//        Stream<Student> maleStream = totalStream.filter(s -> s.getSex().equals("남자"));
//        Supplier<MaleStudent> supplier = () -> new MaleStudent();
//        BiConsumer<MaleStudent, Student> accumulator = (ms, s) -> ms.accumulate(s);
//        BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);
//
//        MaleStudent maleStudent = maleStream.collect(supplier, accumulator, combiner);
        MaleStudent maleStudent = totalList.stream()
                .filter(s -> s.getSex().equals("남자"))
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent.getList().stream()
                .forEach(System.out::println);

    }
}
