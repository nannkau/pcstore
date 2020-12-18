package edu.sgu.store.controller;

import edu.sgu.store.dto.CustomerDTO;
import edu.sgu.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {
    final private CustomerService customerService;
    @Autowired
    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping(value = "/register.html")
    public String add(Model model){
        CustomerDTO customerDTO= new CustomerDTO();
        model.addAttribute("customerDTO",customerDTO);
        return "register/index";
    }
    @RequestMapping(value = "/register.html",method = RequestMethod.POST)
    public String add(@Valid CustomerDTO customerDTO, BindingResult result){
        if (customerService.findByUserName(customerDTO.getUsername()).isPresent()) {
            result
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (result.hasErrors()) {
            return "register/index";
        }
        else {
            customerService.save(customerDTO);
        }
        return "redirect:/login";
    }
}
