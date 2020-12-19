package edu.sgu.store.controller;
import edu.sgu.store.dto.CartDTO;
import edu.sgu.store.dto.InvoiceDTO;
import edu.sgu.store.service.CartService;
import edu.sgu.store.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CartController {
    final private CartService cartService;
    final private InvoiceService invoiceService;
    @Autowired
    public CartController(CartService cartService, InvoiceService invoiceService) {
        this.cartService = cartService;
        this.invoiceService = invoiceService;
    }
    @RequestMapping("/cart/index.html")
    public String buy(Model model, Authentication authentication){
        InvoiceDTO  invoiceDTO= new InvoiceDTO();
        invoiceDTO.setItemList(cartService.getCartByUserName(authentication.getName()));
        model.addAttribute("invoiceDTO",invoiceDTO);
        model.addAttribute("cartDTOs",cartService.getCartByUserName(authentication.getName()));
        return "cart/index";
    }
    @RequestMapping(value = "/cart/index.html",method = RequestMethod.POST)
    public String buy(Model model, Authentication authentication, @Valid InvoiceDTO invoiceDTO){
        Integer dem=0;
        for (CartDTO cartDTO: invoiceDTO.getItemList()){
                if (cartDTO.getSelected()==true) dem++;
            }
            if (dem>0){
                invoiceService.save(invoiceDTO,authentication.getName());
                return "redirect:/";
            }
            else return "redirect:/cart/index.html";

    }
    @RequestMapping(value = "cart/add.html")
    public String add(Model model, @RequestParam("id") Integer id,@RequestParam("flag") String flag,Authentication authentication){
        if (authentication!=null){
            cartService.save(id,flag,authentication.getName());
            if(flag.equals("1")){
                return "redirect:/combo/index.html";
            }
            else {
                return "redirect:/";
            }
        }
       else {
            return "redirect:/login";
        }
    }
    @RequestMapping(value = "/cart/remove/{id}")
    public String remove(Model model, Authentication authentication, @PathVariable("id") Integer id){
        cartService.remove(id,authentication.getName());
        return "redirect:/cart/index.html";
    }
}
