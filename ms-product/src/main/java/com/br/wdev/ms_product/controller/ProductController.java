package com.br.wdev.ms_product.controller;

import com.br.wdev.ms_product.dto.ProductRequestDTO;
import com.br.wdev.ms_product.model.Product;
import com.br.wdev.ms_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createdProduct(@RequestBody ProductRequestDTO productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<Product> GetAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
