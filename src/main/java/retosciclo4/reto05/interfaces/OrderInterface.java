package retosciclo4.reto05.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import retosciclo4.reto05.model.Order;

public interface OrderInterface extends MongoRepository<Order, Integer>{
    
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
