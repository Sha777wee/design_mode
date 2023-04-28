package com.shawee.design_mode.observer;

import java.util.ArrayList;
import java.util.List;

// 观察者模式
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObserver("xxx");
    }
}

class Subject {
    private List<Observer> container = new ArrayList<>();

    public void addObserver(Observer observer) {
        container.add(observer);
    }

    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer item : container) {
            item.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("Task1 received:" + object);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("Task2 received:" + object);
    }
}
