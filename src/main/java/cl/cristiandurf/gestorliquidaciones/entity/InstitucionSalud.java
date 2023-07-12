package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy = "institucionSalud")
    List<Trabajador> listaTrabajadores;

    //relacion salud-liquidacion
    @OneToMany(mappedBy = "institucionSalud")
    List<Liquidacion> listaLiquidaciones;

}
