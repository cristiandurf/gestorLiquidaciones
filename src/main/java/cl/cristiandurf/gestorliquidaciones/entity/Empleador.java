package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 16-07-2023
 */
@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleador") //parámetro es una colum en nuestra tabla definida
    private int idEmpleador;
    @Column(unique = true)
    private int run;
    @Column(length = 100)
    private String nombre;
    @Column(name = "apellido_1", length = 100)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;
    @Column(length = 500)
    private String direccion;
    @Column(length = 100)
    private String email;

    //relacion empleador-usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private long telefono;

    //relacion empleador-trabajador
    @ManyToMany(mappedBy = "empleadores")
    List<Trabajador> listaTrabajadores;

    public void setFechaCreacion(LocalDateTime localDateTime) {
    }
}
