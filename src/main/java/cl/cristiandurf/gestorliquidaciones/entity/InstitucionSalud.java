package cl.cristiandurf.gestorliquidaciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 16-07-2023
 */
@Data
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {
    @Id
    @Column(name = "id_inst_salud")
    private int idInstSalud;
    @Column(length = 100)
    private String descripcion;
    @Column(name = "porc_dcto")
    private Float porcDcto;

    //relacion salud-trabajador
    @JsonIgnore
    @OneToMany(mappedBy = "instSalud")
    List<Trabajador> listaTrabajadores;

    //relacion salud-liquidacion
    @JsonIgnore
    @OneToMany(mappedBy = "instSalud")
    List<Liquidacion> listaLiquidaciones;

}
