package com.userOrange.resources;

import java.util.List;

import javax.validation.Valid;

import com.userOrange.model.Vehicle;
import com.userOrange.services.VehicleService;
import com.userOrange.repositories.VehicleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResouce {
    
    @Autowired
    private VehicleRepository vRepo;

    @Autowired
    private VehicleService vService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> listVehicles() {
      return ResponseEntity.ok().body(vRepo.findAll());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Vehicle> addVeiculos(@Valid @RequestBody Vehicle vehicles) {

          
        
      try {
        Vehicle vehiclereturn = vService.insertVehicles(vehicles);
         
        return new ResponseEntity<>(vehiclereturn, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
      }
      
    } 
}
