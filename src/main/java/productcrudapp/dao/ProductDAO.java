package productcrudapp.dao;

import productcrudapp.model.Product;

import java.util.List;

public interface ProductDAO {
    
    void create(Product product);
    
    Product read(int id);
    
    List<Product> readAll();
    
    void update(Product product);
    
    void delete(int id);
}
