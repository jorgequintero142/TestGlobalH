package co.miingresohitts.varios;

import co.miingresohitts.model.VentaModel;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class VentaHelper {

    public static VentaModel getModel(VentaDTO dto) {
        VentaModel model = new VentaModel();
        model.setIdProducto(dto.getProducto().getIdProducto());
        model.setCantidad(dto.getCantidad());
        model.setIdCliente(dto.getCliente().getIdCliente());
        model.setFecha(new Date());
        return model;
    }
}
