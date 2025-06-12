package com.br.wdev.ms_product.repository;

import com.br.wdev.ms_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{
}
