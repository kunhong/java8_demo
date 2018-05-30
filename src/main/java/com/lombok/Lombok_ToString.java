package com.lombok;

import lombok.ToString;

// Lombok_ToString(name=null, tags=null, shape=Lombok_ToString.Square(super=com.lombok.Lombok_ToString$Square@4a574795, width=5, height=10))
@ToString
public class Lombok_ToString {
    private static final int STATIC_VAR = 10;
    @ToString.Include(name = "some other name")
    private String name; // Lombok_ToString(some other name=null ....
    private String[] tags;
    private Shape shape = new Square(5, 10);
    @ToString.Exclude private int id;

    public String getName() {
        return this.name;
    }

    public static class Shape {
        private int type;

        public Shape(int type) {
            this.type = type;
        }
    }
//    includeFieldNames 을 통해 field name을 출력하지 않도록 변경할 수 있다. (includeFieldNames =false)
//    shape=Lombok_ToString.Square(super=com.lombok.Lombok_ToString$Square@4a574795, 5, 10))
//    exclude 를 사용하여 출력하지 않을 field를 지정할 수 있다.
//    callSuper를 통해 super type의 toString() method의 결과값을 출력에포함할지를 결정할 수도 있다.
    // shape=Lombok_ToString.Square(width=5, height=10)) => callSuper=false
    @ToString(callSuper=true, includeFieldNames=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            super(100);
            this.width = width;
            this.height = height;
        }
    }
}
