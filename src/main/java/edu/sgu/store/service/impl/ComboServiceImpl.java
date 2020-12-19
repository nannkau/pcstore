package edu.sgu.store.service.impl;

import edu.sgu.store.dto.ComboDTO;
import edu.sgu.store.entity.Combo;
import edu.sgu.store.entity.ComboProduct;
import edu.sgu.store.repository.ComboRepository;
import edu.sgu.store.service.ComboService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ComboServiceImpl implements ComboService {
    final private ComboRepository comboRepository;
    public ComboServiceImpl(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    @Override
    public List<ComboDTO> findAll() {
        List<ComboDTO> comboDTOS= new ArrayList<>();
        long price=0;
        for (Combo combo : comboRepository.findAll()){
            for (ComboProduct comboProduct: combo.getComboProducts())
            {
                price=price+(comboProduct.getProduct().getPrice()-(comboProduct.getProduct().getPrice()*comboProduct.getProduct().getDiscountPercent()/100))* comboProduct.getAmount();
            }
            ComboDTO comboDTO= new ComboDTO();
            comboDTO.setName(combo.getName());
            comboDTO.setId(combo.getId());
            comboDTO.setPrice(price);
            comboDTOS.add(comboDTO);
        }

        return comboDTOS;
    }
}
