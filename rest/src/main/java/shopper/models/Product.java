package shopper.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * The actual product which belongs to the cart
 * the cart can have multiple products
 */
public class Product {
    public Product() { //empty constructor

    }

    public Product(String id){
        setId(id);
    }

    public Product(String name, String description, String picture, int quantity,
                   float price) {
        setName(name);
        this.description = description;
        this.picture = picture;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = new Date();
    }

    //the id of the product
    @Id
    private String id;

    //The name of the product
    @JsonProperty("name")
    private String name;

    //The description of the product
    private String description;

    //The picture of the product
    //in production this would be mapped to a different model and
    //would support an array of images
    private String picture;

    //The quantity as chosen by the user
    private int quantity;

    //The price of the product
    private float price;

    //when the product was created
    private Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Increments the quantity of the product
     */
    public void plusOne(){
        setQuantity(getQuantity() + 1);
    }
}
