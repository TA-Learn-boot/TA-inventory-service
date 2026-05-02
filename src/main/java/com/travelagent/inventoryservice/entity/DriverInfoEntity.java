package com.travelagent.inventoryservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "driverinfo")
public class DriverInfoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false,unique = false)
    private String phone_number;

    @Column(name = "owner_id", nullable = false,unique = false)
    private Long ownerId;
}
