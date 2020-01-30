package co.miingresohitts.ejb;

import co.miingresohitts.model.VentaModel;
import co.miingresohitts.varios.VentaDTO;
import co.miingresohitts.varios.VentaHelper;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class VentaBean implements VentaBeanLocal {

    @PersistenceContext(unitName = "hitssXE")
    private EntityManager em;

    @Override
    public void realizarVenta(List<VentaDTO> listaVenta) {

        for (VentaDTO venta : listaVenta) {
            VentaModel model = VentaHelper.getModel(venta);
            em.persist(model);
            em.flush();

        }

    }
}
