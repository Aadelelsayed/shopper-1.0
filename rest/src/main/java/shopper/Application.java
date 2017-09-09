package shopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shopper.models.Product;
import shopper.repositories.CartRepository;
import shopper.repositories.ProductRepository;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }


    public void run(ApplicationArguments args) {
        productRepository.deleteAll();
        cartRepository.deleteAll();

        productRepository.save(new Product(
                "Sony W800/S 20.1 MP Digital Camera (Silver)",
                "MP Super HAD CCD sensor for beautifully detailed images Sony Lens w/ 5x Optical Zoom Reduced blur with SteadyShot Image stabilization Capture your videos in 720p HD Movie mode Simplify camera menu with Easy Mode Take stunning images in Sweep Panorama mode-up to 360 Smile Shutter technology automatically captures smiles Creative shooting with Picture Effects Conveniently charge your battery via USB3 In camera guide helps navigate features",
                "https://images-na.ssl-images-amazon.com/images/I/61fIEs7CAuL._SL1200_.jpg",
                1,
                94.00f
        ));

        productRepository.save(new Product(
                "Balance Bikes for Children Baby Walker ride on toy No Foot Pedal",
                "New: A brand-new, unused, unopened, undamaged item (including handmade items). See the seller's listing for full details.",
                "https://i.ebayimg.com/images/g/1EcAAOSwCU1YyUDX/s-l500.jpg",
                1,
                38.00f
        ));

        productRepository.save(new Product(
                "500ml Plastic Outdoor Camping Travel Sport Portable Fruit Juice Water Bottle Cup",
                "New: A brand-new, unused, unopened, undamaged item in its original packaging (where packaging is applicable). Packaging should be the same as what is found in a retail store, unless the item is handmade or was packaged by the manufacturer in non-retail packaging, such as an unprinted box or plastic bag. See the seller's listing for full details.",
                "https://i.ebayimg.com/images/g/fYgAAOSw2xRYmZWE/s-l500.jpg",
                1,
                5.96f
        ));

        productRepository.save(new Product(
                "HP 17.3 12GB Powerful Gaming Laptop 3.40GHz A12 QuadCore 2TB AMD Radeon R7 WIN10\n",
                "This Powerful HP Notebook has a 17.3\" HD+ SVA display supported by Integrated AMD Radeon™ R7 Graphics and DTS Studio Sound™",
                "http://i.ebayimg.com/images/g/Dt8AAOSwR29ZGiGg/s-l1600.jpg",
                1,
                94.00f
        ));
    }
}
