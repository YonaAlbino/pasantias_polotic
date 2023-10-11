/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polotic.pasantias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_institucion;

    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "rela_institucion_nivel",
            joinColumns = @JoinColumn(name = "FK_INSTITUCION", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_NIVEL", nullable = false)
    )
    private List<Nivel> listaNiveles;
    
    @OneToOne
    @JoinColumn(name = "id_contacto",
            referencedColumnName = "id_contacto")
    private Contacto unContacto;
    
    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad unaLocalidad;
}
