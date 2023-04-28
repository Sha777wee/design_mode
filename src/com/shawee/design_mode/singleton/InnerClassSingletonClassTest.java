package com.shawee.design_mode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonClassTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1==instance2);

        new Thread(()->{
            InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
            System.out.println(innerClassSingleton);
        }).start();

        new Thread(()->{
            InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
            System.out.println(innerClassSingleton);
        }).start();
        attackSingleton();
    }

    // 通过反射破坏单例模式
    public static void attackSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        Constructor constructor =  InnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InnerClassSingleton instance2= (InnerClassSingleton)constructor.newInstance();
        // 输出为false
        System.out.println(instance1 == instance2);
    }
}

// 静态内部类实现单例模式
class InnerClassSingleton{
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        if (InnerClassHolder.instance!=null) {
            throw  new RuntimeException("单例中不允许多个实例");
        }
    }
    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}

