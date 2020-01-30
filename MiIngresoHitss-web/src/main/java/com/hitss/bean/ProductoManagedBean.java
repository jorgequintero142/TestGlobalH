package com.hitss.bean;

import co.miingresohitts.ejb.ProductoBeanLocal;
import co.miingresohitts.varios.ProductoDTO;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author jorge
 */
@Named(value = "productoManagedBean")
@RequestScoped
@ManagedBean
public class ProductoManagedBean {

    @EJB
    private ProductoBeanLocal ejbProducto;

    /**
     * Creates a new instance of ProductoManagedBean
     */
    private String nombreProducto;
    private String descripcionProducto;
    private BigDecimal precioProducto;
    private List<ProductoDTO> listaProductos;
    private Long idProducto;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoBeanLocal getEjbProducto() {
        return ejbProducto;
    }

    public void setEjbProducto(ProductoBeanLocal ejbProducto) {
        this.ejbProducto = ejbProducto;
    }

    public List<ProductoDTO> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoDTO> listaProductos) {
        this.listaProductos = listaProductos;
    }

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

    public void guardarProducto() {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombreProducto(this.getNombreProducto());
        dto.setDescripcionProducto(this.getDescripcionProducto());
        dto.setPrecioProducto(this.getPrecioProducto());
        dto.setIdProducto(this.getIdProducto());
        ejbProducto.guardarProducto(dto);
    }

    public List<ProductoDTO> listarProductos() {
        return ejbProducto.listarProductos();
    }

    public void generarInformacion(ProductoDTO p){
    this.nombreProducto = p.getNombreProducto();
    this.precioProducto = p.getPrecioProducto();
    this.idProducto = p.getIdProducto();
    this.descripcionProducto = p.getDescripcionProducto();
    
    }
    public ProductoManagedBean() {

    }

}
