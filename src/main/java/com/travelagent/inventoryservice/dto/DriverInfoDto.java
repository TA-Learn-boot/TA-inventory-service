package com.travelagent.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDto {
    private Long driver_id;
    private String name;
    private String phone_number;
    private Long owner_id;

    public boolean isValid() {
        return name != null && !name.isBlank() && !name.isEmpty()
                && phone_number != null && !phone_number.isBlank() && !phone_number.isEmpty()
                && owner_id != null && owner_id > 0;
    }
}
