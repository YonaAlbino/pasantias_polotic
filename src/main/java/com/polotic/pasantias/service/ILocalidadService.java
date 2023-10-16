/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Localidad;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface ILocalidadService {

    public void saveLocalidad(Localidad localidad);

    public List<Localidad> getLocalidades();

    public Localidad findLocalidad(Long id);

    public void editLocalidad(Localidad nivel);

    public void deleteLocalidad(Long id);

}
