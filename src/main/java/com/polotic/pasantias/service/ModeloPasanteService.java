/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Modelo_pasante;
import com.polotic.pasantias.repository.IMoldeloPasanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloPasanteService implements IModeloPasanteService{
    
    @Autowired
    private IMoldeloPasanteRepository modeloRepo;

    @Override
    public List<Modelo_pasante> getModeloPasantes() {
      List<Modelo_pasante> listaModelos = modeloRepo.findAll();
      if(!listaModelos.isEmpty())
          return listaModelos;
      else 
          throw new ListaVaciaException("La lista de modelos pasantes esta vacía");
    }

    @Override
    public void saveModeloPasante(Modelo_pasante modelo_pasante) {
        modeloRepo.save(modelo_pasante);
    }

    @Override
    public void deleteModeloPasante(Long id) {
        modeloRepo.deleteById(id);
    }

    @Override
    public Modelo_pasante findModeloPasante(Long id) {
        Modelo_pasante modelo_pasante = modeloRepo.findById(id).orElse(null);
        if(modelo_pasante != null)
            return modelo_pasante;
        else
            throw new RegistroNullException("El modelo de pasante que estas buscando no existe en la base de datos");
    }

    @Override
    public void editModeloPasante(Modelo_pasante modelo_pasante) {
        this.saveModeloPasante(modelo_pasante);
    }
    
}
