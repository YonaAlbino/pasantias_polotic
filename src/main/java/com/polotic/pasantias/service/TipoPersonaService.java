/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Tipo_persona;
import com.polotic.pasantias.repository.ITipoPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPersonaService implements ITipoPersonaService {

    @Autowired
    private ITipoPersonaRepository tipoRepo;

    @Override
    public List<Tipo_persona> getTiposPersona() {
        List<Tipo_persona> listaTipoPersonas = tipoRepo.findAll();
        if (!listaTipoPersonas.isEmpty()) {
            return listaTipoPersonas;
        } else {
            throw new ListaVaciaException("La lista de tipos de personas se encuentra vacia");
        }
    }

    @Override
    public void saveTipoPersona(Tipo_persona tipoPersona) {
        tipoRepo.save(tipoPersona);
    }

    @Override
    public void deleteTipoPersona(Long id) {
        tipoRepo.deleteById(id);
    }

    @Override
    public Tipo_persona findTipoPersona(Long id) {
        Tipo_persona tipo_persona = tipoRepo.findById(id).orElse(null);
        if(tipo_persona != null)
            return tipo_persona;
        else
            throw new RegistroNullException("El tipo de persona que estas buscando no existe en la base de datos");
    }

    @Override
    public void editTipoPersona(Tipo_persona tipoPersona) {
        this.saveTipoPersona(tipoPersona);
    }

}
