package com.company.generic;

import com.company.generic.person.Student;
import com.company.generic.person.Worker;

import java.util.Arrays;

public class WildCardExample {
    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    // 학생 과정 course 에는 Student 와 HighStudent 만 올수 있음
    public static void registerCourseStudent(Course<? extends Student> course) {

    }

    // 직장인과 일반인 과정 , Worker 와 Person이 올 수 잇음
    public static void registerCourseWorker(Course<? super Worker> course) {

    }
}
