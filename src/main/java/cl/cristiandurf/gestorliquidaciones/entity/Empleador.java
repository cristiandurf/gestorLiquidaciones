package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    private int direccion;
    @Column(length = 100)
    private String email;

    //relacion empleador-usuario
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private long telefono;

    //relacion empleador-trabajador utilizando "tabla intermedia"
    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_empleador"),
            inverseJoinColumns = @JoinColumn(name = "id_trabajador"))
    List<Trabajador> listaTrabajadores;
}
