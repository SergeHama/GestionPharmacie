package com.example.GestionPharmacie.Controllers;

import com.example.GestionPharmacie.Dtos.Requests.CategoryRequest;
import com.example.GestionPharmacie.Dtos.Responses.CategoryResponse;
import com.example.GestionPharmacie.Services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/getByTrackingId/{trackingId}")
    public CategoryResponse getByTrackingId(@PathVariable UUID trackingId) {
        return categoryService.findByTrackingId(trackingId);
    }

    @PostMapping("/create")
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        return categoryService.create(request);
    }

    @PutMapping("/update/{trackingId}")
    public CategoryResponse update(@PathVariable UUID trackingId, @RequestBody CategoryRequest request) {
        return categoryService.update(trackingId, request);
    }

    @DeleteMapping("/deleteById/{trackingId}")
    public void deleteById(@PathVariable UUID trackingId) {
        categoryService.delete(trackingId);
    }
}
