package project.software.domain.cart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.cart.controller.dto.response.AllCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.cart.service.AddCartService;
import project.software.domain.cart.service.GetAllCartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
@Validated
public class CartController {

    private final AddCartService addCartService;
    private final GetAllCartService getAllCartService;

    @GetMapping
    public AllCartResponse getAllCart() {
        return getAllCartService.execute();
    }

    @GetMapping("/{shop-id}")
    public void addCart(@PathVariable ("shop-id") Long shopId, @RequestParam(value = "count", defaultValue = "1L") Long count) {
        addCartService.execute(shopId, count);
    }
}
