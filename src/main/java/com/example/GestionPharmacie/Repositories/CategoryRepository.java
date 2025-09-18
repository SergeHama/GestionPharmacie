package com.example.GestionPharmacie.Repositories;


import com.example.GestionPharmacie.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(
            value = """
                    SELECT * FROM CATEGORIES
                    WHERE tracking_id = :trackingId
                    """, nativeQuery = true
    )
    Optional<Category> findByTrackingId(@Param("trackingId") UUID trackingId);
}
