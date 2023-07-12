package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //atajo para el método ToString, Getter, Setter y constructores, viene del lombok
@Entity //conecta la class con la BD, viene del spring
@Table(name = "perfil") //nombre de la tabla en la BD
public class Perfil {
    @Id
    @Column(name = "id_perfil")
    private int idPerfil;
    @Column(length = 50)
    private String descripcion;
    @Column
    private boolean estado;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;
}
