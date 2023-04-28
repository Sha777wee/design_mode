package com.shawee.design_mode.adapter.clzz;

// 类适配器模式
public class ClassAdapterTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5v();
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

class Adapter extends Adaptee implements Target {
    @Override
    public int output5v() {
        int i = output220v();
        // ... 原始电压转换为目标电压
        return 5;
    }
}

