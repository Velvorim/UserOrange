package com.userOrange.resources;

import java.util.List;

import com.userOrange.model.Fipe;
import com.userOrange.services.FipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fipe")
public class FipeResouces {
    @Autowired
    private FipeService fipeService;

    @GetMapping("/marcas")
    public ResponseEntity<List<Fipe>> listMarcas() {
        try {
            List<Fipe> fipe = fipeService.findBrands();
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos")
    public ResponseEntity<Fipe> listModelos(@PathVariable String marca) {
        try {
            Fipe fipe = fipeService.FindMondels(marca);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos/{modelo}/anos")
    public ResponseEntity<List<Fipe>> listAno(@PathVariable String marca, @PathVariable String modelo) {
        try {
            List<Fipe> fipe = fipeService.findYears(marca, modelo);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos/{modelo}/anos/{ano}")
    public ResponseEntity<Fipe> listAll(@PathVariable String marca, @PathVariable String modelo,
            @PathVariable String ano) {
        try {
            Fipe fipe = fipeService.findVehicles(marca, modelo, ano);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
