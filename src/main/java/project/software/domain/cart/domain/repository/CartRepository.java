package project.software.domain.cart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.cart.domain.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);

}
