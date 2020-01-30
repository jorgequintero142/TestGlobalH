package co.miingresohitts.ejb;

import co.miingresohitts.model.ClienteModel;
import co.miingresohitts.varios.ClienteDTO;
import co.miingresohitts.varios.ClienteHelper;
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
public class ClienteBean implements ClienteBeanLocal {

    @PersistenceContext(unitName = "hitssXE")
    private EntityManager em;

    @Override
    public void guardarCliente(ClienteDTO dto) {
        ClienteModel model = ClienteHelper.getClienteModel(dto);
        if (model.getIdCliente() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> listaDto = new ArrayList<>();
        List<ClienteModel> listaModel;

        ClienteModel pm = new ClienteModel();
        listaModel = em.createQuery("SELECT c FROM ClienteModel c ", ClienteModel.class).getResultList();
        if (listaModel != null && listaModel.size() > 0) {
            for (ClienteModel model : listaModel) {
                listaDto.add(ClienteHelper.getClienteDTO(model));
            }
        }
        return listaDto;
    }
}
