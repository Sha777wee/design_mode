package com.shawee.design_mode.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        AbstractZombie flagZombie = new FlagZombie();

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }
}

interface Moveable {
    void move();
}

class StepByStepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("一步一步移动.");
    }
}

interface Attackable {
    void attack();
}

class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("咬.");
    }
}

abstract class AbstractZombie {

    protected Moveable moveable;

    protected Attackable attackable;

    public AbstractZombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public abstract void move();

    public abstract void attack();

    public abstract void display();
}

class NormalZombie extends AbstractZombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸.");
    }

    @Override
    public void move() {
        moveable.move();
    }

    @Override
    public void attack() {
        attackable.attack();
    }
}

class FlagZombie extends AbstractZombie {

    public FlagZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸.");
    }

    @Override
    public void move() {
        moveable.move();
    }

    @Override
    public void attack() {
        attackable.attack();
    }
}

