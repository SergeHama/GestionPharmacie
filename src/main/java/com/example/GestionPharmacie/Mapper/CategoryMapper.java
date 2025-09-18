package com.example.GestionPharmacie.Mapper;

import com.example.GestionPharmacie.Dtos.Requests.CategoryRequest;
import com.example.GestionPharmacie.Dtos.Responses.CategoryResponse;
import com.example.GestionPharmacie.Entities.Category;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category entity) {
        return new CategoryResponse(
                entity.getTrackingId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    public Category toEntity (CategoryRequest request) {
        return new Category(
                request.name(),
                request.description()
        );
    }

    public List<CategoryResponse> toResponseList (List<Category> list) {
        return list.stream()
                .map(this::toResponse)
                .toList();
    }
}
