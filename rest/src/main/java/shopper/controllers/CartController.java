package shopper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopper.models.Cart;
import shopper.models.Product;
import shopper.repositories.CartRepository;
import shopper.repositories.ProductRepository;
import shopper.requests.AddProductRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController extends BaseController {

    @Autowired
    private CartRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/cart")
    public List<Cart> getAll(){
        return repository.findAll();
    }

    @RequestMapping("/cart/get")
    public Cart get(@RequestParam(name = "id") String id){
        if(id == null || id.isEmpty())
            throw404();

        Cart cart = repository.findOne(id);
        cart.products = getProducts(id);

        if(cart == null) throw404();

        return cart;
    }

    @RequestMapping("/cart/getProducts")
    public List<Product> getProducts(@RequestParam(name = "id") String id){
        if(id == null) throw404();

        List<Product> tempProducts = new ArrayList<>();

        for(String productId : repository.findOne(id).getProductsIds()) {
            tempProducts.add(productRepository.findOne(productId));
        }

        return tempProducts;
    }

    @RequestMapping(path = "/cart/create", method = RequestMethod.POST)
    public ResponseEntity<Cart> create(@RequestParam(name = "session_id") String sessionId){
        return new ResponseEntity<Cart>(repository.insert(new Cart(sessionId)), HttpStatus.OK);
    }

    @RequestMapping(path = "/cart/addProduct", method = RequestMethod.POST)
    public HttpStatus addProduct(
            @RequestBody AddProductRequest request){
        System.out.print(request.getCartId());
        System.out.print(request.getProductId());

        if(request.getProductId() == null || request.getCartId()== null)
            return HttpStatus.BAD_REQUEST;

        Cart cart = repository.findOne(request.getCartId());

        cart.addProduct(request.getProductId());
        repository.save(cart);

        return HttpStatus.OK;
    }

    @RequestMapping(path = "/cart/removeProduct", method = RequestMethod.POST)
    public HttpStatus removeProduct(@RequestBody AddProductRequest request) {
        if(request.getProductId() == null || request.getCartId() == null) return HttpStatus.BAD_REQUEST;

        Cart cart = repository.findOne(request.getCartId());

        cart.removeProduct(request.getProductId());
        repository.save(cart);

        return HttpStatus.OK;
    }
}
