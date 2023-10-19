/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Lugar_realizacion;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface ILugarRealizacionService {

    public List<Lugar_realizacion> getLugarDeRealizacion();

    public void saveLugarRealizacion(Lugar_realizacion lugar_realizacion);

    public void deleteLugarRealizacion(Long id);

    public Lugar_realizacion findLugarRealizacion(Long id);

    public void editLugarRealizacion(Lugar_realizacion lugar_realizacion);
}
