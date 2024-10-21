package  com.products.repository;
import com.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product, Integer > {

}
