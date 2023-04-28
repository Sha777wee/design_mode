package com.shawee.design_mode.adapter.object;

//对象适配器模式
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.output5v();
    }
}

class Adaptee {
    public int output220v() {
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        // ... 原始电压转换为目标电压
        return 5;
    }
}