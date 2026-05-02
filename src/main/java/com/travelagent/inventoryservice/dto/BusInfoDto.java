package com.travelagent.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusInfoDto {
      
    private Long bus_id;
    private String name; 
    private Integer seating_capacity; 
    private Long createdBy;

    @JsonIgnore
    public Boolean isValid()
    {
       return name != null && !name.isBlank()
       && seating_capacity>0 ;
    }
    
}
