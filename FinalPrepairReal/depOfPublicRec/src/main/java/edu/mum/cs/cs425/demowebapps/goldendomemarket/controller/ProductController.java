package edu.mum.cs.cs425.demowebapps.goldendomemarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Product;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Supplier;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.ProductService;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.SupplierService;

@Controller
public class ProductController {
	

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = {"/product/register"})
	public String showNewStudentRegisterForm(Model model) {
		List<Supplier> suppliers = supplierService.getAllSupplier();
		model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());
        return "product/register";
	}
	@PostMapping(value = {"/product/register"})
	public String registerNewStudent(@Valid @ModelAttribute("product") Product product,
	                                     BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "product/register";
	        }
	        List<Supplier> suppliers = supplierService.getAllSupplier();
	        model.addAttribute("suppliers", suppliers);
	        
	        product = productService.registerNewProduct(product);
	        return "redirect:/product/list";
	    }
	
	@GetMapping(value = {"/product/list"})
	public ModelAndView showStudentsListForm(@RequestParam(defaultValue = "0")int pageNo) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("products", productService.getAllProductPaged(pageNo));
	        modelAndView.addObject("currentPageNo", pageNo); //current page no
	        modelAndView.setViewName("product/list");
	        return modelAndView;
	}
	
	@GetMapping(value = {"/product/edit/{productId}"})
    public String studentEditForm(@PathVariable Integer productId, Model model) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "product/edit";
        }
        return "product/list";
    }

    @PostMapping(value = {"/product/edit"})
    public String updateStudent(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/edit";
        }
        product = productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping(value = {"/product/delete/{productId}"})
    public String deleteProduct(@PathVariable Integer productId, Model model) {
  
    	productService.deleteProductById(productId);
        return "redirect:/product/list";
    }
	

}
