package org.lrdz.UtilPojos;

import lombok.ToString;

@ToString
public class MyProduct {

    Integer price;
    String name;

    public MyProduct(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

}
