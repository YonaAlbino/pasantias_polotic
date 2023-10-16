/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.model.Contacto;
import java.util.List;

/**
 *
 * @author yonat
 */
public interface IContactoService {

    public List<Contacto> getContactos();

    public void saveContacto(Contacto contacto);

    public Contacto findContacto(Long id);

    public void deleteContacto(Long id);

    public void editContacto(Contacto contacto);

}
