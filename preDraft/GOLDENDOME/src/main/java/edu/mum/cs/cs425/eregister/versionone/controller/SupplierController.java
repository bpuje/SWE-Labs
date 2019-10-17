package edu.mum.cs.cs425.eregister.versionone.controller;

import edu.mum.cs.cs425.eregister.versionone.model.Supplier;
import edu.mum.cs.cs425.eregister.versionone.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SupplierController {


    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"goldendome/supplier/list"})
    public ModelAndView listSuppliers(){
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        modelAndView.addObject("suppliers", suppliers);
        //modelAndView.addObject("searchString", "");
        //modelAndView.addObject("suppliersCount", suppliers.size());
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }

    @GetMapping(value = {"/goldendome/supplier/new"})
    public String displayNewSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/new";
    }

    @PostMapping(value = {"/goldendome/supplier/new"})
    public String addNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/new";
        }
        supplier = supplierService.saveSupplier(supplier);
        System.out.println("End hewlej uzew =====" + supplier);
        return "redirect:/goldendome/supplier/list";
    }


//    @Autowired
//    private SupplierService supplierService;
//
//    @GetMapping(value = {"/supplier/register"})
//    public String showNewStudentRegisterForm(Model model) {
//        model.addAttribute("supplier", new Supplier());
//        return "supplier/register";
//    }
//    @PostMapping(value = {"/supplier/register"})
//    public String registerNewStudent(@Valid @ModelAttribute("supplier") Supplier supplier,
//                                     BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "supplier/register";
//        }
//        supplier = supplierService.registerNewSupplier(supplier);
//        return "redirect:/supplier/list";
//    }
//
//    @GetMapping(value = {"/supplier/list"})
//    public ModelAndView showStudentsListForm(@RequestParam(defaultValue = "0")int pageNo) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("suppliers", supplierService.getAllSupplierPaged(pageNo));
//        modelAndView.addObject("currentPageNo", pageNo); //current page no
//        modelAndView.setViewName("supplier/list");
//        return modelAndView;
//    }

















}
