package com.userOrange.services;

import java.util.List;

import com.userOrange.model.Fipe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/carros/", name ="fipe")
public interface FipeService {
    @GetMapping("marcas")
    public List<Fipe> findBrands();

    @GetMapping("marcas/{marca}/modelos")
    public Fipe FindMondels(@PathVariable("marca") String marca);

    @GetMapping("marcas/{marca}/modelos/{modelo}/anos")
    public List<Fipe> findYears(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo);

    @GetMapping("marcas/{marca}/modelos/{modelo}/anos/{ano}")
    public Fipe findVehicles(@PathVariable("marca") String marca,
     @PathVariable("modelo") String modelo, @PathVariable("ano") String ano);
}
