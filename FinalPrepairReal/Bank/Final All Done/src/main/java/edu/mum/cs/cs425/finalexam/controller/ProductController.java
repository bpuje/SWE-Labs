package edu.mum.cs.cs425.finalexam.controller;

import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.service.IProductService;
import edu.mum.cs.cs425.finalexam.service.ISupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;
    
    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = {"/list", "/", ""})
    public String showProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping(value = "/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.findAll());
        return "products/new";
    }

    @PostMapping(value = "/add")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/new";
        }
        productService.save(product);
        return "redirect:/products";
    }
}

