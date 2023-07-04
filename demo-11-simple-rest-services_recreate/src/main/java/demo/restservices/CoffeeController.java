package demo.restservices;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coffee")
@CrossOrigin
public class CoffeeController {

    private Map <Long,Coffee> menu= new HashMap<>();
    {
        menu.put(1L,new Coffee(1L,"Makiato",8.50));
        menu.put(2L,new Coffee(2L,"Late",10.50));
        menu.put(3L,new Coffee(3L,"Mocchacino",12.50));

    }

@GetMapping("/products")
    public Collection<Coffee> getProducts(){
        return menu.values();
}

@GetMapping("/products2")
    public ResponseEntity<Collection<Coffee>> getProducts2(){
        return ResponseEntity.ok().body(menu.values());
}

@GetMapping("/products/{id}")
    public ResponseEntity<Coffee> getProductsById(@PathVariable  long id){
        Coffee c = menu.get(id);
                if (c==null)
                    return ResponseEntity.notFound().build();
                else
                    return ResponseEntity.ok().body(c);
}

@GetMapping("/productsM/min")
    public ResponseEntity<Collection<Coffee>>getProductsMoreThan(@RequestParam(value="min", required=false, defaultValue="9.0")double min){
        Collection<Coffee> prods=menu.values()
                .stream()
                .filter(c ->c.getPrice()>min)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(prods);
}


}
