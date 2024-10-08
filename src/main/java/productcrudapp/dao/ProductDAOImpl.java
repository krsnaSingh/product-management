package productcrudapp.dao;

import productcrudapp.exception.ProductNotFoundException; 
import productcrudapp.model.Product;
import productcrudapp.mapper.ProductMapper; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    
    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_PRODUCT = "INSERT INTO Product (name, price, description) VALUES (?, ?, ?)";
    private final String UPDATE_PRODUCT = "UPDATE Product SET name = ?, price = ?, description = ? WHERE id = ?";
    private final String DELETE_PRODUCT = "DELETE FROM Product WHERE id = ?";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM Product WHERE id = ?";
    private final String SELECT_ALL_PRODUCTS = "SELECT * FROM Product";

    public void create(Product product){
        try {
            jdbcTemplate.update(INSERT_PRODUCT, product.getName(), product.getPrice(), product.getDescription());
            logger.info("Product created: {}", product);
        } catch (Exception e) {
            logger.error("Error while inserting product: {}", product, e);
            throw new RuntimeException("Error while inserting product", e);
        }
    }	

    public Product read(int id){
        try {
            return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new ProductMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Product not found with id: {}", id);
            throw new ProductNotFoundException("Product not found with id: " + id);
        } catch (Exception e) {
            logger.error("Error while reading product with id: {}", id, e);
            throw new RuntimeException("Error while reading product", e);
        }
    }

    public List<Product> readAll(){
        try {
            return jdbcTemplate.query(SELECT_ALL_PRODUCTS, new ProductMapper());
        } catch (Exception e) {
            logger.error("Error while reading all products", e);
            throw new RuntimeException("Error while reading all products", e);
        }
    }

    public void update(Product product){
        try {
            jdbcTemplate.update(UPDATE_PRODUCT, product.getName(), product.getPrice(), product.getDescription(), product.getId());
            logger.info("Product updated: {}", product);
        } catch (Exception e) {
            logger.error("Error while updating product: {}", product, e);
            throw new RuntimeException("Error while updating product", e);
        }
    }

    public void delete(int id){
        try {
            jdbcTemplate.update(DELETE_PRODUCT, id);
            logger.info("Product deleted with id: {}", id);
        } catch (Exception e) {
            logger.error("Error while deleting product with id: {}", id, e);
            throw new RuntimeException("Error while deleting product with id: " + id, e);
        }
    }
}
