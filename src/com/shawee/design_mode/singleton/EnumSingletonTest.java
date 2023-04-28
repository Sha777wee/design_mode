package com.shawee.design_mode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1== instance2);

        attackSingleton();
    }

    // 通过反射破坏单例模式
    public static void attackSingleton() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        // 抛出异常
        Constructor constructor =  EnumSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumSingleton instance2= (EnumSingleton)constructor.newInstance("INSTANCE",0);
        System.out.println(instance1 == instance2);
    }
}

enum EnumSingleton{
    INSTANCE;

}
