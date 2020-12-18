package edu.sgu.store.service.impl;

import edu.sgu.store.dto.ProductDTO;
import edu.sgu.store.entity.Product;
import edu.sgu.store.repository.ProductRepository;
import edu.sgu.store.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    final private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS= new ArrayList<>();
        for (Product entity: productRepository.findAll()){
            ProductDTO productDTO=new ModelMapper().map(entity,ProductDTO.class);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }



    @Override
    public ProductDTO findById(Integer id) {
        return  new ModelMapper().map(productRepository.findById(id).get(),ProductDTO.class);
    }
}
