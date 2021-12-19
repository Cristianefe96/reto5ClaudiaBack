package retosciclo4.reto05.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import retosciclo4.reto05.model.Clone;

public interface InterfaceCloneEq extends MongoRepository<Clone, Integer>{
    public List<Clone> findByPriceLessThanEqual(double precio);
    //Reto 5

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Clone> findByDescriptionLike(String description); 
}
