/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Modelo_pasante;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IModeloPasanteService {

    public List<Modelo_pasante> getModeloPasantes();

    public void saveModeloPasante(Modelo_pasante modelo_pasante);

    public void deleteModeloPasante(Long id);

    public Modelo_pasante findModeloPasante(Long id);

    public void editModeloPasante(Modelo_pasante modelo_pasante);
}
