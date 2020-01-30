package co.miingresohitts.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "PRODUCTO")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_producto")
    private Long idProducto;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "desc_producto")
    private String descripcionProducto;
    @Column(name = "precio")
    private BigDecimal precioProducto;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}
