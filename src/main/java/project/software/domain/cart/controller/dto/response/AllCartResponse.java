package project.software.domain.cart.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.cart.domain.Cart;
import java.util.List;

@Getter
@AllArgsConstructor
public class AllCartResponse {

    private final List<CartResponse> cartList;
    private final Long totalPrice;

    public static AllCartResponse from(List<Cart> carts, Long totalPrice) {
        return new AllCartResponse(
            carts.stream()
                .map(cart -> CartResponse.builder()
                    .shopId(cart.getShop().getId())
                    .brandName(cart.getShop().getBrandName())
                    .glassName(cart.getShop().getGlassesName())
                    .description(cart.getShop().getDescriptionImage())
                    .price(cart.getShop().getPrice())
                    .count(cart.getCount())
                    .build()
                ).toList(),
            totalPrice
        );
    }

    @Getter
    @Builder
    public static class CartResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassName;
        private final String description;
        private final Long price;
        private final Long count;
    }
}
