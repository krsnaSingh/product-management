package productcrudapp.service;


import productcrudapp.model.Product;

import java.util.List;

public interface ProductService {
    
    void createProduct(Product product);
    
    Product getProductById(int id);
    
    List<Product> getAllProducts();
    
    void updateProduct(Product product);
    
    void deleteProduct(int id);
}
