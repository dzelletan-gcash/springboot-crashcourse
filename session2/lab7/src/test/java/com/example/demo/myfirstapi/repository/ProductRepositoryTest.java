package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void findAll_shouldReturnInitialProducts() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void findById_existingId_shouldReturnProduct() {
        Optional<Product> found = productRepository.findById(1L);
        assertTrue(found.isPresent());
        assertEquals("Laptop", found.get().getName());
    }

    @Test
    void findById_nonExistingId_shouldReturnEmptyOptional() {
        Optional<Product> found = productRepository.findById(999L);
        assertFalse(found.isPresent());
    }

    @Test
    void save_newProduct_shouldAssignIdAndAddToRepository() {
        Product newProduct = new Product("Monitor", 300.0);
        Product savedProduct = productRepository.save(newProduct);

        assertNotNull(savedProduct.getId());
        assertEquals("Monitor", savedProduct.getName());

        Optional<Product> fetched = productRepository.findById(savedProduct.getId());
        assertTrue(fetched.isPresent());
        assertEquals(savedProduct, fetched.get());
    }

    @Test
    void save_existingProduct_shouldUpdateInRepository() {
        Optional<Product> existing = productRepository.findById(1L);
        assertTrue(existing.isPresent());

        Product productToUpdate = existing.get();
        productToUpdate.setPrice(1500.0);
        Product updatedProduct = productRepository.save(productToUpdate);

        assertEquals(1500.0, updatedProduct.getPrice());

        Optional<Product> fetched = productRepository.findById(1L);
        assertTrue(fetched.isPresent());
        assertEquals(1500.0, fetched.get().getPrice());
    }

    @Test
    void save_nonExistingId_shouldNotAddOrUpdate() {
        Product productWithInvalidId = new Product(999L, "GhostProduct", 0.0);
        Product savedProduct = productRepository.save(productWithInvalidId);

        assertEquals(999L, savedProduct.getId());

        // It should not be added
        Optional<Product> fetched = productRepository.findById(999L);
        assertFalse(fetched.isPresent());
    }
}
