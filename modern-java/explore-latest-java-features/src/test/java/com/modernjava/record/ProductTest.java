package com.modernjava.record;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @Test
    void createProduct() {

        var product = new Product("IPhone", new BigDecimal("999.99"),
                "ELECTRONICS");
        System.out.println("product = " + product);
        assertEquals("IPhone", product.name());
        assertEquals("ELECTRONICS", product.type());

        // Explain about immutablility
        /**
         * There are no setter methods to access and modify the values of the instance variable.
         */
    }



    @Test
    void createProduct_customConstructor() {

        var product = new Product("IPhone", new BigDecimal("999.99"));
        System.out.println("product = " + product);
        assertEquals("IPhone", product.name());
        assertEquals("GENERAL", product.type());

    }

    @Test
    void createProduct_error() {

        var exception = assertThrows(IllegalArgumentException.class,
                ()-> new Product("IPhone", new BigDecimal("-999.99"),
                        "ELECTRONICS")                );

        assertEquals("cost value is not valid!", exception.getMessage());
    }


    @Test
    void createProduct_name_notValid() {


        var exception = assertThrows(IllegalArgumentException.class,
                ()-> new Product("", new BigDecimal("999.99"),
                        "ELECTRONICS")                );

        assertEquals("name value is not valid!", exception.getMessage());
    }

    @Test
    void createProductComparison() {

        var product = new Product("IPhone",
                new BigDecimal("999.99"),
                //new BigDecimal("1999.99"),
                "ELECTRONICS");

        var product1 = new Product("IPhone", new BigDecimal("999.99"),
                "ELECTRONICS");
        assertEquals(product1, product);
        System.out.println("product = " + product);
        assertEquals("IPhone", product.name());
        assertEquals("ELECTRONICS", product.type());

    }

}