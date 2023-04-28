package com.shawee.design_mode.builder.v2;

public class BuilderTest2 {
    public static void main(String[] args) {
        Product product = (new Product.Builder()).productName("XXX").companyName("XXX").part1("XXX").part2("xxx").part3("xxx").part4("xxx").build();
        System.out.println(product.toString());


    }
}

class Product {
    private final String productName;

    private final String companyName;

    private final String part1;

    private final String part2;

    private final String part3;

    private final String part4;

    public Product(String productName, String companyName, String part1, String part2,
                   String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    static class Builder {
        private String productName;

        private String companyName;

        private String part1;

        private String part2;

        private String part3;

        private String part4;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder part1(String part1) {
            this.part1 = part1;
            return this;
        }


        public Builder part2(String part2) {
            this.part2 = part2;
            return this;
        }

        public Builder part3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Builder part4(String part4) {
            this.part4 = part4;
            return this;
        }

        Product build() {
            return new Product(this.productName, this.companyName, this.part1, this.part2, this.part3, this.part4);
        }
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