package com.br.wdev.ms_product.service;

import com.br.wdev.ms_product.dto.ProductRequestDTO;
import com.br.wdev.ms_product.model.Product;
import com.br.wdev.ms_product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public Product createProduct(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        return productRepository.save(product);
    }



    @Cacheable(value = "product-cache", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("BUSCANDO DO BANCO DE DADOS: " + id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @CacheEvict(value = "product-cache", key = "#id")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
