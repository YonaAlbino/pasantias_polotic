/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Localidad;
import com.polotic.pasantias.repository.ILocalidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService implements ILocalidadService {

    @Autowired
    private ILocalidadRepository localidadRepo;

    @Override
    public void saveLocalidad(Localidad localidad) {
        localidadRepo.save(localidad);
    }

    @Override
    public List<Localidad> getLocalidades() {
        List<Localidad> listaLocalidades = localidadRepo.findAll();
        if (listaLocalidades.isEmpty()) {
            throw new RegistroNullException("La lista de localidades se encuentra vacia");
        } else {
            return listaLocalidades;
        }
    }

    @Override
    public Localidad findLocalidad(Long id) {
        Localidad localidad = localidadRepo.findById(id).orElse(null);
        if (localidad != null) {
            return localidad;
        } else {
            throw new RegistroNullException("La localidad que estas buscando no existe en la base de datos");
        }
    }

    @Override
    public void editLocalidad(Localidad nivel) {
        this.saveLocalidad(nivel);
    }

    @Override
    public void deleteLocalidad(Long id) {
        localidadRepo.deleteById(id);
    }

}
