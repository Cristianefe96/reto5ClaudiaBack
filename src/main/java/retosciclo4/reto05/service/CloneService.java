package retosciclo4.reto05.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retosciclo4.reto05.model.Clone;
import retosciclo4.reto05.repository.CloneRepository;

@Service
public class CloneService {
    @Autowired
    private CloneRepository cloneRepository;
    private Clone cloneEq;

    public List<Clone> getAll() {
        return cloneRepository.getAll();
    }

    public Optional<Clone> getCloneEq(Integer id) {
        return cloneRepository.getCloneEq(id);
    }

    public Clone create(Clone cloneEq) {
        if (cloneEq.getId() == null) {
            return cloneEq;
        } else {
            return cloneRepository.create(cloneEq);
        }
    }

    public Clone update(Clone cloneEq) {

        if (cloneEq.getId() != null) {
            Optional<Clone> cloneEqDb = cloneRepository.getCloneEq(cloneEq.getId());
            if (!cloneEqDb.isEmpty()) {
                
                if (cloneEq.getBrand()!= null) {
                    cloneEqDb.get().setBrand(cloneEq.getBrand());
                }
                
                if (cloneEq.getProcesor() != null) {
                    cloneEqDb.get().setProcesor(cloneEq.getProcesor());
                }

                if (cloneEq.getOs() != null) {
                    cloneEqDb.get().setOs(cloneEq.getOs());
                }
                
                if (cloneEq.getDescription() != null) {
                    cloneEqDb.get().setDescription(cloneEq.getDescription());
                }

                if (cloneEq.getMemory() != null) {
                    cloneEqDb.get().setMemory(cloneEq.getMemory());
                }

                if (cloneEq.getHardDrive() != null) {
                    cloneEqDb.get().setHardDrive(cloneEq.getHardDrive());
                }

                if (cloneEq.getPrice() != 0.0) {
                    cloneEqDb.get().setPrice(cloneEq.getPrice());
                }

                if (cloneEq.getQuantity() != 0) {
                    cloneEqDb.get().setQuantity(cloneEq.getQuantity());
                }
                
                if (cloneEq.getPhotography() != null) {
                    cloneEqDb.get().setPhotography(cloneEq.getPhotography());
                }
                cloneEqDb.get().setAvailability(cloneEq.isAvailability());
                cloneRepository.update(cloneEqDb.get());
                return cloneEqDb.get();
            } else {
                this.cloneEq = cloneEq;
                return this.cloneEq;
            }
        } else {
            return cloneEq;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getCloneEq(id).map(cloneEq -> {
            cloneRepository.delete(cloneEq);
            return true;
        }).orElse(false);
        return aBoolean;
    }

        //Reto 5
   public List<Clone> productByPrice(double price) {
    return cloneRepository.productByPrice(price);
}

public List<Clone> findByDescriptionLike(String description) {
    return cloneRepository.findByDescriptionLike(description);
}
}
