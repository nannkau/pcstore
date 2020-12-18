package edu.sgu.store.service;

import edu.sgu.store.dto.ComboDTO;
import edu.sgu.store.entity.Combo;

import java.util.List;

public interface ComboService {
    List<ComboDTO> findAll();
}
