package edu.sgu.store.repository;

import edu.sgu.store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("select c from Cart c join c.customer u where u.username =:username")
    List<Cart> findByUserName(@Param("username")String username);
    @Query("select c from Cart c join c.product p  join c.customer u where  p.id =:id and u.username =:username")
    List<Cart> findByProductId(@Param("id") Integer id,@Param("username") String username);
    @Query("select c from Cart c join c.combo cb join c.customer u  where  cb.id =:id and u.username =:username")
    List<Cart> findByComboId(@Param("id") Integer id,@Param("username") String username);
    @Query("delete from Cart c where c.id =:id")
    void deleteByIdAndUserName(@Param("id") Integer id);

}
