package shopper.models;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The cart object which will hold all the
 * products added. In production env it will
 * mapped to the actual user
 */
public class Cart {
    public Cart() {
        //empty constructor
    }

    public Cart(String sessionId){
        setSessionId(sessionId);
        setCreatedAt(new Date());
    }

    //The id of the cart
    @Id
    private String id;

    //The owner of the cart if not a guest
    private String userId;

    //Specific session id of the cart stored to allow
    //for later visit retrieval
    private String sessionId;

    //when the cart was created
    private Date createdAt;

    //when the cart was checkout at
    //used to later determine if the cart should be archived (deleted)
    private Date checkoutAt;

    //list of products held by the cart
    private List<String> productIds;

    //List of actual products that were mapped
    @Ignore
    public List<Product> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCheckoutAt() {
        return checkoutAt;
    }

    public void setCheckoutAt(Date checkoutAt) {
        this.checkoutAt = checkoutAt;
    }

    public List<String> getProductsIds() {
        return productIds;
    }

    public void setProductsIds(List<String> products) {
        this.productIds = products;
    }

    /**
     * Adds a new product to the cart
     * @param productId the target productId
     */
    public void addProduct(String productId){
        if(getProductsIds() == null)
            setProductsIds(new ArrayList<>());

        getProductsIds().add(productId);
    }

    /**
     * Removes the productId from the list of products
     * @param productId
     */
    public void removeProduct(String productId){
        if(getProductsIds() != null){
            getProductsIds().remove(productId);
        }
    }

    /**
     * Check if the cart already has the product
     * @param productId the target product id
     * @return if the product exists
     */
    public boolean isHasProduct(String productId){
       return getProductsIds() != null && getProductsIds().indexOf(productId) != -1;
    }
}
