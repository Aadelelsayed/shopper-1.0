package shopper.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import shopper.models.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {

}
