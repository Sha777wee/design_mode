package com.shawee.design_mode.template;

// 模板方法模式
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();
    }
}

abstract class AbstractClass {
    public void operation() {
        System.out.println("preHandle ...");
        templateMethod();
        System.out.println("afterHandle ... ");
    }

    protected abstract void templateMethod();
}

class SubClass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClass task ...");
    }
}
