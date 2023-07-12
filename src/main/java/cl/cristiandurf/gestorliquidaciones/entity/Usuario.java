package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.dialect.function.TruncFunction;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @Column(name = "apelliedo_1", length = 100)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    //relacion usuario-perfil
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Column(length = 100)
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;

    //relacion usuario-empleador
    @OneToMany(mappedBy = "usuario")
    List<Empleador> listaEmpleadores;
}
