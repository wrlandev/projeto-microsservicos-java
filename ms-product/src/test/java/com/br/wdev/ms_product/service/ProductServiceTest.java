package com.br.wdev.ms_product.service;

import com.br.wdev.ms_product.dto.ProductRequestDTO;
import com.br.wdev.ms_product.model.Product;
import com.br.wdev.ms_product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void whenCreateProduct_thenShouldSaveProduct(){
        var request = new ProductRequestDTO("Notebook", "Gamer", new BigDecimal("5000"));
        var product = new Product();
        product.setName(request.name());

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(request);

        assertNotNull(createdProduct);
        assertEquals("Notebook", createdProduct.getName());

        verify(productRepository, times(1)).save(any(Product.class));
    }

}
