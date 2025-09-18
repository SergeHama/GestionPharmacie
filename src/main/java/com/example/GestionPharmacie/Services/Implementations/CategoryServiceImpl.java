package com.example.GestionPharmacie.Services.Implementations;


import com.example.GestionPharmacie.Dtos.Requests.CategoryRequest;
import com.example.GestionPharmacie.Dtos.Responses.CategoryResponse;
import com.example.GestionPharmacie.Entities.Category;
import com.example.GestionPharmacie.Mapper.CategoryMapper;
import com.example.GestionPharmacie.Repositories.CategoryRepository;
import com.example.GestionPharmacie.Services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{


    private final CategoryRepository repository ;

    private final CategoryMapper mapper ;

    public CategoryServiceImpl(CategoryRepository repository,CategoryMapper  mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public CategoryResponse create(CategoryRequest request) {
        if(request == null){
            throw  new IllegalArgumentException("request must be not null");
        }

        Category entity  = this.mapper.toEntity(request);
        entity.setTrackingId(UUID.randomUUID());

        Category result = this.repository.save(entity);


        return this.mapper.toResponse(result);


    }



    @Override
    public CategoryResponse update(UUID trackingId, CategoryRequest request) {

        if(trackingId == null || request == null){
            throw new IllegalArgumentException("make sure that neither the tracking id or request be null");
        }

        Category category = this.repository.findByTrackingId(trackingId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "company not found or invalid tracking id"));


        category.setName(request.name());
        category.setDescription(request.description());


        Category result = this.repository.save(category);

        return  this.mapper.toResponse(result);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return  this.repository.findAll()
                .stream().map(this.mapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse findByTrackingId(UUID trackingId) {
        if(trackingId == null  ){
            throw new IllegalArgumentException("make sure that   the tracking id is not null  ");
        }

        Category category = this.repository.findByTrackingId(trackingId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "company not found or invalid tracking id"));
        return this.mapper.toResponse(category);
    }

    @Override
    public void delete(UUID trackingId) {
        if(trackingId == null  ){
            throw new IllegalArgumentException("make sure that   the tracking id is not null  ");
        }

        Category category = this.repository.findByTrackingId(trackingId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "company not found or invalid tracking id"));

        this.repository.delete(category);
    }
}
