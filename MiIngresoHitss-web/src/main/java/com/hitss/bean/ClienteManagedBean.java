package com.hitss.bean;

import co.miingresohitts.ejb.ClienteBeanLocal;
import co.miingresohitts.varios.ClienteDTO;
import co.miingresohitts.varios.DocEnum;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jorge
 */
@Named(value = "clienteManagedBean")
@RequestScoped
@ManagedBean
public class ClienteManagedBean {

    @EJB
    private ClienteBeanLocal ejbCliente;
    private Long idCliente;
    private String nombreCompleto;
    private String tipoDocumento;
    private String numDocumento;
    private DocEnum[] listaDocs;

    public DocEnum[] getListaDocs() {
        return DocEnum.values();
    }

    public void setListaDocs(DocEnum[] listaDocs) {
        this.listaDocs = listaDocs;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void guardarCliente() {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(idCliente);
        dto.setNombreCompleto(nombreCompleto);
        dto.setNumDocumento(numDocumento);
        dto.setTipoDocumento(tipoDocumento);
        ejbCliente.guardarCliente(dto);
    }

    public List<ClienteDTO> listarClientes() {
        return ejbCliente.listarClientes();
    }

    public void generarInformacion(ClienteDTO dto) {
        this.idCliente = dto.getIdCliente();
        this.nombreCompleto = dto.getNombreCompleto();
        this.numDocumento = dto.getNumDocumento();
        this.tipoDocumento = dto.getTipoDocumento();
    }

    public ClienteManagedBean() {
    }

}
