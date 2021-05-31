package com.userOrange.services;

import java.util.Optional;

import com.userOrange.model.Fipe;
import com.userOrange.model.User;
import com.userOrange.model.Vehicle;
import com.userOrange.repositories.UserRepository;
import com.userOrange.repositories.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vRepo;

    @Autowired
    private UserRepository uRepo;

    @Autowired
    private FipeService fipeService;
    private Fipe fipe;

    public Vehicle insertVehicles(Vehicle vehicle) throws Exception {
        Optional<User> existingUser = uRepo.findByCpf(vehicle.getUser().getCpf());

        try {
            fipe = fipeService.findVehicles(vehicle.getMarca(), vehicle.getModelo(), vehicle.getAno());
        } catch (Exception e) {
            throw new Exception("Os dados informados não existem na tabela Fipe");
        }

        if (existingUser.isPresent()) {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setUser(existingUser.get());
            newVehicle.setMarca(fipe.getMarca());
            newVehicle.setAno(fipe.getAno());
            newVehicle.setModelo(fipe.getModelo());
            newVehicle.setValor(fipe.getValor());

            vRepo.save(newVehicle);

            existingUser.get().getVehicles().add(newVehicle);

            return newVehicle;

        } else {
            throw new Exception("O Usuário não foi cadastrado!");
        }
    }
}
