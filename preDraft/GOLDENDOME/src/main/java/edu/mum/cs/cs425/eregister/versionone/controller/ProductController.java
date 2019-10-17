package edu.mum.cs.cs425.eregister.versionone.controller;

import edu.mum.cs.cs425.eregister.versionone.model.Product;
import edu.mum.cs.cs425.eregister.versionone.service.ProductService;

import edu.mum.cs.cs425.eregister.versionone.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = {"goldendome/product/list"})
    public ModelAndView listProducts(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("productsCount", products.size());
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @GetMapping(value = {"/goldendome/product/new"})
    public String displayNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/new";
    }

    @PostMapping(value = {"/goldendome/product/new"})
    public String addNewproduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/new";
        }
        product = productService.saveProduct(product);
        //System.out.println("End hewlej uzew =====" + product);
        return "redirect:/goldendome/product/list";
    }

}
