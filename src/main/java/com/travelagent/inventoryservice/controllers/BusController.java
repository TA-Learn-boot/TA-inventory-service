package com.travelagent.inventoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelagent.inventoryservice.dto.BusInfoDto;
import com.travelagent.inventoryservice.services.BusService;

@RestController
@RequestMapping("v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BusInfoDto>> getBuses(@RequestParam Long createdBy) {
        if (createdBy != null) {
            var allBuses = busService.getAllBus(createdBy);
            if (allBuses == null || allBuses.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(busService.getAllBus(createdBy));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<BusInfoDto> getBus(@RequestParam Long busId) {
        if (busId != null) {
            var bus = busService.getBus(busId);
            if (bus == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(busService.getBus(busId));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBus(@RequestParam Long busId) {
        if (busId != null) {
            busService.deleteBus(busId);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateBus(@RequestBody BusInfoDto busInfoDto) {
        if (busInfoDto != null && busInfoDto.isValid() && busInfoDto.getBus_id() > 0) {
            BusInfoDto updatedBus = busService.updateBusInfo(busInfoDto);
            if (updatedBus == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(updatedBus);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<BusInfoDto> postBus(@RequestBody BusInfoDto busInfoDto) {
        if (busInfoDto != null && busInfoDto.isValid()) {
            BusInfoDto createdBus = busService.createBus(busInfoDto);
            if (createdBus == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(createdBus);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
