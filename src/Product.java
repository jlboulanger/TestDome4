//  Created by naXa! on 18/02/2019.
//  Copyright © 2019 naXa!. All rights reserved.
//
/*
 This code is a practice Java interview question from testdome.com
 Problem statement: Refactor the class Product ...
 */

public class Product {

    private final String name;
    private int quantity;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1)
            this.quantity = 1;
        else
            this.quantity = quantity;
    }
}
