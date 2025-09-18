package com.example.GestionPharmacie.Dtos.Responses;

import java.util.UUID;

public record CategoryResponse(
        UUID trackingId,
        String name,
        String description
) {
}
