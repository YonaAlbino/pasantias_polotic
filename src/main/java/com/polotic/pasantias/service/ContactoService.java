/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.service;

import com.polotic.pasantias.excepciones.ListaVaciaException;
import com.polotic.pasantias.excepciones.RegistroNullException;
import com.polotic.pasantias.model.Contacto;
import com.polotic.pasantias.repository.IContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContactoService {

    @Autowired
    private IContactoRepository contactoRepo;

    @Override
    public List<Contacto> getContactos() {
        List<Contacto> listaContactos = contactoRepo.findAll();
        if (!listaContactos.isEmpty()) {
            return listaContactos;
        } else {
            throw new ListaVaciaException("La lista de contactos esta vacia");
        }
    }

    public void saveContacto(Contacto contacto) {
        contactoRepo.save(contacto);
    }

    @Override
    public Contacto findContacto(Long id) {
        Contacto contacto = contactoRepo.findById(id).orElse(null);
        if (contacto != null) {
            return contacto;
        } else {
            throw new RegistroNullException("El contacto al que quieres tener acceso no existe en la base de datos");
        }

    }

    @Override
    public void deleteContacto(Long id) {
        Contacto contacto = this.findContacto(id);
        contactoRepo.deleteById(id);
    }

    @Override
    public void editContacto(Contacto contacto) {
        this.saveContacto(contacto);
    }

}
