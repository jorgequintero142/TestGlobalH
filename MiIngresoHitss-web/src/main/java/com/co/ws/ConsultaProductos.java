package com.co.ws;

import co.miingresohitts.ejb.ProductoBeanLocal;
import co.miingresohitts.varios.ProductoDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;


/**
 *
 * @author jorge
 */
@WebService(serviceName = "ConsultaProductos")
@Stateless()
public class ConsultaProductos {
    @EJB
    private ProductoBeanLocal ejbRef;

   

    @WebMethod(operationName = "listarProductos")
    public List<ProductoDTO> listarProductos() {
        return ejbRef.listarProductos();
    }
    
}
