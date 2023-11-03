/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Reunion;
import com.polotic.pasantias.repository.IReunionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReunionService implements IReunionService {

    @Autowired
    private IReunionRepository reunionRepo;

    @Override
    public List<Reunion> getReuniones() {
        List<Reunion> listaReuniones = reunionRepo.findAll();
        if (!listaReuniones.isEmpty()) {
            return listaReuniones;
        } else {
            throw new ListaVaciaException("La lista de reuniones esta vacia");
        }
    }

    @Override
    public void saveReunion(Reunion reunion) {
        reunionRepo.save(reunion);
    }

    @Override
    public void deleteReunion(Long id) {
        reunionRepo.deleteById(id);
    }

    @Override
    public Reunion findReunion(Long id) {
        Reunion reunion = reunionRepo.findById(id).orElse(null);
        if (reunion != null) {
            return reunion;
        } else {
            throw new RegistroNullException("La reunion que estas buscando no se encuentra en la base de datos");
        }
    }

    @Override
    public void editReunion(Reunion reunion) {
        this.saveReunion(reunion);
    }

}
