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
@Table(name = "businfo")
public class BusInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bus_id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false,unique = false)
    private Integer seating_capacity;

    @Column(nullable = false,unique = false)
    private Long createdBy;
    
}
