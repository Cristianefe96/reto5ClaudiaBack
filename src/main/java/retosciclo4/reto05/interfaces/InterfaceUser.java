package retosciclo4.reto05.interfaces;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import retosciclo4.reto05.model.User;



public interface InterfaceUser extends MongoRepository<User, Integer>{
    Optional<User> findByEmail (String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findTopByOrderByIdDesc();
    List<User> findBybirthtDay(Date date);
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
