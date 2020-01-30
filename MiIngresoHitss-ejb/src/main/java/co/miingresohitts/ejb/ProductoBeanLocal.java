package co.miingresohitts.ejb;


import co.miingresohitts.varios.ProductoDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface ProductoBeanLocal {
    public void guardarProducto(ProductoDTO dto);

    public List<ProductoDTO> listarProductos();
}
