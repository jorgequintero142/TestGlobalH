package co.miingresohitts.ejb;

import co.miingresohitts.varios.ClienteDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author YUDY
 */
@Local
public interface ClienteBeanLocal {

    public void guardarCliente(ClienteDTO dto);

    public List<ClienteDTO> listarClientes();
}
