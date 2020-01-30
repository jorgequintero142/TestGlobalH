package co.miingresohitts.varios;

import co.miingresohitts.model.ClienteModel;

/**
 *
 * @author jorge
 */
public class ClienteHelper {

    public static ClienteDTO getClienteDTO(ClienteModel model) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(model.getIdCliente());
        dto.setNombreCompleto(model.getNombreCompleto());
        dto.setNumDocumento(model.getNumDocumento());
        dto.setTipoDocumento(model.getTipoDocumento());
        return dto;
    }

    public static ClienteModel getClienteModel(ClienteDTO dto) {
        ClienteModel model = new ClienteModel();
        model.setIdCliente(dto.getIdCliente());
        model.setNombreCompleto(dto.getNombreCompleto());
        model.setNumDocumento(dto.getNumDocumento());
        model.setTipoDocumento(dto.getTipoDocumento());
        return model;
    }
}
