package com.example.GestionPharmacie.Services;

import com.example.GestionPharmacie.Dtos.Requests.CategoryRequest;
import com.example.GestionPharmacie.Dtos.Responses.CategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryResponse create(CategoryRequest request);

    CategoryResponse update(UUID trackingId, CategoryRequest request);



    List<CategoryResponse> getAll();

    CategoryResponse findByTrackingId (UUID trackingId);



    void delete (UUID trackingId);
}
