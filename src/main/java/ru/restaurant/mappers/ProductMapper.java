package ru.restaurant.mappers;

import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.Product;
import ru.restaurant.dto.ProductDto;

@Service
public class ProductMapper implements Mapper<ProductDto, Product> {
    @Override
    public ProductDto mapToDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
//                .count(entity.getCount())
                .build();
    }

    @Override
    public Product mapToEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
//                .count(dto.getCount())
                .build();
    }
}
