package edu.sgu.store.service;

import edu.sgu.store.dto.CartDTO;
import edu.sgu.store.entity.Cart;

import java.util.List;

public interface CartService {
    void add(CartDTO cartDTO);
    void deleteById(Integer id);
    List<CartDTO> getCartByUserName(String username);
    List<Cart> checkNull(Integer id,String flag);
    Integer save(Integer id,String flag,String username);
    void remove(Integer id,String username);
}
