package productcrudapp.service;

import productcrudapp.model.Product;
import productcrudapp.dao.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAOImpl productDAO;

    public void createProduct(Product product){
        productDAO.create(product);
    }

    public Product getProductById(int id){
        return productDAO.read(id);
    }

    public List<Product> getAllProducts(){
        return productDAO.readAll();
    }
    
    public void updateProduct(Product product){
        productDAO.update(product);
    }

    public void deleteProduct(int id){
        productDAO.delete(id);
    }
}
