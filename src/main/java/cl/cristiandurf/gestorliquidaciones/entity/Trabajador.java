package cl.cristiandurf.gestorliquidaciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 16-07-2023
 */
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

    //relacion trabajador-salud
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud instSalud;

    //relacion trabajador-prevision
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_inst_prevision")
    private InstitucionPrevision instPrevision;

    @Column
    private long telefono;

    @JsonIgnore
    @ManyToMany //tabla intermedia, se genera acá porque cuando se crea un trabajador, se necesita agregar un empleador
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            inverseJoinColumns = @JoinColumn(name = "id_empleador"))
    private List<Empleador> empleadores;

    public void setFechaCreacion(LocalDateTime localDateTime) {
    }
}
