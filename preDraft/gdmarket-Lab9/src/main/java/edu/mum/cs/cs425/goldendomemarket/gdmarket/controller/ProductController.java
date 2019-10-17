package edu.mum.cs.cs425.goldendomemarket.gdmarket.controller;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Product;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.service.ProductService;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = {"/product/list"})
    public ModelAndView showListProduct(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productService.getAllProduct());
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @GetMapping(value = {"product/new"})
    public String showNewProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        return "product/new";
    }


    @PostMapping(value = {"/product/new"})
    public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/new";
        }
        product = productService.saveProduct(product);
        return "redirect:/product/list";
    }


}
