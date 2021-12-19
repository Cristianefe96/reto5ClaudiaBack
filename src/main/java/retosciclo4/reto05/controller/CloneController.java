package retosciclo4.reto05.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import retosciclo4.reto05.model.Clone;
import retosciclo4.reto05.service.CloneService;

@RestController
@RequestMapping("/api/clone")
@CrossOrigin("*")
public class CloneController {
    @Autowired
    private CloneService cloneService;

    @GetMapping("/all")
    public List<Clone> getAll() {
        return cloneService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Clone> getClone(@PathVariable("id") Integer id) {
        return cloneService.getCloneEq(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone create(@RequestBody Clone product) {
        return cloneService.create(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone product) {
        return cloneService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cloneService.delete(id);
    }

        //Reto 5
        @GetMapping("/price/{price}")
        public List<Clone> gadgetsByPrice(@PathVariable("price") double precio) {
            return cloneService.productByPrice(precio);
        }
        //Reto 5
        @GetMapping("/description/{description}")
        public List<Clone> findByDescriptionLike(@PathVariable("description") String description) {
            return cloneService.findByDescriptionLike(description);
        }
}
