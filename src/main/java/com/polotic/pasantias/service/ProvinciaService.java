/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.model.Provincia;
import com.polotic.pasantias.repository.IProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepo;

    @Override
    public List<Provincia> getProvincia() {
        List<Provincia> lista = provinciaRepo.findAll();
        if (!lista.isEmpty()) {
            return lista;
        } else {
            throw new ListaVaciaException("La lista de provincias esta vacia");
        }
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        provinciaRepo.save(provincia);
    }

    @Override
    public void deleteProvincia(Long id) {
        provinciaRepo.deleteById(id);
    }

    @Override
    public Provincia findProvincia(Long id) {
        Provincia provincia = provinciaRepo.findById(id).orElse(null);
        return provincia;
    }

    @Override
    public void editProvincia(Provincia provincia) {
        this.saveProvincia(provincia);
    }

}
