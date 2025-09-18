package com.example.GestionPharmacie.Entities;


import com.example.GestionPharmacie.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PHARMACISTS")

public class Pharmacists  extends  Users {




}
