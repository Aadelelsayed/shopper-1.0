package shopper.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddProductRequest {
    @JsonProperty("cart_id")
    private String cartId;

    @JsonProperty("product_id")
    private String productId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
