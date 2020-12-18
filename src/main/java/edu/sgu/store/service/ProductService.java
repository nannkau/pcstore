package edu.sgu.store.service;

import edu.sgu.store.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAll();
    public ProductDTO findById(Integer id);

}
