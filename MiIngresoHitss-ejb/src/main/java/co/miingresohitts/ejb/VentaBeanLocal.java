package co.miingresohitts.ejb;

import co.miingresohitts.varios.VentaDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface VentaBeanLocal {

    public void realizarVenta(List<VentaDTO> venta);
}
