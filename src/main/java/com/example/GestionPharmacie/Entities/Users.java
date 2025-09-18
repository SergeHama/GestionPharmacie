package com.example.GestionPharmacie.Entities;


import com.example.GestionPharmacie.utils.BaseEntity;
import com.example.GestionPharmacie.utils.ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;



@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Entity
@Setter
public   class  Users  extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "firstname" , nullable = false , length = 100)
    private String  firstname ;
    @Column(name = "lastname" , nullable = false , length = 100)
    private String lastname ;
    @Column(name = "email" , nullable = false , length =  200)
    private  String email ;
    @Column(name = "phone" , nullable = false , length = 30)
    private String phone ;
    @Column(name = "address" , nullable = false )
    private String address ;
    @Column(name = "tracking_id" , nullable = false )
    private UUID trackingId ;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ROLE role ;


}

