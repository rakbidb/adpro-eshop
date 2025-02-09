package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product edit(Product product, int idx) {
        productData.set(idx, product);
        return product;
    }
    
    public Product delete(Product product) {
        productData.remove(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product getProductById(UUID id) {
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    public int getProductIdx(Product product) {
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(product.getProductId())) {
                return i;
            }
        }
        return -1;
    }
}