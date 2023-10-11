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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Modelo_pasante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_modelo_pasante;

    private String meses_tentativos;
    private int cupo;
    private String tareas_a_realizar;
    private String objetivo_PPS;
    private String dias_preferenciales;
    private String horario_preferencial;
    private String consentimiento;

    @OneToOne
    @JoinColumn(name = "lugar_de_Realizacion",
            referencedColumnName = "id_lugar_realizacion")
    private Lugar_realizacion unLugar_realizacion;

    @OneToOne
    @JoinColumn(name = "id_area",
            referencedColumnName = "id_area")
    private Area unArea;

    @OneToOne
    @JoinColumn(name = "id_modalidad",
            referencedColumnName = "id_modalidad")
    private Modalidad unaModalidad;

    @OneToMany(mappedBy = "unModelo_pasante")
    private List<Persona> listaPersonas;
}
