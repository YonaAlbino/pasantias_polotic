/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.model.Nivel;
import com.polotic.pasantias.repository.INivelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelService implements INivelService {

    @Autowired
    private INivelRepository nivelRepo;

    @Override
    public void saveNivel(Nivel nivel) {
        nivelRepo.save(nivel);
    }

    @Override
    public List<Nivel> getNiveles() {
        List<Nivel> listaNiveles = nivelRepo.findAll();
        if (!listaNiveles.isEmpty()) {
            return listaNiveles;
        } else {
            throw new ListaVaciaException("La lista de niveles esta vacia");
        }
    }

    @Override
    public Nivel findNivel(Long id) {
        Nivel nivel = nivelRepo.findById(id).orElse(null);
        if(nivel != null)
            return nivel;
        else
            throw new RegistroNullException("El nivel que estas buscando no existe en la base de datos");
    }

    @Override
    public void editNivel(Nivel nivel) {
        this.saveNivel(nivel);
    }

    @Override
    public void deleteNivel(Long id) {
        nivelRepo.deleteById(id);
    }

}
