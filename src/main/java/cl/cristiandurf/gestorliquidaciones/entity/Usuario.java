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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(unique = true)
    private int run;
    @Column(length = 200)
    private String clave;
    @Column(length = 100)
    private String nombre;
    @Column(name = "apellido_1", length = 100)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    //relacion usuario-perfil
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Column(length = 100)
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;

    //relacion usuario-empleador
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    List<Empleador> listaEmpleadores;
}
