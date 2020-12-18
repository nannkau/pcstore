package edu.sgu.store.controller;

import edu.sgu.store.service.ComboService;
import edu.sgu.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    final private ProductService productService;
    final private ComboService comboService;
    @Autowired
    public HomeController(ProductService productService, ComboService comboService) {
        this.productService = productService;
        this.comboService = comboService;
    }

    @RequestMapping(value = {"/","index.html"})
    public String index(Model model){
        model.addAttribute("products",productService.findAll());
        return "home/home";
    }
    @RequestMapping(value = "/combo/index.html")
    public String combo(Model model){
        model.addAttribute("combos",comboService.findAll());
        return "home/combo";
    }
    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model,@PathVariable("id") Integer id){
        model.addAttribute("product",productService.findById(id));
        return "product/detail";
    }
}
