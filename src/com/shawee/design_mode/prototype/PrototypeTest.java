package com.shawee.design_mode.prototype;

// 原型模式
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Product product = new Product("part1", "part2", "part3", "part4", new Company("XXX"));
        // clone是浅复制，如果需要深复制，对应的引用可变变量也需要实现Cloneable
        Product clone = product.clone();
        clone.setCompany(clone.getCompany().clone());
        product.getCompany().setName("YYY");
        System.out.println(product);
        System.out.println(clone);
    }
}

class Company implements Cloneable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

    @Override
    protected Company clone() throws CloneNotSupportedException {
        return (Company) super.clone();
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Product implements Cloneable {
    private String part1;

    private String part2;

    private String part3;

    private String part4;

    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Product(String part1, String part2, String part3, String part4, Company company) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.company = company;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", company=" + company +
                '}';
    }
}
