package com.shawee.design_mode.facade;

// 门面模式
public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSomething();
        ;
    }
}

class Facade {
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("Subsystem1 method1 executed.");
    }

}

class SubSystem2 {
    public void method2() {
        System.out.println("Subsystem2 method2 executed.");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("Subsystem3 method3 executed.");
    }
}
