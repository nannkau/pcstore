package edu.sgu.store.service.impl;

import edu.sgu.store.dto.CartDTO;
import edu.sgu.store.entity.Cart;
import edu.sgu.store.entity.Customer;
import edu.sgu.store.entity.Product;
import edu.sgu.store.repository.CartRepository;
import edu.sgu.store.repository.CustomerRepository;
import edu.sgu.store.repository.ProductRepository;
import edu.sgu.store.service.CartService;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    final private CartRepository cartRepository;
    final private CustomerRepository customerRepository;
    final private ProductRepository productRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void add(CartDTO cartDTO) {
        Cart cart=new ModelMapper().map(cartDTO,Cart.class);
        cartRepository.save(cart);
    }

    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<CartDTO> getCartByUserName(String username) {
        List<CartDTO> cartDTOS= new ArrayList<>();
        for (Cart entity: cartRepository.findAll()){
            CartDTO cartDTO=new ModelMapper().map(entity,CartDTO.class);
            cartDTOS.add(cartDTO);
        }
        return cartDTOS;
    }

    @Override
    public List<Cart> checkNull(Integer id, String flag) {
        if(flag.equals("1")){

        }
        else {

        }
        return  null;
    }

    @Override
    public Integer save(Integer id, String flag,String username) {
        if(flag.equals("1")){
         if(cartRepository.findByComboId(id,username).size()>0){
          return 0;
         }
         else {
             Product product=productRepository.findById(id).get();
             Customer customer= customerRepository.findByUsername(username).get();
             Cart cart= new Cart();
             cart.setCustomer(customer);
             cart.setProduct(product);
             cart.setAmount(1);
             cartRepository.save(cart);
             return 1;
         }
        }
        else {
            if(cartRepository.findByProductId(id,username).size()>0){
                return 0;
            }
            else {
                Product product=productRepository.findById(id).get();
                Customer customer= customerRepository.findByUsername(username).get();
                Cart cart= new Cart();
                cart.setCustomer(customer);
                cart.setProduct(product);
                cart.setAmount(1);
                cartRepository.save(cart);
                return 1;
            }
        }
    }

    @Override
    public void remove(Integer id, String username) {
        cartRepository.deleteById(id);
    }
}
