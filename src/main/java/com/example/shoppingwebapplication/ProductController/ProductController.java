package com.example.shoppingwebapplication.ProductController;

import com.example.shoppingwebapplication.Entity.ProductForm;
import com.example.shoppingwebapplication.Entity.Product;
import com.example.shoppingwebapplication.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductForm());
        return "addProduct";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String save(@Valid ProductForm productForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addProduct";
        Product product = new Product();
        product.setCreationDate(new Date(System.currentTimeMillis()));
        product.setCategory(productForm.getCategory());
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());

        if (productForm.getFileData() != null) {
            byte[] image = new byte[0];
            try {
                image = productForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            product.setImage(image);
        }

        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String list(Model model, @SortDefault("name") Pageable pageable) {
        model.addAttribute("page", productService.getAllProducts(pageable));
        return "products";
    }

    @RequestMapping(value = {"/product/image"}, method = RequestMethod.GET, produces = {MediaType.IMAGE_JPEG_VALUE})
    @ResponseBody
    public byte[] productImage(@RequestParam("productId") int productId) throws IOException {
        Product product = this.productService.findProductById(productId);
        return product.getImage();
    }


}
