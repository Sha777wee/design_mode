package com.shawee.design_mode.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 享元模式
public class FlyWeightTest {
    public static void main(String[] args) {
        // 对于不同位置的同类型的树，使用的都是同一个对象
        TreeNode treeNode1 = new TreeNode(3, 4, TreeFactory.getTree("xxx", "yyy"));
        TreeNode treeNode2 = new TreeNode(3, 4, TreeFactory.getTree("xxx", "yyy"));
    }
}

class TreeNode {
    private final int x;
    private final int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tree getTree() {
        return tree;
    }
}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
}

class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
