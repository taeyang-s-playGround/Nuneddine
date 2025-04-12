package project.software.domain.cart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.cart.controller.dto.response.AllCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.guide.domain.Guide;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);

}
