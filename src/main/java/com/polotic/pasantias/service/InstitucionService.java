/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveInstitucion(Institucion institucion) {
        institucionRepo.save(institucion);
    }

}
