package com.example.GestionPharmacie.Dtos.Requests;

import jakarta.persistence.Column;

import java.util.UUID;

public record CategoryRequest(
        String name,
        String description
) {
}
