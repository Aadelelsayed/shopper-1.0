package shopper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopper.models.Product;
import shopper.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController extends BaseController{

    @Autowired
    private ProductRepository repository;

    @RequestMapping("/product/get/{id}")
    public Product get(@PathVariable String id){
        if(id == null || id.isEmpty())
            throw404();

        Product product = repository.findOne(id);

        if(product == null)
            throw404();

        return product;
    }

    @RequestMapping("/product")
    public List<Product> getAll(){
        return repository.findAll();
    }


}
