package productcrudapp.controller;

import productcrudapp.exception.ProductNotFoundException;
import productcrudapp.model.Product;
import productcrudapp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        logger.info("Retrieved {} products.", products.size());
        return "product-list"; 
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        logger.info("Displaying create product form.");
        return "product-form"; 
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        logger.info("Created product: {}", product);
        return "redirect:/products"; 
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable int id, Model model) {
        try {
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            logger.info("Displaying edit form for product id: {}", id);
            return "product-edit"; 
        } catch (ProductNotFoundException e) {
            logger.error("Product not found with id: {}", id, e);
            return "error/404";         }
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product) {
        product.setId(id); 
        productService.updateProduct(product);
        logger.info("Updated product: {}", product);
        return "redirect:/products"; 
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        logger.info("Deleted product with id: {}", id);
        return "redirect:/products";
    }
}
