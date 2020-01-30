package com.hitss.bean;

import co.miingresohitts.ejb.VentaBeanLocal;
import co.miingresohitts.varios.ProductoDTO;
import co.miingresohitts.varios.VentaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author YUDY
 */
@Named(value = "ventaManagedBean")
@SessionScoped
@ManagedBean
public class VentaManagedBean {
    
    @EJB
    private VentaBeanLocal ejbVenta;
    
    private List<VentaDTO> listaventas;
    private Long idCliente;
    
    public Long getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    public List<VentaDTO> getListaventas() {
        return listaventas;
    }
    
    public void setListaventas(List<VentaDTO> listaventas) {
        this.listaventas = listaventas;
    }
    
    private boolean existeProducto(ProductoDTO producto) {
        for (VentaDTO venta : listaventas) {
            if (producto.getIdProducto() == venta.getProducto().getIdProducto()) {
                return true;
            }
        }
        return false;
    }
    
    public void addProducto(ProductoDTO producto) {
        if (listaventas == null) {
            listaventas = new ArrayList<>();
        }
        
        if (listaventas != null && listaventas.size() > 0) {
            if (existeProducto(producto)) {
                for (VentaDTO venta : listaventas) {
                    if (producto.getIdProducto() == venta.getProducto().getIdProducto()) {
                        venta.setCantidad(venta.getCantidad() + 1);
                    }
                }
            } else {
                addVenta(producto);
            }
            
        } else {
            addVenta(producto);
        }
        
    }
    
    private void addVenta(ProductoDTO producto) {
        VentaDTO venta = new VentaDTO();
        venta.setCantidad(1);
        venta.setProducto(producto);
        listaventas.add(venta);
    }
    
    public void removeProducto(ProductoDTO dto) {
        if (listaventas != null) {
            for (VentaDTO venta : listaventas) {
                if (dto.getIdProducto() == venta.getProducto().getIdProducto()) {
                    listaventas.remove(venta);
                }
            }
        }
    }
    
    public void realizarVenta() {
        for(VentaDTO v: listaventas) {
         //v.setCliente(null);
        }
        ejbVenta.realizarVenta(listaventas);
    }
}
