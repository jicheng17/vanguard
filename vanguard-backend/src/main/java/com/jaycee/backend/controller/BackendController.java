package com.jaycee.backend.controller;

import com.jaycee.backend.domain.Product;
import com.jaycee.backend.domain.User;
import com.jaycee.backend.repository.UserRepository;
import com.jaycee.backend.service.ProductService;
import com.jaycee.backend.service.ProductServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 4800, allowCredentials = "false")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/products")
    public @ResponseBody
    List<Product> getAllProducts() {
        List<Product> result = productService.getAllProducts();

        if(result == null || result.isEmpty()) {
            List<Product> dummy = new ArrayList<>();
            Product product = new Product();
            product.setPk("123");
            product.setName("dummy");
            product.setSellPrice("100");
            dummy.add(product);

            return dummy;
        }
        else{
            return result;
        }
    }

    @RequestMapping(path = "/saveProduct")
    public @ResponseBody
    Product saveProduct() {
        Product product = new Product();
        product.setId("2");
        product.setPk("abc");
        product.setName("test product");
        product.setSellPrice("200 dollars");

        return productService.saveProduct(product);
    }



    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User(firstName, lastName);
        userRepository.save(user);

        LOG.info(user.toString() + " successfully saved into DB");

        return user.getId();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return userRepository.findById(id).get();
    }

}
