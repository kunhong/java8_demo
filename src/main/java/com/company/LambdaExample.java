package com.company;

import com.company.lambda.MyFunctionalInterface;
import com.company.lambda.MyFunctionalInterfaceReturn;
import com.company.lambda.MyFunctionalInterfaceWithParam;

public class LambdaExample {
    public static int sum(int x, int y) {
        return x  + y;
    }
    public static void main(String[] args) {
        MyFunctionalInterface fi = () -> {
            System.out.println("MyFunctionalInterface::method call");
        };
        fi.method();

        fi = () -> System.out.println("MyFunctionalInterface::method call2");
        fi.method();

        MyFunctionalInterfaceWithParam fi_param = (x) -> {
            System.out.println("MyFunctionalInterfaceWithParam = [" + x + "]");
        };
        fi_param.method(10);

        MyFunctionalInterfaceReturn fi_return1 = (x, y) -> {
            return x + y;
        };
        System.out.println("fi_return1 = [" + fi_return1.method(1,1) + "]");

        fi_return1 = (x, y) -> x * y;
        System.out.println("fi_return1 = [" + fi_return1.method(2,3) + "]");

        fi_return1 = (x, y) -> sum(x,y);
        System.out.println("fi_return1 = [" + fi_return1.method(2,3) + "]");


    }
}
