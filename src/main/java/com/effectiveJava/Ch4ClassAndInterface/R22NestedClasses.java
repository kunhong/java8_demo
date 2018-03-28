package com.effectiveJava.Ch4ClassAndInterface;

class Outer {
    private int x = 100;
    private static String str = "static outer";

    public void makeInner() {
        Inner in = new Inner();
        in.seeOuter();

    }
/*
* nonstatic member classes
Each instance of a nonstatic member class is implicitly associated with an enclosing instance of its containing class
You can invoke methods on the enclosing instance or obtain a refer- ence to the enclosing instance using the qualified this construct
The association between a nonstatic member class instance and its enclosing instance is established when the former is created
The association takes up space in the nonstatic member class instance and adds time to its construction
i.e One common use of a nonstatic member class is to define an Adapter
*/
    class Inner {
        public void seeOuter() {
            System.out.println("Outer private x is " + x);
            System.out.println("Outer class reference is " + Outer.this);
        }
    }

    /*
    * static member classes
Ordinary class that happens to be declared inside another class and has access to all of the enclosing class’s members, even those declared private
i.e. One common use of a static member class is as a public helper class, useful only in conjunction with its outer class
*/
    static class InnerStatic {
        void go() {
            System.out.println("Inner Static class reference is : " + this);
        }
    }

    public void doStuff() {
        class MyInner {
            public void seeOuter() {
                System.out.println("[doStuff method]Outer private x is " + x);
            }
        }

        MyInner i = new MyInner();
        i.seeOuter();
    }

    public void doStaticStuff() {
        class MyInner {
            public void seeOuter() {
                System.out.println("[doStaticStuff method]Outer private str is " + str);
            }
        }

        MyInner i = new MyInner();
        i.seeOuter();
    }

    private static class PrivateStaticInner {
        void go() {
            System.out.println("Inner Private Static class reference is : " + this);
        }
    }
}

public class R22NestedClasses {
    public static void main(String[] args) {
        Outer.InnerStatic n = new Outer.InnerStatic();
        n.go();

        Outer outer = new Outer();
        Outer.Inner i = outer.new Inner();
        i.seeOuter();

        outer.doStuff();
        outer.doStaticStuff();

        Outer.InnerStatic n2 = new Outer.InnerStatic();
        n2.go();
    }
}
