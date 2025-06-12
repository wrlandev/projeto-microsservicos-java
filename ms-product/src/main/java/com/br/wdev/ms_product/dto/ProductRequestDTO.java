package com.br.wdev.ms_product.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, String description, BigDecimal price) {

}
