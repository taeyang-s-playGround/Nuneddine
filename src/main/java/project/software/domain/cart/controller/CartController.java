package project.software.domain.cart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.cart.controller.dto.request.ChangeOptionRequest;
import project.software.domain.cart.controller.dto.request.DeleteCartsRequest;
import project.software.domain.cart.controller.dto.response.GlassesCartResponse;
import project.software.domain.cart.controller.dto.response.LensCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.cart.service.AddCartService;
import project.software.domain.cart.service.ChangeOptionService;
import project.software.domain.cart.service.DeleteCartService;
import project.software.domain.cart.service.GetGlassesCartService;
import project.software.domain.cart.service.GetLensCartService;
import project.software.domain.shop.controller.dto.response.GlassesListResponse;
import project.software.domain.shop.controller.dto.response.LensListResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
@Validated
public class CartController {

    private final AddCartService addCartService;
    private final GetLensCartService getLensCartService;
    private final GetGlassesCartService getGlassesCartService;
    private final ChangeOptionService changeOptionService;
    private final DeleteCartService deleteCartService;

    @GetMapping("/lens")
    public LensCartResponse getLensListByCategory() {
        return getLensCartService.execute();
    }

    //메인페이지
    @GetMapping("/glasses")
    public GlassesCartResponse getGlassesListByCategory() {
        return getGlassesCartService.execute();
    }

    @PostMapping("/{shop-id}")
    public void addCart(@PathVariable ("shop-id") Long shopId, ChangeOptionRequest request) {
        addCartService.execute(shopId, request);
    }


    @PatchMapping("/{cart-id}")
    public void changeOption(@PathVariable ("cart-id") Long cartId, @RequestBody ChangeOptionRequest request) {
        changeOptionService.execute(cartId, request);
    }

    @DeleteMapping
    public void deleteCart(@RequestBody DeleteCartsRequest request) {
        deleteCartService.execute(request);
    }
}
