package edu.mum.cs425.cs.goldendome.goldendome.controller;

import edu.mum.cs425.cs.goldendome.goldendome.model.Product;
import edu.mum.cs425.cs.goldendome.goldendome.model.Supplier;
import edu.mum.cs425.cs.goldendome.goldendome.service.ProductService;
import edu.mum.cs425.cs.goldendome.goldendome.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
	

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = {"/product/gdm"})
	public String showNewStudentgdmForm(Model model) {
		List<Supplier> suppliers = supplierService.getAllSupplier();
		model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());
        return "product/gdm";
	}
	@PostMapping(value = {"/product/gdm"})
	public String registerNewStudent(@Valid @ModelAttribute("product") Product product,
                                     BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "product/gdm";
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
