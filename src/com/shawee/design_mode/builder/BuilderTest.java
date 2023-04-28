package com.shawee.design_mode.builder;

public class BuilderTest {

    public static void main(String[] args) {
        ProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(defaultConcreteProductBuilder);
        Product product = director.makeProduct("productNameXXX", "companyNameXXX", "part1", "part2", "part3", "part4");
        System.out.println(product);
    }
}


interface ProductBuilder {
    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderPart1(String part1);

    void builderPart2(String part2);

    void builderPart3(String part3);

    void builderPart4(String part4);

    Product build();
}


class DefaultConcreteProductBuilder implements ProductBuilder {
    private String productName;

    private String companyName;

    private String part1;

    private String part2;

    private String part3;

    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.companyName, this.part1, this.part2, this.part3, this.part4);
    }
}


class Director {
    private ProductBuilder productBuilder;

    public Director(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2,
                               String part3, String part4) {
        productBuilder.builderProductName(productName);
        productBuilder.builderCompanyName(companyName);
        productBuilder.builderPart1(part1);
        productBuilder.builderPart2(part2);
        productBuilder.builderPart3(part3);
        productBuilder.builderPart4(part4);
        return productBuilder.build();
    }
}


class Product {
    private String productName;

    private String companyName;

    private String part1;

    private String part2;

    private String part3;

    private String part4;

    public Product(String productName, String companyName, String part1, String part2,
                   String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}