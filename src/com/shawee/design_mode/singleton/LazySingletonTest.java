package com.shawee.design_mode.singleton;

public class LazySingletonTest {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2);

        new Thread(()->{
            LazySingleton lazySingleton =LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();

        new Thread(()->{
            LazySingleton lazySingleton =LazySingleton.getInstance();
            System.out.println(lazySingleton);
        }).start();
    }

}

// 懒汉单例模式
class LazySingleton {
    // 加入volatile防止创建对象时JIT编译器进行优化重排序
    private volatile static  LazySingleton instance;

    private LazySingleton(){
    }

    public static LazySingleton getInstance(){
        if (instance==null) {
            // 防止多线程并发创建多个实例
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}