package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.dto.Product;
//import lt.codeacademy.eshop.service.ProductService;
import lt.codeacademy.eshop.dto.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * /products
 * |_GET -> gausim visus produktus!!!!
 * <p>
 * /products/save
 * |_GET -> parodo forma
 * |_POST -> sukuriame produkta
 * <p>
 * <p>
 * /products/{productId}
 * |_GET
 * |_PUT
 * |_DELETE
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/save")
    public String openCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "form/product";           //is kur norime pasiimti
    }

    @PostMapping("/save")
    public String createProduct(Product product, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("message", "Product created successfully");

        productService.createProduct(product);

        return "form/product";
    }

    @GetMapping
    public String showProducts(Model model, @RequestParam(required = false) String category) {
        if (category != null && !category.isBlank()) {
            model.addAttribute("products", productService.getProductsByCategory(category));
        } else {
            model.addAttribute("products", productService.getProducts());
        }
        return "products";
    }

    @GetMapping("/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProduct(id));

        return "productDetails";
    }

    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "form/product";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(Product product, Model model) {
        productService.updateProduct(product);
        model.addAttribute("products", productService.getProducts());

        return "products";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable UUID id, Model model) {
        productService.delete(id);
        model.addAttribute("products", productService.getProducts());

        return "products";
    }
}
