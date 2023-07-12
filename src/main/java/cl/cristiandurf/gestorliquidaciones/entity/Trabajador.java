package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Column(unique = true)
    private int run;
    @Column(length = 100)
    private String nombre;
    @Column(name = "apellido_1", length = 100)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;
    @Column(length = 100)
    private String email;

    //relacion trabajador-prevision
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inst_prevision")
    private InstitucionPrevision institucionPrevision;

    //relacion trabajador-salud
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud institucionSalud;

    @Column
    private int telefono;
}