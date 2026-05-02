package com.travelagent.inventoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelagent.inventoryservice.dto.DriverInfoDto;
import com.travelagent.inventoryservice.services.DriverService;

@RestController
@RequestMapping("v1/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DriverInfoDto>> getAllData(@RequestParam Long owner_id) {
        if (owner_id < 0) {
            List<DriverInfoDto> driverInfoDtoList = driverService.getAll(owner_id);
            if (driverInfoDtoList == null || driverInfoDtoList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(driverInfoDtoList);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping
    public ResponseEntity<DriverInfoDto> postDriverData(@RequestBody DriverInfoDto driverInfoDto) {
        if (driverInfoDto == null && !driverInfoDto.isValid()) {
            return ResponseEntity.badRequest().build();
        } else {
            DriverInfoDto insertedDriver = driverService.createDriver(driverInfoDto);
            if(insertedDriver == null)
            {
                return ResponseEntity.internalServerError().build();
            }
            else{
                return ResponseEntity.ok().body(insertedDriver);
            }
        }
    }

}
