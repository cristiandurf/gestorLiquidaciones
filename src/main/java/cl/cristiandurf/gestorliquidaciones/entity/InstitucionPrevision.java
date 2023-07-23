package cl.cristiandurf.gestorliquidaciones.entity;

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
@Table(name = "institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name = "id_inst_prevision")
    private int idInstPrevision;
    @Column(length = 50)
    private String descripcion;
    @Column(name = "porc_dcto")
    private Float porcDcto;

    //relacion prevision-trabajador
    @OneToMany(mappedBy = "instPrevision")
    List<Trabajador> listaTrabajadores;

    //relacion prevision-liquidacion
    @OneToMany(mappedBy = "institucionPrevision")
    List<Liquidacion> listaLiquidaciones;
}
