package co.miingresohitts.varios;

import co.miingresohitts.model.ProductoModel;

/**
 *
 * @author jorge
 */
public class ProductoHelper {

    public static ProductoDTO getProductoDTO(ProductoModel model) {
        ProductoDTO dto = new ProductoDTO();
        dto.setDescripcionProducto(model.getDescripcionProducto());
        dto.setIdProducto(model.getIdProducto());
        dto.setNombreProducto(model.getNombreProducto());
        dto.setPrecioProducto(model.getPrecioProducto());
        return dto;
    }

    public static ProductoModel getProductoModel(ProductoDTO dto) {
        ProductoModel model = new ProductoModel();
        model.setDescripcionProducto(dto.getDescripcionProducto());
        model.setIdProducto(dto.getIdProducto());
        model.setNombreProducto(dto.getNombreProducto());
        model.setPrecioProducto(dto.getPrecioProducto());
        return model;
    }
}
