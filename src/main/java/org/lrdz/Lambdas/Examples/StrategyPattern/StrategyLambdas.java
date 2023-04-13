package org.lrdz.Lambdas.Examples.StrategyPattern;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

public class StrategyLambdas {
    public static void main(String[] args) {
        Product p1 = Product.builder().id(1L).name("shampoo").price(150.0).userType("BASIC").build();
        var p2 = Product.builder().id(1L).name("keyboard").price(150.0).userType("PLUS").build();
        var p3 = Product.builder().id(1L).name("cellphone").price(150.0).userType("PRIME").build();
        var products = List.of(p1, p2, p3);

        products.forEach(p -> {
            switch (p.getUserType()) {
                case "BASIC":
                    p.setDiscountStrategy(Strategies.basicDiscount);
                    break;
                case "PLUS":
                    p.setDiscountStrategy(Strategies.plusDiscount);
                    break;
                case "PRIME":
                    p.setDiscountStrategy(Strategies.primeDiscount);
                    break;
            }
        });

        products.forEach(p -> {
            System.out.println("Price: " + p.getPrice() + "User type: " + p.getUserType() + "Discount: " + p.getDiscountStrategy().get(p.getPrice()));
        });

    }
}

@FunctionalInterface
interface IApplyDiscountStrategy {
    Double get(Double price);
}

@Data
@Builder
@ToString
class Product {
    private Long id;
    private String userType;
    private String name;
    private Double price;
    private IApplyDiscountStrategy discountStrategy;
}

class Strategies {
    static IApplyDiscountStrategy basicDiscount = p -> p*0.02;
    static IApplyDiscountStrategy plusDiscount = p -> p*0.05;
    static IApplyDiscountStrategy primeDiscount = p -> p*0.10;
}