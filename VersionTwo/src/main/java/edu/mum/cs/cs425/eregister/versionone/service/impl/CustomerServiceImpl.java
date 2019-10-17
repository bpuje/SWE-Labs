package edu.mum.cs.cs425.eregister.versionone.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs.cs425.eregister.versionone.model.Customer;
import edu.mum.cs.cs425.eregister.versionone.repository.CustomerRepository;
import edu.mum.cs.cs425.eregister.versionone.service.CustomerService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepo.deleteById(customerId);
    }

    @Override
    public String printPrimeCustomersByAge(Customer customer) {
        // Creating Object of ObjectMapper define in Jakson Api
        LocalDate currentTime = LocalDate.now();
        String jsonStr = "";

        int age = (currentTime.getYear() - customer.getDateOfBirth().getYear());
        System.out.println("customer age: " + age);

        if (age > 40) {
            ObjectMapper Obj = new ObjectMapper();

            System.out.println(customer.getName());
            try {
                // get Oraganisation object as a json string
                jsonStr = Obj.writeValueAsString(customer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonStr;
    }

    //    @Override
//    public List<Customer> searchCustomers(String searchString) {
//        if(containsDecimalPoint(searchString) && isResult(searchString)){
//            return customerRepo.findAllByCustomerIdEquals(Long.parseLong(searchString));
//        }else if(isDate(searchString)){
//            return customerRepo.findAllByDateOfBirthEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
//        }else {
//            return customerRepo.findAllByCustomerIdContainingOrNameContainingOrDateOfBirthContainingOrderByName(searchString, searchString, searchString);
//        }
//    }
//
//    private boolean isResult(String searchString){
//        boolean isParseableAsResult = false;
//        try {
//            Long.parseLong(searchString);
//            isParseableAsResult = true;
//        }catch (Exception e){
//
//            if (e instanceof ParseException){
//                isParseableAsResult = false;
//            }
//        }
//        return isParseableAsResult;
//    }
//
//    private boolean isDate(String searchString){
//        boolean isParseableAsDate = true;
//        try {
//            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
//            isParseableAsDate = true;
//        }catch (Exception e){
//            if (e instanceof DateTimeParseException){
//                isParseableAsDate = false;
//            }
//        }
//        return isParseableAsDate;
//    }
//
//    private boolean containsDecimalPoint(String searchString){
//        return searchString.contains(".");
//    }
}
