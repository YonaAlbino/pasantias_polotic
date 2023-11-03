/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Reunion;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IReunionService {

    public List<Reunion> getReuniones();

    public void saveReunion(Reunion reunion);

    public void deleteReunion(Long id);

    public Reunion findReunion(Long id);

    public void editReunion(Reunion reunion);

}
