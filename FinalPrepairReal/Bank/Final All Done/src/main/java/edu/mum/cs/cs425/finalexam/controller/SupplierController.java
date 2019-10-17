package edu.mum.cs.cs425.finalexam.controller;

import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.model.Supplier;
import edu.mum.cs.cs425.finalexam.service.IProductService;
import edu.mum.cs.cs425.finalexam.service.ISupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = {"/list", "/", ""})
    public String showSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/list";
    }

    @GetMapping(value = "/add")
    public String showAddSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "suppliers/new";
    }

    @PostMapping(value = "/add")
    public String addNewProduct(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "suppliers/new";
        }
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }
}

