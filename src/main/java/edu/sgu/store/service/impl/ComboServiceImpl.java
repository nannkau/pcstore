package edu.sgu.store.service.impl;

import edu.sgu.store.entity.Combo;
import edu.sgu.store.repository.ComboRepository;
import edu.sgu.store.service.ComboService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComboServiceImpl implements ComboService {
    final private ComboRepository comboRepository;
    public ComboServiceImpl(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    @Override
    public List<Combo> findAll() {
        return comboRepository.findAll();
    }
}
