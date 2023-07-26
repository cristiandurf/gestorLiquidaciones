package cl.cristiandurf.gestorliquidaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Cristian Durán
 * @version 0.0.1
 * @since 16-07-2023
 */
@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion")
    private long idLiquidacion;

    //relacion liquidacion-trabajador
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;

    @Column
    private LocalDate periodo;
    @Column(name = "sueldo_imponible")
    private int sueldoImponible;
    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;

    //relacion liquidacion-salud
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud")
    private InstitucionSalud instSalud;

    @Column(name = "monto_inst_salud")
    private int montoInstSalud;

    //relacion liquidacion-prevision
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_previsional")
    private InstitucionPrevision instPrevision;

    @Column(name = "monto_inst_previsional")
    private int montoInstPrevision;
    @Column(name = "total_descuento")
    private int totalDescuento;
    @Column(name = "total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;

    public void setFechaCreacion(LocalDateTime localDateTime) {
    }
}
