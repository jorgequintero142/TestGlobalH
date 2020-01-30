package co.miingresohitts.ejb;

import co.miingresohitts.model.ProductoModel;
import co.miingresohitts.varios.ProductoDTO;
import co.miingresohitts.varios.ProductoHelper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class ProductoBean implements ProductoBeanLocal {

    @PersistenceContext(unitName = "hitssXE")
    private EntityManager em;

    @Override
    public void guardarProducto(ProductoDTO dto) {
        ProductoModel model = ProductoHelper.getProductoModel(dto);
        if (model.getIdProducto() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }

    }

    @Override
    public List<ProductoDTO> listarProductos() {

        List<ProductoDTO> listaDto = new ArrayList<>();
        List<ProductoModel> listaModel;

        ProductoModel pm = new ProductoModel();
        listaModel = em.createQuery("SELECT p FROM ProductoModel p ", ProductoModel.class).getResultList();
        if (listaModel != null && listaModel.size() > 0) {
            for (ProductoModel model : listaModel) {
                listaDto.add(ProductoHelper.getProductoDTO(model));
            }
        }
        return listaDto;
    }

}
