package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product = new Product(1L, "Sample", 10.0);
        assertEquals(1L, product.getId());
    }

    @Test
    void getName() {
        Product product = new Product(1L, "Sample", 10.0);
        assertEquals("Sample", product.getName());
    }

    @Test
    void getPrice() {
        Product product = new Product(1L, "Sample", 10.0);
        assertEquals(10.0, product.getPrice());
    }

    @Test
    void setId() {
        Product product = new Product("Sample", 10.0);
        product.setId(2L);
        assertEquals(2L, product.getId());
    }

    @Test
    void setName() {
        Product product = new Product(1L, "OldName", 10.0);
        product.setName("NewName");
        assertEquals("NewName", product.getName());
    }

    @Test
    void setPrice() {
        Product product = new Product(1L, "Sample", 10.0);
        product.setPrice(99.99);
        assertEquals(99.99, product.getPrice());
    }

    @Test
    void testToString() {
        Product product = new Product(1L, "Sample", 10.0);
        String expected = "Product{id=1, name='Sample', price=10.0}";
        assertEquals(expected, product.toString());
    }

    @Test
    void testEquals() {
        Product product1 = new Product(1L, "Sample", 10.0);
        Product product2 = new Product(1L, "Sample", 10.0);
        Product product3 = new Product(2L, "Different", 20.0);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(null, product1);
        assertNotEquals("NotAProduct", product1);
    }

    @Test
    void testHashCode() {
        Product product1 = new Product(1L, "Sample", 10.0);
        Product product2 = new Product(1L, "Sample", 10.0);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}
