/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.controller;

import com.polotic.pasantias.model.Contacto;
import com.polotic.pasantias.service.IContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacto")
public class ContactoController {

    @Autowired
    private IContactoService contactoService;

    @GetMapping("/traer/todos")
    public ResponseEntity<List<Contacto>> getContactos() {
        List<Contacto> listaContacto = contactoService.getContactos();
        return new ResponseEntity<>(listaContacto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveContacto(@RequestBody Contacto contacto) {
        contactoService.saveContacto(contacto);
        return new ResponseEntity<>("Contacto creado exitosamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> deleteContacto(@RequestParam Long id) {
        contactoService.deleteContacto(id);
        return new ResponseEntity<>("Contacto eliminado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Contacto> findContacto(@RequestParam Long id) {
        Contacto contacto = contactoService.findContacto(id);
        return new ResponseEntity<>(contacto, HttpStatus.FOUND);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> editContacto(@RequestBody Contacto contacto) {
        contactoService.editContacto(contacto);
        return new ResponseEntity<>("El contacto fue modificiado exitosamente", HttpStatus.OK);
    }
}
