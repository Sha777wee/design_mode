package com.shawee.design_mode.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // 简单工厂
        SimpleFactory.getProduct("A").show();
        SimpleFactory.getProduct("B").show();

        // 工厂方法模式
        new FactoryA().getProduct().show();
        new FactoryB().getProduct().show();
    }
}

interface Product{
    void show();
}

class ProductA implements Product{
    public void show(){
        System.out.println("This is ProductA");
    }
}

class ProductB implements  Product {
    public void show(){
        System.out.println("This is ProductB");
    }
}

abstract class Factory {
    abstract Product createProduct();
    Product getProduct() {
        // ... 一些固定前置初始化操作
        return createProduct();
    }
}

class FactoryA extends Factory{
    @Override
    public Product createProduct(){
        return new ProductA();
    }
}

class FactoryB extends Factory{
    @Override
    public Product createProduct(){
        return new ProductB();
    }
}

// 简单工厂，它并不是一种设计模式，只是一种编码的方式
class SimpleFactory {
    public static  Product getProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        } else {
            return null;
        }
    }
}