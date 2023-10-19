/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Institucion;
import com.polotic.pasantias.repository.IInstitucionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionService implements IIinstitucionService {

    @Autowired
    private IInstitucionRepository institucionRepo;

    @Override
    public List<Institucion> getInstituciones() {
        List<Institucion> listaInstituciones = institucionRepo.findAll();
        if(!listaInstituciones.isEmpty())
            return listaInstituciones;
        else 
            throw new ListaVaciaException("La lista de instituciones se encuentra vacía");
    }

    @Override
    public void saveInstitucion(Institucion institucion) {
        institucionRepo.save(institucion);
    }

    @Override
    public Institucion findInstitucion(Long id) {
        Institucion institucion = institucionRepo.findById(id).orElse(null);
        if(institucion != null)
            return institucion;
        else
            throw new RegistroNullException("La institución que estas buscando no se encuentra en la base de datos");
    }

    @Override
    public void deleteInsitucion(Long id) {
        institucionRepo.deleteById(id);
    }

    @Override
    public void editInstitucion(Institucion institucion) {
        this.saveInstitucion(institucion);
    }

}
