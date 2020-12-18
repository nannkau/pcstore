package edu.sgu.store.repository;

import edu.sgu.store.entity.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo,Integer> {
}
